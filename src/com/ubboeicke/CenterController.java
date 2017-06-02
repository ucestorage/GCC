package com.ubboeicke;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 01.06.2017.
 */
public class CenterController {

    public Label playerNameLabel;
    @FXML
    private TextField playerNameTextField;
    @FXML
    private TextField playerLevelTextField;

    public void write(){
    playerNameLabel.setText(playerLevelTextField.getText());

    }
    public Label getPlayerNameLabel(){
        return playerNameLabel;
    }

    public TextField getPlayerNameTextField() {
        return playerNameTextField;
    }

    public TextField getPlayerLevelTextField() {
        return playerLevelTextField;
    }
}
