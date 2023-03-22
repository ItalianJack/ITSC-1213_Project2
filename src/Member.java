public class Member {
    // Fields
    private String name;
    private double amountSpent;

    // Constructor
    public Member(String n) {
        name = n;
        amountSpent = 0.0;
    }

    // Getters
    public String getName() {return this.name;}
    public double getSpent() {return this.amountSpent;}

    // Setters
    public void setName(String n) {name = n;}
    public double addMoneySpent(double s) {
        amountSpent += s;
        return amountSpent;
    }

}
