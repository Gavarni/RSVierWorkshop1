/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Scanner;

/**
 *
 * @author Gavarni
 */
public class View implements interfaceView{
    
    //
    protected int userChoice;
    protected Scanner in;
    
    public View() {
        in = new Scanner(System.in);
    }

    public void showView(){
        System.out.println("/-------------------------------------/");
        System.out.println("/             InlogScherm             /");
        System.out.println("/-------------------------------------/");
        System.out.println();
        System.out.println("\t\tWELKOM ");
        System.out.println("    Applikaasie, de kaas specialist    ");
        System.out.println();
        System.out.println();
        System.out.println("Optie (1) inloggen, optie (0) afsluiten");
        System.out.println("Geef uw invoer:");
        readUserInput();
    }
    
    public int getUserInput(){
        return userChoice;
    }

    @Override
    public void readUserInput() {
        userChoice = in.nextInt();
    }
    
}
