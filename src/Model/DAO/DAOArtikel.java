/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.POJO.Artikel;
import Model.POJO.Bestelling;
import Utilities.JDBC.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
            
            prepStmnt.setLong(1, artikel.getArtikelNummer());
            prepStmnt.executeUpdate();
            //System.out.print("Delete Succesful");
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
    }
       
    public List<Artikel> readAll() throws ClassNotFoundException, SQLException{
        List<Artikel> artikelen = new ArrayList<Artikel>();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");

        String query = "SELECT * FROM Artikel";
        
        try {
            Statement stmnt = connection.createStatement();
            ResultSet result = stmnt.executeQuery(query);
            
            while(result.next()){
                Artikel artikel = new Artikel();
                
                artikel.setIdArtikel(result.getLong("idArtikel"));
                artikel.setArtikelNummer(result.getLong("artikelNummer"));
                artikel.setNaam(result.getString("naam"));
                artikel.setOmschrijving(result.getString("omschrijving"));
                artikel.setPrijs(result.getDouble("prijs"));
                artikel.setVoorraad(result.getInt("voorraad"));
                
                artikelen.add(artikel);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return artikelen;
    }
    
    public Artikel readByArtikelNummer(Artikel artikel) throws ClassNotFoundException, SQLException{
        
        Artikel gevondenArtikel = new Artikel();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Dataabse connected");

        String query = "SELECT * FROM Artikel WHERE artikel.artikelNummer = ?";
        
        try {
            
            prepStmnt = connection.prepareCall(query);
            prepStmnt.setLong(1, artikel.getArtikelNummer());
            
            ResultSet result = prepStmnt.executeQuery();
            
            while(result.next()){
                artikel.setIdArtikel(result.getLong("idArtikel"));
                artikel.setArtikelNummer(result.getLong("artikelNummer"));
                artikel.setNaam(result.getString("naamm"));
                artikel.setOmschrijving(result.getString("omschrjving"));
                artikel.setPrijs(result.getDouble("prijs"));
                artikel.setVoorraad(result.getInt("voorraad"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gevondenArtikel;
        
    }
    
    
    
}
