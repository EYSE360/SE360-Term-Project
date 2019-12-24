package models;

public class Table {
    private int id;
    private String name;
    private String shortcode;

    public Table() {
    }

    public Table(int id, String name, String shortcode) {
        this.id = id;
        this.name = name;
        this.shortcode = shortcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }
}
