class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public void displayInfo() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("Publication Year: " + getPublicationYear());
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Author bookAuthor = new Author(
            "The Great Gatsby", 
            1925, 
            "F. Scott Fitzgerald", 
            "An American novelist whose works illustrate the Jazz Age."
        );

        bookAuthor.displayInfo();
    }
}