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

    // @Override
    // public int compareTo(Product o) {
    //     if (this instanceof Book && (o instanceof CD || o instanceof DVD)) {
    //         return 1;
    //     } else if (this instanceof)
    //     return 0;
    // }
}
