package com.ubboeicke.UI.CenterView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class CenterViewController {
    @FXML private TextField playerNameTextField;


    public void initialize(TabPane tabPane)throws IOException{
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();

    }
    public TextField getPlayerNameTextField() {
        return playerNameTextField;
    }

    public void setPlayerNameTextFieldString(String string) {
        playerNameTextField.setText(string);
    }
}
