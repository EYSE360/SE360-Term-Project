package com.eyse360.models;

public class Bar {
    private long id;
    private String name;
    private String city;
    private boolean alcoholPermission;

    public Bar() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean getAlcoholPermission() {
        return alcoholPermission;
    }

    public void setAlcoholPermission(boolean alcoholPermission) {
        this.alcoholPermission = alcoholPermission;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", alcoholPermission=" + alcoholPermission +
                '}';
    }
}
