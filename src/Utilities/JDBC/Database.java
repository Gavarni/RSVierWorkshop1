/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gavarni
 */
public class Database {
    
    private final static Database dbInstance = new Database();
    
    private Database() {
        
        // Load the JDBC MySQL Driver
        try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        //Connect to MySQL Database
        try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Database getDBOInstance(){
        return dbInstance;
    }
    
}
