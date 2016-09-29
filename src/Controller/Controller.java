/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.View;
import java.util.Scanner;

/**
 *
 * @author Gavarni
 */
public class Controller implements InterfaceController{
    
    public Model model;
    public View view;
    
    Scanner in = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        FacadeController facade = new FacadeController();
    }
    
    public void runApp(){
        showView();
        if (view.getUserInput() == 1){
            facade.initLogin();
        } else if(view.getUserInput() == 0) {
        
        } else if (view.getUserInput() != 1 || view.getUserInput() != 0){
            System.out.println("Optie (1) inloggen, optie (0) afsluiten");
            System.out.println("Geef uw invoer:");
            view.readUserInput();
        }
        /*
        while(view.getUserInput() !=  ){
            view.getUserInput();
            System.out.print("User input is: " + view.getUserInput());
            System.exit(0);
        }*/
    }

    @Override
    public void showView() {
        view.showView();
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
