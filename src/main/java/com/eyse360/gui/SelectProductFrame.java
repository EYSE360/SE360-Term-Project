package com.eyse360.gui;

import com.eyse360.controllers.mysql.CategoryDAO;
import com.eyse360.controllers.mysql.ProductDAO;
import com.eyse360.controllers.mysql.TableDAO;
import com.eyse360.models.Bar;
import com.eyse360.models.Category;
import com.eyse360.models.Check;
import com.eyse360.models.Product;
import com.eyse360.models.Table;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import java.util.List;

public class SelectProductFrame extends javax.swing.JFrame {

    private Bar currentBar;
    
    private DefaultComboBoxModel comboboxModel;
    private DefaultListModel defaultListModel;
    private static CategoryDAO catDao;
    private static ProductDAO productDao;
    private static TableDAO tableDao;
    
    public SelectProductFrame(Table table, Bar bar, Check check) {
        catDao = new CategoryDAO();
        productDao = new ProductDAO();
        tableDao = new TableDAO();
        currentBar = bar;
        
        initComponents();
        
        comboboxModel = new DefaultComboBoxModel();
        CategoryComboBox.setModel(comboboxModel);
        List<Category> categoryList = catDao.getAllByBar(bar);
        for (Category category : categoryList)
            comboboxModel.addElement(category);
        
        defaultListModel = new DefaultListModel();
        ProductList.setModel(defaultListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CategoryComboBox = new javax.swing.JComboBox<Category>();
        CategoriesLabel = new javax.swing.JLabel();
        ProductListLabel = new javax.swing.JLabel();
        SelectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CategoryComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CategoryComboBoxItemStateChanged(evt);
            }
        });

        CategoriesLabel.setText("Categories");

        ProductListLabel.setText("Product List");

        SelectButton.setText("Select");
        SelectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectButtonMouseClicked(evt);
            }
        });

        ProductList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ProductList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectButton)
                    .addComponent(CategoriesLabel)
                    .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductListLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CategoriesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(ProductListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectButtonMouseClicked
        Product product = ProductList.getSelectedValue();
        TableContentFrame.tableModel.addRow(product, 1);
        tableDao.addProductToCheck(product, TableContentFrame.currentCheck, 1);
        
        dispose();
    }//GEN-LAST:event_SelectButtonMouseClicked

    private void CategoryComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CategoryComboBox�temStateChanged
        Category category = (Category) CategoryComboBox.getSelectedItem();
        defaultListModel.removeAllElements();
        List<Product> productList = productDao.getAllByBarAndCategory(currentBar, category);
        for (Product product : productList)
            defaultListModel.addElement(product);
    }//GEN-LAST:event_CategoryComboBox�temStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CategoriesLabel;
    private javax.swing.JComboBox<Category> CategoryComboBox;
    private javax.swing.JList<Product> ProductList;
    private javax.swing.JLabel ProductListLabel;
    private javax.swing.JButton SelectButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
