package com.ubboeicke.application.Controller.Start_Exit;

import com.ubboeicke.application.Controller.TopViewController;
import com.ubboeicke.application.Controller.MainController;
import com.ubboeicke.application.Model.MainModel;
import com.ubboeicke.application.Model.Save_Load.SaveAndLoadHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by Ubbo Eicke on 09.06.2017.
 */
public class WelcomeDialogue {
    private MainModel mMainModel;
    private SaveAndLoadHandler mSaveAndLoadHandler;
    MainController mMainController;
    TopViewController mTopViewController;
    ButtonType loadBtn = new ButtonType("Load my Save!", ButtonBar.ButtonData.OK_DONE);
    ButtonType fsBtn = new ButtonType("First Start!", ButtonBar.ButtonData.CANCEL_CLOSE);
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Brought to you by bOngshotsGG.\nIf this is your first start,\nclick the corresponding button,\notherwise load your save.",loadBtn,fsBtn);

    public WelcomeDialogue (MainController mainController){
        this.mMainController = mainController;
        this.mTopViewController = mMainController.getTopViewController();
        this.mMainModel = mMainController.getMainModel();
        this.mSaveAndLoadHandler = mMainModel.getSaveAndLoadHandler();

    }
    public void welcome() {
        alert.setTitle("Welcome!");
        alert.setHeaderText("Welcome to Grow Castle Calculator!");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == loadBtn) {

            mSaveAndLoadHandler.loadAll();


        } else {
           giveBasicInformation();


        }
    }
        private void giveBasicInformation(){
        int i = 1;
            InputDialogue Input1 = new InputDialogue("Ok", "Basic Informations", "Please enter Player Name", "Step "+i++ +" / 10");
            Input1.dialogueHandler();
            mMainController.writerLabel(Input1.getInput(), mTopViewController.getPlayerNameLabel());

            InputDialogue Input2 = new InputDialogue("Ok", "Basic Informations", "Please enter Player Level", "Step "+i++ +" / 10");
            Input2.dialogueHandler();
            mMainController.writerLabel(Input2.getInput(), mTopViewController.getPlayerLevelLabel());

            InputDialogue Input3 = new InputDialogue("Ok", "Basic Informations", "Please enter Guild Name", "Step "+i++ +" / 10");
            Input3.dialogueHandler();
            mMainController.writerLabel(Input3.getInput(), mTopViewController.getGuildLabel());

            InputDialogue Input4 = new InputDialogue("Ok", "Basic Informations", "Please enter Start Date", "Step "+i++ +" / 10");
            Input4.dialogueHandler();
            mMainController.writerLabel(Input4.getInput(), mTopViewController.getStartDateLabel());

            InputDialogue Input5 = new InputDialogue("Ok", "Basic Informations", "Please enter current Wave Count", "Step "+i++ +" / 10");
            Input5.dialogueHandler();
            mMainController.writerTextField(Input5.getInput(), mTopViewController.getWaveCountTextField());

            InputDialogue Input6 = new InputDialogue("Ok", "Basic Informations", "Please enter  beaten Earth Colonies\nMAX: 204", "Step "+i++ +" / 10");
            Input6.dialogueHandler();
            mMainController.writerLabel(Input6.getInput(), mTopViewController.geteColoLabel());

            InputDialogue Input7 = new InputDialogue("Ok", "Basic Informations", "Please enter  beaten Hell Colonies\nMAX: 187", "Step "+i++ +" / 10");
            Input7.dialogueHandler();
            mMainController.writerLabel(Input7.getInput(), mTopViewController.gethColoLabel());

            InputDialogue Input8 = new InputDialogue("Ok", "Basic Informations", "Please enter  beaten Orc Colonies\nMAX: 101", "Step "+i++ +" / 10");
            Input8.dialogueHandler();
            mMainController.writerLabel(Input8.getInput(), mTopViewController.getoColoLabel());

            InputDialogue Input9 = new InputDialogue("Ok", "Basic Informations", "Please enter current Town Worker Level", "Step "+i++ +" / 10");
            Input9.dialogueHandler();
            mMainController.writerLabel(Input9.getInput(), mTopViewController.getTwLabel());

            InputDialogue Input10 = new InputDialogue("Ok", "Basic Informations", "Please enter current Orc Worker Level", "Step "+i++ +" / 10");
            Input10.dialogueHandler();
            mMainController.writerLabel(Input10.getInput(), mTopViewController.getOwLabel());




    }

    }


