public abstract class Product implements Comparable<Product> {
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

    @Override
    public int compareTo(Product arg0) {
        if (this.getClass().equals(arg0.getClass())) {
            // If they are the same type, compare prices
            if (this.getPrice() > arg0.getPrice()) {
                return 1;
            } else if (this.getPrice() < arg0.getPrice()) {
                return -1;
            } else {
                return 0;
            }
        } else if (this instanceof Book) {
            // If the objects are different types and this is a Book, the other object can only be a CD or DVD, so return 1 because books come first
            return 1;
        } else if (this instanceof DVD) {
            //If the objects are different types and this is a DVD, the other object can only be a Book or CD so return -1 because DVDs come last
            return -1;
        } else if (arg0 instanceof Book) {
            //If the objects are different types, and this is neither a Book nor DVD, it must be a CD. If the other object is a book, return -1 because CDs come after books
            return -1;
        } else {
            //Otherwise return 1 because the other object must be a DVD which come after CDs
            return 1;
        }
    }

}
