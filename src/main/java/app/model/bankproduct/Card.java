package app.model.bankproduct;

public class Card extends BankProduct{

    private int cardNumber;
    private float balance;

    public Card(){super();}

    public Card(int number, int cardNumber, float balance, String clientId){
        super(number, clientId);
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Card(int number) {
        super(number);
    }

    public Card(int productNumber, String clientId) {
        super(productNumber, clientId);
    }

    @Override
    public int getProductNumber() {
        return super.getProductNumber();
    }

    @Override
    public void setProductNumber(int productNumber) {
        super.setProductNumber(productNumber);
    }

    @Override
    public String getClientId() {
        return super.getClientId();
    }

    @Override
    public void setClientId(String clientId) {
        super.setClientId(clientId);
    }
}
