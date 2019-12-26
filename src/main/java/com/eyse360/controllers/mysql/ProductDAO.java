package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.gui.BarFrame;
import com.eyse360.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO implements DAO<Product> {
    DBConnection conn = new DBConnection();
    @Override
    public Product get(Product product) {
        return null;
    }

    @Override
    public Product getById(int id) {
        conn.connect();

        Product product = null;

        String query = "SELECT * FROM products WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("type").equals("food")) {
                    product = new Food();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescription(rs.getString("description"));
                } else if (rs.getString("type").equals("beverage")) {
                    product = new Beverage();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescription(rs.getString("description"));
                    ((Beverage) product).setBrand(rs.getString("brand"));
                    ((Beverage) product).setAlcoholVolume(rs.getDouble("alcoholVolume"));
                }
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return product;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    public List<Product> getAllByBar(Bar bar) {
        conn.connect();
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Product> productList = null;

        String query = "SELECT * FROM products WHERE bar = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) bar.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                productList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("type").equals("food")) {
                    Food product = new Food();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescription(rs.getString("description"));
                    product.setCategory(categoryDAO.getById(rs.getInt("category")));
                    productList.add(product);
                } else if (rs.getString("type").equals("beverage")) {
                    Beverage product = new Beverage();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescription(rs.getString("description"));
                    product.setBrand(rs.getString("brand"));
                    product.setAlcoholVolume(rs.getDouble("alcoholVolume"));
                    product.setCategory(categoryDAO.getById(rs.getInt("category")));
                    productList.add(product);
                }
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
        return productList;
    }

    public List<Product> getAllByBarAndCategory(Bar bar, Category category) {
        conn.connect();

        List<Product> productList = null;

        String query = "SELECT * FROM products WHERE bar = ? AND category = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) bar.getId());
            pstmt.setInt(2, (int) category.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                productList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("type").equals("food")) {
                    Food product = new Food();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescription(rs.getString("description"));
                    productList.add(product);
                } else if (rs.getString("type").equals("beverage")) {
                    Beverage product = new Beverage();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setDescription(rs.getString("description"));
                    product.setBrand(rs.getString("brand"));
                    product.setAlcoholVolume(rs.getDouble("alcoholVolume"));
                    productList.add(product);
                }
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return productList;
    }

    @Override
    public int save(Product product) {
        conn.connect();

        int id = 0;
        if (product instanceof Food) {
            String query = "INSERT INTO products (category, name, price, description, type, bar) VALUES (?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, (int) product.getCategory().getId());
                pstmt.setString(2, product.getName());
                pstmt.setDouble(3, product.getPrice());
                pstmt.setString(4, product.getDescription());
                pstmt.setString(5, "food");
                pstmt.setInt(6, (int) BarFrame.currentBar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                
                if (rs.next())
                    id = rs.getInt(1);

                rs.close();
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (product instanceof Beverage) {
            String query = "INSERT INTO products (category, name, price, description, brand, alcoholVolume, type, bar) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                pstmt.setInt(1, (int) product.getCategory().getId());
                pstmt.setString(2, product.getName());
                pstmt.setDouble(3, product.getPrice());
                pstmt.setString(4, product.getDescription());
                pstmt.setString(5, ((Beverage) product).getBrand());
                pstmt.setDouble(6, ((Beverage) product).getAlcoholVolume());
                pstmt.setString(7, "beverage");
                pstmt.setInt(8, (int) BarFrame.currentBar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                
                if (rs.next())
                    id = rs.getInt(1);

                rs.close();
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }   
        }

        conn.disconnect();

        return id;
    }

    @Override
    public void update(Product product) {
        System.out.println(product);
        conn.connect();
        if (product instanceof Food) {
            String query = "UPDATE products SET category = ?, name = ?, price = ?, description = ?, type = ? WHERE id = ?";
            try {
                PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
                pstmt.setInt(1, (int) product.getCategory().getId());
                pstmt.setString(2, product.getName());
                pstmt.setDouble(3, product.getPrice());
                pstmt.setString(4, product.getDescription());
                pstmt.setString(5, "food");
                pstmt.setInt(6, (int) product.getId());
                
                pstmt.executeUpdate();
                pstmt.close();
            }  catch (SQLException e) {
               e.printStackTrace();
            }
        } else if (product instanceof Beverage) {
            String query = "UPDATE products SET category = ?, name = ?, price = ?, description = ?, brand = ?, alcoholVolume = ?, type = ? WHERE id = ?";
            try {
                PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
                pstmt.setInt(1, (int) product.getCategory().getId());
                pstmt.setString(2, product.getName());
                pstmt.setDouble(3, product.getPrice());
                pstmt.setString(4, product.getDescription());
                pstmt.setString(5, ((Beverage) product).getBrand());
                pstmt.setDouble(6, ((Beverage) product).getAlcoholVolume());                    
                pstmt.setString(7, "beverage");
                pstmt.setInt(8, (int) product.getId());
                
                pstmt.executeUpdate();
                
                pstmt.close();
            }  catch (SQLException e) {
               e.printStackTrace();
            }
        }

        conn.disconnect();
    }

    @Override
    public void delete(Product product) {
        conn.connect();
        try {
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) product.getId());
            pstmt.executeQuery();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();
    }
}
