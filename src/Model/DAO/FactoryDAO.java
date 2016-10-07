/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import java.sql.SQLException;

/**
 *
 * @author Gavarni
 */
public class FactoryDAO {
    
    public static DAOArtikel getDAOArtikel() throws ClassNotFoundException, SQLException{
        return new DAOArtikel();
    }
    
    public static DAOBestelling getDAOBestelling(){
        return new DAOBestelling();
    }
    
}
