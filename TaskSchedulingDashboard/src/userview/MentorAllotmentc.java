/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userview;

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
public class MentorAllotmentc extends javax.swing.JPanel {
    boolean usertask1,usertask2,usertask3;
    public static int TaskNumber;
    /**
     * Creates new form Attendance
     */
    public MentorAllotmentc(String username) {
        initComponents();
        checkdate(22);
        checkdate(23);
        checkdate(24);
        String query="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=22";
        Connection con=null;
        PreparedStatement st=null;
            
        try {
            Connection con1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=22");
            while(rs1.next()){
                String data=rs1.getString(1);
                jComboBox1.addItem(data);
                if(data.equals(username)){
                    usertask1=true;
                }
            }
            con1.close();
            st1.close();
            rs1.close();
            if(usertask1 == true)
            {
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
            else
            {
                jComboBox1.removeAllItems();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        String query1="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=23";    
        try {
            Connection con2=null;
 
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=23");
            while(rs2.next()){
                String data=rs2.getString(1);
                jComboBox2.addItem(data);
                if(data.equals(username)){
                    usertask2=true;
                }
            }
            con2.close();
            st2.close();
            rs2.close();
            if(usertask2 == true)
            {
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
            else
            {
                jComboBox2.removeAllItems();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        String query2="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=24";
        
            
        try {
            Connection con1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=24");
            while(rs1.next()){
                String data=rs1.getString(1);
                jComboBox3.addItem(data);
                if(data.equals(username)){
                    usertask3=true;
                }
            }
            con1.close();
            st1.close();
            rs1.close();
            if(usertask3 == true)
            {
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
            else
            {
                jComboBox3.removeAllItems();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
                } 
    }
    void Progress(int ID,int percentage){
        
            String query = "UPDATE `properties2` SET `Progress`=(?) WHERE id="+ID;
            Connection con=null;
            PreparedStatement st=null;
            
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st = con.prepareStatement(query);
            st.setInt(1,percentage);
            st.executeUpdate();
            st.close();
            con.close();
             } catch (SQLException ex) {
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MentorAllotmentc.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel2 = new javax.swing.JLabel();
        jStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jStatus2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jStatus3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jEndDate = new javax.swing.JLabel();
        jEndDate2 = new javax.swing.JLabel();
        jStartDate3 = new javax.swing.JLabel();
        jStartDate2 = new javax.swing.JLabel();
        jStartDate = new javax.swing.JLabel();
        jEndDate3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        jPanel2.setBackground(new java.awt.Color(0, 128, 191));

        jLabel1.setFont(new java.awt.Font("SimSun", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mentor Allotment");

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

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("Guidline to Mentor");

        jStatus.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jStatus.setText("Deadline");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Report Submission");

        jProgressBar2.setStringPainted(true);

        jStatus2.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jStatus2.setText("Deadline");

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setText("Colllect Student Details");

        jProgressBar3.setStringPainted(true);

        jStatus3.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jStatus3.setText("Deadline");

        jProgressBar1.setStringPainted(true);
        jProgressBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jProgressBar1MouseClicked(evt);
            }
        });

        jButton1.setText("Add Progress");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add Progress");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add Progress");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("       Status");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Progress");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Start Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("End Date");

        jEndDate.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jEndDate.setForeground(new java.awt.Color(204, 0, 51));
        jEndDate.setText("No data");

        jEndDate2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jEndDate2.setForeground(new java.awt.Color(204, 0, 51));
        jEndDate2.setText("No data");

        jStartDate3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jStartDate3.setForeground(new java.awt.Color(0, 102, 51));
        jStartDate3.setText("No data");

        jStartDate2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jStartDate2.setForeground(new java.awt.Color(0, 102, 51));
        jStartDate2.setText("No data");

        jStartDate.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jStartDate.setForeground(new java.awt.Color(0, 102, 51));
        jStartDate.setText("No data");

        jEndDate3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jEndDate3.setForeground(new java.awt.Color(204, 0, 51));
        jEndDate3.setText("No data");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Alloted to");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jStartDate)
                    .addComponent(jLabel10)
                    .addComponent(jStartDate2)
                    .addComponent(jStartDate3))
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEndDate)
                            .addComponent(jEndDate2)
                            .addComponent(jEndDate3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStartDate)
                    .addComponent(jEndDate)
                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStartDate2)
                            .addComponent(jEndDate2)
                            .addComponent(jButton1)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStartDate3)
                            .addComponent(jEndDate3)
                            .addComponent(jButton3)
                            .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86))
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

    private void jProgressBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jProgressBar1MouseClicked

    }//GEN-LAST:event_jProgressBar1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(usertask2==true){
        int percentage=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter the percentage of work done"));
        if(percentage>100 || percentage<0){
            JOptionPane.showMessageDialog(this,"Please Enter value from 0 to 100");
        }
        else{
            jProgressBar2.setValue(percentage);
            jProgressBar2.setStringPainted(true);
            if(percentage!=100)
            {
                jStatus2.setText("In Progress");
            }
            else{
                jStatus2.setText("Completed");
            }
            Progress(23,percentage);
        }
        }
else 
        {
            JOptionPane.showMessageDialog(this,"Ask Admin to assign this task to you.");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(usertask1==true){
        int percentage=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter the percentage of work done"));
        if(percentage>100 || percentage<0){
            JOptionPane.showMessageDialog(this,"Please Enter value from 0 to 100");
        }
        else{
            jProgressBar1.setValue(percentage);
            jProgressBar1.setStringPainted(true);
            if(percentage!=100)
            {
                jStatus.setText("In Progress");
            }
            else{
                jStatus.setText("Completed");
            }
            Progress(22,percentage);

            
        }   
        }  
        else 
        {
            JOptionPane.showMessageDialog(this,"Ask Admin to assign this task to you.");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(usertask3==true){
        int percentage=Integer.parseInt(JOptionPane.showInputDialog(this,"Enter the percentage of work done"));
        if(percentage>100 || percentage<0){
            JOptionPane.showMessageDialog(this,"Please Enter value from 0 to 100");
        }
        else{
            jProgressBar3.setValue(percentage);
            jProgressBar3.setStringPainted(true);
            if(percentage!=100)
            {
                jStatus3.setText("In Progress");
            }
            else{
                jStatus3.setText("Completed");
            }
            Progress(24,percentage);

            
        }    
        }  
        else 
        {
            JOptionPane.showMessageDialog(this,"Ask Admin to assign this task to you.");
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jEndDate;
    private javax.swing.JLabel jEndDate2;
    private javax.swing.JLabel jEndDate3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
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
