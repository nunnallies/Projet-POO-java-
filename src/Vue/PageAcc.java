/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vue;

import projetjava.utils.*;

import java.sql.Connection;
import javax.swing.JFrame;
import static javax.swing.text.html.HTML.Tag.SELECT;
import projetjava.utils.*;
import java.sql.*;

/**
 *
 * @author XPS
 */
public class PageAcc extends javax.swing.JFrame {

    /**
     * Creates new form PageAcc
     */
    public PageAcc() {
        initComponents();
    }

    void fermer() {
        dispose();

    }

    public boolean VerifierExistenceEmploye(String pseudonyme, String mdp) {
        Connection conn;
        JDBConnector jdbc = new JDBConnector();
        conn = jdbc.CreateConnection();
        int a=-1;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT count(*) from employe WHERE login='" + pseudonyme + "' AND motdepasse='" + mdp + "'");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                 a=rs.getInt(WIDTH);
            }

            
        } catch (SQLException e) {
            System.out.println("Error Occured " + e.toString());
        }
        System.out.println("Le nombre d'element répondant aux criteres est de :" + a);
        if (a==0){
            return false; 
        }
        else{
            return true;
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LoginField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        PasswordField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bienvenue à vous !");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(961, 480));
        setPreferredSize(new java.awt.Dimension(961, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("UserName");
        jLabel1.setToolTipText("");
        jLabel1.setName(""); // NOI18N
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 130, 70, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("PassWord");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(564, 210, 60, 20));

        LoginField.setBackground(new java.awt.Color(255, 255, 255));
        LoginField.setForeground(new java.awt.Color(0, 0, 0));
        LoginField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginFieldActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 163, 140, -1));
=======
        getContentPane().add(LoginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 159, 140, -1));
>>>>>>> bac68657ceb40ae59be0eb6ee552f9c08a5e0b8f

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Entrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 90, 40));

        PasswordField.setBackground(new java.awt.Color(255, 255, 255));
        PasswordField.setForeground(new java.awt.Color(0, 0, 0));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 234, 140, -1));
=======
        getContentPane().add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(633, 230, 140, -1));
>>>>>>> bac68657ceb40ae59be0eb6ee552f9c08a5e0b8f

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/ciné.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 240, 400));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/eseeee.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 350));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vue/eseeee.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, -1, -1));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
<<<<<<< HEAD
       
        new AppercuEmplyé().setVisible(true);
        fermer();
=======

        if (VerifierExistenceEmploye(LoginField.getText(),PasswordField.getText())){
        new AppercuEmplyé().setVisible(true);
        fermer();
        }
>>>>>>> bac68657ceb40ae59be0eb6ee552f9c08a5e0b8f
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void LoginFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PageAcc().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField LoginField;
    private javax.swing.JTextField PasswordField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
=======
>>>>>>> bac68657ceb40ae59be0eb6ee552f9c08a5e0b8f
    // End of variables declaration//GEN-END:variables
}
