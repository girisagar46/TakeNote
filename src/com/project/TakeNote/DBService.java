package com.project.TakeNote;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by linuxsagar on 5/7/16.
 */
public class DBService {
    private Connection myConn;
    public DBService() throws IOException, SQLException {
        Properties dbProperties = new Properties();
        dbProperties.load(new FileInputStream("db.properties"));

        String username = dbProperties.getProperty("username");
        String password = dbProperties.getProperty("password");
        String dbUrl = dbProperties.getProperty("dbUrl");

        myConn = DriverManager.getConnection(dbUrl,username,password);
    }

    public Connection getConnection(){
        System.out.println("myConn = " + myConn);
        System.out.println("Connected");
        return myConn;
    }
}
