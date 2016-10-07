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
    
    public static DAOAccount getDAOAccount() throws ClassNotFoundException, SQLException{
        return new DAOAccount();
    }
    
    public static DAOAdres getDAOAdres()  throws ClassNotFoundException, SQLException{
        return new DAOAdres();
    }
    
    public static DAOArtikel getDAOArtikel() throws ClassNotFoundException, SQLException{
        return new DAOArtikel();
    }
    
    public static DAOBestelling getDAOBestelling() throws ClassNotFoundException, SQLException{
        return new DAOBestelling();
    }
    
    public static DAOKlant getDAOKlant() throws ClassNotFoundException, SQLException{
        return new DAOKlant();
    }
    
}
