package app.model.bankproduct;

public class Credit extends BankProduct{
    private String creditType;
    private float sum;
    private int time;
    private float percent;
    private float payment;

    public Credit() {super();}

    public Credit(int productNumber, String type, float sum, int time, float percent, float payment, String clientId) {
        super(productNumber, clientId);
        this.creditType = type;
        this.sum = sum;
        this.time = time;
        this.percent = percent;
        this.payment = payment;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    public Credit(int productNumber) {
        super(productNumber);
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
