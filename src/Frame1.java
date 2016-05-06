import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
public class Frame1 extends javax.swing.JFrame {
    String namdel;
    public Frame1()throws Exception {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notel = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        notebookl = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NewNotebook = new javax.swing.JButton();
        NewNote = new javax.swing.JButton();
        DeleteNotebook = new javax.swing.JButton();
        DeleteNote = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(693, 528));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(254, 254, 254), null));
        jPanel1.setOpaque(false);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Note");

        notel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(notel);

        jTextArea1.setBackground(new java.awt.Color(254, 254, 254));
        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea1);

        notebookl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notebooklMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(notebookl);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Notebook");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Content");

        NewNotebook.setText("New Notebook");
        NewNotebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewNotebookActionPerformed(evt);
            }
        });

        NewNote.setText("New Note");
        NewNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewNoteActionPerformed(evt);
            }
        });

        DeleteNotebook.setText("Delete Notebook");
        DeleteNotebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNotebookActionPerformed(evt);
            }
        });

        DeleteNote.setText("Delete Note");
        DeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(DeleteNotebook, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(NewNotebook, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(DeleteNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(NewNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel3))
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane4)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(NewNote, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addComponent(NewNotebook, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(DeleteNotebook, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                        .addComponent(DeleteNote, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simplynote");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 681, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Siddhartha Verma");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, 681, -1));

        setSize(new java.awt.Dimension(684, 627));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NewNotebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewNotebookActionPerformed
        String nbname=JOptionPane.showInputDialog(null, "Enter the the name of your new"
                + " Notebook(Max 14 Characters)");
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            ResultSet m=stm.executeQuery("select max(id) from notebook;");
            m.next();
            int max=m.getInt(1);
            max++;
            stm.executeUpdate("insert into notebook values("+max+",'"+nbname+"');");
            ResultSet cc=stm.executeQuery("select count(id) from notebook;");
            cc.next();
            int ll=cc.getInt(1);String arr2[]=new String[ll];
            ResultSet rs=stm.executeQuery("select Name from notebook order by id;");
            String nb;int i=0;
            while(rs.next())
            {       nb=rs.getString("Name");
                arr2[i]=nb;i++;
            }
            final String fin[]=arr2;
            notebookl.setModel(new javax.swing.AbstractListModel() {
                public int getSize() { return fin.length; }
                public Object getElementAt(int i) { return fin[i]; }
            });
            rs.close();
            stm.close();
            con.close();
        }catch(Exception e){System.out.print(e);
        };

    }//GEN-LAST:event_NewNotebookActionPerformed

    private void NewNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewNoteActionPerformed
        Frame2 a=new Frame2(namdel);
        namdel=notebookl.getSelectedValue().toString();
        new Frame2(namdel).setVisible(true);
    }//GEN-LAST:event_NewNoteActionPerformed

    private void DeleteNotebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteNotebookActionPerformed
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            ResultSet m=stm.executeQuery("select max(id) from notebook;");
            m.next();int max=m.getInt(1);max++;
            namdel=notebookl.getSelectedValue().toString();
            ResultSet ccc=stm.executeQuery("select id from notebook where"
                    + " Name='"+namdel+"';");
            ccc.next();int s=ccc.getInt(1);
            stm.executeUpdate("delete from noote where id="+s+";");
            stm.executeUpdate("delete from notebook where Name='"+namdel+"';");
            ResultSet cc=stm.executeQuery("select count(id) from notebook;");
            cc.next();int ll=cc.getInt(1);String arr2[]=new String[ll];
            ResultSet rs=stm.executeQuery("select Name from notebook order by id;");
            String nb;int i=0;
            while(rs.next()){
                nb=rs.getString("Name");
                arr2[i]=nb;i++;}
            final String fin[]=arr2;
            notebookl.setModel(new javax.swing.AbstractListModel() {
                public int getSize() { return fin.length; }
                public Object getElementAt(int i) { return fin[i]; }
            });
            rs.close();stm.close();con.close();cc.close();m.close();
        }catch(Exception e){};
        final String fin[]={};
        notel.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return fin.length; }
            public Object getElementAt(int i) { return fin[i]; }
        });
        jTextArea1.setText("");
    }//GEN-LAST:event_DeleteNotebookActionPerformed

    private void DeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteNoteActionPerformed
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            String aaa=notel.getSelectedValue().toString();
            stm.executeUpdate("delete from noote where title='"+aaa+"';");
            namdel=notebookl.getSelectedValue().toString();
            ResultSet cc=stm.executeQuery("select id from notebook "
                    + "where Name='"+namdel+"';");
            cc.next();
            int s=cc.getInt(1);
            String nb;int i=0;
            ResultSet ccc=stm.executeQuery("select count(id) from noote where id="+s+";");
            ccc.next();
            int ll=ccc.getInt(1);
            String arr2[]=new String[ll];
            ResultSet notes=stm.executeQuery("select title from noote where id="+s+";");
            while(notes.next())
            {       nb=notes.getString("title");
                arr2[i]=nb;i++;
            }
            final String fin[]=arr2;
            notel.setModel(new javax.swing.AbstractListModel() {
                public int getSize() { return fin.length; }
                public Object getElementAt(int i) { return fin[i]; }
            });
            cc.close();
            stm.close();
            con.close();
            jTextArea1.setText("");
        }catch(Exception e){};
    }//GEN-LAST:event_DeleteNoteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ListModel dlm = new DefaultListModel();
        dlm=(ListModel)notebookl.getModel();
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            ResultSet m=stm.executeQuery("select count(id) from notebook;");
            m.next();int l=m.getInt(1);String arr[]=new String[l];
            ResultSet rs=stm.executeQuery("select Name from notebook order by id;");
            String nb;int i=0;
            while(rs.next()){
                nb=rs.getString("Name");
                arr[i]=nb;i++;}
            final String fin[]=arr;
            notebookl.setModel(new javax.swing.AbstractListModel() {
                public int getSize() { return fin.length; }
                public Object getElementAt(int i) { return fin[i]; }
            });
            rs.close();stm.close();con.close();m.close();
        }catch(Exception e){System.out.print(e);
        }
        notebookl.setSelectedIndex(0);DefineNoteList();notel.setSelectedIndex(0);
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            namdel=notel.getSelectedValue().toString();
            ResultSet cc=stm.executeQuery("select content from noote where "
                    + "title='"+namdel+"';");
            cc.next();String s=cc.getString(1);jTextArea1.setText(s);
            cc.close();
            stm.close();
            con.close();
        }catch(Exception e){System.out.print("Error="+e);}
    }//GEN-LAST:event_formWindowOpened

    private void notebooklMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notebooklMouseClicked
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            namdel=notebookl.getSelectedValue().toString();
            ResultSet cc=stm.executeQuery("select id from notebook where Name='"+namdel+"';");
            cc.next();
            int s=cc.getInt(1);
            String nb;int i=0;
            ResultSet ccc=stm.executeQuery("select count(id) from noote where id="+s+";");
            ccc.next();
            int ll=ccc.getInt(1);
            String arr2[]=new String[ll];
            ResultSet notes=stm.executeQuery("select title from noote where id="+s+";");
            while(notes.next())
            {       nb=notes.getString("title");
                arr2[i]=nb;i++;
            }
            final String fin[]=arr2;
            notel.setModel(new javax.swing.AbstractListModel() {
                public int getSize() { return fin.length; }
                public Object getElementAt(int i) { return fin[i]; }
            });
            ccc.close();
            cc.close();
            stm.close();
            con.close();
        }catch(Exception e){System.out.print("Error="+e);}

        jTextArea1.setText("");
    }//GEN-LAST:event_notebooklMouseClicked

    private void notelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notelMouseClicked
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            namdel=notel.getSelectedValue().toString();
            ResultSet cc=stm.executeQuery("select content from noote where"
                    + " title='"+namdel+"';");
            cc.next();
            String s=cc.getString(1);
            jTextArea1.setText(s);
            cc.close();
            stm.close();
            con.close();
        }catch(Exception e){System.out.print("Error="+e);}
    }//GEN-LAST:event_notelMouseClicked
    public static void main(String args[])throws Exception {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Frame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run(){
                try {
                    new Frame1().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Frame1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void DefineNoteList()
    {
        try{Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/simplynote","root","iam@Dwit!23AD1");
            Statement stm=con.createStatement();
            namdel=notebookl.getSelectedValue().toString();
            ResultSet cc=stm.executeQuery("select id from notebook where"
                    + " Name='"+namdel+"';");
            cc.next();
            int s=cc.getInt(1);
            String nb;int i=0;
            ResultSet ccc=stm.executeQuery("select count(id) from noote where id="+s+";");
            ccc.next();
            int ll=ccc.getInt(1);
            String arr2[]=new String[ll];
            ResultSet notes=stm.executeQuery("select title from noote where id="+s+";");
            while(notes.next())
            {       nb=notes.getString("title");
                arr2[i]=nb;i++;
            }
            final String fin[]=arr2;
            notel.setModel(new javax.swing.AbstractListModel() {
                public int getSize() { return fin.length; }
                public Object getElementAt(int i) { return fin[i]; }
            });
            cc.close();
            stm.close();
            con.close();
        }catch(Exception e){System.out.println(e);
        };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteNote;
    private javax.swing.JButton DeleteNotebook;
    private javax.swing.JButton NewNote;
    private javax.swing.JButton NewNotebook;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList notebookl;
    private javax.swing.JList notel;
    // End of variables declaration//GEN-END:variables
}
