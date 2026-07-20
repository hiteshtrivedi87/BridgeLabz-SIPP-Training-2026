import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.addFirst("Lion");
        animals.addLast("Elephant");
        System.out.println("Animals: " + animals);
        System.out.println("First animal: " + animals.getFirst());
        System.out.println("Last animal: " + animals.getLast());
        animals.remove("Cat");
        System.out.println("After removing Cat: " + animals);
    }
}
