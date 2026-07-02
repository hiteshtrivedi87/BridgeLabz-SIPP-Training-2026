import java.util.ArrayList;
import java.util.List;

public class SafeDataManager<T> {
    private final List<T> dataList = new ArrayList<>();        
    private final Validator<T> validator;  

    public SafeDataManager(Validator<T> validator) {
        this.validator = validator;
    }

    public void addSafely(T item) {
        if (validator.isValid(item)) {
            dataList.add(item);
        }
    }
}

interface Validator<T> { 
    boolean isValid(T item); 
}