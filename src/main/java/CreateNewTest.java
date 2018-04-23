import com.mongodb.*;

import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author devika
 */
public class CreateNewTest extends javax.swing.JFrame {
    private ArrayList <File> Questions = new ArrayList<>();
    private ArrayList <File>  TestCase = new ArrayList<>();
    private ArrayList <File>  Output = new ArrayList<>();
    private String Uname;
    private Component frame;
    private long TestID;

    /**
     * Creates new form CreateNewTest
     * @param username
     */
    FacultyHomePage prev;
    public CreateNewTest(String username,FacultyHomePage prev) {
        Uname = username;
        TestID = System.nanoTime();
        initComponents();
        this.prev=prev;
    }
    
    // On clicking edit on ViewUpcommingTest page
    public CreateNewTest(String username,long testid) {
        Uname = username;
        TestID = testid;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TestNameField = new javax.swing.JTextField();
        NextButton = new javax.swing.JButton();
        DurationHourField = new javax.swing.JTextField();
        DurationMinField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        SubmitButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        DateField = new javax.swing.JTextField();
        TimeField = new javax.swing.JTextField();
        HomeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Test Name");

        jLabel2.setText("Start Time");

        jLabel3.setText("Duration");

        TestNameField.setText("[Eg : Test123 ]");
        TestNameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TestNameFieldMouseClicked(evt);
            }
        });
        TestNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestNameFieldActionPerformed(evt);
            }
        });

        NextButton.setText("--->");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        DurationHourField.setText("Hours");
        DurationHourField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DurationHourFieldMouseClicked(evt);
            }
        });

        DurationMinField.setText("Minutes");
        DurationMinField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DurationMinFieldMouseClicked(evt);
            }
        });

        jLabel4.setText(":");

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Date");

        DateField.setText("yyyy-mm-dd");
        DateField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateFieldMouseClicked(evt);
            }
        });
        DateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateFieldActionPerformed(evt);
            }
        });

        TimeField.setText("hh:mm:ss");
        TimeField.setToolTipText("24 hour format");
        TimeField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimeFieldMouseClicked(evt);
            }
        });
        TimeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeFieldActionPerformed(evt);
            }
        });

        HomeButton.setText("Home");
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(HomeButton))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DurationHourField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DurationMinField, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addComponent(DateField)
                                    .addComponent(TestNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(TimeField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(SubmitButton)))
                .addGap(74, 74, 74))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(NextButton)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TestNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(DateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DurationHourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DurationMinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextButton)
                    .addComponent(HomeButton))
                .addGap(26, 26, 26)
                .addComponent(SubmitButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void DateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateFieldActionPerformed

    private void TimeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeFieldActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        // TODO add your handling code here:
        //ArrayList<File> ques = new ArrayList<File>();
        String date = DateField.getText();
        String time = TimeField.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startTimet = LocalDateTime.parse(date+" "+time,dtf);
        System.out.println(startTimet);
        LocalDateTime endTimet = startTimet.plusHours(Integer.parseInt(DurationHourField.getText()));
        endTimet = endTimet.plusMinutes(Integer.parseInt(DurationMinField.getText()));
        Timestamp startTime = Timestamp.valueOf(startTimet);
        Timestamp endTime = Timestamp.valueOf(endTimet);
        String TestName = TestNameField.getText();
        try {            
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://elmer.db.elephantsql.com:5432/zmglkugx","zmglkugx","s8hW68DxJLftEUIiBRo5TGYuMKSYQtCt");
            Map data = new HashMap();
            AddTestModule atm = new AddTestModule(conn);
            data.put("TestID",TestID);
            data.put("starttime","'"+startTime+"'");
            data.put("endTime","'"+endTime+"'");
            data.put("TestName","'"+TestName+"'");
            atm.AddToTest(data);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CreateNewTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_NextButtonActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        prev.setVisible(true);
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void TestNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TestNameFieldActionPerformed

    private void DateFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateFieldMouseClicked
        // TODO add your handling code here:
        if(DateField.getText().equals("yyyy-mm-dd"))
            {
                DateField.setText("");
                repaint();
                revalidate();
            }     
    }//GEN-LAST:event_DateFieldMouseClicked

    private void TestNameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TestNameFieldMouseClicked
        // TODO add your handling code here:
        if(TestNameField.getText().equals("[Eg : Test123 ]"))
            {
                TestNameField.setText("");
                repaint();
                revalidate();
            }   
    }//GEN-LAST:event_TestNameFieldMouseClicked

    private void TimeFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeFieldMouseClicked
        // TODO add your handling code here:
        if(TimeField.getText().equals("hh:mm:ss"))
            {
                TimeField.setText("");
                repaint();
                revalidate();
            }  
        
    }//GEN-LAST:event_TimeFieldMouseClicked

    private void DurationHourFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DurationHourFieldMouseClicked
        // TODO add your handling code here:
        if(DurationHourField.getText().equals("Hours"))
            {
                DurationHourField.setText("");
                repaint();
                revalidate();
            }  
    }//GEN-LAST:event_DurationHourFieldMouseClicked

    private void DurationMinFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DurationMinFieldMouseClicked
        // TODO add your handling code here:
        if(DurationMinField.getText().equals("Minutes"))
            {
                DurationMinField.setText("");
                repaint();
                revalidate();
            }  
        
    }//GEN-LAST:event_DurationMinFieldMouseClicked

    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DateField;
    private javax.swing.JTextField DurationHourField;
    private javax.swing.JTextField DurationMinField;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JTextField TestNameField;
    private javax.swing.JTextField TimeField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
