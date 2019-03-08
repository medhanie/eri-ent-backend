package io.medhanie.erient.client.authentication;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeScopes;

@Component
public class GoogleUserAuthentication {

	@Value("${youtube.apiKey}")
	private String apiKey;

	@Value("${youtube.userId}")
	private String userId;

	@Value("${youtube.passord}")
	private String password;

	@Value("${project.name}")
	private String projectName;

	public YouTube getYouTubeService() throws IOException, GeneralSecurityException {

		JsonFactory jsonFactory = GsonFactory.getDefaultInstance();

		GoogleClientSecrets clientSecrets = new GoogleClientSecrets();
		Details details = clientSecrets.getInstalled();
		details.setClientId(userId);
		details.setClientSecret(password);
		clientSecrets.setInstalled(details);

		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

		List<String> scopes = Arrays.asList(YouTubeScopes.YOUTUBE_READONLY);

		
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(httpTransport, jsonFactory,
				clientSecrets, scopes).setAccessType("offline").build();

		Credential credential = flow.loadCredential(userId);

		return new YouTube.Builder(httpTransport, jsonFactory, credential).setApplicationName(projectName).build();
	}
}
