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
public class Admin extends javax.swing.JFrame {
    java.util.Date date;
    public static int TaskNumber;

    /**
     * Creates new form New1
     */
    public Admin() {
        initComponents();
        checkdate(1);
        checkdate(2);
        checkdate(3);
        String query="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=1";
        Connection con=null;
        PreparedStatement st=null;
            
        try {
            Connection con1=null;
 
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=1");
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
            Logger.getLogger(Attendance1.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        String query1="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=2";    
        try {
            Connection con2=null;
 
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=2");
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
        
        String query2="SELECT Progress,StartDate,EndDate FROM `properties2` WHERE id=3";
        
            
        try {
            Connection con1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            Statement st1=con1.createStatement();
            ResultSet rs1=null;
            rs1=st1.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=3");
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
                String query4 = "INSERT INTO `past addpeople`(`id`, `lid`, `Task number`) VALUES ((?),(?),(?))";
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jStartDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jEndDate = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jStatus = new javax.swing.JLabel();
        jProgressBar2 = new javax.swing.JProgressBar();
        jStartDate2 = new javax.swing.JLabel();
        jEndDate2 = new javax.swing.JLabel();
        jStatus2 = new javax.swing.JLabel();
        jStartDate3 = new javax.swing.JLabel();
        jEndDate3 = new javax.swing.JLabel();
        jStatus3 = new javax.swing.JLabel();
        jProgressBar3 = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jDateChooser5 = new com.toedter.calendar.JDateChooser();
        jDateChooser6 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jDelete = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jDelete2 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jDelete3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Display T.T");

        jLabel2.setText("Start Date");

        jStartDate.setText("No data");

        jLabel4.setText("End Date");

        jEndDate.setText("No data");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jDateChooser2.setDateFormatString("yyyy-MM-dd");

        jLabel6.setText("Progress");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Logout");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Status");

        jStatus.setText("No Data");

        jStartDate2.setText("No Data");

        jEndDate2.setText("No Data");

        jStatus2.setText("No Data");

        jStartDate3.setText("No Data");

        jEndDate3.setText("No Data");

        jStatus3.setText("No Data");

        jLabel5.setText("Add People");

        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        jLabel7.setText("IAT T.T");

        jLabel8.setText("IAT PORTION");

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

        jDelete3.setText("Delete");
        jDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDelete3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(94, 94, 94)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jEndDate)
                                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jStartDate2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jEndDate2)
                                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jStartDate3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jEndDate3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDateChooser6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jStatus3)
                                .addGap(332, 332, 332))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jStatus2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jDelete2))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jDelete3))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(22, 22, 22)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jDelete)))))
                                .addGap(64, 64, 64)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jStatus)
                                        .addComponent(jButton4)
                                        .addComponent(jButton1)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jDelete))
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jStatus2)
                                                .addComponent(jButton2)
                                                .addComponent(jButton5)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jDelete2)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jEndDate2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jStartDate))
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jStartDate2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStatus3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jEndDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton6)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDelete3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jStartDate3)
                    .addComponent(jEndDate3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Date StartDate=jDateChooser1.getDate();
            Date EndDate=jDateChooser4.getDate();
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            jStartDate.setText(dateFormat.format(StartDate));
            jEndDate.setText(dateFormat.format(EndDate));
            
            String query1="SELECT `Task number` FROM `properties2` WHERE id=1";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            Insert(StartDate,EndDate,1,number+1);
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=1");
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

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        dispose();   // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            AddPeople add=new AddPeople();
            add.setVisible(true);
        }
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            AddPeople add=new AddPeople();
            add.setVisible(true);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date StartDate=jDateChooser2.getDate();  
        Date EndDate=jDateChooser5.getDate();
        jStartDate2.setText(dateFormat.format(StartDate));
        jEndDate2.setText(dateFormat.format(EndDate));
        try{
            String query1="SELECT `Task number` FROM `properties2` WHERE id=2";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            Insert(StartDate,EndDate,2,number+1);
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id==2");
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
            String query1="SELECT `Task number` FROM `properties2` WHERE id=3";
            Connection con1=null;
            PreparedStatement st1=null;
            con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
            st1=con1.prepareStatement(query1);
            ResultSet rs1=null;
            rs1=st1.executeQuery();
            rs1.next();
            int number = rs1.getInt("Task number");
            Insert(StartDate,EndDate,3,number+1);
            con1.close();
            st1.close();
            rs1.close();
            Connection con2=null;
            con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/users_db","root","");
        
            Statement st2=con2.createStatement();
            ResultSet rs2=null;
            rs2=st2.executeQuery("SELECT users.username FROM users JOIN addpeople ON users.id=addpeople.lid WHERE addpeople.id=3");
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

    private void jDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteActionPerformed
        jComboBox1.removeAllItems();
        jStartDate.setText("No Data");
        jEndDate.setText("No Data");
        jProgressBar1.setValue(0);
        jProgressBar1.setStringPainted(true);
        jStatus.setText("No ");
        Properties2(1);
        AddPeople(1);
        DeleteAddPeople(1);
        JOptionPane.showMessageDialog(this,"Task Deleted Successfully");
    }//GEN-LAST:event_jDeleteActionPerformed

    private void jDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDelete2ActionPerformed
         jComboBox2.removeAllItems();
        jStartDate2.setText("No Data");
        jEndDate2.setText("No Data");
        jProgressBar2.setValue(0);
        jProgressBar2.setStringPainted(true);
        jStatus2.setText("No ");
        Properties2(2);
        AddPeople(2);
        DeleteAddPeople(2);
        JOptionPane.showMessageDialog(this,"Task Deleted Successfully");        // TODO add your handling code here:
    }//GEN-LAST:event_jDelete2ActionPerformed

    private void jDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDelete3ActionPerformed
        jComboBox3.removeAllItems();
        jStartDate3.setText("No Data");
        jEndDate3.setText("No Data");
        jProgressBar3.setValue(0);
        jProgressBar3.setStringPainted(true);
        jStatus3.setText("No ");
        Properties2(3);
        AddPeople(3);
        DeleteAddPeople(3);
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
            AddPeople add=new AddPeople();
            add.setVisible(true);
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JLabel jStartDate;
    private javax.swing.JLabel jStartDate2;
    private javax.swing.JLabel jStartDate3;
    private javax.swing.JLabel jStatus;
    private javax.swing.JLabel jStatus2;
    private javax.swing.JLabel jStatus3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
