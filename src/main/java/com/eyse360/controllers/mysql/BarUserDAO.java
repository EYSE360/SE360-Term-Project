package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.GUITest;
import com.eyse360.models.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarUserDAO implements DAO<BarUser> {
    DBConnection conn = new DBConnection();
    @Override
    public BarUser get(BarUser barUser) {
        conn.connect();

        BarUser returnUser = null;

        String query = "SELECT * FROM bar_users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return returnUser;
    }

    @Override
    public BarUser getById(int id) {
        conn.connect();

        BarUser barUser = null;

        String query = "SELECT * FROM bar_users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return barUser;
    }
    
    public List<Waiter> getAllWaitersByBar(Bar bar) {
        conn.connect();
        List<Waiter> waiters = null;
        String query = "SELECT * FROM bar_users WHERE userRole = 'waiter' ";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                waiters = new ArrayList<>();
            }
            rs.beforeFirst();
            while(rs.next()){
                Waiter waiter = new Waiter();
                waiter.setId(rs.getLong("id"));
                waiter.setUserName(rs.getString("username"));
                waiter.setPassword(rs.getString("password"));
                waiter.setSSN(rs.getString("SSN"));
                waiter.setFullName(rs.getString("fullName"));
                waiter.setPhoneNumber(rs.getString("phoneNumber"));
                waiter.setRole(rs.getString("userRole"));
                
                waiters.add(waiter);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(BarUserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conn.disconnect();
        
        return waiters;
    }

    @Override
    public List<BarUser> getAll() {
        return null;
    }

    public List<BarUser> getAllByBar(Bar b) {
        conn.connect();

        List<BarUser> barUserList = null;

        String query = "SELECT * FROM bar_users WHERE bar = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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

        conn.disconnect();

        return barUserList;
    }

    @Override
    public int save(BarUser barUser) {
        conn.connect();
        String query = "INSERT INTO bar_users (username, password, SSN, fullName, phoneNumber, userRole, bar) VALUES (?, ?, ?, ?, ?, ?, ?)";

        int id = 0;

        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
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

        conn.disconnect();
        return id;
    }

    @Override
    public void update(BarUser barUser) {
        conn.connect();

        String query = "UPDATE bar_users SET username = ?, password = ?, SSN = ?, fullName = ?, phoneNumber = ?, userRole = ? WHERE id = ? AND bar = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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
        conn.disconnect();

    }

    @Override
    public void delete(BarUser barUser) {

    }
}
