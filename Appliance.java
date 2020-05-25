public class Appliance {
    private static int counter = 1;
    private String type = "";
    private int wattsOff;
    private int wattsOn;
    private int applianceLocation;
    private boolean on;

    //Default Constructor
    public Appliance() throws ApplianceInvalidException {
        applianceLocation = counter;
        setType(type);
        setOffWatts(wattsOff);
        setOnWatts(wattsOn);
        turnOff();
        counter++;
    }
    //Non-Default Constructor
    public Appliance(int newWattsOn, int newWattsOff) throws ApplianceInvalidException {
        applianceLocation = counter;
        setType(type);
        setOffWatts(newWattsOff);
        setOnWatts(newWattsOn);
        turnOff();
        counter++;
    }
    //Copy Constructor
    public Appliance(Appliance object) throws ApplianceInvalidException {
        applianceLocation = object.getApplianceLocation();
        setType(object.type);
        setOffWatts(object.wattsOff);
        setOnWatts(object.wattsOn);
        if(object.getOn()) {
            this.turnOn();
        } else {
            this.turnOff();
        }
    }

    //Mutators
    public void setLocation(int IDnumber) {
        applianceLocation = IDnumber;
    }
    public void setType(String theType) {
        type = theType;
    }
    public void setOnWatts(int theWattsOn) {
        if(theWattsOn>=0) {
            wattsOn = theWattsOn;
        } else {
            wattsOn = 1;
        }
    }
    public void setOffWatts(int theWattsOff) {
        if(theWattsOff>=0) {
            wattsOff = theWattsOff;
        } else {
            wattsOff = 0;
        }
    }

    //Accessors
    public int getApplianceLocation() {
        return applianceLocation;
    }
    public int getWattsOff() {
        return wattsOff;
    }
    public int getWattsOn() {
        return wattsOn;
    }
    public int getCurrentWatts() {
        if(on) {
            return wattsOn;
        } else {
            return wattsOff;
        }
    }
    public boolean getOn() {
        return on;
    }

    //turnOn method
    public void turnOn() {
        on = true;
    }

    //turnOff method
    public void turnOff() {
        on = false;
    }
    public String toString() {
        return getApplianceLocation() + " on?=" + getOn() + " OnW=" + getWattsOn() + " OffW=" + getWattsOff();
    }
}