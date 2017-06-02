/*
package com.ubboeicke;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

*/
/**
 * Created by Ubbo Eicke on 31.05.2017.
 *//*

public class Loader {



    public Loader(){

    }

    LocalObjectDB lodb = new LocalObjectDB();
    String FILENAME = "LocalObjectDB";

    public void load() {

        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                lodb = (LocalObjectDB) ois.readObject();
            }
           */
/* playerNameLabel.setText(lodb.getList().get(0));
            playerLevelLabel.setText(lodb.getList().get(1));*//*

            playerNameTextField.setText(lodb.getList().get(0));
            playerLevelTextField.setText(lodb.getList().get(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
