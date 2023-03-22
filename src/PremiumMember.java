public class PremiumMember {
    // Fields
    private String name;
    private int paymentCardNo;
    private double amountSpent;
    private boolean subscriptionPaid;

    // Constructor
    public PremiumMember(String n) {
        name = n;
        paymentCardNo = 0;
        amountSpent = 0;
        subscriptionPaid = true;
    }

    public PremiumMember(String n, int c) {
        name = n;
        paymentCardNo = c;
        amountSpent = 0;
        subscriptionPaid = true;
    }

    // Getters
    public String getName() {return name;}
    public int getPaymentCardNo() {return paymentCardNo;}
    public double getSpent() {return amountSpent;}
    public boolean isSubscriptionPaid() {return subscriptionPaid;}

    // Setters
    public void setName(String n) {name = n;}
    public void setPaymentCardNo(int c) {paymentCardNo = c;}
    public double addMoneySpent(double c) {
        amountSpent += c;
        return amountSpent;
    }
    public void setSubscriptionPaid(boolean p) {subscriptionPaid = p;}
}
