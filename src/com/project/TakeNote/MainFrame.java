package com.project.TakeNote;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by linuxsagar on 5/7/16.
 */
public class MainFrame extends JFrame {

    private DBService dbService = new DBService();
    private Connection mainConnection =dbService.getConnection();
    private Statement statement = mainConnection.createStatement();

    private JPanel controls = new JPanel();

    MainFrame() throws IOException, SQLException {
        super("TakeNote - A note taking desktop app");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFont(new Font("Arial", Font.PLAIN, 12));

        MenuBar menuBar = new MenuBar();
        this.setMenuBar(menuBar);
        Menu file = new Menu();
        menuBar.add(file);
        file.setLabel("Menu");

        MenuItem newNote = new MenuItem();
        newNote.setLabel("New Note");
        newNote.setShortcut(new MenuShortcut(KeyEvent.VK_N, false));
        file.add(newNote);

        newNote.addActionListener(e -> {
            try {
                MainFrame.this.setVisible(false);
                new NoteFrame().setVisible(true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        showMainLabel();
        JScrollPane jScrollPane = new JScrollPane(controls);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        getContentPane().add(jScrollPane);
    }

    private void showMainLabel() throws SQLException {
        int noteCount = 0;
        try {
            ResultSet count = statement.executeQuery("SELECT count(id) FROM note");
            count.next();
            noteCount=count.getInt(1);
            controls.setLayout(new GridLayout(noteCount+1,1));
            String lbltext = "Currently you have: ["+noteCount+"] notes";
            JLabel label = new JLabel(lbltext, JLabel.CENTER);
            controls.add(label);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet titles = null;
        try {
            titles = statement.executeQuery("SELECT title FROM note ORDER BY id DESC");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert titles != null;
        while (titles.next()) {
            String titleText = titles.getString(1);
            JButton b = new JButton(titleText);
            controls.add(b);

            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (e.getButton() == 3) { // if right click
                        JPopupMenu delMenu = new JPopupMenu();
                        JMenuItem menuItem = new JMenuItem("Delete Note");
                        delMenu.setLocation(e.getX(), e.getY());
                        delMenu.add(menuItem);
                        delMenu.setVisible(true);

                        menuItem.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                super.mouseClicked(e);
                                if (e.getButton() == 1){
                                    String del = "DELETE FROM note WHERE title='"+titleText+"'";
                                    try {
                                        statement.execute(del);
                                        delMenu.setVisible(false);
                                    } catch (SQLException e1) {
                                        e1.printStackTrace();
                                    }
                                }
                            }
                        });
                    }else {
                        try {
                            new OldNoteFrame(titleText);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
        }
        add(controls);
    }

    public static void main(String[] args) throws IOException, SQLException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
