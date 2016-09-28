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
public class Controller {
    
    public Model model;
    public View view;
    
    Scanner in = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        
    }
    
    public void runApp(){
        view.initView();
        while(true){
            view.getUserInput();
            System.out.print("User input is: " + view.getUserInput());
            System.exit(0);
        }
    }
    
}
