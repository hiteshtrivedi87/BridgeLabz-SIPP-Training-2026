public class Box<T extends Number> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public double getDoubleValue() {
        return value.doubleValue(); 
    }
}