package com.eyse360.models;

public class Beverage extends Product {
    private String brand;
    private double alcoholVolume;

    public Beverage() {
        super();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getAlcoholVolume() {
        return alcoholVolume;
    }

    public void setAlcoholVolume(double alcoholVolume) {
        this.alcoholVolume = alcoholVolume;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "brand='" + brand + '\'' +
                ", alcoholVolume=" + alcoholVolume +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
