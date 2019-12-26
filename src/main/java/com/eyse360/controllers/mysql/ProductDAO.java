package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.GUITest;
import com.eyse360.gui.BarFrame;
import com.eyse360.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    ResultSet rs2 = pstmt2.executeQuery();
                    if (rs2.next()) {
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDescription(rs.getString("description"));
                    }
                    rs2.close();
                    pstmt2.close();
                } else if (rs.getString("type").equals("beverage")) {
                    product = new Beverage();
                    product.setId(rs.getInt("id"));
                    String query2 = "SELECT * FROM beverages WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    ResultSet rs2 = pstmt2.executeQuery();
                    if (rs2.next()) {
                        product.setName(rs.getString("name"));
                        product.setPrice(rs.getDouble("price"));
                        product.setDescription(rs.getString("description"));
                        ((Beverage) product).setBrand(rs.getString("brand"));
                        ((Beverage) product).setAlcoholVolume(rs.getDouble("alcoholVolume"));
                    }
                    rs2.close();
                    pstmt2.close();
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
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, rs.getInt("id"));
                    ResultSet rs2 = pstmt2.executeQuery();
                    while (rs2.next()) {
                        Food product = new Food();
                        product.setId(rs.getInt("id"));
                        product.setName(rs2.getString("name"));
                        product.setPrice(rs2.getDouble("price"));
                        product.setDescription(rs2.getString("description"));
                        product.setCategory(categoryDAO.getById(rs.getInt("category")));
                        productList.add(product);
                    }
                    rs2.close();
                    pstmt2.close();
                } else if (rs.getString("type").equals("beverage")) {
                    String query2 = "SELECT * FROM beverages WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, rs.getInt("id"));
                    ResultSet rs2 = pstmt2.executeQuery();
                    while (rs2.next()) {
                        Beverage product = new Beverage();
                        product.setId(rs.getInt("id"));
                        product.setName(rs2.getString("name"));
                        product.setPrice(rs2.getDouble("price"));
                        product.setDescription(rs2.getString("description"));
                        product.setBrand(rs2.getString("brand"));
                        product.setAlcoholVolume(rs2.getDouble("alcoholVolume"));
                        product.setCategory(categoryDAO.getById(rs.getInt("category")));
                        productList.add(product);
                    }
                    rs2.close();
                    pstmt2.close();
                }
            }
            pstmt.close();
            rs.close();
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
                    String query2 = "SELECT * FROM foods WHERE product = ? LIMIT 1";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
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
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
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
            conn.disconnect();

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

        String query = "INSERT INTO products (type, category, bar) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            if (product instanceof Food) {
                pstmt.setString(1, "food");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) BarFrame.currentBar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getInt(1);
                    String query2 = "INSERT INTO foods (product, name, price, description) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.executeUpdate();

                    pstmt2.close();
                }

                pstmt.close();
                rs.close();
            } else if (product instanceof Beverage) {
                pstmt.setString(1, "beverage");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) BarFrame.currentBar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getInt(1);
                    String query2 = "INSERT INTO beverages (product, name, price, description, brand, alcoholVolume) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.setString(5, ((Beverage) product).getBrand());
                    pstmt2.setDouble(6, ((Beverage) product).getAlcoholVolume());
                    pstmt2.executeUpdate();

                    pstmt2.close();
                }

                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return id;
    }

    public int saveByCategory(Product product, Category category) {
        conn.connect();

        int id = 0;

        String query = "INSERT INTO products (type, category, bar) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            if (product instanceof Food) {
                pstmt.setString(1, "food");
                pstmt.setInt(2, (int) category.getId());
                pstmt.setInt(3, (int) GUITest.bar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getInt(1);
                    String query2 = "INSERT INTO foods (product, name, price, description) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.executeUpdate();

                    pstmt2.close();
                }

                pstmt.close();
                rs.close();
            } else if (product instanceof Beverage) {
                pstmt.setString(1, "beverage");
                pstmt.setInt(2, (int) category.getId());
                pstmt.setInt(3, (int) GUITest.bar.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    id = rs.getInt(1);
                    String query2 = "INSERT INTO beverages (product, name, price, description, brand, alcoholVolume) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setInt(1, id);
                    pstmt2.setString(2, product.getName());
                    pstmt2.setDouble(3, product.getPrice());
                    pstmt2.setString(4, product.getDescription());
                    pstmt2.setString(5, ((Beverage) product).getBrand());
                    pstmt2.setDouble(6, ((Beverage) product).getAlcoholVolume());
                    pstmt2.executeUpdate();

                    pstmt2.close();
                }

                pstmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return id;
    }

    @Override
    public void update(Product product) {
        conn.connect();
        String query = "UPDATE products SET type = ?, category = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            if (product instanceof Food) {
                pstmt.setString(1, "food");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) product.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    String query2 = "UPDATE foods SET name = ?, price = ?, description = ? WHERE product = ?";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setString(1, product.getName());
                    pstmt2.setDouble(2, product.getPrice());
                    pstmt2.setString(3, product.getDescription());
                    pstmt2.setInt(4, (int) product.getId());
                    pstmt2.executeUpdate();
                }
            } else if (product instanceof Beverage) {
                pstmt.setString(1, "beverage");
                pstmt.setInt(2, (int) product.getCategory().getId());
                pstmt.setInt(3, (int) product.getId());
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();

                if (rs.next()) {
                    String query2 = "UPDATE beverages SET name = ?, price = ?, description = ?, brand = ?, alcoholVolume = ? WHERE product = ?";
                    PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                    pstmt2.setString(1, product.getName());
                    pstmt2.setDouble(2, product.getPrice());
                    pstmt2.setString(3, product.getDescription());
                    pstmt2.setString(4, ((Beverage) product).getBrand());
                    pstmt2.setDouble(5, ((Beverage) product).getAlcoholVolume());
                    pstmt2.setInt(6, (int) product.getId());
                    pstmt2.executeUpdate();
                }
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();
    }

    @Override
    public void delete(Product product) {
        conn.connect();
        try {
            if (product instanceof Food) {
                String query2 = "DELETE FROM foods WHERE product = ?";
                PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                pstmt2.setInt(1, (int) product.getId());
                pstmt2.executeQuery();
                pstmt2.close();
            } else if (product instanceof Beverage) {
                String query2 = "DELETE FROM beverages WHERE product = ?";
                PreparedStatement pstmt2 = conn.getConnection().prepareStatement(query2);
                pstmt2.setInt(1, (int) product.getId());
                pstmt2.executeQuery();
                pstmt2.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();
    }
}
