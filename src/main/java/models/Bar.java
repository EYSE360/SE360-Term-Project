package models;

import java.util.List;

public class Bar {
    private long id;
    private String name;
    private String city;
    private boolean alcoholPermission;
    private List<Product> products;
    private List<Category> categories;
    private List<BarUser> barUsers;

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

    public boolean isAlcoholPermission() {
        return alcoholPermission;
    }

    public void setAlcoholPermission(boolean alcoholPermission) {
        this.alcoholPermission = alcoholPermission;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

    public List<BarUser> getBarUsers() {
        return barUsers;
    }

    public void setBarUsers(List<BarUser> barUsers) {
        this.barUsers = barUsers;
    }

    public void addBarUser(BarUser user) {
        barUsers.add(user);
    }

    public void removeBarUser(BarUser user) {
        barUsers.remove(user);
    }

    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", alcoholPermission=" + alcoholPermission +
                ", products=" + products +
                ", barUsers=" + barUsers +
                '}';
    }
}
