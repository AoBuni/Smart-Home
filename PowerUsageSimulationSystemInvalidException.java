public class PowerUsageSimulationSystemInvalidException extends Exception {
    public PowerUsageSimulationSystemInvalidException (String errorMessage) {
		super(errorMessage);
	}
	public String getMessage() {
		return "A failure of execution happened.";
	}
	
	public String toString() {
		return "PowerUsageSimulationSystemInvalidException";
	}
}