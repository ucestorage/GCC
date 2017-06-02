package com.ubboeicke.ZZZ;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubbo Eicke on 31.05.2017.
 */
public class Saver {

    @FXML
    public TextField playerNameTextField;

    public TextField playerLevelTextField;

    String FILENAME = "LocalObjectDB";
    List<String> list = new ArrayList<>();

    LocalObjectDB lodb = new LocalObjectDB();

    public void save(){

        list.add(playerNameTextField.getText());
        list.add(playerLevelTextField.getText());

        lodb.setList(list);


        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                oos.writeObject(lodb);
            }

            lodb = null;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved " + list.size() + " entries.", ButtonType.CLOSE);
            alert.showAndWait();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
