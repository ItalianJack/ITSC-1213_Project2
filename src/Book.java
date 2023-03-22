public class Book {
    // Fields
    private String name;
    private double price;
    private String author;

    // Constructor
    public Book(String n, double p, String a) {
        name = n;
        price = p;
        author = a;
    }

    // Getters (no setters, object is immutable)
    public String getName() {return name;}
    public double getPrice() {return price;}
    public String getAuthor() {return author;}
}
