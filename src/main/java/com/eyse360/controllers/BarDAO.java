package com.eyse360.controllers;
import com.eyse360.DAO;
import com.eyse360.GUITest;
import com.eyse360.models.Bar;
import com.eyse360.models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BarDAO implements DAO<Bar> {
    @Override
    public Optional<Bar> get(Bar bar) {
        return Optional.empty();
    }

    public Bar getById(int id) {
        GUITest.conn.connect();
        Bar b = null;
        String query = "SELECT * FROM bars WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                b = new Bar();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCity(rs.getString("city"));
                b.setAlcoholPermission(rs.getBoolean("alcoholPermission"));
            }
            pstmt.close();
            rs.close();

            GUITest.conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();
        return b;
    }

    @Override
    public List<Bar> getAll() {
        GUITest.conn.connect();
        String query = "SELECT * FROM bars";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            List<Bar> barList = null;
            if (rs.next()) {
                barList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                Bar b = new Bar();
                b.setId(rs.getInt("id"));
                b.setName(rs.getString("name"));
                b.setCity(rs.getString("city"));
                b.setAlcoholPermission(rs.getBoolean("alcoholPermission"));
                barList.add(b);
            }
            pstmt.close();
            rs.close();
            return barList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();
        return null;
    }

    @Override
    public int save(Bar b) {
        GUITest.conn.connect();
        String query = "INSERT INTO bars (name, city, alcoholPermission) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, b.getName());
            pstmt.setString(2, b.getCity());
            pstmt.setInt(3, b.getAlcoholPermission() ? 1 : 0);
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
    public void update(Bar b) {
        String query = "UPDATE bars SET name = ?, city = ?, alcoholPermission = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setString(1, b.getName());
            pstmt.setString(2, b.getCity());
            pstmt.setInt(3, b.getAlcoholPermission() ? 1 : 0);
            pstmt.setInt(4, (int) b.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();
    }

    @Override
    public void delete(Bar b) {

    }
}
