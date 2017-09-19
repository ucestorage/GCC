package com.ubboeicke.application.Controller.Main;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Deck.DeckCreationController;
import com.ubboeicke.application.Controller.Item.ItemCreationController;
import com.ubboeicke.application.Controller.Main.Start_Exit.InputDialogue;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.Enums.Filename;
import com.ubboeicke.application.Model.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */


public class MainController extends BorderPane {
    @FXML
    private VBox vboxTop;
    @FXML
    private TabPane centerContainer;
    private final TopViewController mTopViewController;
    private final CenterViewController mCenterViewController;
    private MainModel mMainModel;
    private Stage mStageDeck;
    private Stage mStage;

    public MainController() throws IOException {
        this.mCenterViewController = new CenterViewController();
        this.mTopViewController = new TopViewController();

        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        mCenterViewController.initialize(getCenterContainer());
        mTopViewController.initialize(getContentHolder());
        this.mMainModel = new MainModel(this);

    }
    public void makeNewDeck(){
        try {
            DeckCreationController deckCreator = new DeckCreationController(this);
            Scene scene = new Scene(deckCreator);
            mStageDeck = new Stage();
            mStageDeck.setScene(scene);

            mStageDeck.setTitle("Deck Creation");
            mStageDeck.show();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public void redditThread(){
        Alert aler = new Alert(Alert.AlertType.INFORMATION);
        aler.setTitle("Reddit");
        aler.setHeaderText("Find help in the official Reddit Thread!");
        aler.setContentText(Filename.REDDIT);
        aler.showAndWait();
    }

    public void setPlayerName(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter your desired Name.","Change Playername","");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getPlayerNameLabel());
    }
    public void setPlayerLevel(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter your Level.","Change PlayerLevel","401(MAX)");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getPlayerLevelLabel());
    }
    public void setGuildLabel(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter your Guild.","Change Guild","");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getGuildLabel());
    }
    public void setStartDate(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter your start Date.","Change StartDate","");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getStartDateLabel());
    }
    public void setEarthColo(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter beaten Earth Colonies.","Earth Colonies","204 (MAX)");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.geteColoLabel());
    }
    public void setHellColo(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter beaten Hell Colonies.","Hell Colonies","187 (MAX)");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.gethColoLabel());
    }
    public void setOrcColo(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter beaten Orc Colonies.","Orc Colonies","101 (MAX)");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getoColoLabel());
    }
    public void setTownWorker(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter your Town Worker Level.","Change Town Worker Level","1000 (MAX)");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getTwLabel());
    }
    public void setOrcWorker(){
        InputDialogue pnid = new InputDialogue("Ok","Edit Basic Information","Enter your Orc Worker Level.","Change Orc Worker Level","1000 (MAX)");
        pnid.dialogueHandler();
        this.writerLabel(pnid.getInput(),mTopViewController.getOwLabel());
    }

   public void makeNewItem(){
               try {
                   ItemCreationController itemCreator = new ItemCreationController(mCenterViewController);
                   Scene scene = new Scene(itemCreator);
                   mStage = new Stage();
                   mStage.setScene(scene);

                   mStage.setTitle("Item Creation");
                   mStage.show();

               } catch (IOException ioe) {
                   ioe.printStackTrace();
               }
       }


    public Stage getStage() {
        return mStage;
    }

    public Stage getStageDeck() {
        return mStageDeck;
    }

    public MainModel getMainModel() {
        return mMainModel;
    }

    public TopViewController getTopViewController() {
        return mTopViewController;
    }

    public CenterViewController getCenterViewController() {
        return mCenterViewController;
    }

    private VBox getContentHolder() {
        return vboxTop;
    }

    private TabPane getCenterContainer() {
        return centerContainer;
    }


    public void writerLabel(String string, Label label) {
        label.setText(string);

    }

    public void writerTextField(String string, TextField textField) {
        textField.setText(string);
    }
}
