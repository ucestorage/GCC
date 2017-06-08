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

    private SaveAndLoadHandler mSaveAndLoadHandler;
    private List<String> saved;


    public MainModel(SaveAndLoadHandler saveAndLoadHandler) {

        this.mSaveAndLoadHandler = saveAndLoadHandler;
        this.saved = saveAndLoadHandler.getStringList();

    }
    public void save(String item){
        mSaveAndLoadHandler.save(item);
    }
    public List<String> load(){
        return mSaveAndLoadHandler.load();
    }

    public List<String> getSaved() {
        return saved;
    }
}