import java.io.IOException;
import java.util.ArrayList;

public class PowerUsageSimulationSystem {
    private int powerLimit;
    private int timeLength;
    private int interval;
    private int count;
    private ApplianceList one;
    private ArrayList offLocation;
    private final int POWER_LIMIT = 50000;
    private final int DEFAULT_TIME_LENGTH = 24 * 60;
    private final int DEFAULT_INTERVAL = 5;

    //Default
    public PowerUsageSimulationSystem() {
        setPowerLimit(POWER_LIMIT);
        setInterval(DEFAULT_INTERVAL);
    }    
    //Non-Default
    public PowerUsageSimulationSystem(int newTimeLength, int newInterval, int newSize, String csv) throws ApplianceListInvalidException, IOException, ApplianceInvalidException, SmartApplianceInvalidException{
        one = new ApplianceList(newSize, csv);
        setPowerLimit(POWER_LIMIT);
        setInterval(newInterval);
        setTimeLength(newTimeLength);
    }

    public void setPowerLimit(int theLimit) {
        if(theLimit>=0) {
            powerLimit = theLimit;
        } else {
            powerLimit = POWER_LIMIT;
        }
    }

    public void setInterval(int theInterval) {
        if(theInterval>=0) {
            interval = theInterval;
        } else {
            interval = DEFAULT_INTERVAL;
        }
    }

    public void setTimeLength(int theTimeLength) {
        if(theTimeLength>=0) {
            timeLength = theTimeLength;
        } else {
            timeLength = DEFAULT_TIME_LENGTH;
        }
    }

    public int getTotalPower() {
        return findTotalPower();
    }

    //PowerInDangerZone
    public void powerInDangerZone() throws ApplianceListInvalidException, ApplianceInvalidException {
        int max = 0;
        int location;
        while(findTotalPower()>powerLimit) {
            count = 1;
            if(one.isThere(10000000 + count) != null) {
                if(max < sumWattageLocation(10000000 + count)) {
                    max = sumWattageLocation(10000000 + count);
                    location = 10000000 + count;
                }
            }
            count++;
            turnOffLocation();
        }
        count = 1;
    }

    //Sum of City
    public int findTotalPower() {
        int totalSum = 0;
        for(int i=0; i<one.length(); i++) {
            if(one.getAppliance(i).getOn()==true) {
                if(one.getAppliance(i) instanceof SmartAppliance) {
                    totalSum += one.getAppliance(i).getCurrentWatts();
                } else {
                    totalSum += one.getAppliance(i).getWattsOn();
                }
            }
        }
        return totalSum;
    }

    //Sum Location
    public int sumWattageLocation(int location) {
        int sumWatts = 0;
        for(int i=one.startLocation(location); i<one.endLocation(location);i++) {
            sumWatts += one.getAppliance(i).getCurrentWatts();
        }
        return sumWatts;
    }

    //TurnOffLocation
    public void turnOffLocation() {
        int start = one.startLocation(10000000 + count);
        int end = one.endLocation(10000000 + count);
        offLocation = new ArrayList<Appliance>();
        for(int j=start; j<end; j++) {      //Finding smart appliance
            if(one.getAppliance(j) instanceof SmartAppliance) {
                one.getAppliance(j).turnOff();
                offLocation.add(one.startLocation(10000000 + count));
            }
        } 
    }

    public String toString() {
        String string = "";
        int count = 1;
        for(int i=0; i<timeLength; i+=interval) {
            string += "Minute: " + i + " Event#" + count + "\n";
        }
        return string;
    }
}