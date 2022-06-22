package app.model.bankproduct;

public class BankAccount extends BankProduct{
    private float balance;

    public BankAccount(){
        super();}

    public BankAccount(int number, float balance, String clientId) {
        super(number, clientId);
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public BankAccount(int number) {
        super(number);
    }

    @Override
    public int getProductNumber() {
        return super.getProductNumber();
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
