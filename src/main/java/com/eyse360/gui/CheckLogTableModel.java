/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyse360.gui;

import com.eyse360.models.Category;
import com.eyse360.models.Product;
import java.util.Map;
import java.util.HashMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yagiz
 */
public class CheckLogTableModel extends AbstractTableModel {
    private String[] columnNames = {"Product", "Category", "Quantity"};
    private HashMap<Product, Integer> products;
    
    public CheckLogTableModel(HashMap<Product, Integer> map) {
        products = map;
    }

    @Override
    public int getRowCount() {
        int size;
        if (products == null) {
            size = 0;
        } else {
            size = products.size();
        }
        
        return size;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Object[] entries = products.entrySet().toArray();
        Map.Entry<Product, Integer> entry = (Map.Entry) entries[row];
        
        if (col == 0) {
           return entry.getKey();
        }
        else if (col == 1) {
           return entry.getKey().getCategory();
        }
        else if (col == 2) {
           return entry.getValue();
        }
        
        return null;
    }   
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public Class getColumnClass(int col) {
        if (col == 0) {
             return Product.class;
        } else if (col == 1) {
            return Category.class;
        } else if (col == 2) {
             return Double.class;
        }
        
        return null;
    }
}
