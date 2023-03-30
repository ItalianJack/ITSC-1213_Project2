public class CD extends Product {
    // Fields
    private String artist;

    // Constructor
    public CD(String n, double p, String a) {
        super(n,p);
        artist = a;
    }

    // Getters (no setters, object is immutable)
    public String getArtist() {return artist;}

    //Print method
    @Override
    public void print() {
        super.print();
        System.out.println("Artist: "+this.artist);
    }
}
