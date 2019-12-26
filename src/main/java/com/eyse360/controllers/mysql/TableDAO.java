package com.eyse360.controllers.mysql;

import com.eyse360.DAO;
import com.eyse360.DBConnection;
import com.eyse360.gui.BarFrame;
import com.eyse360.models.Bar;
import com.eyse360.models.Check;
import com.eyse360.models.Product;
import com.eyse360.models.Table;
import com.eyse360.models.Waiter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableDAO implements DAO<Table> {
    DBConnection conn = new DBConnection();
    @Override
    public Table get(Table table) {
        conn.connect();

        Table returnTable = null;

        String query = "SELECT * FROM tables WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return returnTable;
    }
    
    public Check getTableCheck(Table table) {
        CheckDAO checkDAO = new CheckDAO();
        conn.connect();
        Check check = null;
        
        String query = "SELECT id_check, is_open FROM checks WHERE id_table = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) table.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                check = checkDAO.getById(rs.getInt("id_check"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return check;
    }

    @Override
    public Table getById(int id) {
        conn.connect();

        Table table = null;

        String query = "SELECT * FROM tables WHERE id = ? LIMIT 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
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

            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();

        return table;
    }

    @Override
    public List<Table> getAll() {
        return null;
    }

    public List<Table> getAllByBar(Bar bar) {
        conn.connect();

        List<Table> tableList = null;

        String query = "SELECT * FROM tables WHERE id_bar = ?";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            System.out.println(pstmt.getMetaData());
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

        conn.disconnect();

        return tableList;
    }

    @Override
    public int save(Table table) {
        conn.connect();
        String query = "INSERT INTO tables (shortcode, name, customerCount, id_bar) VALUES (?, ?, ?, ?)";

        int id = 0;

        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, table.getShortCode());
            pstmt.setString(2, table.getName());
            pstmt.setInt(3, table.getCustomerCount());
            pstmt.setInt(4, (int) BarFrame.currentBar.getId());
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
    public void update(Table table) {
        conn.connect();
        String query = "UPDATE tables SET shortcode = ?, name = ?, customerCount = ? WHERE id = ?";
        
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setString(1, table.getShortCode());
            pstmt.setString(2, table.getName());
            pstmt.setInt(3, table.getCustomerCount());
            pstmt.setInt(4, (int) table.getId());
            pstmt.executeUpdate();
            
            pstmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        conn.disconnect();
    }

    @Override
    public void delete(Table table) {
        conn.connect();
        String query = "DELETE FROM tables WHERE id = ?";
        
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) table.getId());
            pstmt.executeUpdate();
            
            pstmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        conn.disconnect();
    }
    
    public Check getOpenCheckDetailByTable(Table table) {
        conn.connect();
        BarUserDAO barUserDao = new BarUserDAO();
        
        Check check = null;
        
        String query = "SELECT * FROM checks WHERE id_table = ? AND is_open = 1";
        try {
            PreparedStatement pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) table.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                check = new Check();
                check.setId(rs.getInt("id_check"));
                check.setIsOpen(rs.getInt("is_open") == 1? true : false);
                check.setTime(rs.getInt("time"));
                check.setClose_time(rs.getInt("close_time"));
                check.setWaiter((Waiter) barUserDao.getById(rs.getInt("id_waiter")));
            }
            rs.close();
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conn.disconnect();
        return check;
    }
    
    public HashMap<Product, Integer> getTableProducts(Check check) {
        conn.connect();
        ProductDAO productDao = new ProductDAO();
        
        HashMap<Product, Integer> products = null;
        
        String query = "SELECT cc.id_product, cc.quantity"
                + "     FROM check_contents AS cc"
                + "         LEFT JOIN products AS p ON p.id = cc.id_product"
                + "     WHERE cc.id_check = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.getConnection().prepareStatement(query);
            pstmt.setInt(1, (int) check.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                products = new HashMap<Product, Integer>();

            rs.beforeFirst();

            while (rs.next()) {
                products.put(productDao.getById(rs.getInt("id_product")), rs.getInt("quantity"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        return products;
    }
}
