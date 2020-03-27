
public class ResponseObject {
	String errorMessage;
	int errorCode; // we can start with the codes: 100 for general error messages and 200 for general success messages
	
	public ResponseObject(int code, String errorMessage) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = code;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int code) {
		this.errorCode = code;
	}
}

