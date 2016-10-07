/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOTests;

import Model.DAO.DAOArtikel;
import Model.POJO.Artikel;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 *
 * @author Gavarni
 */
public class TestDAOArtikel {
    
        
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        
        DAOArtikel daoArtikel = new DAOArtikel();
        Artikel artikel = new Artikel();
        
        //artikel.setIdArtikel(11);
        //artikel.setArtikelNummer(10001);
        artikel.setNaam("kaas2");
        //daoArtikel.delete(artikel);
        daoArtikel.readByNaam(artikel);
        /*artikel.setIdArtikel(11);
        artikel.setArtikelNummer(12356);
        artikel.setNaam("gesmoltenkazen");
        artikel.setOmschrijving("zijn het de gesmolten kazen?");
        artikel.setPrijs(new BigDecimal("10.50"));
        artikel.setVoorraad(23);
        
       
                
        daoArtikel.create(artikel);*/
        
        //System.out.print("id: " + artikel.getIdArtikel() + " artnr: " + artikel.getArtikelNummer() );
        
    }
    
}
