package LogisticCompany.App;
/**
 * This class represents an exception that will be thrown when the operation is not allowed
 * for instance when the client is logged in and tries to perform an action that requires logistic company authorization 
 */
public class OperationNotAllowedException extends Exception {

	/**
	 * A new exception is constructed with error message errorMessage.
	 * @param errorMessage the error message of the exception
	 */
	public OperationNotAllowedException(String errorMessage) {
		super(errorMessage);
	}

}
