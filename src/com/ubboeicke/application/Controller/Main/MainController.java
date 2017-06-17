package com.ubboeicke.application.Controller.Main;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Item.ItemCreationController;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
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
    @FXML private MenuItem Menu_Item_Make;
    private final TopViewController mTopViewController;
    private final CenterViewController mCenterViewController;
    private MainModel mMainModel;
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
