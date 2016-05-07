package com.project.TakeNote;

import sun.font.TextLabel;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.xml.transform.Result;
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


    public MainFrame() throws IOException, SQLException {
        super("TakeNote - A note taking desktop app");
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setFont(new Font("Arial", Font.PLAIN, 12));

        showMainLabel();
//        showTitles();
    }

    public void showMainLabel() throws SQLException {
        int noteCount = 0;
        JPanel controls = new JPanel();

        try {
            ResultSet count = statement.executeQuery("SELECT count(id) FROM note");
            count.next();
            noteCount=count.getInt(1);
            controls.setLayout(new GridLayout(noteCount+1,1));
            String lbltext = "Currently you have: ["+noteCount+"] notes";
            JLabel label = new JLabel(lbltext, JLabel.LEFT);
            controls.add(label);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet titles = null;
        try {
            titles = statement.executeQuery("SELECT title FROM note");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setLayout(new java.awt.GridLayout(noteCount, 1));
        while (titles.next()) {
            String titleText = titles.getString(1);
            JButton b = new JButton(titleText);
            controls.add(b);
            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {

                    //TODO: add and event
                    super.mouseClicked(e);
                    if (e.getButton() == 3) { // if right click
                        // b.setText("F");
                        // b.getModel().setPressed(false);
                        // button.setEnabled(true);
                        DefaultContextMenu contextMenu = new DefaultContextMenu();
                        b.add(contextMenu);
                    } else {
                        b.setText("X");
                        b.getModel().setPressed(true);
                        // button.setEnabled(false);
                    }
                }
            });
        }
        add(controls);
    }

    /*public void showTitles() throws SQLException {
        int noteCount = 0;
        ResultSet titles = null;
        try {
            ResultSet count = statement.executeQuery("SELECT count(id) FROM note");
            titles = statement.executeQuery("SELECT title FROM note");
            noteCount = count.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        setLayout(new java.awt.GridLayout(noteCount, 1));
        while (titles.next()){
            String titleText = titles.getString(1);
            JButton b = new JButton(titleText);
            add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String SQL = "SELECT content FROM note WHERE title="+titleText;
                    try {
                        ResultSet titleContent = statement.executeQuery(SQL);
                        titleContent.getString(1)
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            });
        }
        System.out.println("rootPane = " + rootPane);
    }*/
    public static void main(String[] args) throws IOException, SQLException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
