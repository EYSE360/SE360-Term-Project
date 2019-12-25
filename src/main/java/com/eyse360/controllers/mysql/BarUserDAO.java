package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.GUITest;
import com.eyse360.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BarUserDAO implements DAO<BarUser> {
    @Override
    public BarUser get(BarUser barUser) {

        GUITest.conn.connect();

        BarUser returnUser = null;

        String query = "SELECT * FROM bar_users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) barUser.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("userRole").equals("manager")) {
                    returnUser = new BarManager();
                    returnUser.setId(rs.getInt("id"));
                    returnUser.setUserName(rs.getString("username"));
                    returnUser.setPassword(rs.getString("password"));
                    returnUser.setSSN(rs.getString("SSN"));
                    returnUser.setFullName(rs.getString("fullName"));
                    returnUser.setPhoneNumber(rs.getString("phoneNumber"));
                    returnUser.setRole(rs.getString("userRole"));
                } else if (rs.getString("userRole").equals("waiter")) {
                    returnUser = new Waiter();
                    returnUser.setId(rs.getInt("id"));
                    returnUser.setUserName(rs.getString("username"));
                    returnUser.setPassword(rs.getString("password"));
                    returnUser.setSSN(rs.getString("SSN"));
                    returnUser.setFullName(rs.getString("fullName"));
                    returnUser.setPhoneNumber(rs.getString("phoneNumber"));
                    returnUser.setRole(rs.getString("userRole"));
                }
            }
            pstmt.close();
            rs.close();

            GUITest.conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return returnUser;
    }

    @Override
    public BarUser getById(int id) {
        GUITest.conn.connect();

        BarUser barUser = null;

        String query = "SELECT * FROM bar_users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("userRole").equals("manager")) {
                    barUser = new BarManager();
                    barUser.setId(rs.getInt("id"));
                    barUser.setUserName(rs.getString("username"));
                    barUser.setPassword(rs.getString("password"));
                    barUser.setSSN(rs.getString("SSN"));
                    barUser.setFullName(rs.getString("fullName"));
                    barUser.setPhoneNumber(rs.getString("phoneNumber"));
                    barUser.setRole(rs.getString("userRole"));
                } else if (rs.getString("userRole").equals("waiter")) {
                    barUser = new Waiter();
                    barUser.setId(rs.getInt("id"));
                    barUser.setUserName(rs.getString("username"));
                    barUser.setPassword(rs.getString("password"));
                    barUser.setSSN(rs.getString("SSN"));
                    barUser.setFullName(rs.getString("fullName"));
                    barUser.setPhoneNumber(rs.getString("phoneNumber"));
                    barUser.setRole(rs.getString("userRole"));
                }
            }
            pstmt.close();
            rs.close();

            GUITest.conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return barUser;
    }

    @Override
    public List<BarUser> getAll() {
        return null;
    }

    public List<BarUser> getAllByBar(Bar b) {
        GUITest.conn.connect();

        List<BarUser> barUserList = null;

        String query = "SELECT * FROM bar_users WHERE bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) b.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                barUserList = new ArrayList<>();
            }
            rs.beforeFirst();
            while (rs.next()) {
                if (rs.getString("userRole").equals("manager")) {
                    BarManager user = new BarManager();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setSSN(rs.getString("SSN"));
                    user.setFullName(rs.getString("fullName"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setRole(rs.getString("userRole"));
                    barUserList.add(user);
                } else if (rs.getString("userRole").equals("waiter")) {
                    Waiter user = new Waiter();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setSSN(rs.getString("SSN"));
                    user.setFullName(rs.getString("fullName"));
                    user.setPhoneNumber(rs.getString("phoneNumber"));
                    user.setRole(rs.getString("userRole"));
                    barUserList.add(user);
                }
            }
            pstmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        GUITest.conn.disconnect();

        return barUserList;
    }

    @Override
    public int save(BarUser barUser) {
        GUITest.conn.connect();
        String query = "INSERT INTO bar_users (username, password, SSN, fullName, phoneNumber, userRole, bar) VALUES (?, ?, ?, ?, ?, ?, ?)";

        int id = 0;

        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, barUser.getUserName());
            pstmt.setString(2, barUser.getPassword());
            pstmt.setString(3, barUser.getSSN());
            pstmt.setString(4, barUser.getFullName());
            pstmt.setString(5, barUser.getPhoneNumber());
            pstmt.setString(6, barUser instanceof BarManager ? "manager" : "waiter");
            pstmt.setInt(7, (int) GUITest.bar.getId());
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
    public void update(BarUser barUser) {
        GUITest.conn.connect();

        String query = "UPDATE bar_users SET username = ?, password = ?, SSN = ?, fullName = ?, phoneNumber = ?, userRole = ? WHERE id = ? AND bar = ?";
        try {
            PreparedStatement pstmt = GUITest.conn.getConnection().prepareStatement(query);
            pstmt.setString(1, barUser.getUserName());
            pstmt.setString(2, barUser.getPassword());
            pstmt.setString(3, barUser.getSSN());
            pstmt.setString(4, barUser.getFullName());
            pstmt.setString(5, barUser.getPhoneNumber());
            pstmt.setString(6, barUser.getRole());
            pstmt.setInt(7, (int) barUser.getId());
            pstmt.setInt(8, (int) GUITest.bar.getId());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        GUITest.conn.disconnect();

    }

    @Override
    public void delete(BarUser barUser) {

    }
}
