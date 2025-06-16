import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JournalBaby {

    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String journal;
        String fileName;
        int option;

        while(true) {
            printHeader();

            System.out.println(YELLOW + "   1. Add New Entry");
            System.out.println("   2. View Entry");
            System.out.println("   3. Exit" + RESET);
            System.out.print(BLUE + "\n   CHOOSE AN OPTION BABY: " + RESET);

            while (!input.hasNextInt()) {
                System.out.print(RED + "   Invalid input. Enter a number: " + RESET);
                input.next();
            }
            option = input.nextInt();
            input.nextLine();

            switch(option) {
                case 1:
                    System.out.print(PURPLE + "\nEnter your file name baby: " + RESET);
                    fileName = input.nextLine() + ".txt";

                    System.out.println(CYAN + "\nEnter your journal entry baby:\n" + RESET);
                    journal = input.nextLine();

                    try (PrintWriter writer = new PrintWriter(new FileWriter("D:\\coding\\journalhehe\\" + fileName, true))) {
                        writer.println(journal);
                        writer.println();
                        System.out.println(GREEN + "\nJOURNAL SAVED!\n" + RESET);
                    } catch(IOException e) {
                        System.out.println(RED + "Error saving journal entry: " + e.getMessage() + RESET);
                    }
                    break;

                case 2:
                    System.out.print(PURPLE + "\nEnter the file name of the journal you want to view: " + RESET);
                    fileName = input.nextLine() + ".txt";

                    try {
                        System.out.println(YELLOW + "\nJournal Entries:" + RESET);
                        System.out.println(BLUE + "-----------------------------------------------------" + RESET);
                        System.out.println(fileName);
                        System.out.println(new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("D:\\coding\\journalhehe\\" + fileName))));
                        System.out.println(BLUE + "-----------------------------------------------------\n" + RESET);
                    } catch (IOException e) {
                        System.out.println(RED + "Error reading journal entries: " + e.getMessage() + RESET);
                    }
                    break;

                case 3:
                    System.out.println(GREEN + "\nThank you baby! Pede ko ba basahin entries mo pagpunta ko mwa \n" + RESET);
                    System.exit(0);

                default:
                    System.out.println(RED + "\nWala sa option baby mwamwa \n" + RESET);
            }
        }
    }

    public static void printHeader() {
        System.out.println(BLUE + "-----------------------------------------------------" + RESET);
        System.out.println(PURPLE + "                  YOUR JOURNAL BABY" + RESET);
        System.out.println(BLUE + "-----------------------------------------------------" + RESET);
    }
}
