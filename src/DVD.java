public class DVD extends Product {
    // Fields
    private String studio;

    // Constructor
    public DVD(String n, double p, String s) {
        super(n,p);
        studio = s;
    }

    // Getters (no setters, object is immutable)
    public String getStudio() {return studio;}

    //Print method
    @Override
    public void print() {
        super.print();
        System.out.println("Studio: "+this.studio);
    }
}
