package models;

public class Beer {
    private String brand;
    private String type;
    private float alcoholVol;
    private float price;
    private int serialNumber;



    public Beer(String brand, String type, float alcoholVol, float price, int serialNumber) {
        this.brand = brand;
        this.type = type;
        this.alcoholVol = alcoholVol;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    public Beer(){
        brand = "Unknown";
        type = "Unknown";
        alcoholVol = 0;
        serialNumber = 0;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAlcoholVol() {
        return alcoholVol;
    }

    public void setAlcoholVol(float alcoholVol) {
        this.alcoholVol = alcoholVol;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void display(){
        System.out.println("Brand: "+getBrand()+"\nType: "+getType()+"\nAlcohol Volume: "+getAlcoholVol()+"\nPrice: "+getPrice());
    }

}
