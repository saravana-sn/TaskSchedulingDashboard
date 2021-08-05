/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminView;

import static AdminView.Admin.TaskNumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 *
 * @author DISHA
 */
public class Attendance1 extends javax.swing.JPanel {
    java.util.Date date;
    /**
     * Creates new form Attendance
     */
    public Attendance1() {
        initComponents();
         checkdate(7);
        checkdate(8);
        checkdate(9);
        String query="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=7";
        Connection con=null;
        PreparedStatement st=null;
            
        try {
            Connection con1=null;
 
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=7");
            while(rs1.next()){
                String data=rs1.getString(1);
                jComboBox1.addItem(data);
            }
            con1.close();
            st1.close();
            rs1.close();
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st=con.prepareStatement(query);
            ResultSet rs=null;
            rs=st.executeQuery();
            rs.next();
            int progress = rs.getInt("Progress");
            String SDate=rs.getString("StartDate");
            String EDate=rs.getString("EndDate");
            String[] arrOfStr = SDate.split("-",2);
            if(Integer.parseInt(arrOfStr[0])==1970){
               jStartDate.setText("No Data");
                jEndDate.setText("No Data"); 
            }
            else{
                jStartDate.setText(SDate);
                jEndDate.setText(EDate);
                
            }
            jProgressBar1.setValue(progress);
            jProgressBar1.setStringPainted(true);
            if(progress==0)
            {
                jStatus.setText("no data");
            }
            else if(progress==100){
                jStatus.setText("Completed");
            }
            else{
                jStatus.setText("In Progress");
            }
           
            
            con.close();
            st.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        String query1="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=8";    
        try {
            Connection con2=null;
 
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=8");
            while(rs2.next()){
                String data=rs2.getString(1);
                jComboBox2.addItem(data);
            }
            con2.close();
            st2.close();
            rs2.close();
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int progress1 = rs1.getInt("Progress");
            String SDate=rs1.getString("StartDate");
            String EDate=rs1.getString("EndDate");
            String[] arrOfStr = SDate.split("-",2);
            if(Integer.parseInt(arrOfStr[0])==1970){
               jStartDate2.setText("No Data");
                jEndDate2.setText("No Data"); 
            }
            else{
                jStartDate2.setText(SDate);
                jEndDate2.setText(EDate);
                
            }
            jProgressBar2.setValue(progress1);
            jProgressBar2.setStringPainted(true);
            if(progress1==0)
            {
                jStatus2.setText("no data");
            }
            else if(progress1==100){
                jStatus2.setText("Completed");
            }
            else{
                jStatus2.setText("In Progress");
            }
            
            con1.close();
            st1.close();
            rs1.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        String query2="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=9";
        
            
        try {
            Connection con1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=9");
            while(rs1.next()){
                String data=rs1.getString(1);
                jComboBox3.addItem(data);
            }
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            PreparedStatement st2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st2=con2.prepareStatement(query2);
            ResultSet rs2=null;
            rs2=st2.executeQuery();
            rs2.next();
            int progress = rs2.getInt("Progress");
            String SDate1=rs2.getString("StartDate");
            String EDate1=rs2.getString("EndDate");
            
            String[] arrOfStr = SDate1.split("-",2);
            if(Integer.parseInt(arrOfStr[0])==1970){
               jStartDate3.setText("No Data");
                jEndDate3.setText("No Data"); 
            }
            else{
                
                jStartDate3.setText(SDate1);
                jEndDate3.setText(EDate1);
            }
            jProgressBar3.setValue(progress);
            jProgressBar3.setStringPainted(true);
            if(progress==0)
            {
                jStatus3.setText("no data");
            }
            else if(progress==100){
                jStatus3.setText("Completed");
            }
            else{
                jStatus3.setText("In Progress");
            }
            con2.close();
            st2.close();
            rs2.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    void Insert(Date StartD,Date EndD,int ID, int number){
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String query = "UPDATE `properties2` SET `StartDate`=(?),`EndDate`=(?),`Task number`=(?) WHERE id="+ID;
        Connection con=null;
        PreparedStatement st=null;
            
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
                st = con.prepareStatement(query);
                st.setString(1,dateFormat.format(StartD));
                st.setString(2,dateFormat.format(EndD));
                st.setInt(3,number);
                st.executeUpdate();
                st.close();
                con.close();
            } catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    void checkdate(int id){
        try {
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            String query="SELECT EndDate FROM `properties2` WHERE id="+id;
            Connection con2=null;
            PreparedStatement st2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st2=con2.prepareStatement(query);
            ResultSet rs2=null;
            rs2=st2.executeQuery();
            rs2.next();
            Date EDate1=rs2.getDate("EndDate");
            String[] arrOfStr = (EDate1.toString()).split("-",2);
            if(Integer.parseInt(arrOfStr[0])==1970){
               return;
            }
            else if(EDate1.compareTo(date)<0){
                    Properties2(id);
                    AddPeople(id);
                    DeleteAddPeople(id);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void AddPeople(int id){    
        try {
            
            String query1="SELECT `lid`,`Task number` FROM `addpeople` WHERE id="+id;
            Connection con3=null;
            PreparedStatement st3=null;
            con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            st3=con3.prepareStatement(query1);
            ResultSet rs3=null;
            rs3=st3.executeQuery();
            int lid[]=new int[5];
            int i=0;
            while(rs3.next()){
                lid[i] = rs3.getInt("lid");
                TaskNumber=rs3.getInt("Task number");
                i++;
            }
            int j=i;
            rs3.close();
            con3.close();
            st3.close();
            while(i>0){
                String query4 = "INSERT INTO `past addpeople`(`id`, `lid`, `Task_number`) VALUES ((?),(?),(?))";
                Connection con4=null;
                PreparedStatement st4=null;
                con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
                st4 = con4.prepareStatement(query4);
                st4.setInt(1,id);
                st4.setInt(2,lid[j-i]);
                st4.setInt(3,TaskNumber);
                st4.executeUpdate();
                st4.close();
                con4.close();
                i--;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void DeleteAddPeople(int id){
        try {
            Connection con1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            Statement st1=con1.createStatement();
            st1.execute("DELETE FROM `addpeople` WHERE id="+id);
            con1.close();
            st1.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Properties2(int id){
        try {    
            String query1="SELECT `TaskName`, `StartDate`, `EndDate`, `Progress`, `Task number` FROM `properties2` WHERE id="+id;
            Connection con3=null;
            PreparedStatement st3=null;
            con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st3=con3.prepareStatement(query1);
            ResultSet rs3=null;
            rs3=st3.executeQuery();
            rs3.next();
            String Task=rs3.getString("TaskName");
            int progress1 = rs3.getInt("Progress");
            Date SDate=rs3.getDate("StartDate");
            Date EDate=rs3.getDate("EndDate");
            int Task_number=rs3.getInt("Task number");
            rs3.close();
            con3.close();
            st3.close();
            
            String query4 = "INSERT INTO `past task`(`TaskName`, `StartDate`, `EndDate`, `Progress`, `Task number`) VALUES ((?),(?),(?),(?),(?))";
            Connection con4=null;
            PreparedStatement st4=null;
            
            con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            st4 = con4.prepareStatement(query4);
            st4.setString(1,Task);
            st4.setString(2,dateFormat.format(SDate));
            st4.setString(3,dateFormat.format(EDate));
            st4.setInt(4,progress1);
            st4.setInt(5,Task_number);
            st4.executeUpdate();
            st4.close();
            con4.close();
            
            String query = "UPDATE `properties2` SET `StartDate`=(?),`EndDate`=(?),`Progress`=(?) WHERE id="+id;
            Connection con2=null;
            PreparedStatement st2=null;
            con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st2 = con2.prepareStatement(query);
            st2.setString(1,dateFormat.format(0000-00-00));
            st2.setString(2,dateFormat.format(0000-00-00));
            st2.setInt(3,0);
            st2.executeUpdate();
            st2.close();
            con2.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jDelete = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDelete2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jDelete3 = new javax.swing.JButton();
        jStartDate2 = new javax.swing.JLabel();
        jEndDate2 = new javax.swing.JLabel();
        jStartDate3 = new javax.swing.JLabel();
        jEndDate3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jStartDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jEndDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jStatus = new javax.swing.JLabel();
        jStatus2 = new javax.swing.JLabel();
        jStatus3 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(0, 128, 191));

        jLabel1.setFont(new java.awt.Font("SimSun", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Attendance");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N

        jDelete.setText("Delete");
        jDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteActionPerformed(evt);
            }
        });

        jDelete2.setText("Delete");
        jDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDelete2ActionPerformed(evt);
            }
        });

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jDelete3.setText("Delete");
        jDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDelete3ActionPerformed(evt);
            }
        });

        jStartDate2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jStartDate2.setForeground(new java.awt.Color(0, 102, 51));
        jStartDate2.setText("No Data");

        jEndDate2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jEndDate2.setForeground(new java.awt.Color(204, 0, 51));
        jEndDate2.setText("No Data");

        jStartDate3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jStartDate3.setForeground(new java.awt.Color(0, 102, 51));
        jStartDate3.setText("No Data");

        jEndDate3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jEndDate3.setForeground(new java.awt.Color(204, 0, 51));
        jEndDate3.setText("No Data");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Add People");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel3.setText("Arranging Meetings");

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Start Date");

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jStartDate.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jStartDate.setForeground(new java.awt.Color(0, 102, 0));
        jStartDate.setText("No Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("End Date");

        jButton4.setText("+");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Done");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Done");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jDateChooser3.setDateFormatString("yyyy-MM-dd");

        jDateChooser4.setDateFormatString("yyyy-MM-dd");

        jDateChooser5.setDateFormatString("yyyy-MM-dd");

        jDateChooser6.setDateFormatString("yyyy-MM-dd");

        jEndDate.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jEndDate.setForeground(new java.awt.Color(204, 0, 51));
        jEndDate.setText("No Data");

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel7.setText("Monitoring Atttendance");

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel8.setText("Monthly Defaulter List");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Task Name");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Assigned To");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("CONFIRM");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("CANCEL");

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setText("Set Priority");

        jLabel23.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel23.setText("Arranging Meetings");

        jLabel24.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel24.setText("Monitoring Atttendance");

        jLabel25.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel25.setText("Monthly Defaulter List");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));
        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low", "Medium", "High" }));

        jButton7.setText("Done");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Done");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Done");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel22)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setText("Progress and Status");

        jLabel39.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel39.setText("Arranging Meetings");

        jLabel40.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel40.setText("Monitoring Atttendance");

        jLabel41.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel41.setText("Monthly Defaulter List");

        jProgressBar1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jProgressBar1.setOpaque(true);
        jProgressBar1.setStringPainted(true);

        jProgressBar2.setBackground(new java.awt.Color(0, 120, 215));
        jProgressBar2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jProgressBar2.setToolTipText("");
        jProgressBar2.setStringPainted(true);

        jProgressBar3.setBackground(new java.awt.Color(0, 120, 215));
        jProgressBar3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jProgressBar3.setStringPainted(true);

        jStatus.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jStatus.setForeground(new java.awt.Color(51, 51, 51));
        jStatus.setText("No Data");

        jStatus2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jStatus2.setText("No Data");

        jStatus3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jStatus3.setText("No Data");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStatus2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(jStatus3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jStartDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jDateChooser3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jStartDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jStartDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jEndDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jEndDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3)
                                            .addComponent(jButton2))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(39, 39, 39)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6)
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jButton5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jDelete2))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jButton1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jDelete)))))))
                            .addComponent(jDelete3, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jDelete)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jStartDate)
                                            .addComponent(jEndDate))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton2)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton5)
                                            .addComponent(jDelete2)))
                                    .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jStartDate2)
                                    .addComponent(jEndDate2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jDateChooser6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                        .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton3)
                                        .addComponent(jButton6)
                                        .addComponent(jDelete3)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jEndDate3)
                                    .addComponent(jStartDate3)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        jComboBox1.removeAllItems();
        jStartDate.setText("No Data");
        jEndDate.setText("No Data");
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        jStatus.setText("No ");
        Properties2(7);
        AddPeople(7);
        DeleteAddPeople(7);
        JOptionPane.showMessageDialog(this,"Task Deleted Successfully");
    }//GEN-LAST:event_jDeleteActionPerformed

    private void jDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDelete2ActionPerformed
        jComboBox2.removeAllItems();
        jStartDate2.setText("No Data");
        jEndDate2.setText("No Data");
        jProgressBar2.setValue(0);
        jProgressBar2.setStringPainted(true);
        jStatus2.setText("No ");
        Properties2(8);
        AddPeople(8);
        DeleteAddPeople(8);
        JOptionPane.showMessageDialog(this,"Task Deleted Successfully");        // TODO add your handling code here:
    }//GEN-LAST:event_jDelete2ActionPerformed

    private void jDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDelete3ActionPerformed
        jComboBox3.removeAllItems();
        jStartDate3.setText("No Data");
        jEndDate3.setText("No Data");
        jProgressBar3.setValue(0);
        jProgressBar3.setStringPainted(true);
        jStatus3.setText("No ");
        Properties2(9);
        AddPeople(9);
        DeleteAddPeople(9);
        JOptionPane.showMessageDialog(this,"Task Deleted Successfully");        // TODO add your handling code here:
    }//GEN-LAST:event_jDelete3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date  yesterday=new Date(System.currentTimeMillis()-1000*24*60*60);
        Date Sdate=jDateChooser2.getDate();
        Date Edate=jDateChooser5.getDate();
        if(Sdate.compareTo(yesterday)<0){
            JOptionPane.showMessageDialog(this,"Start date cannot be before current date");
            return;
        }
        else if(Edate.compareTo(Sdate) < 0){
            JOptionPane.showMessageDialog(this,"End date cannot be before Start date");
            return;
        }
        else {
            AddPeople8 add=new AddPeople8();
            add.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date  yesterday=new Date(System.currentTimeMillis()-1000*24*60*60);
        Date Sdate=jDateChooser3.getDate();
        Date Edate=jDateChooser6.getDate();
        if(Sdate.compareTo(yesterday)<0){
            JOptionPane.showMessageDialog(this,"Start date cannot be before current date");
            return;
        }
        else if(Edate.compareTo(Sdate) < 0){
            JOptionPane.showMessageDialog(this,"End date cannot be before Start date");
            return;
        }
        else {
            AddPeople9 add=new AddPeople9();
            add.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date  yesterday=new Date(System.currentTimeMillis()-1000*24*60*60);
        Date Sdate=jDateChooser1.getDate();
        Date Edate=jDateChooser4.getDate();
        if(Sdate.compareTo(yesterday)<0){
            JOptionPane.showMessageDialog(this,"Start date cannot be before current date");
            return;
        }
        else if(Edate.compareTo(Sdate) < 0){
            JOptionPane.showMessageDialog(this,"End date cannot be before Start date");
            return;
        }
        else {
            AddPeople7 add=new AddPeople7();
            add.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date StartDate=jDateChooser2.getDate();
        Date EndDate=jDateChooser5.getDate();
        jStartDate2.setText(dateFormat.format(StartDate));
        jEndDate2.setText(dateFormat.format(EndDate));
        try{
            String query1="SELECT `Task number` FROM `properties2` WHERE id=8";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            Insert(StartDate,EndDate,8,number+1);
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");

            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=8");
            while(rs2.next()){
                String data=rs2.getString(1);
                jComboBox2.addItem(data);
            }
            con2.close();
            st2.close();
            rs2.close();
            JOptionPane.showMessageDialog(this,"Task Alloted Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*Insert(StartDate,EndDate,2);*/        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date StartDate=jDateChooser3.getDate();
        Date EndDate=jDateChooser6.getDate();
        jStartDate3.setText(dateFormat.format(StartDate));
        jEndDate3.setText(dateFormat.format(EndDate));
        /*Insert(StartDate,EndDate,3);*/
        try{
            String query1="SELECT `Task number` FROM `properties2` WHERE id=9";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            Insert(StartDate,EndDate,9,number+1);
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");

            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=9");
            while(rs2.next()){
                String data=rs2.getString(1);
                jComboBox3.addItem(data);
            }
            con2.close();
            st2.close();
            rs2.close();
            JOptionPane.showMessageDialog(this,"Task Alloted Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Date StartDate=jDateChooser1.getDate();
            Date EndDate=jDateChooser4.getDate();
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            jStartDate.setText(dateFormat.format(StartDate));
            jEndDate.setText(dateFormat.format(EndDate));

            String query1="SELECT `Task number` FROM `properties2` WHERE id=7";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            Insert(StartDate,EndDate,7,number+1);
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");

            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=7");
            while(rs2.next()){
                String data=rs2.getString(1);
                jComboBox1.addItem(data);
            }
            con2.close();
            st2.close();
            rs2.close();

            JOptionPane.showMessageDialog(this,"Task Alloted Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String query = "UPDATE `properties2` SET `Priority`=(?) WHERE id=7";
        Connection con=null;
        PreparedStatement st=null;

        try {
            int priority;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st = con.prepareStatement(query);
            if(jComboBox7.getSelectedItem().equals("Low")){
                priority=0;
            }
            else if(jComboBox7.getSelectedItem().equals("Medium")){
                priority=1;
            }
            else{
                priority=2;
            }
            st.setInt(1, priority);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
        }                 // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String query = "UPDATE `properties2` SET `Priority`=(?) WHERE id=8";
        Connection con=null;
        PreparedStatement st=null;

        try {
            int priority;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st = con.prepareStatement(query);
            if(jComboBox8.getSelectedItem().equals("Low")){
                priority=0;
            }
            else if(jComboBox8.getSelectedItem().equals("Medium")){
                priority=1;
            }
            else{
                priority=2;
            }
            st.setInt(1, priority);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String query = "UPDATE `properties2` SET `Priority`=(?) WHERE id=9";
        Connection con=null;
        PreparedStatement st=null;

        try {
            int priority;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st = con.prepareStatement(query);
            if(jComboBox9.getSelectedItem().equals("Low")){
                priority=0;
            }
            else if(jComboBox9.getSelectedItem().equals("Medium")){
                priority=1;
            }
            else{
                priority=2;
            }
            st.setInt(1, priority);
            st.executeUpdate();
            st.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private com.toedter.calendar.JDateChooser jDateChooser5;
    private com.toedter.calendar.JDateChooser jDateChooser6;
    private javax.swing.JButton jDelete;
    private javax.swing.JButton jDelete2;
    private javax.swing.JButton jDelete3;
    private javax.swing.JLabel jEndDate;
    private javax.swing.JLabel jEndDate2;
    private javax.swing.JLabel jEndDate3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JLabel jStartDate;
    private javax.swing.JLabel jStartDate2;
    private javax.swing.JLabel jStartDate3;
    private javax.swing.JLabel jStatus;
    private javax.swing.JLabel jStatus2;
    private javax.swing.JLabel jStatus3;
    // End of variables declaration//GEN-END:variables
}
