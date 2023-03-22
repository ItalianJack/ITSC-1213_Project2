public class CreditCard {
    
    private long cardNo;
    private String expDate;

    public CreditCard(long no, String exp) {
        this.cardNo = no;
        this.expDate = exp;
    }

    public long getCardNo() {
        return cardNo;
    }
    public String getExpDate() {
        return expDate;
    }

}
