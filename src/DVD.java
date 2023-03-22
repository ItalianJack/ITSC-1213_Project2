public class DVD {
    // Fields
    private String name;
    private double price;
    private String studio;

    // Constructor
    public DVD(String n, double p, String s) {
        name = n;
        price = p;
        studio = s;
    }

    // Getters (no setters, object is immutable)
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getStudio() {
        return studio;
    }
}
