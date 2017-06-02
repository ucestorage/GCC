package com.ubboeicke;

import javafx.fxml.FXML;
import javafx.scene.Parent;

/**
 * Created by Ubbo Eicke on 01.06.2017.
 */
public class MainController{
    @FXML private Parent embeddedCustomMenu;
    @FXML private MenuController embeddedCustomMenuController;
    @FXML
    private  TopController topc;
    @FXML
    private  CenterController centerc;

public MainController(){
    test();
}

public void test() {
    System.out.println(embeddedCustomMenuController);
    System.out.println(embeddedCustomMenu);
    embeddedCustomMenuController.save();

}

}
