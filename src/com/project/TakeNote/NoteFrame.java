package com.project.TakeNote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by linuxsagar on 5/3/16.
 */

class NoteFrame extends JFrame {

    protected TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);

    private DBService dbService = new DBService();
    private Connection connection = dbService.getConnection();
    Statement statement = connection.createStatement();

    protected MenuBar menuBar = new MenuBar(); // first, create a MenuBar item
    protected Menu file = new Menu(); // our File menu
    protected MenuItem openFile = new MenuItem();  // an open option
    protected MenuItem saveFile = new MenuItem(); // a save option
    protected MenuItem deleteFile = new MenuItem(); // a delete option
    protected MenuItem exit = new MenuItem(); // and a close option!
    protected MenuItem cancel = new MenuItem(); // and a close option!


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

        this.cancel.setLabel("Cancel operation");
        this.cancel.setShortcut(new MenuShortcut(KeyEvent.VK_ESCAPE, false));
        this.file.add(cancel);

        this.exit.setLabel("Exit App");
        this.exit.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
        this.file.add(exit);

        openFile.addActionListener(e -> {
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
        });

        saveFile.addActionListener(e -> {
            try {
                DBService service = new DBService();
                Statement statement1;
                Connection myConnection = service.getConnection();
                statement1 = myConnection.createStatement();

                String title1 = JOptionPane.showInputDialog(NoteFrame.this, "Enter title:", "Title input",
                        JOptionPane.WARNING_MESSAGE);

                String content = textArea.getText();
                if(Objects.equals(content, "") || Objects.equals(title1, "")){
                    JOptionPane.showMessageDialog(NoteFrame.this, "Content OR Title can't be empty.");
                }else{
                    statement1.executeUpdate("INSERT INTO note(title,content) VALUES('"+ title1 +"','"+content+"')");
                    NoteFrame.this.setVisible(false);
                    new MainFrame().setVisible(true);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        });

        deleteFile.addActionListener(e -> {

        });

        cancel.addActionListener(e->{
            try {
                NoteFrame.this.setVisible(false);
                new MainFrame().setVisible(true);
            } catch (IOException | SQLException e1) {
                e1.printStackTrace();
            }
        });
        exit.addActionListener(e -> System.exit(0));
    }

    public NoteFrame(String title) throws Exception{
        super();
    }
}
