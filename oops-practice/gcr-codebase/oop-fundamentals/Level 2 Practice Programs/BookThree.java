class BookThree {
    static String libraryName = "Central Library";

    String title;
    String author;
    final String isbn;

    BookThree(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        BookThree b = new BookThree("Java", "James", "ISBN101");

        if (b instanceof BookThree) {
            displayLibraryName();
            b.display();
        }
    }
}