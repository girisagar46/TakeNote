package com.project.TakeNote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by linuxsagar on 5/3/16.
 */
public class NoteFrame extends JFrame {

    private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);


    private MenuBar menuBar = new MenuBar(); // first, create a MenuBar item
    private Menu file = new Menu(); // our File menu
    private MenuItem openFile = new MenuItem();  // an open option
    private MenuItem saveFile = new MenuItem(); // a save option
    private MenuItem deleteFile = new MenuItem(); // a delete option
    private MenuItem exit = new MenuItem(); // and a close option!


    public NoteFrame() throws Exception{
        super("Write a note");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.textArea.setFont(new Font("Arial", Font.PLAIN, 12));

        this.getContentPane().add(textArea);
        this.setMenuBar(menuBar);
        this.menuBar.add(this.file);
        this.file.setLabel("Menu");

        this.openFile.setLabel("Load Text");
        this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_L, false));
        this.file.add(openFile);

        this.saveFile.setLabel("Save note");
        this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
        this.file.add(saveFile);

        this.deleteFile.setLabel("Delete note");
        this.deleteFile.setShortcut(new MenuShortcut(KeyEvent.VK_D, false));
        this.file.add(deleteFile);

        this.exit.setLabel("Exit App");
        this.exit.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.file.add(exit);

        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser open = new JFileChooser();
                int option = open.showOpenDialog(NoteFrame.this);
                if(option == JFileChooser.APPROVE_OPTION){
                    textArea.setText("");
                    try{
                        Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
                        while (scan.hasNext())
                            textArea.append(scan.nextLine()+"\n");
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });

        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBService service = new DBService();
                    Statement statement;
                    Connection myConnection = service.getConnection();
                    statement = myConnection.createStatement();

                    String title = JOptionPane.showInputDialog(NoteFrame.this, "Enter title:", "Title input",
                            JOptionPane.WARNING_MESSAGE);

                    String content = textArea.getText();
                    statement.executeUpdate("insert into note(title,content) values('"+title+"','"+content+"')");
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        deleteFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoteFrame.this.dispose();
            }
        });
    }

    public static void main(String[] args) throws Exception {
        NoteFrame noteFrame = new NoteFrame();
        noteFrame.setVisible(true);
    }

}
