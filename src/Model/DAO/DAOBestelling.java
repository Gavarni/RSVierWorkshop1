/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Artikel;
import Model.POJO.Bestelling;
import Model.POJO.Klant;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Gavarni
 */
public class DAOBestelling{
    
    private PreparedStatement prepStmnt;
    private Bestelling bestelling;
    private Connection connection;
    
    
    public void create(Bestelling bestelling, Klant klant) throws ClassNotFoundException, SQLException{
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");
        
        String query = "INSERT INTO Bestelling(bestelNummer, bestelDatum, idKlant) VALUES (?, ?, ?)";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setString(1, bestelling.getBestelNummer());
            prepStmnt.setDate(2, new java.sql.Date(bestelling.getBestelDatum().getTime()));// waarom moet dit zo en kan je dit niet gelijk uit het object halen door get besteldatum aan te roepen.
            prepStmnt.setLong(3, klant.getIdKlant());
            
            prepStmnt.executeQuery();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
     
    public void delete(Bestelling bestelling) throws ClassNotFoundException, SQLException{
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");
        
        String query = "DELETE FROM Bestelling WHERE bestelNummer = ?";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setString(1, bestelling.getBestelNummer());
            
            prepStmnt.executeUpdate();
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public Set<Bestelling> readAll() throws ClassNotFoundException, SQLException {
        
        Set<Bestelling> bestellingen = new HashSet<Bestelling>();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");

        String query = "SELECT * FROM Bestelling";
        
        try {
            prepStmnt = connection.prepareStatement(query);
            ResultSet result = prepStmnt.executeQuery(query);
            
            while(result.next()){
                Bestelling bestelling = new Bestelling();
                bestelling.setIdBestelling(result.getLong("idBestelling"));
                bestelling.setBestelNummer(result.getString("bestelNummer"));
                bestelling.setBestelDatum(result.getDate("bestelDatum"));
                bestelling.setIdKlant(result.getInt("idKlant"));
                
                bestellingen.add(bestelling);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bestellingen;
        
    }
    
    public Bestelling readByBestelNummer(Bestelling bestelling) throws ClassNotFoundException, SQLException{
        
        Bestelling gevondenBestelling = new Bestelling();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");

        String query = "SELECT * FROM Bestelling WHERE bestelNummer = ? ";
        
        try {
            
            prepStmnt = connection.prepareCall(query);
            prepStmnt.setString(1, bestelling.getBestelNummer());
            
            ResultSet result = prepStmnt.executeQuery();
            
            while(result.next()){
                bestelling.setIdBestelling(result.getLong("idBestelling"));
                bestelling.setBestelNummer(result.getString("bestelNummer"));
                bestelling.setBestelDatum(result.getDate("bestelDatum"));
                bestelling.setIdKlant(result.getLong("idKlant"));                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gevondenBestelling;
    }
    
    public void update(Bestelling bestelling){
        
        
        
    }
    
    
    

}
    
