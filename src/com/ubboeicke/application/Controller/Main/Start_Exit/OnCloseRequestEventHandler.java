package com.ubboeicke.application.Controller.Main.Start_Exit;

import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Model.DB.Save_Load.SaveAndLoadHandler;
import com.ubboeicke.application.Model.MainModel;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * Created by Ubbo Eicke on 08.06.2017.
 */
public class OnCloseRequestEventHandler {
    ButtonType saveBtn = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
    ButtonType exitBtn = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);
    Alert exitAlert = new Alert(Alert.AlertType.WARNING, "", saveBtn, exitBtn);
    private Stage mStage;
    private MainModel mMainModel;
    private MainController mMainController;
    private SaveAndLoadHandler mSaveAndLoadHandler;
    public EventHandler<WindowEvent> confirm = event -> {
        exitAlert.setTitle("Warning!");
        exitAlert.setHeaderText("Please Save before exiting.");
        exitAlert.initModality(Modality.APPLICATION_MODAL);
        exitAlert.initOwner(mStage);
        Optional<ButtonType> result = exitAlert.showAndWait();
        if (result.isPresent() && result.get() == saveBtn) {
            mSaveAndLoadHandler.saveAll();
        }
        if (result.isPresent() && result.get() == exitBtn) {
            System.exit(0);
        }
    };

    public OnCloseRequestEventHandler(Stage stage, MainController mainController) {
        this.mMainController = mainController;
        this.mStage = stage;
        this.mMainModel = mMainController.getMainModel();
        mSaveAndLoadHandler = mMainModel.getSaveAndLoadHandler();
    }
}
