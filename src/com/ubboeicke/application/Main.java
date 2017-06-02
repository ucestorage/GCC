package com.ubboeicke.application;

import com.ubboeicke.ZZZ.MainModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainModel mainModel = new MainModel();
        Scene scene = new Scene(new MainController(mainModel));



        primaryStage.setTitle("Grow Castle Calculator");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
