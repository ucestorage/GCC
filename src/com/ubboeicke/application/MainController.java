package com.ubboeicke.application;

import com.ubboeicke.UI.CenterView.CenterViewController;
import com.ubboeicke.UI.TopView.TopViewController;
import com.ubboeicke.ZZZ.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;
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
    private CenterViewController mCenterViewController;
    private TopViewController mTopViewController;
    private MainModel mMainModel;

    public MainController(MainModel mainModel) throws IOException {
        this.mMainModel = mainModel;
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        CenterViewController cvc = new CenterViewController(getCenterContainer());
        TopViewController tvc = new TopViewController(getContentHolder());
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
}
