import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
    
        String word, reverse = "";
        int vowelCount = 0;
        int i; 
        boolean isPalindrome = false;

       
        Scanner input = new Scanner(System.in);

        // User-Input
        System.out.print("Please enter a word: ");
        word = input.nextLine();

        // Get the Vowel Counts
        for (i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' ||
                    word.charAt(i) == 'i' ||
                    word.charAt(i) == 'o' ||
                    word.charAt(i) == 'u' ||
                    word.charAt(i) == 'A' ||
                    word.charAt(i) == 'E' ||
                    word.charAt(i) == 'I' ||
                    word.charAt(i) == 'O' ||
                    word.charAt(i) == 'U'
            ) {
                vowelCount++;
            }
        }

 
        for (i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

    
        if (word.equalsIgnoreCase(reverse)) {
            isPalindrome = true;
        }

   
        System.out.println("\n======================");
        System.out.println("Reversed Word: " + reverse);
        System.out.println("Number of Vowels: " + vowelCount);
        System.out.println("Palindrome or Not a Palindrome: " + isPalindrome);
        System.out.println("======================");

        input.close();
    }
}