package com.eyse360.gui;

import com.eyse360.models.Category;
import com.eyse360.models.Product;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CheckLogTableModel extends AbstractTableModel {
    private String[] columnNames = {"Product", "Price", "Quantity"};
    private LinkedHashMap<Product, Integer> products;
    
    public CheckLogTableModel(LinkedHashMap<Product, Integer> map) {
        products = map;
    }
    
    public CheckLogTableModel() {
        products = new LinkedHashMap<>();
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
           return entry.getKey().getPrice();
        }
        else if (col == 2) {
           return entry.getValue();
        }
        
        return null;
    }
    
    public void addRow(Product product, Integer quantity) {
        //if (products)
        int q = products.containsKey(product) ? products.get(product) + quantity : quantity;
        products.put(product, q);
        
        if (products.get(product) <= 0)
            removeRow(product);
        fireTableDataChanged();
    }
    
    public void removeRow(Product product) {
        int row = getProductMapIndex(products, product);
        products.remove(product);
        fireTableRowsDeleted(row, row);
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
    
    public int getProductMapIndex(Map map, Product product) {      
        List indexes = new ArrayList<>(map.keySet());
        
        return indexes.indexOf(product);
    }
}
