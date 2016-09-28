/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Bestelling;
import java.sql.*;

/**
 *
 * @author Gavarni
 */
public class DAOBestelling{
    
    private PreparedStatement prepStmnt;
    private Bestelling bestelling;
    
    public void delete(int bestelNummer) throws ClassNotFoundException, SQLException{
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");
        
        String query = "DELETE FROM Bestelling WHERE bestelNummer = ?";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setLong(1, bestelNummer);
            prepStmnt.executeUpdate();
            System.out.print("Delete Succesful");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    
    public void create(){
    }
   
   
}
