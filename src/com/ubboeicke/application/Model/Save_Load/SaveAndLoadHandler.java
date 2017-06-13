package com.ubboeicke.application.Model.Save_Load;

import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Controller.MainController;
import com.ubboeicke.application.Controller.TopViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponentParser;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.Item;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.ItemParser;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import com.ubboeicke.application.Model.Gamedata.Towers.TowerParser;
import com.ubboeicke.application.Model.MainModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class SaveAndLoadHandler {
    private MainController mMainController;
    private MainModel mMainModel;
    private TopViewController mTopViewController;
    private CenterViewController mCenterViewController;
    private ItemParser mItemParser;
    private CastleComponentParser mCastleComponentParser;
    private TowerParser mTowerParser;
    private SaveAndLoadController mSaveAndLoadController;

    public SaveAndLoadHandler(MainModel mainModel, MainController mainController) {
        this.mMainController = mainController;
        this.mMainModel = mainModel;
        this.mCenterViewController = mMainController.getCenterViewController();
        this.mTopViewController = mMainController.getTopViewController();
        mItemParser = new ItemParser(mCenterViewController);
        mTowerParser = new TowerParser(mCenterViewController);
        mCastleComponentParser = new CastleComponentParser(mCenterViewController);
        mSaveAndLoadController = mMainModel.getSaveAndLoadController();

    }
    public void saveAll() {
        saveGeneralInformation();
        saveCastleComponents();
        saveItems();
        saveTowers();
    }
    public void loadAll(){
        loadGeneralInformation();
        loadItems();
        loadCastleComponents();
        loadTowers();

    }
    public void loadGeneralInformation(){
        mTopViewController.setPlayerNameLabel(mSaveAndLoadController.load().get(0));
        mTopViewController.setPlayerLevelLabel(mSaveAndLoadController.load().get(1));
        mTopViewController.setGuildLabel(mSaveAndLoadController.load().get(2));
        mTopViewController.setstartDateLabel(mSaveAndLoadController.load().get(3));
        mTopViewController.setWaveCountTextField(mSaveAndLoadController.load().get(4));
        mTopViewController.seteColoLabel(mSaveAndLoadController.load().get(5));
        mTopViewController.sethColoLabel(mSaveAndLoadController.load().get(6));
        mTopViewController.setoColoLabel(mSaveAndLoadController.load().get(7));
        mTopViewController.setTwLabel(mSaveAndLoadController.load().get(8));
        mTopViewController.setOwLabel(mSaveAndLoadController.load().get(9));
    }
    public void loadItems(){
         ObservableList<Item> mItemObservableList = FXCollections.observableArrayList();
         TableView<Item> mItemTableView = mCenterViewController.getItemTableView();
        for (String s : mSaveAndLoadController.loadItems()){
            mItemObservableList.add(mItemParser.splitItem(s));
        }
        mItemTableView.setItems(mItemObservableList);
    }
    public void loadCastleComponents(){
        TableView<CastleComponent> tvcc = mCenterViewController.getCcTableView();
        ObservableList<CastleComponent> obsv = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadCC()){
            obsv.add(mCastleComponentParser.splitCC(s));
        }tvcc.setItems(obsv);
    }
    public void loadTowers(){
        TableView<Tower> tvt = mCenterViewController.getTwrTableView();
        ObservableList<Tower> obst = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadTWR()){
            obst.add(mTowerParser.splitStrings(s));
        }tvt.setItems(obst);
    }
    public void saveGeneralInformation() {
        mSaveAndLoadController.save(mTopViewController.getPlayerNameLabel().getText());
        mSaveAndLoadController.save(mTopViewController.getPlayerLevelLabel().getText());
        mSaveAndLoadController.save(mTopViewController.getGuildLabel().getText());
        mSaveAndLoadController.save(mTopViewController.getStartDateLabel().getText());
        mSaveAndLoadController.save(mTopViewController.getWaveCountTextField().getText());
       mSaveAndLoadController.save(mTopViewController.geteColoLabel().getText());
        mSaveAndLoadController.save(mTopViewController.gethColoLabel().getText());
        mSaveAndLoadController.save(mTopViewController.getoColoLabel().getText());
        mSaveAndLoadController.save(mTopViewController.getTwLabel().getText());
       mSaveAndLoadController.save(mTopViewController.getOwLabel().getText());
    }
    public void saveItems() {
        for(String s :mItemParser.getItemStrings()){
            mSaveAndLoadController.saveItems(s);
        }
    }
    public void saveCastleComponents(){
        for (String s : mCastleComponentParser.getCCStrings()){
            mSaveAndLoadController.saveCC(s);
        }

    }
    public void saveTowers(){
        for (String s : mTowerParser.getStrings()){
            mSaveAndLoadController.saveTowers(s);
        }

    }



}
