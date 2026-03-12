package model;

public class Booking {
    private int b_id;
    private int c_id;
    public int getC_id() {
        return c_id;
    }
    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    public int getV_id() {
        return v_id;
    }
    public void setV_id(int v_id) {
        this.v_id = v_id;
    }
    private int v_id;
    private String start_date;
    private String end_date;
    private double total_price;
    private boolean is_active;
    private int rental_days;
    
    public int getRental_days() {
        return rental_days;
    }
    public void setRental_days(int rental_days) {
        this.rental_days = rental_days;
    }
    public Booking(int b_id, int c_id, int v_id, String start_date, String end_date, double total_price,
            boolean is_active,int rental_days) {
        this.b_id = b_id;
        this.c_id = c_id;
        this.v_id = v_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.total_price = total_price;
        this.is_active = is_active;
        this.rental_days = rental_days;
    }
    public Booking() {
    }
    public int getB_id() {
        return b_id;
    }
    public void setB_id(int b_id) {
        this.b_id = b_id;
    }
    public String getStart_date() {
        return start_date;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    public String getEnd_date() {
        return end_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    public boolean isIs_active() {
        return is_active;
    }
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
}
