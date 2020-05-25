public class ApplianceInvalidException extends Exception{
	public ApplianceInvalidException (String errorMessage) {
		super(errorMessage);
	}
	public String getMessage() {
		return "A failure of execution happened.";
	}
	
	public String toString() {
		return "ApplianceInvalidException";
	}
	
}