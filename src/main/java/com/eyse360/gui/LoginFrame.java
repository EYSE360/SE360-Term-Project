/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eyse360.gui;

import com.bulenkov.darcula.DarculaLaf;
import com.eyse360.controllers.mysql.BarUserDAO;
import com.eyse360.models.BarUser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Erel
 */
public class LoginFrame extends javax.swing.JFrame {
    private static BarUserDAO barUserDao;
    
    
    /**
     * Creates new form Login
     */
    public LoginFrame() {
        barUserDao = new BarUserDAO();
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        UserName = new javax.swing.JTextField();
        PasswordField_TextField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ShowPassword_CheckBox = new javax.swing.JCheckBox();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("WELCOME TO BCRS!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 60;
        gridBagConstraints.insets = new java.awt.Insets(0, 100, 0, 100);
        getContentPane().add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        getContentPane().add(UserName, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        getContentPane().add(PasswordField_TextField, gridBagConstraints);

        jLabel2.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel3.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(jLabel3, gridBagConstraints);

        ShowPassword_CheckBox.setText("Show Password");
        ShowPassword_CheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPassword_CheckBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        getContentPane().add(ShowPassword_CheckBox, gridBagConstraints);

        LoginButton.setText("Login");
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 20;
        getContentPane().add(LoginButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMouseClicked
        String userName = UserName.getText();
        String password = PasswordField_TextField.getText();

        BarUser user = barUserDao.login(userName, password);
        
        if (user != null) {
            BarFrame barFrame = new BarFrame(user);
            dispose();
            barFrame.setVisible(true);
        }   else{
            JOptionPane.showMessageDialog(this, "WRONG USERNAME OR PASSWORD! PLEASE TRY AGAIN.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_LoginButtonMouseClicked

    private void ShowPassword_CheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPassword_CheckBoxActionPerformed
        
        if(ShowPassword_CheckBox.isSelected()){
            PasswordField_TextField.setEchoChar((char)0);
        }
        else{
            PasswordField_TextField.setEchoChar('*');
        }
        
    }//GEN-LAST:event_ShowPassword_CheckBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       javax.swing.plaf.basic.BasicLookAndFeel darcula = new DarculaLaf();
        javax.swing.UIManager.setLookAndFeel(darcula);
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PasswordField_TextField;
    private javax.swing.JCheckBox ShowPassword_CheckBox;
    private javax.swing.JTextField UserName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
