package com.ubboeicke.ZZZ;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by Ubbo Eicke on 31.05.2017.
 */
public class MenuController {
    @FXML
    private MenuItem save;

    public void save(String test){
        save.setOnAction(e -> {
            System.out.println(test);
                }
        );

    }
    public void load(){

    }


    public void exit(){
    System.exit(0);
    }

}
