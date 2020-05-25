import java.util.*;
import java.io.*;

public class ApplianceList {
    private ArrayList<Appliance> appliances;
    private int sizeOfElements;
    private boolean empty;
    private int sizeOfArray;
    private boolean smart;
    private final int DEFAULT_SIZE = 10000;
    
    //Default Constructor
    public ApplianceList() throws ApplianceListInvalidException {
        appliances = new ArrayList<Appliance>(DEFAULT_SIZE);
    }
    //Non-Default Constructor
    public ApplianceList(int newSize) throws ApplianceListInvalidException {
        if(newSize>0) {
            appliances = new ArrayList<Appliance>(newSize);
            sizeOfArray = newSize;
        }
    }
    //Second Non-Default Constructor
    public ApplianceList(int newSize, String csv) throws IOException, ApplianceListInvalidException, ApplianceInvalidException, SmartApplianceInvalidException {
        File f = new File(csv);
        Scanner in = new Scanner(f);
        Random rand = new Random();
        int count = 0;
        if(newSize>0) {
            appliances = new ArrayList<Appliance>(newSize);
            sizeOfArray = newSize;
            for(int i=0; i<newSize; i++) {
                in.useDelimiter(",");
                int location;
                Appliance garabge = new Appliance();
                if(count>0) {
                    String tempLocation = in.next();
                    location = Integer.parseInt(tempLocation.replaceAll("\r\n",""));
                } else {
                    location = in.nextInt();
                }
                String type = in.next();
                int on = in.nextInt();
                int off = in.nextInt();
                double probability = in.nextDouble();
                smart = in.nextBoolean();
                in.useDelimiter("\r\n");
                String tempSave = in.next();
                double savePercentage = Double.parseDouble(tempSave.replaceAll(",",""));
                count++;
                garabge.setLocation(location);
                garabge.setType(type);
                garabge.setOnWatts(on);
                garabge.setOffWatts(off);
                if(probability<=rand.nextDouble()) {
                    garabge.turnOn();
                }
                if(smart==true) {
                    SmartAppliance trash = new SmartAppliance();
                    trash.setPercentSaving(savePercentage);
                    if(rand.nextDouble()<=0.75) {
                        trash.smartOn();
                        trash.getCurrentWatts();
                    }
                }
                appliances.add(garabge);
            }
            in.close();
        }
    }

    //Observer Methods
    //isEmpty()
    public boolean isEmpty() {
        empty = appliances.isEmpty();
        if(empty == true) {
            return true;
        } else {
            return false;
        }
    }
    //isFull()
    public boolean isFull() {
        sizeOfElements = appliances.size();
        if(length() == sizeOfArray) {
            return true;
        } else {
            return false;
        }
    }
    //length()
    public int length() {
        return sizeOfElements; 
    }
    //Start of location
    public int startLocation(int location) {
        for(int i=0; i<getArraySize(); i++) {
            if(location == appliances.get(i).getApplianceLocation()) {
                return i;
            }
        }
        return 0;
    }
    //End of Location
    public int endLocation(int location) {
        if(location>=10000000) {
            return startLocation(location) + numApp(location) - 1;
        } else {
            return 10000000;
        }
    }
    //Number of Appliances in that location
    public int numApp(int location) {
        int counter = 0;
        int i = 0;
        while(i != appliances.size()) {
            while(location == appliances.get(i).getApplianceLocation()) {
                counter++;
            }
            i++;
        }
        return counter;
    }
    //isThere(int targetApplianceID)
    public Appliance isThere(int targetApplianceLocation) throws ApplianceListInvalidException, ApplianceInvalidException{
        Appliance temp = new Appliance();
        boolean flag = false;
        if(targetApplianceLocation>=10000000) { 
            for(int i=0; i<getArraySize(); i++) {
                if(targetApplianceLocation == appliances.get(i).getApplianceLocation()) {
                    temp = appliances.get(i);
                    flag = true;
                }
            }
        }
        if(flag == true) {
            return temp;
        } else {
            return null;
        }
    }

    //Transformers
    //insert(Appliance targetAppliance)
    public boolean insert(Appliance targetAppliance) {
        if(!isFull()) {
            appliances.add(targetAppliance);
            return true;
        } else {
            return false;
        }
    }
    //delete(int targetAppliance)
    public boolean delete(int targetAppliance) {
        if(targetAppliance>=0 && targetAppliance<=length()-1) {
            appliances.remove(targetAppliance);
            return true;
        } else {
            return false;
        }
    }

    //Accessor
    //getAppliance(int index)
    public Appliance getAppliance(int index) {
        return appliances.get(index);
    }
    public int getArraySize() {
        return sizeOfArray;
    }

    //toString
    public String toString() {
        int count = 1;
        String string = "";
        for(Appliance i : appliances) {
            string += count + ". " + i + "\n";
            count++;
        }
        return string;
    }
}