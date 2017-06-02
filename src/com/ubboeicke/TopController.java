package com.ubboeicke;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Ubbo Eicke on 01.06.2017.
 */
public class TopController extends CenterController{

    @FXML
    private Label playerNameLabel;
    @FXML
    private  Label playerLevelLabel;

    public TopController(){
    playerNameLabel = getPlayerNameLabel();
    }

    public void setPlayerName(String string) {
        playerNameLabel.setText(string);

    }

    public String getPlayerName() {
        return playerNameLabel.getText();
    }



    public Label getPlayerLevelLabel() {
        return playerLevelLabel;
    }
}
