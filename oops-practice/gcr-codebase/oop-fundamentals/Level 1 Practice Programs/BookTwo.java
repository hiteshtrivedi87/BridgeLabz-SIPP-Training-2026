class BookTwo {
    String title;
    String author;
    double price;
    boolean available;

    BookTwo(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        available = true;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book Borrowed Successfully.");
        } else {
            System.out.println("Book is Not Available.");
        }
    }

    void display() {
        System.out.println("Title : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price : " + price);
        System.out.println("Available : " + available);
    }

    public static void main(String[] args) {
        BookTwo b = new BookTwo("Java", "James", 500);

        b.display();
        b.borrowBook();
        b.display();
    }
}