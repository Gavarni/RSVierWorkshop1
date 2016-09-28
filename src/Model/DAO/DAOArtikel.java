/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Artikel;
import Utilities.JDBC.Database;
import java.sql.*;


/**
 *
 * @author Gavarni
 */ 
    
public class DAOArtikel{
    
    private PreparedStatement prepStmnt;
    private Artikel artikel;
    private Connection connection;
    
    public DAOArtikel() throws ClassNotFoundException, SQLException{
    }
    
    public void create(Artikel artikel) throws ClassNotFoundException, SQLException{
        
        Database.getDBOInstance();
        
        String query = "INSERT INTO Artikel(artikelNummer, naam, omschrijving, prijs, voorraad) VALUES(?, ?, ?, ?, ?)";
        
        try {
            prepStmnt = connection.prepareStatement(query);
            prepStmnt.setLong(1, artikel.getArtikelNummer());
            prepStmnt.setString(2, artikel.getNaam());
            prepStmnt.setString(3, artikel.getOmschrijving());
            prepStmnt.setDouble(4, artikel.getPrijs());
            prepStmnt.setInt(5, artikel.getVoorraad());
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void delete(Artikel artikel) throws ClassNotFoundException, SQLException{
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");
        
        String query = "DELETE FROM Artikel WHERE artikelNummer = ?";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setInt(1, artikel.getArtikelNummer());
            prepStmnt.executeUpdate();
            //System.out.print("Delete Succesful");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }

}
