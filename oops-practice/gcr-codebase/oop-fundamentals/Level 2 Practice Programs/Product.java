class Product {
    static double discount = 10;

    String productName;
    double price;
    int quantity;
    final int productID;

    Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    static void updateDiscount(double d) {
        discount = d;
    }

    void display() {
        double total = price * quantity;
        double finalPrice = total - (total * discount / 100);

        System.out.println("Product ID: " + productID);
        System.out.println("Product: " + productName);
        System.out.println("Final Price: " + finalPrice);
    }

    public static void main(String[] args) {
        Product p = new Product(1, "Laptop", 50000, 2);

        updateDiscount(15);

        if (p instanceof Product) {
            p.display();
        }
    }
}