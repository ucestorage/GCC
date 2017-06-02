package com.ubboeicke;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;

/**
 * Created by Ubbo Eicke on 31.05.2017.
 */
public class MenuController {
    @FXML
    private MenuBar customMenuBar;

    public void save(){
        System.out.println("test");
    }
    public void load(){

    }


    public void exit(){
    System.exit(0);
    }

}
