
package com.eyse360.gui;

import com.eyse360.models.Waiter;

/**
 *
 * @author Erel
 */
public class WaiterCreateFrame extends javax.swing.JFrame {

    public WaiterCreateFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        NameLabel = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        SSNLabel = new javax.swing.JLabel();
        SSNTextField = new javax.swing.JTextField();
        PhoneNumberLabel = new javax.swing.JLabel();
        PhoneNumberTextField = new javax.swing.JTextField();
        CreateButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        WaiterUserNameLabel = new javax.swing.JLabel();
        WaiterUserNameTextField = new javax.swing.JTextField();
        WaiterPasswordLabel = new javax.swing.JLabel();
        WaiterPasswordTextField = new javax.swing.JPasswordField();
        ShowPasswordCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(394, 306));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        NameLabel.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(NameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(NameTextField, gridBagConstraints);

        SSNLabel.setText("SSN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(SSNLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(SSNTextField, gridBagConstraints);

        PhoneNumberLabel.setText("Phone Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(PhoneNumberLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(PhoneNumberTextField, gridBagConstraints);

        CreateButton.setText("Create");
        CreateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 120, 6, 0);
        getContentPane().add(CreateButton, gridBagConstraints);

        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 6, 6, 129);
        getContentPane().add(CancelButton, gridBagConstraints);

        WaiterUserNameLabel.setText("Username");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(WaiterUserNameLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(WaiterUserNameTextField, gridBagConstraints);

        WaiterPasswordLabel.setText("Password");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 0);
        getContentPane().add(WaiterPasswordLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        getContentPane().add(WaiterPasswordTextField, gridBagConstraints);

        ShowPasswordCheckbox.setText("Show Password");
        ShowPasswordCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowPasswordCheckboxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        getContentPane().add(ShowPasswordCheckbox, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateButtonMouseClicked
        Waiter waiter = new Waiter();
        waiter.setUserName(WaiterUserNameTextField.getText());
        waiter.setPassword(WaiterPasswordTextField.getText());
        waiter.setFullName(NameTextField.getText());
        waiter.setSSN(SSNTextField.getText());
        waiter.setPhoneNumber(PhoneNumberTextField.getText());
        waiter.setBar(BarFrame.currentBar);
        waiter.setRole("waiter");
        waiter.setId(BarFrame.barUserDao.save(waiter));
        BarFrame.waiterModel.addElement(waiter);
        dispose();
    }//GEN-LAST:event_CreateButtonMouseClicked

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        dispose();
    }//GEN-LAST:event_CancelButtonMouseClicked

    private void ShowPasswordCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowPasswordCheckboxActionPerformed
        if(ShowPasswordCheckbox.isSelected()){
            WaiterPasswordTextField.setEchoChar((char)0);
        }
        else{
            WaiterPasswordTextField.setEchoChar('*');
        }
    }//GEN-LAST:event_ShowPasswordCheckboxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JLabel PhoneNumberLabel;
    private javax.swing.JTextField PhoneNumberTextField;
    private javax.swing.JLabel SSNLabel;
    private javax.swing.JTextField SSNTextField;
    private javax.swing.JCheckBox ShowPasswordCheckbox;
    private javax.swing.JLabel WaiterPasswordLabel;
    private javax.swing.JPasswordField WaiterPasswordTextField;
    private javax.swing.JLabel WaiterUserNameLabel;
    private javax.swing.JTextField WaiterUserNameTextField;
    // End of variables declaration//GEN-END:variables
}
