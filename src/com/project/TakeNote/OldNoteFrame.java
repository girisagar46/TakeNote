package com.project.TakeNote;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * Created by linuxsagar on 5/8/16.
 */
class OldNoteFrame extends NoteFrame {
    OldNoteFrame(String title) throws Exception {
        super();
        String SQL = "SELECT content FROM note WHERE title='"+title+"'";
        ResultSet data = statement.executeQuery(SQL);
        if (data.next()){
            textArea.setText(data.getString(1));
        }
        setVisible(true);
        saveFile.addActionListener(e -> {
            try {
                DBService service = new DBService();
                Statement statement1;
                Connection myConnection = service.getConnection();
                statement1 = myConnection.createStatement();

                String content = textArea.getText();
                if(Objects.equals(content, "")){
                    JOptionPane.showMessageDialog(OldNoteFrame.this, "Content can't be empty.");
                }else{
                    statement1.executeUpdate("UPDATE note SET content='"+content+"' WHERE title='"+title+"'");
                    OldNoteFrame.this.dispose();
                    new MainFrame().setVisible(true);
                }
            } catch (IOException | SQLException e1) {
                e1.printStackTrace();
            }
        });

    }
}
