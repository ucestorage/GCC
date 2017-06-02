package com.ubboeicke.ZZZ;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 01.06.2017.
 */
public class CenterController {


    @FXML
    private TextField playerNameTextField;
    @FXML
    private TextField playerLevelTextField;




    public TextField getPlayerNameTextField() {
        return playerNameTextField;
    }

    public TextField getPlayerLevelTextField() {
        return playerLevelTextField;
    }
}
