package com.ubboeicke.application;

import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Controller.Main.Start_Exit.OnCloseRequestEventHandler;
import com.ubboeicke.application.Controller.Main.Start_Exit.WelcomeDialogue;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainController mainController = new MainController();
        Scene scene = new Scene(mainController);
        OnCloseRequestEventHandler closeRequestEventHandler = new OnCloseRequestEventHandler(primaryStage, mainController);
        primaryStage.setOnCloseRequest(closeRequestEventHandler.confirm);
        primaryStage.setTitle("Grow Castle Calculator");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.show();
        WelcomeDialogue welcomeDialogue = new WelcomeDialogue(mainController);
        welcomeDialogue.welcome();
    }
}
