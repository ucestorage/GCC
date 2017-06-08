package com.ubboeicke.application;

import com.ubboeicke.UI.CenterView.CenterViewController;
import com.ubboeicke.UI.TopView.TopViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LocalObjectDB localObjectDB = new LocalObjectDB();
        SaveAndLoadHandler saveAndLoadHandler = new SaveAndLoadHandler(localObjectDB);
        MainModel mainModel = new MainModel(saveAndLoadHandler);
        CenterViewController centerViewController = new CenterViewController();
        TopViewController topViewController = new TopViewController();
        MainController mainController = new MainController(mainModel, centerViewController, topViewController);
        Scene scene = new Scene(mainController);

        OnCloseRequestEventHandler closeRequestEventHandler = new OnCloseRequestEventHandler(primaryStage,mainController );

        primaryStage.setOnCloseRequest(closeRequestEventHandler.confirm);






        primaryStage.setTitle("Grow Castle Calculator");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.show();
        
        if(mainModel.load().get(0).equals(GlobalConstants.ISSAVED)){
            mainController.load();

        }
        //TODO else Start dialogue general information


    }


    public static void main(String[] args) {
        launch(args);
    }
}
