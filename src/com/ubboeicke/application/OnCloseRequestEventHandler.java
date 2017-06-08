package com.ubboeicke.application;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private Stage mStage;
    private MainController mMainController;
    ButtonType saveBtn = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
    ButtonType exitBtn = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);

    Alert exitAlert = new Alert(Alert.AlertType.WARNING, "Do you want to save before exiting?",saveBtn, exitBtn);

    public OnCloseRequestEventHandler (Stage stage, MainController mainController){
        this.mStage = stage;
        this.mMainController = mainController;


    }

    public EventHandler<WindowEvent> confirm = event -> {

      exitAlert.setHeaderText("Please Save before exiting.");
      exitAlert.initModality(Modality.APPLICATION_MODAL);
      exitAlert.initOwner(mStage);
        Optional<ButtonType> result = exitAlert.showAndWait();

        if (result.isPresent() && result.get() == saveBtn) {
            mMainController.save();
        }
        if (result.isPresent() && result.get() == exitBtn) {
            System.exit(0);
        }

    };

}
