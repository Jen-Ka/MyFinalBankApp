package app.model.bankproduct;

public abstract class BankProduct {
    private int productNumber;
    private String clientId;

    public BankProduct(){
    }

    public BankProduct(int productNumber) {
        this.productNumber = productNumber;
    }

    public BankProduct(int productNumber, String clientId) {
        this.productNumber = productNumber;
        this.clientId = clientId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
