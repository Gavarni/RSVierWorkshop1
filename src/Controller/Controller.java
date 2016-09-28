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
        
        while(view.getUserInput()!= 0){
            
            view.initView();
        }
    }
  
    
    
}
