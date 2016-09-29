/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.ViewLogin;

/**
 *
 * @author gavarni
 */
public class FacadeController {
    
    private InterfaceController login;
    
    public FacadeController(){
        login = new ControllerLogin();
    }
    
    public void initlogin(){
        login.init();
    }
}
