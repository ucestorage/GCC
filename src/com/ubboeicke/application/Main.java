package com.ubboeicke.application;

import com.ubboeicke.UI.CenterView.CenterViewController;
import com.ubboeicke.UI.TopView.TopViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MainModel mainModel = new MainModel();
        CenterViewController centerViewController = new CenterViewController();
        TopViewController topViewController = new TopViewController();
        Scene scene = new Scene(new MainController(mainModel, centerViewController,topViewController ));



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
