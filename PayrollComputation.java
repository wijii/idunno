
import java.util.ArrayList;
import java.util.Scanner;

public class FinalProject { 
    //Style
    public static final String reset = "\033[0m";
    public static final String italic= "\033[3m";
    public static final String bold = "\033[1m";
    
    //Ansii code color FONT
    public static final String red = "\033[38;5;160m";
    public static final String blue = "\033[38;5;195m";
    public static final String black = "\033[30m";
    public static final String pink = "\033[38;5;224m";
    public static final String pink2 = "\033[38;5;174m";
    public static final String gray = "\033[38;5;240m";
    public static final String porpol = "\033[38;5;147m";
    public static final String brown = "\033[38;5;94m";
    public static final String white = "\033[38;5;231m";
    public static final String green = "\033[38;5;150m";
    public static final String yellow = "\033[38;5;230m";
    public static final String yellow2 = "\033[38;5;227m";
    // ansii code color BG
    public static final String whitebg = "\033[47m"; 
    public static final String pinkbg = "\033[48;5;224m";
    public static final String yellowbg = "\033[48;5;230m";
    public static final String porpolbg = "\033[48;5;189m";
    public static final String graybg = "\033[48;5;237m";
    public static final String bluebg = "\033[48;5;195m";
    
    // global variables nilagay ko na lahat dto para malinis main
    static ArrayList<String[]> listEmployee = new ArrayList<String[]>();
    static Scanner input = new Scanner(System.in);
    static int choice = 0;
    static String option = " ";
    static String employeeId = " ";
    static boolean found = false;
    static int i = 0;
    static String line;
    static double rate = 0;

    public static void main(String[] args) {
        mainMenu();
    }

