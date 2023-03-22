public class PremiumMember extends Member {
    // Fields
    private CreditCard cardOnFile;
    private boolean subscriptionPaid;

    // Constructor
    public PremiumMember(String n) {
        super(n);
        cardOnFile = new CreditCard(0,"01/01/1999");
        subscriptionPaid = true;
    }

    public PremiumMember(String n, CreditCard c) {
        super(n);
        this.cardOnFile = c;
        subscriptionPaid = true;
    }

    // Getters
    public CreditCard getCardOnFile() {return cardOnFile;}
    public boolean isSubscriptionPaid() {return subscriptionPaid;}

    // Setters
    public void setPaymentCardNo(CreditCard c) {cardOnFile = c;}
    public void setSubscriptionPaid(boolean p) {subscriptionPaid = p;}
}
