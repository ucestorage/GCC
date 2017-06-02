package com.ubboeicke.UI.TopView;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class TopViewController {
    @FXML private Label playerNameLabel;

    public void initialize(VBox vBox)throws IOException{
        FXMLLoader loader = new FXMLLoader(TopViewController.class.getResource("TopView.fxml"));
        loader.setRoot(vBox);
        loader.setController(this);
        loader.load();

    }

    public Label getPlayerNameLabel() {
        return playerNameLabel;
    }

    public void setPlayerNameLabel(String playerNameLabel) {
        this.playerNameLabel.setText(playerNameLabel);
    }
}
