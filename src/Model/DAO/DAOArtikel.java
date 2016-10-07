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
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    
    public void create(Artikel artikel) throws ClassNotFoundException, SQLException {
        
        //connection = Database.getDBOInstance();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
           
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");
        
        String query = "INSERT INTO Artikel(artikelNummer, naam, omschrijving, prijs, voorraad) VALUES(?, ?, ?, ?, ?)";
        
        try{
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setLong(1, artikel.getArtikelNummer());
            prepStmnt.setString(2, artikel.getNaam());
            prepStmnt.setString(3, artikel.getOmschrijving());
            prepStmnt.setBigDecimal(4, artikel.getPrijs());
            prepStmnt.setInt(5, artikel.getVoorraad());
            prepStmnt.executeUpdate();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void delete(Artikel artikel) throws ClassNotFoundException, SQLException {
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
           
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
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
       
    public Set<Artikel> readAll() throws ClassNotFoundException, SQLException {
        
        Set<Artikel> artikelen = new HashSet<>();// verander naar set want hibernate kan complicaties geven dubbele elementen
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");

        String query = "SELECT * FROM Artikel";
        
        try {
            prepStmnt = connection.prepareStatement(query);
            ResultSet result = prepStmnt.executeQuery(query);
            
            while(result.next()){
                Artikel artikel = new Artikel();
                
                artikel.setIdArtikel(result.getLong("idArtikel"));
                System.out.print(" art. id. " + artikel.getIdArtikel());
                
                artikel.setArtikelNummer(result.getLong("artikelNummer"));
                System.out.print(" art. nr " + artikel.getArtikelNummer());
                
                artikel.setNaam(result.getString("naam"));
                System.out.print(" naam " + artikel.getNaam());
                
                artikel.setOmschrijving(result.getString("omschrijving"));
                System.out.print(" omschrijving " + artikel.getOmschrijving());
                
                artikel.setPrijs(result.getBigDecimal("prijs"));
                System.out.print(" prijs " + artikel.getPrijs());
                
                artikel.setVoorraad(result.getInt("voorraad"));
                System.out.print(" voorraad " + artikel.getVoorraad());
                System.out.println();
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
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");

        String query = "SELECT * FROM Artikel WHERE Artikel.artikelNummer = ?";
        
        try {
            
            prepStmnt = connection.prepareCall(query);
            prepStmnt.setLong(1, artikel.getArtikelNummer());
            
            ResultSet result = prepStmnt.executeQuery();
            
            while(result.next()){
                
                
                gevondenArtikel.setIdArtikel(result.getLong("idArtikel"));
                System.out.print("art.id. " + gevondenArtikel.getIdArtikel());
                
                gevondenArtikel.setArtikelNummer(result.getLong("artikelNummer"));
                System.out.print(" art.nr. " + gevondenArtikel.getArtikelNummer());
                
                gevondenArtikel.setNaam(result.getString("naam"));
                System.out.print(" naam " + gevondenArtikel.getNaam());
                
                gevondenArtikel.setOmschrijving(result.getString("omschrijving"));
                System.out.print(" omschrijving " + gevondenArtikel.getOmschrijving());
                
                gevondenArtikel.setPrijs(result.getBigDecimal("prijs"));
                System.out.print(" prijs " + gevondenArtikel.getPrijs());
                
                gevondenArtikel.setVoorraad(result.getInt("voorraad"));
                System.out.print(" voorraad " + gevondenArtikel.getVoorraad());
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gevondenArtikel;
        
    }
    
    public Artikel readByNaam(Artikel artikel) throws ClassNotFoundException, SQLException{
        
        Artikel gevondenArtikel = new Artikel();
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");

        String query = "SELECT * FROM Artikel WHERE Artikel.naam = ?";
        
        try {
            
            prepStmnt = connection.prepareCall(query);
            prepStmnt.setString(1, artikel.getNaam());
            
            ResultSet result = prepStmnt.executeQuery();
            
            while(result.next()){
                
                
                gevondenArtikel.setIdArtikel(result.getLong("idArtikel"));
                System.out.print("art.id. " + gevondenArtikel.getIdArtikel());
                
                gevondenArtikel.setArtikelNummer(result.getLong("artikelNummer"));
                System.out.print(" art.nr. " + gevondenArtikel.getArtikelNummer());
                
                gevondenArtikel.setNaam(result.getString("naam"));
                System.out.print(" naam " + gevondenArtikel.getNaam());
                
                gevondenArtikel.setOmschrijving(result.getString("omschrijving"));
                System.out.print(" omschrijving " + gevondenArtikel.getOmschrijving());
                
                gevondenArtikel.setPrijs(result.getBigDecimal("prijs"));
                System.out.print(" prijs " + gevondenArtikel.getPrijs());
                
                gevondenArtikel.setVoorraad(result.getInt("voorraad"));
                System.out.print(" voorraad " + gevondenArtikel.getVoorraad());
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return gevondenArtikel;
        
    }
    
    public void update(Artikel artikel) throws ClassNotFoundException, SQLException {
        
        // Load the JDBC MySQL Driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        
        //Connect to MySQL Database
        connection = DriverManager.getConnection("jdbc:mysql://localhost/Applikaasie", "piet", "kaas");
        System.out.println("Database connected");

        String query = "UPDATE Artikel SET Artikel.artikelNummer = ?, Artikel.naam = ?, "
                + "Artikel.omschrijving = ?, Artikel.prijs = ? Artikel.voorraad = ? "
                + "WHERE Artikel.idArtikel = ?";
                       
        try {
            prepStmnt = connection.prepareStatement(query);
            
            prepStmnt.setLong(1, artikel.getArtikelNummer());
            prepStmnt.setString(2, artikel.getNaam());
            prepStmnt.setString(3, artikel.getOmschrijving());
            prepStmnt.setBigDecimal(4, artikel.getPrijs());
            prepStmnt.setInt(5, artikel.getVoorraad());
            prepStmnt.setLong(6, artikel.getIdArtikel());
            prepStmnt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
