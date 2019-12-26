/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyse360.gui;

import com.eyse360.controllers.mysql.BarDAO;
import com.eyse360.controllers.mysql.BarUserDAO;
import com.eyse360.controllers.mysql.CategoryDAO;
import com.eyse360.controllers.mysql.ProductDAO;
import com.eyse360.controllers.mysql.TableDAO;
import com.eyse360.models.Bar;
import com.eyse360.models.Table;

/**
 *
 * @author Erel
 */
public class TableContentFrameBackup extends javax.swing.JFrame {

    /**
     * Creates new form TableContent
     */
    private static BarDAO barDao;
    private static CategoryDAO catDao;
    private static ProductDAO productDAO;
    private static BarUserDAO barUserDAO;
    private static TableDAO tableDAO;
    private static Bar currentBar;
    
    public TableContentFrameBackup() {
        initComponents();
    }

    public TableContentFrameBackup(Table table) {
        barDao = new BarDAO();
        catDao = new CategoryDAO();
        productDAO = new ProductDAO();
        barUserDAO = new BarUserDAO();
        tableDAO = new TableDAO();
        currentBar = barDao.getById(1);
        
        initComponents();
        
        TableNameLabel.setText(table.getName());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TableNameLabel = new javax.swing.JLabel();
        CustomerCountLabel = new javax.swing.JLabel();
        TotalTimeLabel = new javax.swing.JLabel();
        WaiterNameLabel = new javax.swing.JLabel();
        CustomerCountTextField = new javax.swing.JTextField();
        TotalTimeTextField = new javax.swing.JTextField();
        IncrementCustomerCountButton = new javax.swing.JButton();
        DecrementCustomerCountButton = new javax.swing.JButton();
        TableInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CheckLogTable = new javax.swing.JTable();
        AddProductButton = new javax.swing.JButton();
        QuantityLabel = new javax.swing.JLabel();
        IncrementQuantityButton = new javax.swing.JButton();
        DecrementQuantityButton = new javax.swing.JButton();
        RemoveFromTableButton = new javax.swing.JButton();
        TotalLabel = new javax.swing.JLabel();
        TotalTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        TableNameLabel.setText("Table Name:");

        CustomerCountLabel.setText("Customer Count:");

        TotalTimeLabel.setText("Total Time:");

        WaiterNameLabel.setText("Waiter Name");

        CustomerCountTextField.setText("0");

        IncrementCustomerCountButton.setText("+");
        IncrementCustomerCountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncrementCustomerCountButtonMouseClicked(evt);
            }
        });

        DecrementCustomerCountButton.setText("-");
        DecrementCustomerCountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DecrementCustomerCountButtonMouseClicked(evt);
            }
        });

        TableInfoLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        TableInfoLabel.setText("TABLE INFO");

        CheckLogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Category", "Quantity"
            }
        ));
        jScrollPane1.setViewportView(CheckLogTable);

        AddProductButton.setText("Add Product");
        AddProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddProductButtonMouseClicked(evt);
            }
        });

        QuantityLabel.setText("Quantity");

        IncrementQuantityButton.setText("+");
        IncrementQuantityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IncrementQuantityButtonMouseClicked(evt);
            }
        });

        DecrementQuantityButton.setText("-");
        DecrementQuantityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DecrementQuantityButtonMouseClicked(evt);
            }
        });

        RemoveFromTableButton.setText("Remove");
        RemoveFromTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveFromTableButtonMouseClicked(evt);
            }
        });

        TotalLabel.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuantityLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(DecrementQuantityButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IncrementQuantityButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(RemoveFromTableButton))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TableNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CustomerCountLabel)
                            .addComponent(TotalTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TotalTimeTextField)
                            .addComponent(CustomerCountTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IncrementCustomerCountButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DecrementCustomerCountButton)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TotalTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(AddProductButton)
                                        .addGap(43, 43, 43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(WaiterNameLabel)
                                        .addGap(71, 71, 71)))))
                        .addGap(97, 97, 97))))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(TableInfoLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(TableInfoLabel)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TableNameLabel)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerCountLabel)
                            .addComponent(CustomerCountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IncrementCustomerCountButton)
                            .addComponent(DecrementCustomerCountButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalTimeLabel)
                            .addComponent(TotalTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(WaiterNameLabel)
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalLabel)
                            .addComponent(TotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(AddProductButton)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(QuantityLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IncrementQuantityButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DecrementQuantityButton)
                        .addGap(40, 40, 40)
                        .addComponent(RemoveFromTableButton)))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IncrementCustomerCountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncrementCustomerCountButtonMouseClicked
        String s = CustomerCountTextField.getText();
        int var = Integer.parseInt(s);
        CustomerCountTextField.setText(Integer.toString(var++));
    }//GEN-LAST:event_IncrementCustomerCountButtonMouseClicked

    private void DecrementCustomerCountButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DecrementCustomerCountButtonMouseClicked
        String s = CustomerCountTextField.getText();
        int var = Integer.parseInt(s);
        if(var!=0)
        CustomerCountTextField.setText(Integer.toString(var--));
    }//GEN-LAST:event_DecrementCustomerCountButtonMouseClicked

    private void AddProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddProductButtonMouseClicked
        /*SelectProductFrame spf = new SelectProductFrame();
        spf.setVisible(true);*/
    }//GEN-LAST:event_AddProductButtonMouseClicked

    private void RemoveFromTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveFromTableButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RemoveFromTableButtonMouseClicked

    private void IncrementQuantityButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IncrementQuantityButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_IncrementQuantityButtonMouseClicked

    private void DecrementQuantityButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DecrementQuantityButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DecrementQuantityButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TableContentFrameBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableContentFrameBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableContentFrameBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableContentFrameBackup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableContentFrameBackup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProductButton;
    private javax.swing.JTable CheckLogTable;
    private javax.swing.JLabel CustomerCountLabel;
    private javax.swing.JTextField CustomerCountTextField;
    private javax.swing.JButton DecrementCustomerCountButton;
    private javax.swing.JButton DecrementQuantityButton;
    private javax.swing.JButton IncrementCustomerCountButton;
    private javax.swing.JButton IncrementQuantityButton;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JButton RemoveFromTableButton;
    private javax.swing.JLabel TableInfoLabel;
    private javax.swing.JLabel TableNameLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JTextField TotalTextField;
    private javax.swing.JLabel TotalTimeLabel;
    private javax.swing.JTextField TotalTimeTextField;
    private javax.swing.JLabel WaiterNameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
