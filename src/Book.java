public class Book extends Product {
    // Fields
    private String author;

    // Constructor
    public Book(String n, double p, String a) {
        super(n,p);
        author = a;
    }

    // Getters (no setters, object is immutable)
    public String getAuthor() {return author;}
}
