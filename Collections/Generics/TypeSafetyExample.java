import java.util.ArrayList;
import java.util.List;

public class TypeSafetyExample {
    public static void main(String[] args) {
        List rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(42); 

        List<String> safeList = new ArrayList<>();
        safeList.add("Hello");
        
        String cleanStr = safeList.get(0); 
    }
}