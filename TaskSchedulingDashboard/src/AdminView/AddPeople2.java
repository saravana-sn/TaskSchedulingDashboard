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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DISHA
 */
public class AddPeople2 extends javax.swing.JFrame {
    public static int count;
      int[] arrOfint = new int[500];
    JCheckBox[] cb= new JCheckBox[100];
    
    /**
     * Creates new form AddPeople
     */
    public AddPeople2() {
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
                jLabels= new JLabel(data);
                jLabels.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
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
                .addGap(331, 331, 331)
                .addComponent(jButton1)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*for(int j=1;j<count-1;j++){
            System.out.println(cb[j].isSelected());
        }*/
        /*System.out.println(cb[1]);
        System.out.println(cb[2]);
        /*System.out.println(cb[7]);
        System.out.println(cb[6].isSelected());
        System.out.println(cb[5].isSelected());*/
           // TODO add your handling code here:
        
       
        try {
            String query1="SELECT `Task number` FROM `properties2` WHERE id=3";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            con1.close();
            st1.close();
            rs1.close();
            String query = "INSERT INTO `addpeople`(`id`, `lid`, `Task number`) VALUES ((?),(?),(?))";
            Connection con=null;
            PreparedStatement st=null;
             for(int i=0;i<count;i++) {
                /*int id=Integer.parseInt(arrOfStr[i]);
                int data1=arrOfint[id];
                 */
                if(cb[i+1].isSelected()){
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root",""); 
                    st = con.prepareStatement(query);
                    int data1=arrOfint[i+1];
                    st.setInt(1,2);
                    st.setInt(2,data1);
                    st.setInt(3, number+1);
                    st.executeUpdate();
                    st.close();
                    con.close();
                }
             }
                
            } catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
        } 
        dispose();
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
            java.util.logging.Logger.getLogger(AddPeople2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPeople2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPeople2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPeople2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPeople2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
