class Item {
    int itemCode;
    String itemName;
    double price;

    void display() {
        System.out.println("Item Code : " + itemCode);
        System.out.println("Item Name : " + itemName);
        System.out.println("Price     : " + price);
    }

    void totalCost(int quantity) {
        double total = price * quantity;
        System.out.println("Quantity  : " + quantity);
        System.out.println("Total Cost: " + total);
    }

    public static void main(String[] args) {
        Item item = new Item();

        item.itemCode = 1001;
        item.itemName = "Pen";
        item.price = 20;

        item.display();
        item.totalCost(5);
    }
}