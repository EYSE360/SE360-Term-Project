package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.GUITest;
import com.eyse360.models.Bar;
import com.eyse360.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryDAO implements DAO<Category> {
    DBConnection conn = new DBConnection();
    @Override
    public Category get(Category category) {
        conn.connect();

        Category returnCategory = null;

        String query = "SELECT * FROM product_categories WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) category.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                returnCategory = new Category();
                returnCategory.setId(rs.getInt("id"));
                returnCategory.setName(rs.getString("name"));
                returnCategory.setDescription(rs.getString("description"));
                returnCategory.setType(rs.getString("type"));
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return returnCategory;
    }

    @Override
    public Category getById(int id) {
        conn.connect();

        Category category = null;

        String query = "SELECT * FROM product_categories WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setType(rs.getString("type"));
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return category;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    public List<Category> getAllByBar(Bar b) {
        conn.connect();

        List<Category> categoryList = null;

        String query = "SELECT * FROM product_categories WHERE id_bar = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) b.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                categoryList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setType(rs.getString("type"));
                categoryList.add(c);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return categoryList;
    }

    public Category[] getAllByBarToArray(Bar b) {
        conn.connect();

        Category[] categories = null;
        int size = 0;        

        String query = "SELECT * FROM product_categories WHERE id_bar = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pstmt.setInt(1, (int) b.getId());
            ResultSet rs = pstmt.executeQuery();
            
            String query2 = "SELECT COUNT(*) AS count FROM product_categories WHERE id_bar = ?";
            Statement stmt2 = conn.getConnection().createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) AS count FROM product_categories");
            while (rs2.next()) {
                size = rs2.getInt("count");
            }
            rs2.close();
            stmt2.close();
            
            
            categories = new Category[size];
            
            int i = 0;
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setType(rs.getString("type"));
                categories[i] = c;
                i++;
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return categories;
    }

    @Override
    public int save(Category t) {
        return 0;
    }    
    
    public int saveWithBarId(Category category, long barId) {
        conn.connect();
        String query = "INSERT INTO product_categories (name, description, type, id_bar) VALUES (?, ?, ?, ?)";

        int id = 0;

        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getType());
            pstmt.setInt(4, (int) barId);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next())
                id = rs.getInt(1);

            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();
        return id;
    }

    @Override
    public void update(Category category) {
        conn.connect();

        String query = "UPDATE product_categories SET name = ?, description = ?, type = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getType());
            pstmt.setInt(4, (int) category.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
    }

    @Override
    public void delete(Category category) {
        conn.connect();
        
        String query = "DELETE FROM product_categories WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) category.getId());
            
            pstmt.executeQuery();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
