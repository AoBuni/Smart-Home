public class SmartAppliance extends Appliance {
    private double percentageSaving = 0;
    private boolean smartOn;

    public SmartAppliance() throws ApplianceInvalidException, SmartApplianceInvalidException{
        super();
        setPercentSaving(percentageSaving);
        smartOff();
    }
    public SmartAppliance(int newWattsOn, int newWattsOff, double newPercentageSaving) throws ApplianceInvalidException, SmartApplianceInvalidException{
        super(newWattsOn, newWattsOff);
        setPercentSaving(newPercentageSaving);
        smartOff();
    }
    public SmartAppliance(SmartAppliance object) throws ApplianceInvalidException, SmartApplianceInvalidException{
        super((Appliance) object);
        setPercentSaving(object.getPercentageSaving());
        if(object.getOn()) {
            this.smartOn();
        } else {
            this.smartOff();
        }
    }

    //Mutators
    public void setPercentSaving(double thePercentSaving) {
        if(thePercentSaving>=0 && thePercentSaving<1){
            percentageSaving = thePercentSaving;
        } else {
            percentageSaving = 0;
        }
    }
    public void smartOn() {
        smartOn = true;
    }
    public void smartOff() {
        smartOn = false;
    }

    //Accessors
    public int getCurrentWatts() {
        if(getOn() && getSmart()) {
            return (int)(getWattsOn()*(1-percentageSaving));
        } else {
            return super.getCurrentWatts();
        }
    }
    public boolean getSmart() {
        return smartOn;
    }
    public double getPercentageSaving() {
        return percentageSaving;
    }

    //toString method
    public String toString() {
        return super.toString() + " PercentSaving=" + getPercentageSaving() + " smartOn=" + getSmart();
    }
}