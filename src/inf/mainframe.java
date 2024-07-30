/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package inf;


import codes.DBconect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class mainframe extends javax.swing.JFrame {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    
    public mainframe() {
        initComponents();
        conn = DBconect.connect();
        tableload();
    }
    
    public void tableload(){
    
        try{
            String sql = "SELECT id AS ID,sname AS NAME,sage AS AGE,sgrade AS GRADE FROM student";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    
       
    }
    
    public void tabledata(){
        
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r, 0).toString();
        String name = table1.getValueAt(r, 1).toString();
        String age = table1.getValueAt(r, 2).toString();
        String grade = table1.getValueAt(r, 3).toString();
        
        idbox.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
        
                
    }
    
    public void search(){
        
        String srch =searchbox.getText();
        try{
            String sql ="SELECT * FROM student WHERE sname LIKE '%"+srch+"%'OR id LIKE'%"+srch+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    public void update(){
        
        String id = idbox.getText();
        String name = namebox.getText();
        String age = agebox.getText();
        String grade = gradebox.getSelectedItem().toString();
        
        try{
            String sql ="UPDATE student SET sname = '"+name+"',sage = '"+age+"',sgrade = '"+grade+"' WHERE id = '"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "UPDATED");
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
            
        }
    }
    
    public void clear(){
        
        searchbox.setText("");
        idbox.setText("id");
        namebox.setText("");
        agebox.setText("");
        gradebox.setSelectedItem(0);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox<>();
        namebox1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        insertbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));

        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 270, 60));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel1.setText("Name");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        namebox.setToolTipText("Enter your name");
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 130, -1));

        agebox.setToolTipText("Enter your age");
        agebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageboxActionPerformed(evt);
            }
        });
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 130, -1));

        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        gradebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeboxActionPerformed(evt);
            }
        });
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 80, -1));

        namebox1.setToolTipText("Enter your name");
        jPanel4.add(namebox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 130, -1));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        jLabel4.setText("ID");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel4.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 130, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, 260));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        insertbtn.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        insertbtn.setText("Insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });

        updatebtn.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });

        deletebtn.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });

        clearbtn.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        clearbtn.setText("Clear");

        exitbtn.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
        exitbtn.setText("Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deletebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updatebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clearbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(exitbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertbtn)
                    .addComponent(updatebtn))
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearbtn)
                    .addComponent(deletebtn))
                .addGap(18, 18, 18)
                .addComponent(exitbtn)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 270, 140));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 510));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 255));

        table1.setAutoCreateRowSorter(true);
        table1.setBackground(new java.awt.Color(204, 204, 255));
        table1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 420, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 510));

        setBounds(0, 0, 755, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void ageboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageboxActionPerformed

    private void gradeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeboxActionPerformed

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        update();
        tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
       int check =JOptionPane.showConfirmDialog(null, "Do you want to delete!");
       
       if(check==0){
           
           String id =idbox.getText();
           try{
            String sql = "DELETE FROM student WHERE id='"+id+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "DELETED!");           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            
        }    
       }
       tableload();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        String name;
        int age;
        int grade;
        int id ; 
        
        id = Integer.parseInt(idbox.getText());
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        grade = Integer.parseInt(gradebox.getSelectedItem().toString());
        
        
        try{
            String sql="INSERT INTO student (id,sname,sage,sgrade) VALUES ('"+id+"','"+name+"','"+age+"','"+grade+"')";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Inserted");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
            
        }
        tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

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
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JTextField idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField namebox1;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
