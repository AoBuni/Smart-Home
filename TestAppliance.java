public class TestAppliance {
	public static void main(String[] args) throws ApplianceInvalidException, SmartApplianceInvalidException {
		Appliance a1 = new Appliance(200,0);
		System.out.println(a1);
		System.out.println("appliance off watts "+a1.getCurrentWatts());	
		a1.turnOn();
		System.out.println(a1);
		System.out.println("appliance on watts "+a1.getCurrentWatts());	
		
		// test Appliance copy constructor
		System.out.println("Appliance Copy Constructor");
		Appliance a1Copy = new Appliance(a1);
		a1Copy.setOnWatts(150);
		System.out.println("ORIGINAL "+a1);
		System.out.println("COPY "+a1Copy);

		SmartAppliance s1 = new SmartAppliance(783,50,0.25);
		System.out.println(s1);
	
		// test SmartAppliance reduce current wattage
		s1.turnOn();
		System.out.println("smartOff watts "+s1.getCurrentWatts());
		s1.smartOn();
		System.out.println("smartOn watts "+s1.getCurrentWatts());

		// test SmartAppliance copy constructor
		System.out.println("SmartAppliance Copy Constructor");
		SmartAppliance s1Copy = new SmartAppliance(s1);
		s1Copy.setPercentSaving(.5);
		System.out.println("ORIGINAL "+s1);
		System.out.println("COPY "+s1Copy);
	}
}