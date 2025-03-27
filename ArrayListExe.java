
import java.util.ArrayList;
public class ArrayListExe {
    public static void main(String[] args) {
        ArrayList fruitsList = new ArrayList();
        fruitsList.add("Strawberry");
        fruitsList.add("Watermelon");
        fruitsList.add("Banana");
        fruitsList.add("Orange");
        fruitsList.add("Mango");
        fruitsList.add("Pineapple");
        fruitsList.add("Grapes");
        fruitsList.add("Peach");
        fruitsList.add("Pear");
        fruitsList.add("Kiwi");

        System.out.println("List of Fruits: " + fruitsList + "\n");
        System.out.println("Number of Fruits: " + fruitsList.size());

        fruitsList.remove("Watermelon");

        System.out.println("\nUpadated List of Fruits: " + fruitsList + "\n");
        System.out.println("Is Pineapple present in the list:  " + fruitsList.contains("Pineapple"));
        System.out.println("Is Watermelon present in the list:  " + fruitsList.contains("Watermelon"));
        System.out.println("Is Drqagon Fruit present in the list:  " + fruitsList.contains("Dragon Fruit"));
        System.out.println("Is Grapes present in the list:  " + fruitsList.contains("Grapes"));

    }
}
