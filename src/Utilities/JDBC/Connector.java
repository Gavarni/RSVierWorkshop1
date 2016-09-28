package Utilities.JDBC;

import java.sql.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gavarni
 */
public class Connector {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");
        
        //Create a statement
        Statement statement = connection.createStatement();
        
        //Execute a statement
        ResultSet resultSet = statement.executeQuery("select * from Account");
        
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1) + "\t" +
                        resultSet.getString(2) + "\t" +
                        resultSet.getString(3) + "\t" +
                        resultSet.getString(4) + "\t" +
                        resultSet.getObject(5).toString());
        }
        
        connection.close();
    }
}
