package com.ubboeicke.application.Model;

import com.ubboeicke.application.Controller.MainController;
import com.ubboeicke.application.Model.Save_Load.SaveAndLoadController;
import com.ubboeicke.application.Model.Save_Load.SaveAndLoadHandler;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class MainModel {
    private MainController mMainController;
    private SaveAndLoadController mSaveAndLoadController;
    private SaveAndLoadHandler mSaveAndLoadHandler;


    public MainModel(MainController mainController) {
        this.mMainController = mainController;
        this.mSaveAndLoadController = new SaveAndLoadController();
        this.mSaveAndLoadHandler = new SaveAndLoadHandler(this, mMainController);

    }

    public SaveAndLoadController getSaveAndLoadController() {
        return mSaveAndLoadController;
    }

    public SaveAndLoadHandler getSaveAndLoadHandler() {
        return mSaveAndLoadHandler;
    }


}