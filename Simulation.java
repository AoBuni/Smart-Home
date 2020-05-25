import java.util.*;
import java.io.*;

public class Simulation {
    public static void main(String[] args) throws IOException{
        int choice;
        int timeLength;
        int interval;
        int size;
        boolean badInput;
        Scanner in = new Scanner(System.in);
        String a;

        System.out.println("Welcome to Simulator.io");
        System.out.println("1. Input CSV file for simulation\n2. Inserting Appliance to CSV\n3. Deleting Appliance from CSV\n4. Find Appliance from CSV\n5. Exit");
        System.out.print("Input: ");
        do {
            try {
                choice = in.nextInt();
                do {
                    badInput = false;
                    if(choice == 1) {
                        do {
                            badInput = false;
                            try {
                                System.out.print("Please enter a csv file: ");
                                a = in.next();
                                File f = new File(a);
                                Scanner reader = new Scanner(f);
                                do {
                                    badInput = false;
                                    try {
                                        System.out.print("How long do you want the simulation to be? ");
                                        timeLength = in.nextInt();
                                        while(timeLength<0) {
                                            System.out.println("Enter a positive integer.");
                                            System.out.print("How long do you want the simulation to be? ");
                                            timeLength = in.nextInt();
                                        }
                                        do {
                                            badInput = false;
                                            System.out.print("How about the interval? ");
                                            try {
                                                interval = in.nextInt();
                                                while(timeLength<0) {
                                                    System.out.print("Enter a positive integer.");
                                                    System.out.print("How about the interval? ");
                                                    interval = in.nextInt();
                                                }
                                                do {
                                                    badInput = false;
                                                    try {
                                                        System.out.print("Lastly, how big is the size of your appliance list? ");
                                                        size = in.nextInt();
                                                        PowerUsageSimulationSystem puss = new PowerUsageSimulationSystem(timeLength, interval, size, a);
                                                        System.out.println(puss.toString());
                                                    } catch(InputMismatchException ime) {
                                                        badInput = true;
                                                        System.out.println("Enter a integer.");
                                                        in.next();
                                                    }
                                                } while(badInput);
                                            } catch(InputMismatchException ime) {
                                                badInput = true;
                                                System.out.println("Enter a integer.");
                                                in.next();
                                            }
                                        } while(badInput);
                                    } catch(InputMismatchException ime) {
                                        badInput = true;
                                        System.out.println("Enter a integer.");
                                        in.next();
                                    }
                                } while(badInput);
                            } catch(Throwable cause) {
                                badInput = true;
                                System.out.println(cause);
                            }
                        } while(badInput);
                    } else {
                        if(choice == 2) {
                            do {
                                badInput = false;
                                try{
                                    System.out.print("Please enter a csv file: ");
                                    a = in.next();
                                    File f = new File(a);
                                    Scanner reader = new Scanner(f);
                                    do {
                                        badInput = false;
                                        System.out.println("Insert Appliance: ");
                                        int location;
                                        System.out.println("Location: (10000000+).");
                                        try {
                                            location = in.nextInt();
                                            while(location<10000000) {
                                                System.out.println("Enter an integer >10000000.");
                                                location = in.nextInt();
                                            }
                                            do {
                                                badInput = false;
                                                try {
                                                    String name;
                                                    System.out.print("Enter a name: ");
                                                    name = in.next();
                                                    do {
                                                        badInput = false;
                                                        int wattsOn;
                                                        System.out.print("What is the wattage when it is on? ");
                                                        try {
                                                            wattsOn = in.nextInt();
                                                            do {
                                                                badInput = false;
                                                                int wattsOff;
                                                                System.out.print("What is the wattage when it is off? ");
                                                                try {
                                                                    wattsOff = in.nextInt();
                                                                    do {
                                                                        badInput = false;
                                                                        double probability;
                                                                        System.out.print("What is the probability of turning it on? ");
                                                                        try {
                                                                            probability = in.nextDouble();
                                                                            do {
                                                                                badInput = false;
                                                                                boolean answer;
                                                                                System.out.print("Is the appliance smart? (True/False): ");
                                                                                try {
                                                                                    answer = in.nextBoolean();
                                                                                    if(answer == true) {
                                                                                        do {
                                                                                            badInput = false;
                                                                                            double save;
                                                                                            System.out.println("How much does it save? ");
                                                                                            try {
                                                                                                save = in.nextDouble();
                                                                                                SmartAppliance ap = new SmartAppliance();
                                                                                                ap.setLocation(location);
                                                                                                ap.setType(name);
                                                                                                ap.setOnWatts(wattsOn);
                                                                                                ap.setOffWatts(wattsOff);
                                                                                                ap.setPercentSaving(save);
                                                                                                do {
                                                                                                    badInput = false;
                                                                                                    int s;
                                                                                                    System.out.print("What is the size of the csv? ");
                                                                                                    try {
                                                                                                        s = in.nextInt();
                                                                                                        ApplianceList AL = new ApplianceList(s, a);
                                                                                                        AL.insert(ap);
                                                                                                    } catch(InputMismatchException ime) {
                                                                                                        badInput = true;
                                                                                                        System.out.println("What is the size of the csv? ");
                                                                                                        in.next();
                                                                                                    }
                                                                                                } while(badInput);
                                                                                            } catch(InputMismatchException ime) {
                                                                                                badInput = true;
                                                                                                System.out.println("How much does it save? ");
                                                                                                in.next();
                                                                                            }
                                                                                        } while(badInput);
                                                                                    } else {
                                                                                        Appliance ap = new Appliance();
                                                                                        ap.setLocation(location);
                                                                                        ap.setType(name);
                                                                                        ap.setOnWatts(wattsOn);
                                                                                        ap.setOffWatts(wattsOff);
                                                                                        do {
                                                                                            badInput = false;
                                                                                            int s;
                                                                                            System.out.print("What is the size of the csv? ");
                                                                                            try {
                                                                                                s = in.nextInt();
                                                                                                ApplianceList AL = new ApplianceList(s, a);
                                                                                                AL.insert(ap);
                                                                                            } catch(InputMismatchException ime) {
                                                                                                badInput = true;
                                                                                                System.out.println("What is the size of the csv? ");
                                                                                                in.next();
                                                                                            }
                                                                                        } while(badInput);
                                                                                    }
                                                                                } catch(InputMismatchException ime) {
                                                                                    badInput = true;
                                                                                    System.out.println("Is the appliance smart? (True/False)");
                                                                                    in.next();
                                                                                }
                                                                            } while(badInput);
                                                                        } catch(InputMismatchException ime) {
                                                                            badInput = true;
                                                                            System.out.println("What is the probability of turning it on?");
                                                                            in.next();
                                                                        }
                                                                    } while(badInput); 
                                                                } catch(InputMismatchException ime) {
                                                                    badInput = true;
                                                                    System.out.println("What is the wattage when it is off?");
                                                                    in.next();
                                                                }
                                                            } while(badInput);
                                                        } catch(InputMismatchException ime) {
                                                            badInput = true;
                                                            System.out.println("What is the wattage when it is on?");
                                                            in.next();
                                                        }
                                                    } while(badInput);
                                                } catch(InputMismatchException ime) {
                                                    badInput = true;
                                                    System.out.println("Enter a name.");
                                                    in.next();
                                                } 
                                            } while(badInput);
                                        } catch (InputMismatchException ime) {
                                            badInput = true;
                                            System.out.println("Enter an integer >10000000.");
                                            in.next();
                                        }
                                    } while(badInput);
                                } catch(Throwable cause) {
                                    badInput = true;
                                    System.out.println(cause);
                                }
                            } while(badInput);
                        } else {
                            if(choice == 3) {
                                do {
                                    badInput = false;
                                    try {
                                        System.out.print("Please enter a csv file: ");
                                        a = in.next();
                                        File f = new File(a);
                                        Scanner reader = new Scanner(f);
                                        do {
                                            badInput = false;
                                            System.out.println("Delete Appliance (int ApplianceLocation) //10000000+");
                                            int AL;
                                            try{
                                                AL = in.nextInt();
                                                while(AL<10000000) {
                                                    System.out.println("Enter an integer >10000000");
                                                    AL = in.nextInt();
                                                }
                                                do {
                                                    badInput = false;
                                                    try {
                                                        System.out.print("Lastly, how big is the size of your appliance list? ");
                                                        size = in.nextInt();
                                                        ApplianceList apl = new ApplianceList(size, a);
                                                        System.out.println(apl.delete(AL));
                                                    } catch(InputMismatchException ime) {
                                                        badInput = true;
                                                        System.out.println("Enter a integer.");
                                                        in.next();
                                                    }
                                                } while(badInput);
                                            } catch(InputMismatchException ime) {
                                                badInput = true;
                                                System.out.println("Enter an integer >10000000");
                                                in.next();
                                            }
                                        } while(badInput);
                                    } catch(Throwable cause) {
                                        badInput = true;
                                        System.out.println(cause);
                                    }
                                } while(badInput);
                            } else {
                                if(choice == 4) {
                                    do {
                                        badInput = false;
                                        try {
                                            System.out.print("Please enter a csv file: ");
                                            a = in.next();
                                            File f = new File(a);
                                            Scanner reader = new Scanner(f);
                                            do {
                                                badInput = false;
                                                System.out.println("Find Appliance (int ApplianceLocation) //10000000+");
                                                int AL;
                                                try{
                                                    AL = in.nextInt();
                                                    while(AL<10000000) {
                                                        System.out.println("Enter an integer >10000000");
                                                        AL = in.nextInt();
                                                    }
                                                    do {
                                                        badInput = false;
                                                        try {
                                                            System.out.print("Lastly, how big is the size of your appliance list? ");
                                                            size = in.nextInt();
                                                            ApplianceList apl = new ApplianceList(size, a);
                                                            System.out.println(apl.isThere(AL));
                                                        } catch(InputMismatchException ime) {
                                                            badInput = true;
                                                            System.out.println("Enter a integer.");
                                                            in.next();
                                                        }
                                                    } while(badInput);
                                                } catch(InputMismatchException ime) {
                                                    badInput = true;
                                                    System.out.println("Enter an integer >10000000");
                                                    in.next();
                                                }
                                            } while(badInput);
                                        } catch(Throwable cause) {
                                            badInput = true;
                                            System.out.println(cause);
                                        }
                                    } while(badInput);
                                } else {
                                    if(choice == 5) {
                                        break;
                                    } else {
                                        System.out.println("Enter 1, 2, 3, 4, or 5");
                                    }
                                }
                            }
                        }
                    }
                } while(badInput);
            } catch(InputMismatchException ime) {
                badInput = true;
                System.out.println("Enter 1, 2, 3, 4, or 5");
                System.out.print("Input: ");
                in.next();
            }
        } while(badInput);
    }
}