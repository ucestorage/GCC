package com.ubboeicke.application.Model.DB.Save_Load;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.OverviewController;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Goldcalc;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponentParser;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.Decks.DeckParser;
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
    private DeckParser mDeckParser;
    private ObservableList<Leader> LDRList = FXCollections.observableArrayList();
    private ObservableList<Tower> TWRList = FXCollections.observableArrayList();
    private ObservableList<CastleComponent> CCList = FXCollections.observableArrayList();
    private ObservableList<Hero> HeroList = FXCollections.observableArrayList();
    private  ObservableList<Deck> DeckList = FXCollections.observableArrayList();
    private OverviewController mOverviewController;


    public SaveAndLoadHandler(MainModel mainModel, MainController mainController) {
        this.mMainController = mainController;
        this.mMainModel = mainModel;
        this.mCenterViewController = mMainController.getCenterViewController();
        this.mTopViewController = mMainController.getTopViewController();
        this.mSaveAndLoadController = mMainModel.getSaveAndLoadController();

        mItemParser = new ItemParser(mCenterViewController);
        mTowerParser = new TowerParser(mCenterViewController);
        mCastleComponentParser = new CastleComponentParser(mCenterViewController);
        mLeaderParser = new LeaderParser(mCenterViewController);
        mHeroParser = new HeroParser(mCenterViewController);
        mDeckParser = new DeckParser(mCenterViewController);
        mOverviewController = new OverviewController(mMainController);



    }



    public void saveAll() {
        saveGeneralInformation();
        saveCastleComponents();
        saveItemsWeapons();
        saveItemsAccessories();
        saveTowers();
        saveLeaders();
        saveHeroes_OH();
        saveHeroes_UH();
        saveDecks();
    }
    public void loadAll(){
        loadGeneralInformation();
        loadItemsWeapons();
        loadItemsAccessories();
        loadCastleComponents();
        loadTowers();
        loadLeaders();
        loadHeroes_OH();
        loadHeroes_UH();
        loadDecks();
        mOverviewController.populateDeckCB();

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
        mTopViewController.setCastleLvlVTF(mSaveAndLoadController.load().get(10));
        mTopViewController.setTALvlVTF(mSaveAndLoadController.load().get(11));
    }
    public void loadItemsWeapons(){
         ObservableList<Item> mItemObservableList = mCenterViewController.getItemWeaponTableView().getItems();
         TableView<Item> mItemTableView = mCenterViewController.getItemWeaponTableView();
        for (String s : mSaveAndLoadController.loadItemsWeapons()){
            mItemObservableList.add(mItemParser.splitItem(s));
        }
        mItemTableView.setItems(mItemObservableList);
    }
    public void loadItemsAccessories(){
        ObservableList<Item> mItemObservableList = mCenterViewController.getItemAccessoryTableView().getItems();
        TableView<Item> mItemTableView = mCenterViewController.getItemAccessoryTableView();
        for (String s : mSaveAndLoadController.loadItemsAccessories()){
            mItemObservableList.add(mItemParser.splitItem(s));
        }
        mItemTableView.setItems(mItemObservableList);
    }
    public void loadCastleComponents(){
        TableView<CastleComponent> tvcc = mCenterViewController.getCcTableView();

        for (String s : mSaveAndLoadController.loadCC()){
            CCList.add(mCastleComponentParser.splitCC(s));
        }tvcc.setItems(CCList);
    }
    public void loadTowers(){
        TableView<Tower> tvt = mCenterViewController.getTwrTableView();

        for (String s : mSaveAndLoadController.loadTWR()){
            TWRList.add(mTowerParser.splitStrings(s));
        }tvt.setItems(TWRList);
    }
    public void loadLeaders(){
        TableView<Leader> tv = mCenterViewController.getLeaderTableView();

        for (String s : mSaveAndLoadController.loadLDR()){
            LDRList.add(mLeaderParser.splitStrings(s));
        }tv.setItems(LDRList);
    }
    public void loadHeroes_OH(){
        TableView<Hero> tv = mCenterViewController.getHeroTableView1();
        ObservableList<Hero> obsl = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadHeroesOh()){
            obsl.add(mHeroParser.splitStrings_OH(s));
            HeroList.add(mHeroParser.splitStrings_OH(s));
        }tv.setItems(obsl);
    }
    public void loadHeroes_UH(){
        TableView<Hero> tv1 = mCenterViewController.getHeroTableView2();
        ObservableList<Hero> obsl = FXCollections.observableArrayList();
        for (String s : mSaveAndLoadController.loadHeroesUh()){
            obsl.add(mHeroParser.splitStrings_UH(s));
            HeroList.add(mHeroParser.splitStrings_UH(s));

        }tv1.setItems(obsl);
    }
    public void loadDecks(){
        TableView<Deck> tv1 = mCenterViewController.getDeckTableView();

        for (String s : mSaveAndLoadController.loadDecks()){

            DeckList.add(mDeckParser.splitStrings(s));

        }tv1.setItems(DeckList);
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
       mSaveAndLoadController.save(mTopViewController.getCastleLvlVTF().getText());
       mSaveAndLoadController.save(mTopViewController.getTALvlVTF().getText());
    }
    public void saveItemsWeapons() {
        for(String s :mItemParser.getItemWeaponStringList()){
            mSaveAndLoadController.saveItemsWeapons(s);
        }
    }
    public void saveItemsAccessories() {
        for(String s :mItemParser.getItemAccessoryStringList()){
            mSaveAndLoadController.saveItemsAccessories(s);
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
    public void saveDecks(){
        for (String s : mDeckParser.getDeckStrings()){

            mSaveAndLoadController.saveDecks(s);
        }
    }

    public ObservableList<Deck> getDeckList() {
        return DeckList;
    }

    public ObservableList<Tower> getTWRList() {
        return TWRList;
    }

    public ObservableList<Leader> getLDRList() {
        return LDRList;
    }

    public ObservableList<CastleComponent> getCCList() {
        return CCList;
    }

    public ObservableList<Hero> getHeroList() {
        return HeroList;
    }
}
