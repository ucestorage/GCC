package com.ubboeicke.application;

import com.ubboeicke.UI.CenterView.CenterViewController;
import com.ubboeicke.UI.TopView.TopViewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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

        mMainModel.save(mCenterViewController.getPlayerNameTextField().getText());
    }
    public void load(){
        mCenterViewController.setPlayerNameTextFieldString(mMainModel.load().get(0));
        mTopViewController.setPlayerNameLabel(mMainModel.load().get(0));



    }

    public void writeValues(TextField textField, Label label){
        textField.setOnKeyReleased(e -> {
            label.setText(textField.getText());

        });

    }
}
