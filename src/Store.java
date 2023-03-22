import java.util.ArrayList;

public class Store {
    
    // Fields
    private ArrayList<Member> members;
    private ArrayList<PremiumMember> premiumMembers;
    private ArrayList<Book> inventoryBook;
    private ArrayList<DVD> inventoryDVD;
    private ArrayList<CD> inventoryCD;

    // Constructor
    public Store() {
        members = new ArrayList<Member>(10);
        premiumMembers = new ArrayList<PremiumMember>(10);
        inventoryBook = new ArrayList<Book>(10);
        inventoryDVD = new ArrayList<DVD>(10);
        inventoryCD = new ArrayList<CD>(10);

        addMember(new Member("John Doe"));
        addPremiumMember(new PremiumMember("Jane Doe"));
        premiumMembers.get(0).setPaymentCardNo(12345678);
        addBook(new Book("The Bible", 15.99, "God"));
        addDVD(new DVD("Die Hard", 19.99, "Universal Studios"));
        addCD(new CD("Gunfighter Ballads and Trail Songs", 11.99, "Marty Robbins"));
    }

    // Getters
    public ArrayList<Member> getMembers() {return this.members;}
    public ArrayList<PremiumMember> getPremiumMembers() {return this.premiumMembers;}
    public ArrayList<Book> getBooks() {return this.inventoryBook;}
    public ArrayList<DVD> getDVDs() {return this.inventoryDVD;}
    public ArrayList<CD> getCDs() {return this.inventoryCD;}

    // Add members or products to inventory
    public void addBook(Book b) {
        inventoryBook.add(b);
    }
    public void addDVD(DVD d) {
        inventoryDVD.add(d);
    }
    public void addCD(CD c) {
        inventoryCD.add(c);
    }
    public void addMember(Member m) {
        members.add(m);
    }
    public void addPremiumMember(PremiumMember p) {
        premiumMembers.add(p);
    }

    // Remove members or products from inventory.
    public boolean removeMember(Member m) {
        return members.remove(m);
    }
    public boolean removePremium(PremiumMember p) {
        return premiumMembers.remove(p);
    }
    public boolean removeBook(Book b) {
        return inventoryBook.remove(b);
    }
    public boolean removeDVD(DVD d) {
        return inventoryDVD.remove(d);
    }
    public boolean removeCD(CD c) {
        return inventoryCD.remove(c);
    }

    // Print inventory of different products.
    public void printBookInventory() {
        for (int i = 0; i < inventoryBook.size(); i++) {
            System.out.println("\t"+i+"\tName: "+inventoryBook.get(i).getName()+"\t\tBy: "+inventoryBook.get(i).getAuthor()+"\t\t Price: $"+inventoryBook.get(i).getPrice());
        }
    }

    public void printDVDInventory() {
        for (int i = 0; i < inventoryDVD.size(); i++) {
            System.out.println("\t"+i+"\tName: "+inventoryDVD.get(i).getName()+"\t\tBy: "+inventoryDVD.get(i).getStudio()+"\t\t Price: $"+inventoryDVD.get(i).getPrice());
        }
    }

    public void printCDInventory() {
        for (int i = 0; i < inventoryCD.size(); i++) {
            System.out.println("\t"+i+"\tName: "+inventoryCD.get(i).getName()+"\t\tBy: "+inventoryCD.get(i).getArtist()+"\t\t Price: $"+inventoryCD.get(i).getPrice());
        }
    }

    // Find the index of a member in the premium or member lists.
    public int findPremiumMember(String n) {
        for (int i = 0; i < premiumMembers.size(); i++) {
            if (premiumMembers.get(i).getName().equals(n))
                return i;
        }
        return -1;
    }

    public int findMember(String n) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getName().equals(n))
                return i;
        }
        return -1;
    }

    // Using the card passed as a parameter, place the order and remove the items from inventory.
    public String placeOrder(int card, ArrayList<Book> b, ArrayList<DVD> d, ArrayList<CD> cd) {
        for (Book item : b) {
            removeBook(item);
        }
        for (DVD item : d) {
            removeDVD(item);
        }
        for (CD item : cd) {
            removeCD(item);
        }
        return "Order placed with card number "+card;
    }
    
}
