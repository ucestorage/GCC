package com.ubboeicke.UI.TopView;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class TopViewController {
    public TopViewController(VBox vBox) throws IOException {
        FXMLLoader loader = new FXMLLoader(TopViewController.class.getResource("TopView.fxml"));
        loader.setRoot(vBox);
        loader.setController(this);
        loader.load();
    }
}
