package com.ubboeicke.ZZZ;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Ubbo Eicke on 01.06.2017.
 */
public class TopController {

    @FXML
    private Label playerNameLabel;
    @FXML
    private  Label playerLevelLabel;




    public Label getPlayerNameLabel() {
        return playerNameLabel;
    }

    public Label getPlayerLevelLabel() {
        return playerLevelLabel;
    }
}
