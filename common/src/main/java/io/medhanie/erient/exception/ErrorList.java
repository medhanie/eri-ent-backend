package io.medhanie.erient.exception;

public enum ErrorList {

	UNABLE_TO_CONNECT(ErrorType.INVALID_DATA, ErrorLevel.ERROR, "ERR01", "Connection has error.");

	private ErrorType type;
	private ErrorLevel level;
	private String code;
	private String errorMessage;

	private ErrorList(ErrorType type, ErrorLevel level, String code, String errorMessage) {
		this.type = type;
		this.level = level;
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public ErrorType getType() {
		return type;
	}

	public void setType(ErrorType type) {
		this.type = type;
	}

	public ErrorLevel getLevel() {
		return level;
	}

	public void setLevel(ErrorLevel level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
