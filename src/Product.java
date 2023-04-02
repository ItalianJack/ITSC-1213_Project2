public abstract class Product {
    private String name;
    private double price;

    public Product(String n, double p) {
        this.name = n;
        this.price = p;
    }
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.println("Name: "+this.name);
        System.out.println("Price: $"+this.price);
    }

}
