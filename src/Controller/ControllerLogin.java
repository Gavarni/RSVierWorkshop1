/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.View;
import View.ViewLogin;

/**
 *
 * @author gavarni
 */
class ControllerLogin implements InterfaceController {


    
    public ControllerLogin() {

    }

    @Override
    public void showView() {
        System.out.print("---Login View---");
    }

    @Override
    public void init() {
        showView();
    }


    
}
