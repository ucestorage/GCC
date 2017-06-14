package com.ubboeicke.application.Controller.Main;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

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


    public MainController() throws IOException {
        this.mCenterViewController = new CenterViewController();
        this.mTopViewController = new TopViewController();
        this.mMainModel = new MainModel(this);
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        mCenterViewController.initialize(getCenterContainer());
        mTopViewController.initialize(getContentHolder());


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
