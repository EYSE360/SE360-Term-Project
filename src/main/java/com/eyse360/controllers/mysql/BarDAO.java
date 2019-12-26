package com.eyse360.controllers.mysql;
import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.models.Bar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BarDAO implements DAO<Bar> {
    DBConnection conn = new DBConnection();
    @Override
    public Bar get(Bar bar) {
        conn.connect();

        Bar returnBar = null;

        String query = "SELECT * FROM bars WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) bar.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                returnBar = new Bar();
                returnBar.setId(rs.getInt("id"));
                returnBar.setName(rs.getString("name"));
                returnBar.setCity(rs.getString("city"));
                returnBar.setAlcoholPermission(rs.getBoolean("alcoholPermission"));
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return returnBar;
    }

    public Bar getById(int id) {
        conn.connect();

        Bar bar = null;

        String query = "SELECT * FROM bars WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bar = new Bar();
                bar.setId(rs.getInt("id"));
                bar.setName(rs.getString("name"));
                bar.setCity(rs.getString("city"));
                bar.setAlcoholPermission(rs.getBoolean("alcoholPermission"));
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return bar;
    }

    @Override
    public List<Bar> getAll() {
        conn.connect();

        List<Bar> barList = null;

        String query = "SELECT * FROM bars";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return barList;
    }

    @Override
    public int save(Bar b) {
        conn.connect();
        int id = 0;

        String query = "INSERT INTO bars (name, city, alcoholPermission) VALUES (?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, b.getName());
            pstmt.setString(2, b.getCity());
            pstmt.setInt(3, b.getAlcoholPermission() ? 1 : 0);
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
    public void update(Bar b) {
        String query = "UPDATE bars SET name = ?, city = ?, alcoholPermission = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, b.getName());
            pstmt.setString(2, b.getCity());
            pstmt.setInt(3, b.getAlcoholPermission() ? 1 : 0);
            pstmt.setInt(4, (int) b.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn.disconnect();
    }

    @Override
    public void delete(Bar b) {

    }
}
