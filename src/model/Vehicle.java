package model;

public class Vehicle {
    public int getV_id() {
        return v_id;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistration_num() {
        return registration_num;
    }

    public void setRegistration_num(String registration_num) {
        this.registration_num = registration_num;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(double price_per_day) {
        this.price_per_day = price_per_day;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public Vehicle(int v_id, String type, String registration_num, String model, String brand, double price_per_day,
            boolean is_available) {
        this.v_id = v_id;
        this.type = type;
        this.registration_num = registration_num;
        this.model = model;
        this.brand = brand;
        this.price_per_day = price_per_day;
        this.is_available = is_available;
    }

    private int v_id;
    private String type;
    private String registration_num;
    private String model;
    private String brand;
    private double price_per_day;
    private boolean is_available;

    public Vehicle() {
    }
    
}
