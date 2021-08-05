/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DISHA
 */
public class NewAdmin extends javax.swing.JFrame {
    int[] arrOfint = new int[500];
    JCheckBox[] cb= new JCheckBox[100];
    public static int count;
    /**
     * Creates new form NewAdmin
     */
    public NewAdmin() {
        initComponents();
        JPanel jpan;
        jpan = new JPanel();
        jpan.setBounds(0,0,758,326);
        jpan.setOpaque(true);
        
        add(jpan);
        String query="SELECT COUNT(1) as NumberOfRows FROM `users`";
        Connection con=null;
        PreparedStatement st=null;
        try {
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st=con.prepareStatement(query);
            ResultSet rs=null;
            rs=st.executeQuery();
            rs.next();
            count=rs.getInt("NumberOfRows");
            con.close();
            st.close();
            rs.close();
            JLabel jLabels= new JLabel();
            jpan.removeAll();
            String query1="SELECT id,username FROM `users`";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            int j=1;
            while(rs1.next()){
                arrOfint[j]=rs1.getInt("id");
                String data=rs1.getString("username");
                jLabels= new JLabel(data+"  ");
                cb[j]= new JCheckBox();
                /*cb[j].setBounds(150,150,50,50);
                JScrollPane jcrlp = new JScrollPane(cb);
                cb[j].setPreferredSize(new Dimension(758,326));*/
                jpan.add(cb[j]);
                jpan.add(jLabels);
                j++;
            }
            jpan.validate();
            jpan.repaint();
            
            con1.close();
            st1.close();
            rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jButton1)
                .addContainerGap(404, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con=null;
        PreparedStatement st=null;
                
        for(int i=0;i<count;i++)  {
            try {
                if(cb[i+1].isSelected()){
                int data1=arrOfint[i+1];
                String query = "INSERT INTO admin(`full_name`, `username`, `password`, `phone`, `emailid`, `gender`) SELECT `full_name`, `username`, `password`, `phone`, `emailid`, `gender` FROM `users` WHERE users.id="+data1;
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
                st = con.prepareStatement(query);
                st.executeUpdate();
                st.close();
                con.close();
                
                Connection con1=null;
                con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
                Statement st1=con1.createStatement();
                st1.execute("DELETE FROM `users` WHERE id="+data1);
                con1.close();
                st1.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(allowpeople.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
