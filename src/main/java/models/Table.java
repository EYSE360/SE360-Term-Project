package models;

public class Table {
    private long id;
    private String shortCode;
    private String name;
    private int customerCount;

    public Table() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortcode) {
        this.shortCode = shortcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", shortCode='" + shortCode + '\'' +
                ", name='" + name + '\'' +
                ", customerCount=" + customerCount +
                '}';
    }
}
