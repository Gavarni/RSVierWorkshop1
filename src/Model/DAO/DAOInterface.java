/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

/**
 *
 * @author Gavarni
 * @param <E>
 */
public interface DAOInterface<E> {
    
    public void Create(E o);
    public void Delete(E o);
}
