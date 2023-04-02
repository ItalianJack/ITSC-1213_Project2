import java.util.ArrayList;

public class Store implements BookstoreSpecification {
    
    // Fields
    private ArrayList<Member> members;
    private ArrayList<Product> inventory;

    // Constructor
    public Store() {
        members = new ArrayList<Member>(10);
        inventory = new ArrayList<Product>(15);

        addMember(new Member("John Doe"));
        addMember(new PremiumMember("Jane Doe", new CreditCard(1111111111, "01/01/1999")));
        addProduct(new Book("The Bible", 15.99, "God"));
        addProduct(new DVD("Die Hard", 19.99, "Universal Studios"));
        addProduct(new CD("Gunfighter Ballads and Trail Songs", 11.99, "Marty Robbins"));
    }

    // Getters
    public ArrayList<Member> getMembers() {return this.members;}
    public ArrayList<Product> getInventory() {return this.inventory;}

    // Add members or products to inventory
    public void addProduct(Product p) {inventory.add(p);}
    public void addMember(Member m) {members.add(m);}

    // Remove members or products from inventory.
    public boolean removeMember(Member m) {return members.remove(m);}
    public boolean removeProduct(Product p) {return inventory.remove(p);}

    // Search the members list for a member with the given name
    public int findMember(String n) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(n))
                return i;
        }
        return -1;
    }

    // Using the card passed as a parameter, place the order and remove the items from inventory.
    public String placeOrder(CreditCard card, ArrayList<Product> cart) {
        for (Product item : cart) {
            removeProduct(item);
        }
        return "Order placed with card "+card.getCardNo()+" Exp: "+card.getExpDate();
    }

    // Prints the current inventory with the index of the items in the inventory list
    public void printInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("----------------");
            System.out.println(i);
            inventory.get(i).print();
            System.out.println();
        }
    }

    @Override
    public double inventoryValue() {
        double inventoryValue = 0;
        for (Product item : inventory) {
            inventoryValue += item.getPrice();
        }
        return inventoryValue;
    }

    @Override
    public int restockProduct(int productId, int amount) {
        if (inventory.get(productId) instanceof Book) {
            Book book = (Book)inventory.get(productId);
            for (int i = 0; i < amount; i++) {
                inventory.add(new Book(book.getName(), book.getPrice(), book.getAuthor()));
            }
        } else if (inventory.get(productId) instanceof CD) {
            CD cd = (CD)inventory.get(productId);
            for (int i = 0; i < amount; i++) {
                inventory.add(new CD(cd.getName(), cd.getPrice(), cd.getArtist()));
            }
        } else {
            DVD dvd = (DVD)inventory.get(productId);
            for (int i = 0; i < amount; i++) {
                inventory.add(new DVD(dvd.getName(), dvd.getPrice(), dvd.getStudio()));
            }
        }
        int numInStock = 0;
        for (Product item : inventory) {
            if (inventory.get(productId) instanceof Book && item instanceof Book) {
                numInStock++;
            } else if (inventory.get(productId) instanceof CD && item instanceof CD) {
                numInStock++;
            } else if (inventory.get(productId)instanceof DVD && item instanceof DVD) {
                numInStock++;
            }
        }
        return numInStock;
    }
    
}// end class
