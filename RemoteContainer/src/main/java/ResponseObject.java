
public class ResponseObject {
	String errorMessage;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public ResponseObject(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
}

