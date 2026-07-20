import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(2); // Duplicate, won't be added

        System.out.println("Numbers: " + numbers);
        System.out.println("First number: " + numbers.first());
        System.out.println("Last number: " + numbers.last());
    }
}
