package com.eyse360.controllers;

import com.eyse360.DAO;
import com.eyse360.GUITest;
import com.eyse360.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO implements DAO<Product> {
    @Override
    public Optional<Product> get(Product product) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    public List<Product> getAllByBar(Bar bar) {GUITest.conn.connect();
        String query = "SELECT * FROM products WHERE bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) bar.getId());
            ResultSet rs = pstmt.executeQuery();
            List<Product> productList = null;
            if (rs.next()) {
                productList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("type").equals("food")) {
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, rs.getInt("id"));
                    ResultSet rs2 = pstmt2.executeQuery();
                    while (rs2.next()) {
                        Food product = new Food();
                        product.setId(rs.getInt("id"));
                        product.setName(rs2.getString("name"));
                        product.setPrice(rs2.getDouble("price"));
                        product.setDescription(rs2.getString("description"));
                        productList.add(product);
                    }
                    rs2.close();
                    pstmt2.close();
                } else if (rs.getString("type").equals("beverage")) {
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, rs.getInt("id"));
                    ResultSet rs2 = pstmt2.executeQuery();
                    while (rs2.next()) {
                        Beverage product = new Beverage();
                        product.setId(rs.getInt("id"));
                        product.setName(rs2.getString("name"));
                        product.setPrice(rs2.getDouble("price"));
                        product.setDescription(rs2.getString("description"));
                        product.setBrand(rs.getString("brand"));
                        product.setAlcoholVolume(rs.getDouble("alcoholVolume"));
                        productList.add(product);
                    }
                    rs2.close();
                    pstmt2.close();
                }
            }
            pstmt.close();
            rs.close();
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();
        return null;
    }

    public List<Product> getAllByBarAndCategory(Bar bar, Category category) {
        GUITest.conn.connect();
        String query = "SELECT * FROM products WHERE bar = ? AND category = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) bar.getId());
            pstmt.setInt(2, (int) category.getId());
            ResultSet rs = pstmt.executeQuery();
            List<Product> productList = null;
            if (rs.next()) {
                productList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("type").equals("food")) {
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, rs.getInt("id"));
                    ResultSet rs2 = pstmt2.executeQuery();
                    while (rs2.next()) {
                        Food product = new Food();
                        product.setId(rs.getInt("id"));
                        product.setName(rs2.getString("name"));
                        product.setPrice(rs2.getDouble("price"));
                        product.setDescription(rs2.getString("description"));
                        product.setCategory(category);
                        productList.add(product);
                    }
                    rs2.close();
                    pstmt2.close();
                } else if (rs.getString("type").equals("beverage")) {
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, rs.getInt("id"));
                    ResultSet rs2 = pstmt2.executeQuery();
                    while (rs2.next()) {
                        Beverage product = new Beverage();
                        product.setId(rs.getInt("id"));
                        product.setName(rs2.getString("name"));
                        product.setPrice(rs2.getDouble("price"));
                        product.setDescription(rs2.getString("description"));
                        product.setBrand(rs.getString("brand"));
                        product.setAlcoholVolume(rs.getDouble("alcoholVolume"));
                        product.setCategory(category);
                        productList.add(product);
                    }
                    rs2.close();
                    pstmt2.close();
                }
            }
            pstmt.close();
            rs.close();
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();
        return null;
    }

    @Override
    public int save(Product product) {
        GUITest.conn.connect();
        String query = "INSERT INTO products (type, category, bar) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            if (product instanceof Food) {
                pstmt.setString(1, "food");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) GUITest.bar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    String query2 = "INSERT INTO foods (product, name, price, description) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.executeUpdate();

                    return rs.getInt(1);
                }
            } else if (product instanceof Beverage) {
                pstmt.setString(1, "beverage");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) GUITest.bar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    String query2 = "INSERT INTO beverages (product, name, price, description, brand, alcoholVolume) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.setString(5, ((Beverage) product).getBrand());
                    pstmt2.setDouble(6, ((Beverage) product).getAlcoholVolume());
                    pstmt2.executeUpdate();

                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();
        return 0;
    }

    @Override
    public void update(Product product) {
        GUITest.conn.connect();
        String query = "UPDATE products SET type = ?, category = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            if (product instanceof Food) {
                pstmt.setString(1, "food");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) product.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    String query2 = "UPDATE foods SET name = ?, price = ?, description = ? WHERE product = ?";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setString(1, product.getName());
                    pstmt2.setDouble(2, product.getPrice());
                    pstmt2.setString(3, product.getDescription());
                    pstmt2.setInt(4, (int) product.getId());
                    pstmt2.executeUpdate();
                }
            } else if (product instanceof Beverage) {
                pstmt.setString(1, "beverage");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) GUITest.bar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    int id = rs.getInt(1);
                    String query2 = "INSERT INTO beverages (product, name, price, description, brand, alcoholVolume) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt2 = GUITest.conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.setString(5, ((Beverage) product).getBrand());
                    pstmt2.setDouble(6, ((Beverage) product).getAlcoholVolume());
                    pstmt2.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();
    }

    @Override
    public void delete(Product product) {

    }
}
