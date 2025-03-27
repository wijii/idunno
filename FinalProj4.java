import java.util.Scanner;

public class FinalProj4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("\t+-----------------------------------------------------------+");
        System.out.println("\t|               Welcome to the Payroll System!              |");      
        System.out.println("\t+-----------------------------------------------------------+");
        System.out.println("\t| Please follow the steps below to provide your details:    |");
        System.out.println("\t|                                                           |");
        System.out.println("\t|  ~>Enter your personal details                            |");
        System.out.println("\t|  ~>Enter your work details                                |");
        System.out.println("\t|  ~>Specify if you have dependents (affects tax rate):     |");
        System.out.println("\t|    - Type \"A\" for 5% tax                                  |");
        System.out.println("\t|    - Type \"B\" for 10% tax                                 |");
        System.out.println("\t| ~>Enter your Designation:                                 |");
        System.out.println("\t|      [A] for Part-time                                    |");
        System.out.println("\t|      [B] for Regular                                      |");
        System.out.println("\t|      [C] for Manager                                      |");
        System.out.println("\t| After entering all the details, your payroll information  |");
        System.out.println("\t| including Gross Pay, Tax, and Net Pay will be displayed.  |");
        System.out.println("\t+-----------------------------------------------------------+");
        
       
        String name = dName(input);
        String address = dAddress(input);
        String birthday = dBirthday(input);
        long phone = dPhoneNumber(input);
        String email = dEmail(input);
        char designation = designationPos(input);

        int hrsworked = getHoursWorked(input);

        double grossPay = grossPay(designation, hrsworked);

        double tax = taxRate(input, grossPay);

        double netPay = netPay(grossPay, tax);

        char ecode = employeeCode(input, designation);

        // Display all 
        displayAll(name, address, birthday, phone, email, ecode, designation, grossPay, tax, netPay);
        input.close(); 
    }

   //method 4name
   public static String dName(Scanner input) {
    System.out.print("Enter Your Name: ");
    return input.nextLine();
}
  //merod 4 address
public static String dAddress(Scanner input) {
    System.out.print("Address: ");
    return input.nextLine();
}
//method 4 bidet
public static String dBirthday(Scanner input) {
    System.out.print("Birthday: ");
    return input.nextLine();
}
//4 phone number
public static long dPhoneNumber(Scanner input) {
    while(true){
        System.out.print("Phone number: ");
        if (input.hasNextLong()){
            long phone = input.nextLong();
            input.nextLine(); 
            return phone;
        } else {
            System.out.println("Invalid phone number, please enter digits only.");
            input.nextLine();
        }
    }
}
// da email
public static String dEmail(Scanner input) {
    System.out.print("Email Address: ");
    return input.nextLine();
}

    
//method for desig
    public static char designationPos(Scanner input) {
        char designation = ' ';
        while (true) {
            System.out.print("Enter your designation (A-Part-time, B-Regular, C-Manager): ");
            designation = input.next().toUpperCase().charAt(0);
            if (designation == 'A' || designation == 'B' || designation == 'C') { 
                return designation;
            } else {
                System.out.println("Invalid Designation. Please enter A, B, or C.");
                input.next();
            }
        }
        
    }
    //posgiver
    public static String rankDesignation(char designation) {
        if (designation == 'A') {
            return "Part-time";
        } else if (designation == 'B') {
            return "Regular";
        } else {
            return "Manager";
        }
    }

//method for hrswroked
    public static int getHoursWorked(Scanner input) {
        int userInput = 0;
        while(true){
            System.out.print("Enter your hours worked: ");
            if (input.hasNextInt()) {
            userInput = input.nextInt();
            return userInput;
            } else {
                System.out.println("Invalid input, please enter a valid number.");
                input.next();
            }
        }
    }

    //meethod for grosspay   
    public static double grossPay(char designation, int hrsworked) {
        double ratePerHr = 0;
        switch (designation) {
            case 'A': ratePerHr = 250.00; 
            break;
            case 'B': ratePerHr = 320.00; 
            break;
            case 'C': ratePerHr = 450.00;
            break;
        }
        return ratePerHr * hrsworked;
    }

// emthod for tax
    public static double taxRate(Scanner input, double grossPay) {
        char dependent;
        double tax = 0;
        
        while (true) {
            System.out.print("Choose 'A' for [yes] with dependent (5% tax) and 'B' for [no] without dependent (10% tax): ");
            dependent = input.next().toUpperCase().charAt(0);
            
            if (dependent == 'A') {
                tax = grossPay * 0.05; 
                break; 
            } else if (dependent == 'B') {
                tax = grossPay * 0.10; 
                break; 
            } else {
                System.out.println("Invalid choice. Please enter 'A' for with dependent or 'B' for without dependent.");
            }
        }  
        return tax;
    }

   //methoid for netpay
    public static double netPay(double grossPay, double tax) {
        return grossPay - tax;
    }

//method for ecode
    public static char employeeCode(Scanner input, char designation) {
        char ecode = ' ';
        while (true) {
            System.out.print("Choose your employee code (A, B, C): ");
            ecode = input.next().toUpperCase().charAt(0);
            if (matchEmployeeCode(ecode, designation)) { // dito papasok ung boolean na method
                break;
            } else {
                System.out.println("\nInvalid Employee Code for the given designation. Please try again.");
            }
        }
        return ecode;
    }

    // nagccheck kung mmatch employee code sa selected designation
    public static boolean matchEmployeeCode(char ecode, char designation) {
        return (ecode == 'A' && designation == 'A') ||
               (ecode == 'B' && designation == 'B') ||
               (ecode == 'C' && designation == 'C') || (ecode == 'a' && designation == 'a') ||
               (ecode == 'b' && designation == 'b') ||
               (ecode == 'c' && designation == 'c');
    }

// method pangdisplay ng lht ng prompts (not including calculations ofc)
public static void displayAll(String name, String address, String birthday, long phone, String email, 
char ecode, char designation, double grossPay, double tax, double netPay) {

        
        String rankDesignation = rankDesignation(designation);

        // Display Employee Profile
    System.out.println("+------------------------------------------------+");
    System.out.println("|                 Employee Profile               |");
    System.out.println("+------------------------------------------------+");
    System.out.println(" Name                : " + name);
    System.out.println(" Address             : " + address);
    System.out.println(" Birthday            : " + birthday);
    System.out.println(" Phone Number        : 0"+ phone);
    System.out.println(" Email               : " + email);
    System.out.println(" Employee Code       : " + ecode);
    System.out.println(" Designation         : " + rankDesignation);
    System.out.println("--------------------------------------------------");
    System.out.println("");
        
        // Display Payroll Details
    System.out.println("+------------------------------------------------+");
    System.out.println("|                 Payroll Details                |");
    System.out.println("+------------------------------------------------+");
    System.out.println(" Gross Pay           : " + grossPay);
    System.out.println(" Tax                 : " + tax);
    System.out.println(" Net Pay             : " + netPay);
    System.out.println("--------------------------------------------------");
        

    }
}
