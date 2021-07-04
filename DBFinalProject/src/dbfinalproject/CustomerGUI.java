/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbfinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author chris
 */
public class CustomerGUI extends javax.swing.JFrame {
    final String database_URL = "jdbc:derby://localhost:1527/dbCoffeeStoreData";
    
    /**
     * Creates new form CustomerGUI
     */
    public CustomerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaCustomer = new javax.swing.JTextArea();
        displayAllBtn = new javax.swing.JButton();
        displayIDBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerIDText = new javax.swing.JTextField();
        jlblStatus = new javax.swing.JLabel();
        mainGUIBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 600));

        jTextAreaCustomer.setColumns(20);
        jTextAreaCustomer.setRows(5);
        jScrollPane1.setViewportView(jTextAreaCustomer);

        displayAllBtn.setText("Display All");
        displayAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayAllBtnActionPerformed(evt);
            }
        });

        displayIDBtn.setText("Display by id");
        displayIDBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayIDBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Customer Interface");

        jLabel2.setText("Customer ID:");

        jlblStatus.setText(" ");

        mainGUIBtn.setText("Main Screen Page");
        mainGUIBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainGUIBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(displayAllBtn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(displayIDBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(308, 308, 308))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainGUIBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblStatus)
                .addGap(18, 18, 18)
                .addComponent(displayAllBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayIDBtn)
                    .addComponent(jLabel2)
                    .addComponent(customerIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(mainGUIBtn)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void displayAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayAllBtnActionPerformed
        // TODO add your handling code here:
         String displayStatement = "SELECT * FROM CUSTOMER";
        try(Connection connection = DriverManager.getConnection(database_URL, "me", "me");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(displayStatement))
        {
            jTextAreaCustomer.setText("");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            jTextAreaCustomer.append(String.format("Customer Table %n%n"));
            
            for(int i = 1; i <= numberOfColumns; i++){
                jTextAreaCustomer.append(String.format("%-8s\t", metaData.getColumnName(i)));
            }
            jTextAreaCustomer.append(String.format("%n"));
            while(resultSet.next()){
                for(int i = 1; i <= numberOfColumns; i++){
                    jTextAreaCustomer.append(String.format("%-8s\t", resultSet.getObject(i)));
                }
                jTextAreaCustomer.append(String.format("%n"));
            }
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_displayAllBtnActionPerformed

    private void displayIDBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayIDBtnActionPerformed
        // TODO add your handling code here:
        try(
            Connection connection = DriverManager.getConnection(database_URL, "me", "me");
            Statement statement = connection.createStatement();
            ){
        
        int id = Integer.parseInt(customerIDText.getText());
        //PreparedStatement stmt = connection.prepareStatement("SELECT * FROM INVENTORY WHERE ID = (?)");
        //stmt.setInt(1, id);
        //    int a = stmt.executeUpdate();
        //    if (a>0){
        //        jlblStatus.setText("Row selected");
        //    }
        jTextAreaCustomer.setText("");
        ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM CUSTOMER WHERE CUSTOMER_NUMBER = %d", id));
        ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            jTextAreaCustomer.append(String.format("Customer Table %n%n"));
            
            for(int i = 1; i <= numberOfColumns; i++){
                jTextAreaCustomer.append(String.format("%-8s\t", metaData.getColumnName(i)));
            }
            jTextAreaCustomer.append(String.format("%n"));
            while(resultSet.next()){
                for(int i = 1; i <= numberOfColumns; i++){
                    jTextAreaCustomer.append(String.format("%-8s\t", resultSet.getObject(i)));
                }
                jTextAreaCustomer.append(String.format("%n"));
        }
        }catch(Exception e){
            e.printStackTrace();
            jlblStatus.setText("Row not found");
            
        }
    }//GEN-LAST:event_displayIDBtnActionPerformed

    private void mainGUIBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainGUIBtnActionPerformed
        // TODO add your handling code here:
        MainScreenGUI main = new MainScreenGUI();
        main.setVisible(true);
        main.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_mainGUIBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField customerIDText;
    private javax.swing.JButton displayAllBtn;
    private javax.swing.JButton displayIDBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaCustomer;
    private javax.swing.JLabel jlblStatus;
    private javax.swing.JButton mainGUIBtn;
    // End of variables declaration//GEN-END:variables
}
