import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ArrayListActivity {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        ArrayList<Integer> merged = new ArrayList<Integer>();

        Scanner input = new Scanner(System.in);
        //vars
        int inp;
        int cnt, size, size2 = 0;
        char choice;
        System.out.println("ENTER HOW MANY ELEMENTS YOU WANT IN LIST #1");
        while (!input.hasNextInt()) { //looping for error if string input
            System.out.println("Please Enter An Interger");
            input.next();
        }
        size = input.nextInt();
        System.out.println("NOW INPUT AND PRESS ENTER YOUR ELEMENTS");
        for(cnt = 0; cnt<size; cnt++) { //loop for getting user input in arraylist
            while(true) { //loop for repeating the input if the user entered a string
                System.out.print("ELEMENT #" + (cnt+1) + ":");
                if (input.hasNextInt()) {
                inp = input.nextInt();
                numbers.add(inp);
                break;
            } else {
                System.out.println("PLEASE ENTER AN INTEGER");
                input.next();
                }
            }
        }
        System.out.println("ENTER HOW MANY ELEMENTS YOU WANT IN LIST #2");
        while (!input.hasNextInt()) {
            System.out.println("Please Enter An Interger");
            input.next();
        }
        size2 = input.nextInt();
        System.out.println("NOW INPUT AND PRESS ENTER YOUR ELEMENTS");
        for(cnt = 0; cnt<size2; cnt++) {
                while(true) {
                    System.out.print("ELEMENT #" + (cnt+1) + ":");
                    if (input.hasNextInt()) {
                    inp = input.nextInt();
                    numbers2.add(inp);
                    break;
                } else {
                    System.out.println("PLEASE ENTER AN INTEGER");
                    input.next();
                }
            }
        }
            System.out.println("Your list #1: " + numbers);
            System.out.println("Your list #2: " + numbers2);
            System.out.println("COMBINING YOUR LISTS...");
            System.out.println("LISTS ARE NOW COMBINED!");

            merged.addAll(numbers); //combines 2 lists
            merged.addAll(numbers2);
            Collections.sort(merged);
            System.out.println("Your combined list: " + merged);

            HashSet<Integer> noDup = new HashSet<Integer>(merged); // removes duplicates
            noDup.addAll(merged); //adding merged list in the hashset
            System.out.println("Your list without duplicates: " + noDup);
    }
}
