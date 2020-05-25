import java.io.*;

public class ApplianceListTest {
    public static void main(String [] args) throws IOException, ApplianceInvalidException, SmartApplianceInvalidException, ApplianceListInvalidException{
        ApplianceList one = new ApplianceList(1745,"appliancesSmall.csv");
        //System.out.println(one.toString());
        System.out.println(one.isFull());
        System.out.println(one.isThere(10000003));

        ApplianceList two = new ApplianceList(17514,"appliancesBig.csv");
        //System.out.println(two.toString());

        ApplianceList three = new ApplianceList(5);
        System.out.println(three.toString());
        System.out.println(three.isEmpty());
        Appliance mixer = new Appliance();
        System.out.println("Insert = " + three.insert(mixer));
        System.out.println("Empty = " + three.isEmpty());
        System.out.println("Delete = " + three.delete(24777));
        System.out.println(three.toString());

        System.out.println(two.getAppliance(158));
    }
}