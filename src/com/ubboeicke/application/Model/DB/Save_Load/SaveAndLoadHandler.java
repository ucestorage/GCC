package com.ubboeicke.application.Model.DB.Save_Load;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponentParser;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Heroes.HeroParser;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Items.ItemParser;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Leaders.LeaderParser;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import com.ubboeicke.application.Model.Gamedata.Towers.TowerParser;
import com.ubboeicke.application.Model.MainModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private LeaderParser mLeaderParser;
    private HeroParser mHeroParser;

    public SaveAndLoadHandler(MainModel mainModel, MainController mainController) {
        this.mMainController = mainController;
        this.mMainModel = mainModel;
        this.mCenterViewController = mMainController.getCenterViewController();
        this.mTopViewController = mMainController.getTopViewController();
        mItemParser = new ItemParser(mCenterViewController);
        mTowerParser = new TowerParser(mCenterViewController);
        mCastleComponentParser = new CastleComponentParser(mCenterViewController);
        mLeaderParser = new LeaderParser(mCenterViewController);
        mHeroParser = new HeroParser(mCenterViewController);
        mSaveAndLoadController = mMainModel.getSaveAndLoadController();

    }
    public void saveAll() {
        saveGeneralInformation();
        saveCastleComponents();
        saveItems();
        saveTowers();
        saveLeaders();
        saveHeroes_OH();
        saveHeroes_UH();
    }
    public void loadAll(){
        loadGeneralInformation();
        loadItems();
        loadCastleComponents();
        loadTowers();
        loadLeaders();
        loadHeroes_OH();
        loadHeroes_UH();

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
    public void loadLeaders(){
        TableView<Leader> tv = mCenterViewController.getLeaderTableView();
        ObservableList<Leader> obsl = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadLDR()){
            obsl.add(mLeaderParser.splitStrings(s));
        }tv.setItems(obsl);
    }
    public void loadHeroes_OH(){
        TableView<Hero> tv = mCenterViewController.getHeroTableView1();
        ObservableList<Hero> obsl = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadHeroesOh()){
            obsl.add(mHeroParser.splitStrings_OH(s));
        }tv.setItems(obsl);
    }
    public void loadHeroes_UH(){
        TableView<Hero> tv1 = mCenterViewController.getHeroTableView2();
        ObservableList<Hero> obsl = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadHeroesUh()){
            obsl.add(mHeroParser.splitStrings_UH(s));
        }tv1.setItems(obsl);
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
    public void saveLeaders(){
        for (String s : mLeaderParser.getStrings()){
            mSaveAndLoadController.saveLeaders(s);
        }
    }
    public void saveHeroes_OH(){
        for (String s : mHeroParser.getStrings_OH()){
            mSaveAndLoadController.saveHeroesOh(s);
        }
    }
    public void saveHeroes_UH(){
        for (String s : mHeroParser.getStrings_UH()){
            mSaveAndLoadController.saveHeroesUh(s);
        }
    }




}
