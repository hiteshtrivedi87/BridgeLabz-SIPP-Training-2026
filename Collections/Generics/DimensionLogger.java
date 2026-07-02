public class DimensionLogger {
    public <T extends Number> DimensionLogger(T width, T height) {
        System.out.println(width.doubleValue() + "x" + height.doubleValue());
    }

    public static void main(String[] args) {
        new DimensionLogger(10, 20);
        new DimensionLogger(10.5, 20.5);
    }
}