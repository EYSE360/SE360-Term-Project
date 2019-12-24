package models;

import java.util.HashMap;
import java.util.Map;

public class Check {
    private long id;
    private Map<Product, Integer> products;
    private Table table;
    private int time;
    private Waiter waiter;

    public Check() {
        products = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", products=" + products +
                ", table=" + table +
                ", time=" + time +
                ", waiter=" + waiter +
                '}';
    }
}
