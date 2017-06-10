package com.ubboeicke.application;

import com.ubboeicke.application.Controller.MainController;
import com.ubboeicke.application.Controller.Start_Exit.OnCloseRequestEventHandler;
import com.ubboeicke.application.Controller.Start_Exit.WelcomeDialogue;
import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Controller.TopViewController;
import com.ubboeicke.application.Model.MainModel;
import com.ubboeicke.application.Model.Save_Load.LocalObjectDB;
import com.ubboeicke.application.Model.Save_Load.SaveAndLoadHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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


            WelcomeDialogue welcomeDialogue = new WelcomeDialogue(mainController,topViewController);
            welcomeDialogue.welcome();




    }


    public static void main(String[] args) {
        launch(args);
    }
}
