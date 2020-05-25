public class ApplianceListInvalidException extends Exception{
	public ApplianceListInvalidException (String errorMessage) {
		super(errorMessage);
	}
	public String getMessage() {
		return "A failure of execution happened.";
	}
	
	public String toString() {
		return "ApplianceListInvalidException";
	}
	
}