/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Artikel;
import Model.POJO.Bestelling;
import Model.POJO.BestellingArtikel;
import Model.POJO.Klant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gavarni
 */
public class DAOBestellingArtikel {
    
    private PreparedStatement prepStmnt;
    private Bestelling bestelling;
    private Artikel artikel;
    private Connection connection;
    
      
    public void create(BestellingArtikel bestellingArtikel) throws ClassNotFoundException, SQLException{
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");
        
        String query = "INSERT INTO Bestelling_has_Artikel(bestelling_idbestelling, artikel_idArtikel, aantal) VALUES (?, ?, ?)";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setLong(1, bestellingArtikel.getIdBestelling());
            prepStmnt.setLong(2, bestellingArtikel.getIdArtikel());
            prepStmnt.setLong(3, bestellingArtikel.getAantal());
            
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
    
    public Set<BestellingArtikel> readAll() throws ClassNotFoundException, SQLException {
        
        Set<BestellingArtikel> bestellingArtikelen = new HashSet<>();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");

        String query = "SELECT * FROM Bestelling_has_Artikel";
        
        try {
            prepStmnt = connection.prepareStatement(query);
            ResultSet result = prepStmnt.executeQuery(query);
            
            while(result.next()){
                BestellingArtikel bestellingArtikel = new BestellingArtikel();
                
             //   bestellingArtikel.setIdBestelling(result.getLong("idBestelling"));
             //   bestellingArtikel.getIdArtikel(result.getString("bestelling_idBestelling"));
             //   bestellingArtikel.setBestelDatum(result.getDate("bestelDatum"));

                
                bestellingArtikelen.add(bestellingArtikel);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bestellingArtikelen;
        
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
