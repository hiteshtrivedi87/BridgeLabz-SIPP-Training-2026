class Book {
    String title;
    String author;
    double price;

    Book() {
        title = "Java Programming";
        author = "James";
        price = 500;
    }

    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    void display() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Python", "Guido", 700);

        b1.display();
        System.out.println();
        b2.display();
    }
}