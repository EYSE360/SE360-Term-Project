package com.eyse360.gui;

import com.eyse360.models.Category;

/**
 *
 * @author Erel
 */
public class CategoryCreateFrame extends javax.swing.JFrame {
    public CategoryCreateFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        TypeLable = new javax.swing.JLabel();
        TypeComboBox = new javax.swing.JComboBox<>();
        CreateButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        DescriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescriptionTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        NameLabel.setText("Name");

        TypeLable.setText("Type");

        TypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "food", "beverage" }));

        CreateButton.setText("Create");
        CreateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateButtonMouseClicked(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });

        DescriptionLabel.setText("Description");

        DescriptionTextArea.setColumns(20);
        DescriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(DescriptionTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateButton)
                        .addGap(18, 18, 18)
                        .addComponent(CancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DescriptionLabel)
                            .addComponent(NameLabel)
                            .addComponent(TypeLable))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(NameTextField)
                            .addComponent(TypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DescriptionLabel)
                        .addGap(64, 64, 64))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeLable)
                    .addComponent(TypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateButton)
                    .addComponent(CancelButton))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        dispose();
    }//GEN-LAST:event_CancelButtonMouseClicked

    private void CreateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateButtonMouseClicked
        Category category = new Category();
        category.setName(NameTextField.getText());
        category.setDescription(DescriptionTextArea.getText());
        category.setType(TypeComboBox.getSelectedItem().toString());
        category.setId(BarFrame.categoryDao.saveWithBarId(category, BarFrame.currentBar.getId()));
        BarFrame.categoryModel.addElement(category);

        dispose();
    }//GEN-LAST:event_CreateButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CreateButton;
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JTextArea DescriptionTextArea;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JComboBox<String> TypeComboBox;
    private javax.swing.JLabel TypeLable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
