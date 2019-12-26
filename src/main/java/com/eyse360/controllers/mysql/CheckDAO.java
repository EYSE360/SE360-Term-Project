package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.models.Check;
import com.eyse360.models.Table;
import com.eyse360.models.Waiter;
import com.eyse360.tools.Tools;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CheckDAO implements DAO<Check> {
    DBConnection conn = new DBConnection();
    @Override
    public Check get(Check check) {
        conn.connect();
        ProductDAO productDAO = new ProductDAO();
        BarUserDAO barUserDAO = new BarUserDAO();

        Check returnCheck = null;

        String query = "SELECT * FROM table_check WHERE id_check = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) check.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                returnCheck = new Check();
                returnCheck.setId(rs.getInt("id_check"));
                returnCheck.setTime(rs.getInt("time"));
                returnCheck.setWaiter((Waiter) barUserDAO.getById(rs.getInt("id_waiter")));

                String productQuery = "SELECT * FROM check_logs WHERE id_check = ? GROUP BY id_check";
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return returnCheck;
    }
    
    
    public Check getByTable(Table table) {
        conn.connect();
        BarUserDAO barUserDAO = new BarUserDAO();

        Check returnCheck = null;

        String query = "SELECT * FROM checks WHERE id_table = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) table.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                returnCheck = new Check();
                returnCheck.setId(rs.getInt("id_check"));
                returnCheck.setTime(rs.getInt("time"));
                returnCheck.setWaiter((Waiter) barUserDAO.getById(rs.getInt("id_waiter")));
                returnCheck.setIsOpen(rs.getInt("is_open") == 1 ? true : false);
            }
            pstmt.close();
            rs.close();

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return returnCheck;
    }

    @Override
    public Check getById(int id) {
        return null;
    }

    @Override
    public List<Check> getAll() {
        return null;
    }

    @Override
    public int save(Check check) {
        return 0;
    }

    public int saveByTable(Check check, Table table) {
        conn.connect();
        int id = 0;

        String query = "INSERT INTO table_check (id_table, time) VALUES (?, ?)";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, (int) table.getId());
            pstmt.setInt(2, (int) Tools.getCurrentUnixTime());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public void update(Check check) {

    }

    @Override
    public void delete(Check check) {

    }
}
