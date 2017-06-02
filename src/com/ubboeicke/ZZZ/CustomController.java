package com.ubboeicke.ZZZ;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


/**
 * Created by Ubbo Eicke on 31.05.2017.
 */
public class CustomController extends BorderPane{
    @FXML private Parent embeddedCustomMenu;
    @FXML private MenuController embeddedCustomMenuController;
    @FXML private Parent topgrid;
    @FXML private TopController topgridController;
    @FXML private Parent center;
    @FXML private CenterController centerController;
    private MainModel mMainModel;



    public CustomController(MainModel mainModel) {
        this.mMainModel = mainModel;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("application/MainView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mainModel.test("test"));
        write(centerController.getPlayerNameTextField(),topgridController.getPlayerNameLabel());
    }


    public void write(TextField textField, Label label){
        textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                label.setText(textField.getText());
            }
        });



    }

    }


