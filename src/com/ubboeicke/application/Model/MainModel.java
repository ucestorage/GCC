package com.ubboeicke.application.Model;

import com.ubboeicke.application.Model.Save_Load.SaveAndLoadController;

import java.util.List;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class MainModel {

    private SaveAndLoadController mSaveAndLoadController;
    private List<String> saved;
    private List<String> itemssaved;


    public MainModel(SaveAndLoadController saveAndLoadController) {

        this.mSaveAndLoadController = saveAndLoadController;
        this.saved = saveAndLoadController.getStringList();
        this.itemssaved = saveAndLoadController.getItemList();
    }
    public void saveItems(String item) {
        mSaveAndLoadController.saveItem(item);
    }
    public void saveCC(String item) {mSaveAndLoadController.saveCC(item);}
    public void save(String item){
        mSaveAndLoadController.save(item);
    }
    public List<String> load(){
        return mSaveAndLoadController.load();
    }
    public List<String> loadItems() {return mSaveAndLoadController.loadItems();}
    public List<String> loadCC() {return mSaveAndLoadController.loadCC();}
    public List<String> getItemssaved(){
        return itemssaved;
    }
    public List<String> getSaved() {
        return saved;
    }
}