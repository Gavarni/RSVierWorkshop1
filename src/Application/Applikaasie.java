/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Controller.Controller;
import Model.DAO.DAOArtikel;
import Model.Model;
import Model.POJO.Artikel;
import View.View;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 *
 * @author Gavarni
 */
public class Applikaasie {

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
     
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //controller.runApp();
        
        Artikel artikel = new Artikel();
        
        artikel.setIdArtikel(12);
        artikel.setArtikelNummer(10011);
        artikel.setNaam("Kaas11");
        artikel.setOmschrijving("beste kaas ever Omschrijving");
        artikel.setPrijs(new BigDecimal("1000.50"));
        artikel.setVoorraad(30);
        
        System.out.print(artikel.getIdArtikel() + " ");
        System.out.print(artikel.getArtikelNummer() + " ");
        System.out.print(artikel.getNaam() + " ");
        System.out.print(artikel.getOmschrijving() + " ");
        System.out.print(artikel.getPrijs() + " ");
        System.out.print(artikel.getVoorraad() + " ");
        System.out.println();
        DAOArtikel dao = new DAOArtikel();
        
        //dao.create(artikel);
        //dao.readAll();
       dao.update(artikel);
        //controller.runApp();
    }
}

