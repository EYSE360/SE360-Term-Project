package com.eyse360.models;

import java.util.HashMap;
import java.util.Map;

public class Check {
    private long id;
    private HashMap<Product, Integer> products;
    private int time;
    private int close_time;
    private Waiter waiter;
    private boolean isOpen;

    public Check() {
        products = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getClose_time() {
        return close_time;
    }

    public void setClose_time(int close_time) {
        this.close_time = close_time;
    }
    
    

    public void addProduct(Product product, int quantity) {
        products.merge(product, quantity, Integer::sum);
    }

    public void removeProduct(Product product, int quantity) {
        products.remove(product);
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public boolean isIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }
    
    

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", products=" + products +
                ", time=" + time +
                ", waiter=" + waiter +
                '}';
    }
}
