/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PastTask;

import static java.awt.Color.WHITE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Saravana
 */
public class PTimeTable extends javax.swing.JPanel {

    /**
     * Creates new form PTimeTable
     */
    public PTimeTable() {
       initComponents();
         JPanel jpan;
        jpan = new JPanel();
        jpan.setBounds(0,0,1000,800);
        jpan.setBackground(WHITE);
        jpan.setOpaque(true);
        add(jpan);
        JLabel jLabels= new JLabel();
        try{
            Connection con1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT `TaskName`,`StartDate`, `EndDate`, `Progress`, `Task number` FROM `past task` WHERE `Task number` LIKE \"4%\"");
            int j=1;
            while(rs1.next()){
                String TaskName=rs1.getString(1);
                String Sdate=rs1.getString(2);
                String Edate=rs1.getString(3);
                int progress=rs1.getInt(4);
                int Task_Number=rs1.getInt(5);
                jLabels= new JLabel(j+")  "+TaskName+" : Start Date =  "+Sdate+",  End Date =  "+Edate+", Progress = "+progress+"  ,and alloted to  ");
                jLabels.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                jpan.add(jLabels);
                JComboBox jComboBox = new JComboBox();
                Connection con2=null;
                con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
                Statement st2=con2.createStatement();
                ResultSet rs2=null;
                rs2=st2.executeQuery("SELECT users.username FROM users JOIN `past addpeople` ON users.id=`past addpeople`.lid WHERE `past addpeople`.`Task_number`="+Task_Number);
                while(rs2.next()){
                    String user=rs2.getString(1);
                    jComboBox.addItem(user);
                }
                jpan.add(jComboBox);
                con2.close();
                st2.close();
                rs2.close();
                j++;
            }
            con1.close();
            st1.close();
            rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(PTimeTable.class.getName()).log(Level.SEVERE, null, ex);
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

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(PCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PTimeTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
