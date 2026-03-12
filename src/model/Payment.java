package model;

public class Payment {
    public int getP_id() {
        return p_id;
    }
    public void setP_id(int p_id) {
        this.p_id = p_id;
    }
    public Booking getB() {
        return b;
    }
    public void setB(Booking b) {
        this.b = b;
    }
    public String getPayment_date() {
        return payment_date;
    }
    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getPayment_method() {
        return payment_method;
    }
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
    public String getPayment_status() {
        return payment_status;
    }
    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }
    private int p_id;
    private Booking b;
    private String payment_date;
    private double amount;
    private String payment_method;
    private String payment_status;
    public Payment(int p_id, Booking b, String payment_date, double amount, String payment_method,
            String payment_status) {
        this.p_id = p_id;
        this.b = b;
        this.payment_date = payment_date;
        this.amount = amount;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
    }
    public Payment() {
    }

}
