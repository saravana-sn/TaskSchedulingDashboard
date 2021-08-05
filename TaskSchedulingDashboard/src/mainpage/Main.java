/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import AdminView.Attendance1;
import AdminView.ClassCoordinator1;
import AdminView.Delete_Admin;
import AdminView.MajorProject;
import AdminView.MentorAllotment;
import AdminView.MiniProject;
import AdminView.NewAdmin;
import AdminView.NoticeBoard;
import AdminView.RD;
import AdminView.Teams;
import AdminView.TimeTable;
import AdminView.allowpeople;
import PastTask.PAttendance;
import PastTask.PCC;
import PastTask.PMP;
import PastTask.PMentorAllotment;
import PastTask.PMiniProject;
import PastTask.PNoticeBoard;
import PastTask.PRD;
import PastTask.PTimeTable;
import login_register.Login_Form;
import menu.MenuItem;


/**
 *
 * @author Saravana
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    String Username;
    public Main(String username) {
        initComponents();
        
      
        Username=username;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panelBody.removeAll();
               panelBody.revalidate();       
               panelBody.add(new StartPageA());
                panelBody.repaint();
        execute();
    }

    private Main() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void execute(){
        
        ImageIcon iconProject = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/projects.png"));
        ImageIcon iconCompleted = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/completed.png"));
        ImageIcon iconTeams = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/teams.png"));
        ImageIcon iconTT = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/timetable.png"));
        ImageIcon iconRD = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/randd.png"));
        ImageIcon iconMaP = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/majorproject.png"));
        ImageIcon iconMiP = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/miniproject.png"));
        ImageIcon iconAT = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/attendance.png"));
        ImageIcon iconNB = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/noticeboard.png"));
        ImageIcon iconCC = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/classcoordinator.png"));
        ImageIcon iconMA = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/mentorallotment.png"));      
        ImageIcon iconNext = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/next.png"));     
        ImageIcon iconAddUsers = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/AddUsers.png"));
        ImageIcon iconAdminSettings = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/AdminSettings.png"));
        ImageIcon iconSettings = new ImageIcon(Main.this.getClass().getClassLoader().getResource("menu/settings.png"));
        
        //  create submenu of Projects.
        
        MenuItem menuProject1;
        menuProject1 = new MenuItem(iconTT, "Time Table",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                panelBody.add(new TimeTable());
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });  
               
        MenuItem menuProject2 = new MenuItem(iconRD, "R & D", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new RD());
                panelBody.repaint();
                
                
            }
        });  
        MenuItem menuProject3 = new MenuItem(iconMaP, "Major Projects",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new MajorProject());
                panelBody.repaint();
                
                
            }
        });  
         MenuItem menuProject4 = new MenuItem(iconMiP, "Mini Projects", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new MiniProject());
                panelBody.repaint();
                
                
            }
        });  
          MenuItem menuProject5 = new MenuItem(iconAT, "Attendance", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new Attendance1());
                panelBody.repaint();
                
                
            }
        });  
           MenuItem menuProject6 = new MenuItem(iconNB, "Notice Board", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new NoticeBoard());
                panelBody.repaint();
                
                
            }
        });  
            MenuItem menuProject7 = new MenuItem(iconCC, "Class Co-ordinator Lists", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {   
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new ClassCoordinator1());
                panelBody.repaint();
                
                
            }
        });  
             MenuItem menuProject8 = new MenuItem(iconMA, "Mentor Allotment", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new MentorAllotment());
                panelBody.repaint();
                
               
            }
        });  
          
        
        //  create submenu of Completed Projects.

        MenuItem CProject1 = new MenuItem(iconNext, "Time Table",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PTimeTable());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject2 = new MenuItem(iconNext, "R & D",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PRD());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject3 = new MenuItem(iconNext, "Major Projects", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PMP());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject4 = new MenuItem(iconNext, "Minor Projects",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PMiniProject());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject5 = new MenuItem(iconNext, "Attendance", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();              
               panelBody.revalidate();
                panelBody.add(new PAttendance());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject6 = new MenuItem(iconNext, "Notice Board", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PNoticeBoard());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject7 = new MenuItem(iconNext, "Class Co-ordinator Lists", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PCC());
                panelBody.repaint();
                
               
            }
        });  
        MenuItem CProject8 = new MenuItem(iconNext, "Mentor Allotment",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new PMentorAllotment());
                panelBody.repaint();
                
               
            }
        });  
        
        //Create Submenu of Admin Settings
        
         MenuItem ASettings1 = new MenuItem(iconAddUsers, "Allow Requesting Users",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                  allowpeople allow = new allowpeople();
                  allow.setVisible(true);     
                
               
            }
        }); 
         
       
        MenuItem ASettings2 = new MenuItem(iconSettings, "Create New Admin",  new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent ae) {
                 NewAdmin admin= new NewAdmin();
                 admin.setVisible(true);      
            }
        }); 
        
        MenuItem ASettings3 = new MenuItem(iconSettings, "Delete Admin",  new ActionListener() {
            @Override
                    public void actionPerformed(ActionEvent ae) {
                  Delete_Admin delete=new Delete_Admin(Username);
                  delete.setVisible(true);      
            }
        }); 
          
          
          MenuItem ASettings4 = new MenuItem(iconTeams, "Team Members", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                 panelBody.revalidate();
                 panelBody.add(new Teams());
                 panelBody.repaint();
                
               
            }
        });  
        
        
        //Creates array of submenu with their Names 
        
        
        MenuItem menuProject = new MenuItem(iconProject, "Projects", null, menuProject1,menuProject2,menuProject3,menuProject4,menuProject5,menuProject6,menuProject7,menuProject8);
        MenuItem menuCompleted = new MenuItem(iconCompleted, "Previous Competed Tasks", null, CProject1,CProject2,CProject3,CProject4,CProject5,CProject6,CProject7,CProject8);     
        MenuItem menuAdminSettings = new MenuItem(iconAdminSettings, "Admin Settings", null,ASettings1,ASettings2,ASettings3,ASettings4);
        
        //Calls funtion for creating Submenus "addMenu()"
        
        addMenu(menuProject, menuCompleted,menuAdminSettings);
    
}
    
    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem>subMenu = menu[i].getSubMenu();
            for(MenuItem m :subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        lbSfitLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lbBell = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        panelBody = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DASHBOARD - Admin");

        panelHeader.setBackground(new java.awt.Color(0, 128, 191));
        panelHeader.setPreferredSize(new java.awt.Dimension(789, 80));

        lbSfitLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/dashboard.png"))); // NOI18N
        lbSfitLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSfitLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSfitLogoMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        jLabel1.setText("Dashboard");

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/admin1.png"))); // NOI18N
        user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userMouseClicked(evt);
            }
        });

        jButton1.setText("Logout");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbBell.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/bell.png"))); // NOI18N
        lbBell.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBellMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSfitLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 763, Short.MAX_VALUE)
                .addComponent(lbBell, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(user)))
                .addGap(18, 18, 18))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbSfitLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbBell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelHeaderLayout.createSequentialGroup()
                        .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelHeaderLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(panelHeader, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(0, 128, 191));
        panelMenu.setPreferredSize(new java.awt.Dimension(400, 423));

        menus.setBackground(new java.awt.Color(153, 204, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(153, 204, 255));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1207, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbBellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBellMouseClicked
        new Notifications.Notify().setVisible(true);
    }//GEN-LAST:event_lbBellMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        Login_Form login = new Login_Form();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
       new AdminView.Adminprofile(Username).setVisible(true);
    }//GEN-LAST:event_userMouseClicked

    private void lbSfitLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSfitLogoMouseClicked
               panelBody.removeAll();
               panelBody.revalidate();               
               panelBody.add(new StartPageA());
                panelBody.repaint();
    }//GEN-LAST:event_lbSfitLogoMouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBell;
    private javax.swing.JLabel lbSfitLogo;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
   
