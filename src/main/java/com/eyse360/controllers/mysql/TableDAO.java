package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.GUITest;
import com.eyse360.models.Bar;
import com.eyse360.models.Category;
import com.eyse360.models.Table;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TableDAO implements DAO<Table> {
    @Override
    public Table get(Table table) {

        GUITest.conn.connect();

        Table returnTable = null;

        String query = "SELECT * FROM tables WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) table.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                returnTable = new Table();
                returnTable.setId(rs.getInt("id"));
                returnTable.setName(rs.getString("name"));
                returnTable.setShortCode(rs.getString("shortCode"));
                returnTable.setCustomerCount(rs.getInt("int"));
            }
            pstmt.close();
            rs.close();

            GUITest.conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return returnTable;
    }

    @Override
    public Table getById(int id) {
        GUITest.conn.connect();

        Table table = null;

        String query = "SELECT * FROM tables WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                table = new Table();
                table.setId(rs.getInt("id"));
                table.setName(rs.getString("name"));
                table.setShortCode(rs.getString("shortCode"));
                table.setCustomerCount(rs.getInt("int"));
            }
            pstmt.close();
            rs.close();

            GUITest.conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return table;
    }

    @Override
    public List<Table> getAll() {
        return null;
    }

    public List<Table> getAllByBar(Bar bar) {
        GUITest.conn.connect();

        List<Table> tableList = null;

        String query = "SELECT * FROM product_categories WHERE id_bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) bar.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                tableList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                Table t = new Table();
                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));
                t.setShortCode(rs.getString("shortcode"));
                t.setCustomerCount(rs.getInt("customerCount"));
                tableList.add(t);
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return tableList;
    }

    @Override
    public int save(Table table) {
        GUITest.conn.connect();
        String query = "INSERT INTO tables (shortcode, name, customerCount, id_bar) VALUES (?, ?, ?, ?)";

        int id = 0;

        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, table.getShortCode());
            pstmt.setString(2, table.getName());
            pstmt.setInt(3, table.getCustomerCount());
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
    public void update(Table table) {

    }

    @Override
    public void delete(Table table) {

    }
}
