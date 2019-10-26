package models;

import java.util.ArrayList;
import java.util.List;

public class Bar extends User {
    private String name;
    private String city;
    private String barUserName;
    private int barPassword;
    private Boolean alcoholPermission;
    private List<Beer> beerList;

    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    public Bar(String name, String city, Boolean alcoholPermission) {
        this.name = name;
        this.city = city;
        this.alcoholPermission = alcoholPermission;
        beerList = new ArrayList<Beer>();
    }

    public Bar(){
        name = "Unknown";
        city = "Unknown";
        barUserName = "models.Bar";
        barPassword = 123;
        alcoholPermission = false;
        beerList = new ArrayList<Beer>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getAlcoholPermission() {
        return alcoholPermission;
    }
    public String getBarUserName() {
        return barUserName;
    }

    public void setBarUserName(String barUserName) {
        this.barUserName = barUserName;
    }

    public int getBarPassword() {
        return barPassword;
    }

    public void setBarPassword(int barPassword) {
        this.barPassword = barPassword;
    }

    public void setAlcoholPermission(Boolean alcoholPermission) {
        this.alcoholPermission = alcoholPermission;
    }

    @Override
    public void display(){
        System.out.println("models.Bar name: "+getName()+"\nLocated city: "+getCity()+"\nAlcohol Permission: "+isTrue()+"\n\nmodels.Beer Menu: ");

    }
    public String isTrue(){
        if(alcoholPermission==true) return "Acquired!";
        else return "Not acquired!";
    }
    public void displayMenu(){
        for(int i=0;i<beerList.size();i++){
            beerList.get(i).display();
            System.out.println();
        }
    }
}
