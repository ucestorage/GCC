package com.ubboeicke.application;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class MainModel {
    private List<String> mStringList = new ArrayList<>();

    String FILENAME = "LocalObjectDB";
    LocalObjectDB lodb = new LocalObjectDB();

    public MainModel() {

    }

    public void save(String item) {
        mStringList.add(item);
        System.out.println(item);
        lodb.setList(mStringList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
                oos.writeObject(lodb);
            }
            lodb = null;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved " + mStringList.size() + " entries.", ButtonType.CLOSE);
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getStringList() {
        return mStringList;
    }

    public void addStringToList(String string) {
        mStringList.add(string);
    }

    public List<String> load() {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
                lodb = (LocalObjectDB) ois.readObject();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lodb.getList();

    }



}