public class CD {
    // Fields
    private String name;
    private double price;
    private String artist;

    // Constructor
    public CD(String n, double p, String a) {
        name = n;
        price = p;
        artist = a;
    }

    // Getters (no setters, object is immutable)
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getArtist() {
        return artist;
    }
}
