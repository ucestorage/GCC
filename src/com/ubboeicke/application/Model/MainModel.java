package com.ubboeicke.application.Model;

import com.ubboeicke.application.Model.Save_Load.SaveAndLoadHandler;

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