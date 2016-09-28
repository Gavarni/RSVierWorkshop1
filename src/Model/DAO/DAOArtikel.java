/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Artikel;
import java.sql.*;


/**
 *
 * @author Gavarni
 */
public class DAOArtikel{
    
    private PreparedStatement prepStmnt;
    private Artikel artikel;
    
    public DAOArtikel() throws ClassNotFoundException, SQLException{
    }
    
    /**
     *
     * @param artikel
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void Delete(int artikelNummer) throws ClassNotFoundException, SQLException{
        
         // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");
        
        String query = "DELETE FROM Artikel WHERE artikelNummer = ?";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setInt(1, artikelNummer);
            prepStmnt.executeUpdate();
            //System.out.print("Delete Succesful");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
    //public Create()
    

    
}
