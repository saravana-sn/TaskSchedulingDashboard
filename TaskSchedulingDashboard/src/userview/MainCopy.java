/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userview;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import login_register.Login_Form;
import menu.MenuItem;


/**
 *
 * @author Saravana
 */
public class MainCopy extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    String Username;
    
    public MainCopy(String username) {
        initComponents();
        Username =username;
               panelBody.removeAll();
               panelBody.revalidate();       
               panelBody.add(new StartPageU(Username));
                panelBody.repaint();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute(Username);
    }

    private MainCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void execute(String username){
        
        ImageIcon iconProject = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/projects.png"));
        ImageIcon iconCompleted = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/completed.png"));
        ImageIcon iconAlgo = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/algo.png"));
        ImageIcon iconTT = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/timetable.png"));
        ImageIcon iconRD = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/randd.png"));
        ImageIcon iconMaP = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/majorproject.png"));
        ImageIcon iconMiP = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/miniproject.png"));
        ImageIcon iconAT = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/attendance.png"));
        ImageIcon iconNB = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/noticeboard.png"));
        ImageIcon iconCC = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/classcoordinator.png"));
        ImageIcon iconMA = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/mentorallotment.png"));      
        ImageIcon iconNext = new ImageIcon(MainCopy.this.getClass().getClassLoader().getResource("menu/next.png"));     
        //  create submenu of Projects.
        
        
        MenuItem menuProject1;
        
        menuProject1 = new MenuItem(iconTT, "Time Table",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                panelBody.add(new TimeTablec(username));
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });  
               
        MenuItem menuProject2 = new MenuItem(iconRD, "R & D", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new RDc(username));
                panelBody.repaint();
                
                
            }
        });  
        MenuItem menuProject3 = new MenuItem(iconMaP, "Major Projects",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new MajorProjectc(username));
                panelBody.repaint();
                
                
            }
        });  
         MenuItem menuProject4 = new MenuItem(iconMiP, "Mini Projects", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();

               panelBody.add(new MinirProjectc(username));
                panelBody.repaint();
                
                
            }
        });  
          MenuItem menuProject5 = new MenuItem(iconAT, "Attendance", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new Attendence1c(username));
                panelBody.repaint();
                
                
            }
        });  
           MenuItem menuProject6 = new MenuItem(iconNB, "Notice Board", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new NoticeBoardc(username));
                panelBody.repaint();
                
                
            }
        });  
            MenuItem menuProject7 = new MenuItem(iconCC, "Class Co-ordinator Lists", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {   
                 panelBody.removeAll();
               panelBody.revalidate();
                panelBody.add(new ClassCoordinatorc(username));
                panelBody.repaint();
                
                
            }
        });  
             MenuItem menuProject8 = new MenuItem(iconMA, "Mentor Allotment", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 panelBody.removeAll();
                
               panelBody.revalidate();
                panelBody.add(new MentorAllotmentc(username));
                panelBody.repaint();
                
               
            }
        });  
          
        
        //  create submenu of Completed Projects.
/*
        MenuItem CProject1 = new MenuItem(iconNext, "Time Table",null);
        MenuItem CProject2 = new MenuItem(iconNext, "R & D", null);
        MenuItem CProject3 = new MenuItem(iconNext, "Major Projects", null);
        MenuItem CProject4 = new MenuItem(iconNext, "Minor Projects", null);
        MenuItem CProject5 = new MenuItem(iconNext, "Attendance", null);
        MenuItem CProject6 = new MenuItem(iconNext, "Notice Board", null);
        MenuItem CProject7 = new MenuItem(iconNext, "Class Co-ordinator Lists", null);
        MenuItem CProject8 = new MenuItem(iconNext, "Mentor Allotment", null);

        
        */
        

        MenuItem menuProject = new MenuItem(iconProject, "Projects", null, menuProject1,menuProject2,menuProject3,menuProject4,menuProject5,menuProject6,menuProject7,menuProject8);
       /* MenuItem menuCompleted = new MenuItem(iconCompleted, "Previous Competed Tasks", null, CProject1,CProject2,CProject3,CProject4,CProject5,CProject6,CProject7,CProject8);*/
        MenuItem menuSuggest = new MenuItem(iconAlgo, "Best Preference ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelBody.removeAll();
                panelBody.add(new Preference(username));
                panelBody.repaint();
                panelBody.revalidate();
                
            }
        });
        addMenu(menuProject, menuSuggest);
    
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
        setTitle("DASHBOARD - User");

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
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Dashboard");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu/user.jpg"))); // NOI18N
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
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
                .addComponent(lbBell, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                        .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHeaderLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18))))
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
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        getContentPane().add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelBody.setBackground(new java.awt.Color(153, 204, 255));
        panelBody.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelBody, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(803, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbBellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBellMouseClicked
        new Notifications.Notify().setVisible(true);
    }//GEN-LAST:event_lbBellMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login_Form login = new Login_Form();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userMouseClicked
    new userview.userprofile1(Username).setVisible(true);
    }//GEN-LAST:event_userMouseClicked

    private void lbSfitLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSfitLogoMouseClicked
              panelBody.removeAll();
               panelBody.revalidate();  
              
               panelBody.add(new StartPageU(Username));
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
            java.util.logging.Logger.getLogger(MainCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainCopy().setVisible(true);
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
