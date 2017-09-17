package com.ubboeicke.application.Controller.Top;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class TopViewController {


    @FXML
    private TextField waveCountTextField;

    @FXML
    private ToggleButton speedTB;

    @FXML
    private Label playerNameLabel;

    @FXML
    private Label playerLevelLabel;

    @FXML
    private Label guildLabel;

    @FXML
    private Label startDateLabel;

    @FXML
    private TextField goldVTF;

    @FXML
    private Label eColoLabel;

    @FXML
    private Label twLabel;

    @FXML
    private Label owLabel;

    @FXML
    private ToggleButton hornOnOffTB;

    @FXML
    private TextField castleLvlVTF;

    @FXML
    private TextField TALvlVTF;

    @FXML
    private Label HPVL;

    @FXML
    private Label MPVL;

    @FXML
    private Label hColoLabel;

    @FXML
    private Label oColoLabel;

    public void initialize(VBox vBox) throws IOException {
        FXMLLoader loader = new FXMLLoader(TopViewController.class.getResource("TopView.fxml"));
        loader.setRoot(vBox);
        loader.setController(this);
        loader.load();

    }

    public Label getGuildLabel() {
        return guildLabel;
    }

    public TextField getWaveCountTextField() {
        return waveCountTextField;
    }

    public Label getStartDateLabel() {
        return startDateLabel;
    }

    public Label getPlayerNameLabel() {
        return playerNameLabel;
    }

    public Label getPlayerLevelLabel() {
        return playerLevelLabel;
    }

    public Label geteColoLabel() {
        return eColoLabel;
    }

    public Label gethColoLabel() {
        return hColoLabel;
    }

    public Label getoColoLabel() {
        return oColoLabel;
    }

    public Label getTwLabel() {
        return twLabel;
    }

    public Label getOwLabel() {
        return owLabel;
    }

    public void seteColoLabel(String eColoLabel) {
        this.eColoLabel.setText(eColoLabel);
    }

    public void sethColoLabel(String hColoLabel) {
        this.hColoLabel.setText(hColoLabel);
    }

    public void setoColoLabel(String oColoLabel) {
        this.oColoLabel.setText(oColoLabel);
    }

    public void setTwLabel(String twLabel) {
        this.twLabel.setText(twLabel);
    }

    public void setOwLabel(String owLabel) {
        this.owLabel.setText(owLabel);
    }

    public void setPlayerNameLabel(String playerNameLabel) {
        this.playerNameLabel.setText(playerNameLabel);
    }

    public void setPlayerLevelLabel(String playerLevelLabel) {
        this.playerLevelLabel.setText(playerLevelLabel);
    }

    public void setGuildLabel(String guildLabel) {
        this.guildLabel.setText(guildLabel);
    }

    public void setstartDateLabel(String startDateLabel) {
        this.startDateLabel.setText(startDateLabel);
    }
    public void setWaveCountTextField(String waveCountTextField){this.waveCountTextField.setText(waveCountTextField);}

    public void setCastleLvlVTF(String castleLvlVTF) {
        this.castleLvlVTF.setText(castleLvlVTF);
    }

    public void setTALvlVTF(String taLvlVTF) {
        this.TALvlVTF.setText(taLvlVTF);
    }
    public void setGoldVTF(String goldVTF) {
        this.goldVTF.setText(goldVTF);
    }
    public void setHPVL(String hpvl) {
        this.HPVL.setText(hpvl);
    }
    public void setMPVL(String mpvl) {
        this.MPVL.setText(mpvl);
    }

    public TextField getGoldVTF() {
        return goldVTF;
    }


    public TextField getCastleLvlVTF() {
        return castleLvlVTF;
    }

    public TextField getTALvlVTF() {
        return TALvlVTF;
    }

    public Label getHPVL() {
        return HPVL;
    }

    public Label getMPVL() {
        return MPVL;
    }
}
