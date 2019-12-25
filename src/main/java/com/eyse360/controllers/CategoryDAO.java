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
    public Optional<Category> get(Category category) {
        return Optional.empty();
    }

    @Override
    public List<Category> getAll() {
        return null;
    }

    public List<Category> getAllByBar(Bar b) {
        GUITest.conn.connect();
        String query = "SELECT * FROM product_categories WHERE id_bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) b.getId());
            ResultSet rs = pstmt.executeQuery();
            List<Category> categoryList = null;
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
                c.setBar(b);
                categoryList.add(c);
            }
            pstmt.close();
            rs.close();
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();
        return null;
    }

    @Override
    public int save(Category category) {
        GUITest.conn.connect();
        String query = "INSERT INTO product_categories (name, description, type, id_bar) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, category.getName());
            pstmt.setString(2, category.getDescription());
            pstmt.setString(3, category.getType());
            pstmt.setInt(4, (int) category.getBar().getId());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next())
                return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();
        return 0;
    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Category category) {

    }
}
