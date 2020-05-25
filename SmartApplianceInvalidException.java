public class SmartApplianceInvalidException extends Exception{
	public SmartApplianceInvalidException (String errorMessage) {
		super(errorMessage);
	}
	public String getMessage() {
		return "A failure of execution happened.";
	}
	public String toString() {
		return "SmartApplianceInvalidException";
	}
}