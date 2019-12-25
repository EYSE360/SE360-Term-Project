package com.eyse360.controllers;

import com.eyse360.DAO;
import com.eyse360.GUITest;
import com.eyse360.models.Bar;
import com.eyse360.models.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO implements DAO<Category> {
    @Override
    public Category get(Category category) {
        return null;
    }

    @Override
    public Category getById(int id) {
        GUITest.conn.connect();

        Category category = null;

        String query = "SELECT * FROM product_categories WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
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

            GUITest.conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return category;
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    public List<Category> getAllByBar(Bar b) {
        GUITest.conn.connect();

        List<Category> categoryList = null;

        String query = "SELECT * FROM product_categories WHERE id_bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
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

        GUITest.conn.disconnect();

        return categoryList;
    }

    @Override
    public int save(Category category) {
        GUITest.conn.connect();
        String query = "INSERT INTO product_categories (name, description, type, id_bar) VALUES (?, ?, ?, ?)";

        int id = 0;

        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getType());
            pstmt.setInt(4, (int) GUITest.bar.getId());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next())
                id = rs.getInt(1);

            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();
        return id;
    }

    @Override
    public void update(Category category) {
        GUITest.conn.connect();

        String query = "UPDATE product_categories SET name = ?, description = ?, type = ? WHERE id = ? AND id_bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getType());
            pstmt.setInt(4, (int) category.getId());
            pstmt.setInt(5, (int) GUITest.bar.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();
    }

    @Override
    public void delete(Category category) {

    }
}
