package com.ubboeicke.application.Controller.Main.Start_Exit;

import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.DB.Save_Load.SaveAndLoadHandler;
import com.ubboeicke.application.Model.MainModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.util.Optional;

/**
 * Created by Ubbo Eicke on 09.06.2017.
 */
public class WelcomeDialogue {
    MainController mMainController;
    TopViewController mTopViewController;
    ButtonType loadBtn = new ButtonType("Load my Save!", ButtonBar.ButtonData.OK_DONE);
    ButtonType fsBtn = new ButtonType("First Start!", ButtonBar.ButtonData.CANCEL_CLOSE);
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "\nIf this is your first start,\nclick the corresponding button,\notherwise load your save.", loadBtn, fsBtn);
    private MainModel mMainModel;
    private SaveAndLoadHandler mSaveAndLoadHandler;

    public WelcomeDialogue(MainController mainController) {
        this.mMainController = mainController;
        this.mTopViewController = mMainController.getTopViewController();
        this.mMainModel = mMainController.getMainModel();
        this.mSaveAndLoadHandler = mMainModel.getSaveAndLoadHandler();
    }

    public void welcome() {
        alert.setTitle("Welcome!");
        alert.setHeaderText("Welcome to Grow Castle Calculator!");
        Optional<ButtonType> result = alert.showAndWait();
        if (new File("DB_Strings").isFile()) {
            // System.out.println("File exists");
            //TODO if savefile is there, loadbtn disable false
        } else {
            alert.getDialogPane().lookupButton(loadBtn).setDisable(true);
            //TODO if no savefile disable loadbtn
        }
        if (result.isPresent() && result.get() == loadBtn) {
            try {
                mSaveAndLoadHandler.loadAll();
            } catch (Exception fnfe) {
                fnfe.printStackTrace();
                Alert error = new Alert(Alert.AlertType.WARNING, "Error on Loading!");
                error.showAndWait();
            }
        } else {
            giveBasicInformation();
        }
    }

    private void giveBasicInformation() {
        int i = 1;
        int ii = 12;
        InputDialogue Input1 = new InputDialogue("Ok", "Basic Informations", "Please enter Player Name", "Step " + i++ + " / " + ii, "PlayerName");
        Input1.dialogueHandler();
        mMainController.writerLabel(Input1.getInput(), mTopViewController.getPlayerNameLabel());
        InputDialogue Input2 = new InputDialogue("Ok", "Basic Informations", "Please enter Player Level", "Step " + i++ + " / " + ii, "401");
        Input2.dialogueHandler();
        mMainController.writerLabel(Input2.getInput(), mTopViewController.getPlayerLevelLabel());
        InputDialogue Input3 = new InputDialogue("Ok", "Basic Informations", "Please enter Guild Name", "Step " + i++ + " / " + ii, "GuildName");
        Input3.dialogueHandler();
        mMainController.writerLabel(Input3.getInput(), mTopViewController.getGuildLabel());
        InputDialogue Input4 = new InputDialogue("Ok", "Basic Informations", "Please enter Start Date", "Step " + i++ + " / " + ii, "24.04.2016");
        Input4.dialogueHandler();
        mMainController.writerLabel(Input4.getInput(), mTopViewController.getStartDateLabel());
        InputDialogue Input5 = new InputDialogue("Ok", "Basic Informations", "Please enter current Wave Count", "Step " + i++ + " / " + ii, "1");
        Input5.dialogueHandler();
        mMainController.writerTextField(Input5.getInput(), mTopViewController.getWaveCountTextField());
        InputDialogue Input6 = new InputDialogue("Ok", "Basic Informations", "Please enter  beaten Earth Colonies\nMAX: 204", "Step " + i++ + " / " + ii, "204");
        Input6.dialogueHandler();
        mMainController.writerLabel(Input6.getInput(), mTopViewController.geteColoLabel());
        InputDialogue Input7 = new InputDialogue("Ok", "Basic Informations", "Please enter  beaten Hell Colonies\nMAX: 187", "Step " + i++ + " / " + ii, "187");
        Input7.dialogueHandler();
        mMainController.writerLabel(Input7.getInput(), mTopViewController.gethColoLabel());
        InputDialogue Input8 = new InputDialogue("Ok", "Basic Informations", "Please enter  beaten Orc Colonies\nMAX: 101", "Step " + i++ + " / " + ii, "101");
        Input8.dialogueHandler();
        mMainController.writerLabel(Input8.getInput(), mTopViewController.getoColoLabel());
        InputDialogue Input9 = new InputDialogue("Ok", "Basic Informations", "Please enter current Town Worker Level", "Step " + i++ + " / " + ii, "1000(MAX)");
        Input9.dialogueHandler();
        mMainController.writerLabel(Input9.getInput(), mTopViewController.getTwLabel());
        InputDialogue Input10 = new InputDialogue("Ok", "Basic Informations", "Please enter current Orc Worker Level", "Step " + i++ + " / " + ii, "1000(MAX)");
        Input10.dialogueHandler();
        mMainController.writerLabel(Input10.getInput(), mTopViewController.getOwLabel());
        InputDialogue Input11 = new InputDialogue("Ok", "Basic Informations", "Please enter current Castle Level", "Step " + i++ + " / " + ii, "0");
        Input11.dialogueHandler();
        mMainController.writerTextField(Input11.getInput(), mTopViewController.getCastleLvlVTF());
        InputDialogue Input12 = new InputDialogue("Ok", "Basic Informations", "Please enter current Town Archer Level", "Step " + i++ + " / " + ii, "0");
        Input12.dialogueHandler();
        mMainController.writerTextField(Input12.getInput(), mTopViewController.getTALvlVTF());

    }
}
