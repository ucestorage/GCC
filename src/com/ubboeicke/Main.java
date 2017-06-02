package com.ubboeicke;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXML/MainView.fxml"));



        primaryStage.setTitle("Grow Castle Calculator");
        primaryStage.setScene(new Scene(root));
        primaryStage.setWidth(1920);
        primaryStage.setHeight(1080);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
