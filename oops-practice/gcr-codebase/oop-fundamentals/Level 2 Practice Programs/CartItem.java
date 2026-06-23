class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double p, int q) {
        itemName = name;
        price = p;
        quantity = q;
        System.out.println("Item Added Successfully");
    }

    void removeItem() {
        quantity = 0;
        System.out.println("Item Removed");
    }

    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Item Name : " + itemName);
        System.out.println("Price : " + price);
        System.out.println("Quantity : " + quantity);
        System.out.println("Total Cost : " + total);
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem();

        cart.addItem("Laptop", 50000, 2);
        cart.displayTotalCost();

        cart.removeItem();
        cart.displayTotalCost();
    }
}