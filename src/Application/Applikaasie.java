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
        /*
        Artikel artikel = new Artikel();
        
        artikel.setArtikelNummer(3432);
        artikel.setNaam("BLABLA BLA");
        artikel.setOmschrijving("Omschrijving");
        artikel.setPrijs(29.5);
        artikel.setVoorraad(30);
        
        DAOArtikel dao = new DAOArtikel();
        
        dao.create(artikel);
        */
        controller.runApp();
    }
}

