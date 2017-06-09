package com.ubboeicke.application;

import com.ubboeicke.UI.CenterView.CenterViewController;
import com.ubboeicke.UI.TopView.TopViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */


public class MainController extends BorderPane {
    @FXML
    private VBox vboxTop;
    @FXML
    private TabPane centerContainer;
    private CenterViewController mCenterViewController;
    private TopViewController mTopViewController;
    private MainModel mMainModel;



    public MainController(MainModel mainModel, CenterViewController centerViewController, TopViewController topViewController) throws IOException {
        this.mTopViewController = topViewController;
        this.mCenterViewController = centerViewController;
        this.mMainModel = mainModel;
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
       mCenterViewController.initialize(getCenterContainer());
       mTopViewController.initialize(getContentHolder());


        writeValues(mCenterViewController.getPlayerNameTextField(),mTopViewController.getPlayerNameLabel());


    }

    protected final VBox getContentHolder() {
        return vboxTop;
    }

    protected final TabPane getCenterContainer() {
        return centerContainer;
    }

    public void exit() {
        System.exit(0);
    }
    public void save() {

        mMainModel.save(mTopViewController.getPlayerNameLabel().getText());
        mMainModel.save(mTopViewController.getPlayerLevelLabel().getText());
        mMainModel.save(mTopViewController.getGuildLabel().getText());
        mMainModel.save(mTopViewController.getStartDateLabel().getText());
        mMainModel.save(mTopViewController.getWaveCountTextField().getText());
           Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved " + mMainModel.getSaved().size() + " entries.", ButtonType.CLOSE);
          alert.showAndWait();
    }
    public void load(){
        mTopViewController.setPlayerNameLabel(mMainModel.load().get(0));
        mTopViewController.setPlayerLevelLabel(mMainModel.load().get(1));
        mTopViewController.setGuildLabel(mMainModel.load().get(2));
        mTopViewController.setstartDateLabel(mMainModel.load().get(3));
        mTopViewController.setWaveCountTextField(mMainModel.load().get(4));



    }

    public void writeValues(TextField textField, Label label){
        textField.setOnKeyReleased(e -> {
            label.setText(textField.getText());

        });

    }
    public void writerLabel(String string, Label label){
        label.setText(string);

    }
    public void writerTextField(String string, TextField textField) {
        textField.setText(string);
    }
}
