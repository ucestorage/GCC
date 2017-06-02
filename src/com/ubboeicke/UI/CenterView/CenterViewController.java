package com.ubboeicke.UI.CenterView;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.TabPane;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class CenterViewController {
    public CenterViewController(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
    }
}
