import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        List<String> fruits = new java.util.ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println("Fruits: " + fruits);
        System.out.println("Second fruit: " + fruits.get(1));
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
    }
}
