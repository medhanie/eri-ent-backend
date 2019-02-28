package io.medhanie.erient.config;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class RestRequestLoggingInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		String requestString = String.format(
				"\n\tRequest Method: %s,\n\tReqeust URI: %s,\n\tRequest Headers: %s,\n\tRequest Body: %s",
				request.getMethod(), request.getURI(), request.getHeaders(),
				new String(body, Charset.forName("UTF-8")));
		// TODO log requestString

		ClientHttpResponse response = execution.execute(request, body);

		String responseString = String.format(
				"\n\tResponse Status Code: %s,\n\tResponse Headers: %s,\n\tResponse Body: %s", response.getStatusCode(),
				response.getHeaders(), StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
		// TODO log responseString

		return response;
	}

}
