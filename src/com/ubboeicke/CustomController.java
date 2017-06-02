package com.ubboeicke;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * Created by Ubbo Eicke on 31.05.2017.
 */
public class CustomController extends BorderPane{
    @FXML
    private Label playerNameLabel;
    @FXML
    private  Label playerLevelLabel;
    @FXML
    private TextField playerNameTextField;
    @FXML
    private TextField playerLevelTextField;



    public CustomController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/MainView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    }