    public static int mainMenu() {
        while (true) {
            System.out.println(bold + pinkbg + pink2 + "\t╔════════════════════════════════════════════════════════════════════╗" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║ " + reset  + bold + whitebg + black + "             Welcome to the Payroll Management System!             " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t╚════════════════════════════════════════════════════════════════════╝" + reset);
            System.out.println(bold + pinkbg + pink2 + "\t╔════════════════════════════════════════════════════════════════════╗" + reset);
            System.out.println(bold + pinkbg + pink2 + "\t║                                MENU                                ║" + reset);
            System.out.println(bold + pinkbg + pink2 + "\t╠════════════════════════════════════════════════════════════════════╣" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                                                                    ║" + reset);

            System.out.println(bold + whitebg + pink2 + "\t║                                                                    ║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [1]" + reset + bold + whitebg + black + " Add Employee                              " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [2]" + reset + bold + whitebg + black + " Remove Employee                           " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [3]" + reset + bold + whitebg + black + " View Employee                             " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [4]" + reset + bold + whitebg + black + " Exit                                      " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                                                                    ║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t╚════════════════════════════════════════════════════════════════════╝" + reset);
            
            while (true) {
                System.out.print(bold + pink + "\n\t >> " + reset);
                System.out.print(bold + white + " Select from 1 to 4: " + reset);
                line = input.nextLine().trim();
                
                if (line.isEmpty()) {
                    System.out.println(italic + red + "\t     Input cannot be empty. Please enter a number between 1 and 4." + reset);
                    continue;
                }
                    try {
                        choice = Integer.parseInt(line);
                        if (choice >= 1 && choice <= 4) {
                            break;
                        } else {
                            System.out.println(italic + red + "\t     Invalid input. Please enter a number between 1 and 4." + reset);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(italic + red + "\t     Invalid input. Please enter a valid number between 1 and 4." + reset);
                    }
                }
                switch (choice) {
                    case 1:  
                        addEmployee();
                        break;
                    case 2:
                        removeEmployee();
                        break;
                    case 3:
                        viewEmployeeMenu();
                        break;
                    case 4:
                        System.out.println(italic + white + "\n\t     Exiting the program..." + reset);
                        System.out.println(bold + green + "\t     Program Closed." + reset);
                        System.out.println(bold + italic + pink + "\n\t     Thank you for using the Payroll System!" + reset);
                        return 0;
                    default:
                        System.out.print(italic + "\t   Invalid option. Please enter a number between 1 and 4." + reset);
                }
            }
        }
    
    public static void addEmployee() {
        char ch, idCode, eIdCode;
        while (true) {
            String employee[] = new String[13];// changed size of an array to 13 for total deduction, tax, philhealt, pagibig, loan ************************ 
            System.out.println(bold + pink + italic + "\n\t╔═══════════════════════════ Add Employee ═══════════════════════════╗" + reset);
            System.out.print(bold + white + "\t   Enter name: " + reset);
            while (true) {
                employee[0] = input.nextLine();

                if (employee[0].isEmpty()) {
                    System.out.print(italic + red + "\t   Name cannot be empty." + reset);
                    System.out.print(bold + white + "\n\t   Enter name: " + reset);
                    continue;
                }

                i = 0;
                while (i < employee[0].length()) {
                    ch = employee[0].charAt(i);
                    if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == ' ')) {
                        break;
                    }
                    i++;
                }

                if (i == employee[0].length()) {
                    break; 
                } else {
                    System.out.println(italic + red + "\t   Name must only contain letters." + reset);
                    System.out.print(bold + white + "\t   Enter name: " + reset);
                }
            }
    
        while (true) {
            System.out.print(bold + white + "\t   Enter employee ID number: " + reset); // empty input = error
            employee[1] = input.nextLine().toUpperCase().trim(); 
            
            if (employee[1].isEmpty()) {
                System.out.println(italic + red + "\t   Employee ID cannot be empty." + reset);
                continue; 
            }
            idCode = Character.toUpperCase(employee[1].charAt(0)); //getting the letter inputed in the employee number

            //check if the employee id starts with the appropriate letter
            if (idCode != 'P' && idCode != 'R' && idCode != 'M'){
                System.out.println(italic + red + "\t   Employee ID must start with P, R, or M." + reset);
                continue;
            }
            
            //check if the input is numerical after the employee code
            try {
                Integer.parseInt(employee[1].substring(1)); 
            } catch (NumberFormatException e) {
                System.out.println(italic + red + "\t   Incorrect format. Employee ID must be a letter followed by digits." + reset);
                continue; 
            }
            
            boolean idExists = false;
            for (i = 0; i < listEmployee.size(); i++) {
                if (listEmployee.get(i)[1].equals(employee[1])) {
                    System.out.println(italic + red + "\t   ID already exists. Enter a different employee ID number." + reset);
                    idExists = true;
                    break;
                }
            }
            
            if (idExists) {
                continue;
            }
            
            break;
        }

        System.out.print(bold + white + "\t   Enter phone number: " + reset) ;
        while (true) { 
            employee[2] = input.nextLine();

            if (employee[2].isEmpty()) {
                System.out.print(italic + red + "\t   Phone number cannot be empty." + reset);
                System.out.print(bold + white + "\n\t   Enter phone number: " + reset);
                continue;  
            }
        
            try {
                Long.parseLong(employee[2]); //conversion 
                break;  
            } catch (NumberFormatException e) {
                System.out.print(italic + red + "\t   Invalid phone number." + reset);
                System.out.print(bold + white + "\n\t   Enter phone number: " + reset);
            }
        }
        
            System.out.print(bold + white + "\t   Enter email: " + reset);
            while (true) { 
                employee[3] = input.nextLine();
                if (!employee[3].isEmpty()) break;
                System.out.print(italic + red + "\t   Email cannot be empty." + reset);
            }
        
            while (true) { 
            System.out.print(bold + white + "\t   Enter employee designation (Part-time, Regular, Manager): " + reset);
            employee[4] = input.nextLine().trim();

            if (employee[4].isEmpty()) {
                System.out.println(italic + red + "\t   Designation cannot be empty." + reset);
                continue;
            }

            // Check if it's a valid designation (case-insensitive)
            if (employee[4].equalsIgnoreCase("Manager") || employee[4].equalsIgnoreCase("Part-time") || employee[4].equalsIgnoreCase("Regular")) {
                // Keep the designation as entered by user
            } else {
                System.out.println(italic + red + "\t   Invalid designation. Please enter either Part-time, Regular, or Manager." + reset);
                continue;
            }
            
            eIdCode = Character.toUpperCase(employee[4].charAt(0)); // Get the first letter

            // Check if the designation and the employee number matches
            if (idCode != eIdCode) {
                System.out.println(italic + red + "\t   Designation must match with your employee number." + reset);
                continue;
            } 
            break;
        }
            //hours worked
            double hours;
            final double weekly = 168.0; // Maximum hours in a week (24 hours * 7 days)
            final double standard = 40.0; // Standard work week for reference

            while (true) {
                System.out.print(bold + white + "\t   Enter hours worked: " + reset); 
                String doubleInput = input.nextLine();

                if (doubleInput.isEmpty()) {
                    System.out.println(italic + red + "\t   Hours worked cannot be empty." + reset);
                    continue;
                }
                
                try {
                    hours = Double.parseDouble(doubleInput);
                    
                    if (hours < 0) {
                        System.out.println(italic + red + "\t   Hours worked cannot be negative." + reset);
                        continue;
                    }
                    
                    if (hours > weekly) {
                        System.out.println(italic + red + "\t   Invalid working hours. Maximum hours per week is " + weekly     + " hours." + reset);
                        continue;
                    }
                    
                    // Optional: Warning for excessive hours (more than standard work week)
                    if (hours > standard) {
                        System.out.println(italic + yellow + "\t   Warning: Hours exceed standard work week (" + standard + " hours)." + reset);
                    }
                    
                    employee[5] = String.valueOf(hours);
                    break;

                } catch (NumberFormatException e) {
                    System.out.println(italic + red + "\t   Invalid input. Please enter a valid number." + reset);
                }
            }

            String dependent = " ";
            while (true) {
                System.out.print(bold + white + "\t   Does the employee have dependents? (yes/no): " + reset);
                dependent = input.nextLine().toLowerCase();
                if (dependent.equals("yes") || dependent.equals("no")) {
                    break;
                } else {
                    System.out.println(italic + red + "\t   Invalid input. Please enter 'yes' or 'no'." + reset);
                }
            }
            
            double loan = 0;
            while (true) {
                System.out.print(bold + white + "\t   Enter loan amount: " + reset);
                try { 
                    loan = Double.parseDouble(input.nextLine());
                    if (loan < 0) {
                        System.out.println(italic + red + "\t   Loan amount cannot be negative" + reset);
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println(italic + red + "\t   Invalid input. PLease enter a valid loan amount." + reset);
                }
            }
             //calcu
             if (employee[4].equalsIgnoreCase("Part-time")){
                rate = 250;
            } else if (employee[4].equalsIgnoreCase("Regular")){
                rate = 320;
            } else if (employee[4].equalsIgnoreCase("Manager")){
                rate = 450;
            }
            //CUMPUTATION TU
            double grossPay = rate * hours;
            double tax = dependent.equals("yes") ? grossPay * 0.05 : grossPay * 0.10;
            double pagibig = 100;
            double philhealth = 200;
            double netPay = grossPay - (tax + pagibig + philhealth + loan);
            double deduction = tax + pagibig + philhealth + loan;//added ************************ computation for total deduction
            
            employee[6] = String.valueOf(grossPay);
            employee[7] = String.valueOf(netPay);
            employee[8] = String.valueOf(tax);//added ************************ for tax 
            employee[9] = String.valueOf(pagibig);//added ************************ for pag ibig
            employee[10] = String.valueOf(philhealth);//added ************************ for phil health
            employee[11] = String.valueOf(loan);//added ************************ for loan
            employee[12] = String.valueOf(deduction);//added ************************ for total deduction
            
            listEmployee.add(employee);
            System.out.println(bold + green + italic + "\n\t   Employee " + employee[0] + " added successfully!" + reset);
            System.out.print(bold + white + "\n\t   Do you want to add another employee? (yes/no): " + reset);
            option = input.nextLine().toLowerCase();

            if (option.equals("no")) {
                System.out.println(italic + white + "\n\t   Returning to main menu..." + reset);
                System.out.println("");
                break;
            }

            while (!option.equals("yes") && !option.equals("no")) {
                System.out.println(italic + red + "\t   Invalid input. Please enter 'yes' or 'no'." + reset);
                System.out.print(bold + white + "\n\t   Do you want to add another employee? (yes/no): " + reset);
                option = input.nextLine().toLowerCase();
                }
            }
        }
    public static void removeEmployee() {
        
            while (true) {
            // First check if there are any employees to remove
            if (listEmployee.isEmpty()) {
                System.out.println(bold + pink + italic + "\n\t╔═════════════════════════ Remove Employee ══════════════════════════╗" + reset);
                System.out.println(italic + red + "\t   No employees found to remove." + reset);
                System.out.println(italic + white + "\t   Returning to main menu..." + reset);
                return; // Exit the method if no employees exist
            }
            
            System.out.println(bold + pink + italic + "\n\t╔═════════════════════════ Remove Employee ══════════════════════════╗" + reset);
            System.out.print(bold + white + "\t   Enter employee ID number: " + reset);
            
            while (true) { 
                employeeId = input.nextLine().toUpperCase().trim(); // convert to uppercase and remove leading/trailing spaces
                if (!employeeId.isEmpty()) break;
                System.out.print(italic + red + "\t   Employee ID cannot be empty." + reset);
                System.out.print(bold + white + "\n\t   Enter the employee ID number: " + reset);
            }
            
            found = false;
            String[] foundEmployee = null;

            // Find the employee first
            for (i = 0; i < listEmployee.size(); i++) {
                String[] employee = listEmployee.get(i);
                if (employee[1].equals(employeeId)) {
                    foundEmployee = employee;
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(italic + red + "\t   Employee with ID " + employeeId + " not found." + reset);
            } else {
                // Display employee information for confirmation
                System.out.println(bold + pink + italic + "\n\t╔═══════════════════════ Employee Information ═══════════════════════╗" + reset);
                System.out.println("");
                System.out.println(bold + white + "\t                               EMPLOYEE DETAILS                             " + reset);
                System.out.println("");
                
                // Create a mini payslip display for confirmation
                System.out.println(bold + pink + "\t Employee Name:  " + reset + white + formatField(foundEmployee[0], 40) + reset);
                System.out.println(bold + pink + "\t Employee ID:    " + reset + white + formatField(foundEmployee[1], 40) + reset);
                System.out.println(bold + pink + "\t Designation:    " + reset + white + formatField(foundEmployee[4], 40) + reset);
                System.out.println(bold + pink + "\t Gross Pay:      " + reset + white + "Php " + formatCurrency(foundEmployee[6]) + reset);
                System.out.println("");

                // Stylized confirmation box
                System.out.println(pinkbg + bold + pink2 + "\t╔════════════════════════════════════════════════════════════════════╗" + reset);
                System.out.println(pinkbg + bold + pink2 + "\t║                            CONFIRMATION                            ║" + reset);
                System.out.println(pinkbg + bold + pink2 + "\t╠════════════════════════════════════════════════════════════════════╣" + reset);
                System.out.println(whitebg + pink2 + "\t║ " + reset + bold + whitebg + red + "⚠ WARNING: This action cannot be undone!" + reset + whitebg + pink2 + "                           ║" + reset);
                System.out.println(whitebg + pink2 + "\t║ " + reset + bold + whitebg + black + "Are you sure you want to remove this employee?" + reset + whitebg + pink2 + "                     ║" + reset);
                System.out.println(whitebg + pink2 + "\t║                                                                    ║" + reset);
                System.out.println(whitebg + pink2 + "\t║ " + reset + bold + whitebg + green + "Type 'YES'" + reset + whitebg + black + " to confirm or " + reset + bold + whitebg + red + "'NO'" + reset + whitebg + black + " to cancel" + reset + whitebg + pink2 + "                            ║" + reset);
                System.out.println(whitebg + pink2 + "\t╚════════════════════════════════════════════════════════════════════╝" + reset);

                // Get confirmation
                String confirmation;
                while (true) {
                    System.out.print(bold + pink + "\n\t >> " + reset);
                    System.out.print(bold + white + " Input your option: " + reset);
                    confirmation = input.nextLine().trim().toUpperCase();

                    if (confirmation.equals("YES")) {
                        // Remove the employee
                        listEmployee.remove(i);
                        System.out.println(bold + green + "\n\t   ✓ Employee " + foundEmployee[0] + " (ID: " + employeeId + ") has been successfully removed." + reset);
                        break;
                    } else if (confirmation.equals("NO")) {
                        System.out.println(italic + yellow + "\n\t   Operation cancelled. Employee was not removed." + reset);
                        break;
                    } else {
                        System.out.println(italic + red + "\t     Invalid input. Please type 'YES' to confirm or 'NO' to cancel." + reset);
                    }
                }
            }
            
            // Check if there are still employees left
            if (listEmployee.isEmpty()) {
                System.out.println(italic + white + "\n\t   No more employees to remove. Returning to main menu..." + reset);
                return; // Exit the method if no more employees 
            } else {
                // Ask if want to remove another employee
                while (true) {
                    System.out.print(bold + white + "\n\t   Do you want to remove another employee? (yes/no): " + reset);
                    option = input.nextLine().toLowerCase();

                    if (option.equals("yes")) {
                        break; // loop again to remove another employee
                    } else if (option.equals("no")) {
                        System.out.println(italic + white + "\t   Returning to main menu..." + reset);
                        return; // Exit the method and return to main menu
                    } else {
                        System.out.println(italic + red + "\t   Invalid input. Please enter 'yes' or 'no'." + reset);
                    }
                }
            }
        }
    }
    
    public static void viewEmployeeMenu() {
        while (true) {
            System.out.println("");
            System.out.println(bold + pinkbg + pink2 + "\t╔════════════════════════════════════════════════════════════════════╗" + reset);
            System.out.println(bold + pinkbg + pink2 + "\t║                           EMPLOYEE MENU                            ║" + reset);
            System.out.println(bold + pinkbg + pink2 + "\t╠════════════════════════════════════════════════════════════════════╣" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                                                                    ║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║ " + reset  + bold + whitebg + black + "         Choose how you would like to view employee data.          " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║ " + reset  + bold + whitebg + black + "                       Select an option:                           " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [1]" + reset + bold + whitebg + black + " View All Employee                         " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [2]" + reset + bold + whitebg + black + " View by Employee Number                   " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [3]" + reset + bold + whitebg + black + " View by Designation                       " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                      [4]" + reset + bold + whitebg + black + " Main Menu                                 " + pink2 + "║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t║                                                                    ║" + reset);
            System.out.println(bold + whitebg + pink2 + "\t╚════════════════════════════════════════════════════════════════════╝" + reset);
    
            while (true) {
                System.out.print(bold + pink + "\n\t >> " + reset);
                System.out.print(bold + white + " Select from 1 to 4: " + reset);
                line = input.nextLine().trim();

                    if (line.equals("1") || line.equals("2") || line.equals("3") || line.equals("4")) {
                        choice = Integer.valueOf(line);  
                        break;
                    } else {
                        System.out.println(italic + red + "\t     Invalid input. Please enter a number between 1 and 4." + reset);
                    } 
                }   
    
            boolean conView = true;
    
            switch (choice) {
                case 1:
                    viewAllEmployees();
                    conView = viewAgain();
                    break;
                case 2:
                    viewEmployeeByNumber();
                    conView = viewAgain();
                    break;
                case 3:
                    viewByDesignation();
                    conView = viewAgain();
                    break;
                case 4:
                    return; // go back to main menu
                default:
                    System.out.println("Invalid option. Please try again.");
            }
    
            if (!conView) {
                return; // go back to main menu
            }
        }
    }

    // para consistent ung format ng width
    private static String formatField(String text, int width) {
        if (text.length() > width) {
            return text.substring(0, width - 3) + "...";
        }
        // pag mas short ung text sa width, add spaces
        StringBuilder result = new StringBuilder(text);
        while (result.length() < width) {
            result.append(" ");
        }
        return result.toString();
    }
    
    // same lang pero sa currency
    private static String formatCurrency(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return String.format("%.2f", value);
        } catch (NumberFormatException e) {
            return amount;
        }
    }

    // Helper method to display employee payslip with consistent formatting
    private static void thePayslip(String[] employee) {
        System.out.println("");
        System.out.println(bold + white + "\t                                     PAY SLIP                                    " + reset);
        System.out.println("");
        
        // Format employee details with consistent width
        System.out.println(bold + pink + "\t Employee Name:  " + reset + white + formatField(employee[0], 40) + reset);
        System.out.println(bold + pink + "\t Employee ID:    " + reset + white + formatField(employee[1], 40) + reset);
        System.out.println(bold + pink + "\t Phone Number:   " + reset + white + formatField(employee[2], 40) + reset);
        System.out.println(bold + pink + "\t Email:          " + reset + white + formatField(employee[3], 40) + reset);
        System.out.println(bold + pink + "\t Designation:    " + reset + white + formatField(employee[4], 40) + reset);
        System.out.println(bold + pink + "\t Hours Worked:   " + reset + white + formatField(employee[5], 40) + reset);
        System.out.println("");

        // Format amounts with consistent decimal places
        String grossPay = formatCurrency(employee[6]);
        String tax = formatCurrency(employee[8]);
        String pagibig = formatCurrency(employee[9]);
        String philhealth = formatCurrency(employee[10]);
        String loan = formatCurrency(employee[11]);
        String totalDeduction = formatCurrency(employee[12]);
        String netSalary = formatCurrency(employee[7]);

        System.out.println(pinkbg + bold + pink2 + "\t╔════════════════════════╦══════════════╦═════════════════════════╦══════════════╗" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t║        Earnings        ║    Amount    ║       Deductions        ║    Amount    ║" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t╠════════════════════════╬══════════════╬═════════════════════════╬══════════════╣" + reset);
        System.out.println(whitebg + pink2 + "\t║ Basic Salary           ║ Php " + formatField(grossPay, 8) + " ║ Withholding Tax         ║ Php " + formatField(tax, 8) + " ║" + reset);
        System.out.println(whitebg + pink2 + "\t║                        ║              ║ Pag-IBIG                ║ Php " + formatField(pagibig, 8) + " ║" + reset);
        System.out.println(whitebg + pink2 + "\t║                        ║              ║ PhilHealth              ║ Php " + formatField(philhealth, 8) + " ║" + reset);
        System.out.println(whitebg + pink2 + "\t║                        ║              ║ Loan                    ║ Php " + formatField(loan, 8) + " ║" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t╠════════════════════════╩══════════════╩═════════════════════════╩══════════════╣" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t║ Gross Earnings         ║ Php " + formatField(grossPay, 8) + " ║ Total Deductions        ║ Php " + formatField(totalDeduction, 8) + " ║" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t╠════════════════════════════════════════════════════════════════════════════════╣" + reset);
        System.out.println(whitebg + bold + pink2 + "\t║                                                    Net Salary: Php " + formatField(netSalary, 10) + "  ║" + reset);
        System.out.println(whitebg + bold + pink2 + "\t╚════════════════════════════════════════════════════════════════════════════════╝" + reset);
    }

    public static void viewAllEmployees() {
        if (listEmployee.isEmpty()) {
        System.out.println(bold + pink + italic + "\n\t╔═══════════════════════════ All Employee ═══════════════════════════╗" + reset);
        System.out.println(italic + red + "\t     No employees found." + reset); 
        return;
        }
        
        System.out.println(bold + pink + italic + "\n\t╔══════════════════════════════════ All Employee ═════════════════════════════════╗" + reset);
        System.out.println("");
        System.out.println(bold + white + "\t                                   EMPLOYEE LIST                                   " + reset);
        System.out.println("");
        
    
        System.out.println(pinkbg + bold + pink2 + "\t╔═══════════════╦══════════════════════════╦═══════════════════╦═══════════════╗" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t║ Employee ID   ║       Employee Name      ║   Designation     ║   Gross Pay   ║" + reset);
        System.out.println(pinkbg + bold + pink2 + "\t╠═══════════════╬══════════════════════════╬═══════════════════╬═══════════════╣" + reset);
        
   
        for (String[] employee : listEmployee) {
            String empId = formatField(employee[1], 13);           // Employee ID
            String empName = formatField(employee[0], 24);         // Employee Name  
            String empDesignation = formatField(employee[4], 17);  // Designation
            String empGrossPay = "Php " + formatCurrency(employee[6]); // Gross Pay
            empGrossPay = formatField(empGrossPay, 13);            // Format gross pay field
            
            System.out.println(whitebg + pink2 + "\t║ " + empId + " ║ " + empName + " ║ " + empDesignation + " ║ " + empGrossPay + " ║" + reset);
        }
        
    
        System.out.println(pinkbg + bold + pink2 + "\t╚═══════════════╩══════════════════════════╩═══════════════════╩═══════════════╝" + reset);
        
        System.out.println("");
        System.out.println(bold + pink + "\t Total Employees: " + reset + white + listEmployee.size() + reset);
        System.out.println("");
    }

    public static void viewEmployeeByNumber() {
        System.out.print(bold + white + "\n\t   Enter the employee ID number: " + reset);
        while (true) { 
            employeeId = input.nextLine().toUpperCase().trim();
            if (!employeeId.isEmpty()) break;
            System.out.print(italic + red + "\t   Employee ID cannot be empty." + reset);
            System.out.print(bold + white + "\n\t   Enter the employee ID number: " + reset);
        }
        found = false;

        for (String[] employee : listEmployee) {
            if (employee[1].equals(employeeId)) {
                System.out.println(bold + pink + italic + "\n\t╔═══════════════════════════════════════ By Number ═════════════════════════════════════╗" + reset);
                thePayslip(employee);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.print(italic + red + "\t   Employee with ID " + employeeId + " not found." + reset);
        }
    }

    public static void viewByDesignation() {
        System.out.print(bold + white + "\n\t   Enter the designation (Part-time, Regular, Manager): " + reset);
        while (true) { 
            option = input.nextLine();
            if (!option.isEmpty()) break;
            System.out.print(italic + red + "\t   Designation cannot be empty." + reset);
            System.out.print(bold + white + "\n\t   Enter the designation (Part-time, Regular, Manager): " + reset);
        }
    
        found = false;
    
        for (String[] employee : listEmployee) {
            if (employee[4].equalsIgnoreCase(option)) {
                System.out.println(bold + pink + italic + "\n\t╔═════════════════════════════════════ By Designation ═══════════════════════════════════╗" + reset);
                // Use the same display method that is used in viewEmployeeByNumber for consistency
                thePayslip(employee);
                found = true;
            }
        }
    
        if (!found) {
            System.out.println(italic + red + "\t   No employees found with designation: " + option + reset);
        }
    }

    public static boolean viewAgain() {
        while (true) {
            System.out.print(bold + white + "\n\t Go back to Employee Viewing Options? (yes/no): " + reset);
            option = input.nextLine().toLowerCase();

            if (option.equals("yes")) {
                return true; // balik to View Employee Menu
            } else if (option.equals("no")) {
                System.out.println(italic + white + "\t   Returning to main menu..." + reset);
                return false; // balik to Main Menu
            } else {
                System.out.println(italic + red + "\t   Invalid input. Please enter 'yes' or 'no'." + reset);
            }
        }
    }
}
