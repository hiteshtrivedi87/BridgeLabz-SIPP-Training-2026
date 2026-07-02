import java.util.List;

public class ApiDesign {
    public List<? extends Number> badGetSequence() {
        return List.of(1, 2, 3);
    }

    public List<Integer> goodGetSequence() {
        return List.of(1, 2, 3);
    }
}