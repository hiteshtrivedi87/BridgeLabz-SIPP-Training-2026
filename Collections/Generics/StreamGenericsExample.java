import java.util.List;
import java.util.stream.Collectors;

public class StreamGenericsExample {
    public static void main(String[] args) {
        List<String> stringNumbers = List.of("1", "2", "3", "4");

        List<Integer> evenNumbers = stringNumbers.stream()
                .map(Integer::valueOf) 
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers); 
    }
}