/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Bestelling;
import Model.POJO.Klant;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gavarni
 */
public class DAOBestelling{
    
    private PreparedStatement prepStmnt;
    private Bestelling bestelling;
    
    
    public void create(Bestelling bestelling, Klant klant) throws ClassNotFoundException, SQLException{
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");
        
        String query = "INSERT INTO Bestelling(bestelNummer, bestelDatum, idKlant) VALUES (?, ?, ?)";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            prepStmnt.setString(1, bestelling.getBestelNummer());
            prepStmnt.setDate(2, new java.sql.Date(bestelling.getBestelDatum().getTime()));// waarom moet dit zo en kan je dit niet gelijk uit het object halen door get besteldatum aan te roepen.
            prepStmnt.setInt(3, (int)klant.getIdKlant());
            prepStmnt.executeQuery();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
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
            
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public List<Bestelling> readAll() throws ClassNotFoundException, SQLException{
        List<Bestelling> bestellingen = new ArrayList<Bestelling>();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");

        String query = "SELECT * FROM Bestelling";
        
        try {
            Statement stmnt = connection.createStatement();
            ResultSet result = stmnt.executeQuery(query);
            
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
    
    public Bestelling readByBestelNummer(Bestelling bestelling, Klant klant) throws ClassNotFoundException, SQLException{
        
        Bestelling gevondenBestelling = new Bestelling();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
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
                klant.setIdKlant(result.getLong("idKlant"));                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gevondenBestelling;
        
    }
    
    public void updateBestelling(Bestelling bestelling){
        
        
        
    }
    
    
    

}
    
