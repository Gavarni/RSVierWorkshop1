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

        Artikel artikel = new Artikel();
        
        //view.initView();
        
        DAOArtikel daoa = new DAOArtikel();
        
        daoa.delete(3242);
     
    }
}

