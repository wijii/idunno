import java.util.Scanner;

public class MulTable {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick an Integer");
        try {
          int number = scanner.nextInt();
          for (int i = 1; i <= number; i++) {
              for (int u = 1; u <= number; u++) {
                  System.out.print(i * u + "\t");
              }
          }
          System.out.println();
        } catch (Exception e) {
          System.out.println("Not a Integer. Try Again.");
        }

    }
}
