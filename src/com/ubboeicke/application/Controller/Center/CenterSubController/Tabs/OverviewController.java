package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Controller.Top.TopViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.GoldCalc.Gold;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Ubbo Eicke on 24.06.2017.
 */
public class OverviewController {
    private ObservableList<String> deckStringList = FXCollections.observableArrayList();
    private ObservableList<Deck> deckList;
    private ObservableList<CastleComponent> mCastleComponents;
    private ObservableList<Tower> mTowers;
    private ObservableList<Hero> mHeroList = FXCollections.observableArrayList();
    private ObservableList<Hero> mUHeroList = FXCollections.observableArrayList();
    private ObservableList<Item> mWeaponList = FXCollections.observableArrayList();
    private ObservableList<Item> mAccessoryList = FXCollections.observableArrayList();
    private ObservableList<Leader> mLeaderList = FXCollections.observableArrayList();
    private MainController mMainController;
    private CenterViewController mCenterViewController;
    private TopViewController mTopViewController;
    private ValueKeeper vk = new ValueKeeper();
    Double hp = 0.0;
    Double manaRec = 0.0;
    Double archerDmg = 0.0;
    Double towerDmg = 0.0;
    Double cdr = 0.0;
    Double humanSummons = 0.0;
    Double humanSummonDmg = 0.0;
    Double archerCrit = 0.0;
    Double heroCrit = 0.0;
    Double archerAS = 0.0;
    Double defense = 0.0;
    Double siegeDef = 0.0;
    Integer finalHP = 0;
    Integer finalMP = 0;
    private PopulateTab_Goldcalc populateTabGoldcalc;
    private ObservableList<Gold> selectedGold = FXCollections.observableArrayList();
    private ObservableList<Gold> goldTableItems = FXCollections.observableArrayList();
    private Button btn;
    private DecimalFormat df = new DecimalFormat("#");

    public OverviewController(MainController mainController) {
        mMainController = mainController;
        mCenterViewController = mainController.getCenterViewController();
        mTopViewController = mainController.getTopViewController();
    }

    public void populateDeckCB() {
        deckList = mCenterViewController.getDeckTableView().getItems();
        ComboBox<String> cb = mTopViewController.getDeckCB();
        for (Deck d : deckList) {
            deckStringList.add(d.getName());
        }
        cb.getItems().addAll(deckStringList);
        populateTabGoldcalc = new PopulateTab_Goldcalc(mMainController);
        onChangeDeckCB();
    }

    private void calculateBasicValues(String leader, String tb1, String tb2, String tb3, String t1, String t2, String t3, String t4, String t5, String twr1, String twr2, String twr3, String twr4) {
        if (leader.equals("Edward")) {
            vk.setSummonedUnitDmg(vk.getSummonedUnitDmg() + 10.0);
        }
        if (leader.equals("Solar")) {
            vk.setFireDmg(vk.getFireDmg() + 5.0);
        }
        if (leader.equals("Sara")) {
            vk.setPoisonDmg(vk.getPoisonDmg() + 10.0);
        }
        findValuesTb(tb1);
        findValuesTb(tb2);
        findValuesTb(tb3);
        findValuesTreasuresWeapons(t1);
        findValuesTreasures(t2);
        findValuesTreasures(t3);
        findValuesTreasures(t4);
        findValuesTreasures(t5);
        findValuesTwr(twr1);
        findValuesTwr(twr2);
        findValuesTwr(twr3);
        findValuesTwr(twr4);
    }

    private void onChangeDeckCB() {
        mCastleComponents = mCenterViewController.getCcTableView().getItems();
        mTowers = mCenterViewController.getTwrTableView().getItems();
        mHeroList.addAll(mCenterViewController.getHeroTableView1().getItems());
        mUHeroList.addAll(mCenterViewController.getHeroTableView2().getItems());
        mWeaponList.addAll(mCenterViewController.getItemWeaponTableView().getItems());
        mAccessoryList.addAll(mCenterViewController.getItemAccessoryTableView().getItems());
        mLeaderList.addAll(mCenterViewController.getLeaderTableView().getItems());
        mTopViewController.getDeckCB().getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    selectedGold.clear();
                    for (Deck deck : mCenterViewController.getDeckTableView().getItems()) {
                        if (newValue.equals(deck.getName())) {
                            vk.reset();
                            fillOverviewData(deck, mCenterViewController.getTbL1(), mCenterViewController.getTbL2(),
                                    mCenterViewController.getTbL3(), mCenterViewController.gettL1(),
                                    mCenterViewController.gettL2(), mCenterViewController.gettL3(),
                                    mCenterViewController.gettL4(), mCenterViewController.gettL5(),
                                    mCenterViewController.getTwrL(), mCenterViewController.getTwrL1(),
                                    mCenterViewController.getTwrL2(), mCenterViewController.getTwrL3(),
                                    mTowers, mCenterViewController.getCcL(), mCenterViewController.getCcL1(),
                                    mCenterViewController.getCcL2(), mCenterViewController.getCcL3(),
                                    mCastleComponents, mCenterViewController.getLdrL(), mLeaderList);
                            calculateBasicValues(deck.getLeader(), deck.getTownBuilding1(), deck.getTownBuilding2(),
                                    deck.getTownBuilding3(), deck.getTreasure1(), deck.getTreasure2(),
                                    deck.getTreasure3(), deck.getTreasure4(), deck.getTreasure5(),
                                    deck.getTower1(), deck.getTower2(), deck.getTower3(),
                                    deck.getTower4());
                            mTopViewController.setHPVL(calcHP(mTopViewController.getCastleLvlVTF().getText()));
                            mTopViewController.setMPVL(calcMP(mTopViewController.getCastleLvlVTF().getText()));
                            mCenterViewController.getNameLH().setText(deck.getH1());
                            fillHeroData(deck.getH1(), mCenterViewController.getDmgLH(),
                                    mCenterViewController.getItemSWLH(), mCenterViewController.getItemQWLH(),
                                    mCenterViewController.getAtt1WLH(), mCenterViewController.getAtt1VWLH(),
                                    mCenterViewController.getAtt2WLH(), mCenterViewController.getAtt2VWLH(),
                                    mCenterViewController.getAtt3WLH(), mCenterViewController.getAtt3VWLH(),
                                    mCenterViewController.getItemSALH(), mCenterViewController.getItemQALH(),
                                    mCenterViewController.getAtt1ALH(), mCenterViewController.getAtt2ALH(),
                                    mCenterViewController.getAtt3ALH(), mCenterViewController.getAtt1VALH(),
                                    mCenterViewController.getAtt2VALH(), mCenterViewController.getAtt3VALH(),
                                    mCenterViewController.getLvlVLH(), mCenterViewController.getLvlPVLH(),
                                    mCenterViewController.getCdVLH(), mCenterViewController.getManaVLH(),
                                    mCenterViewController.getAmVLH(), mCenterViewController.getAmLH());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH().getText(),
                                    mCenterViewController.getLvlVLH().getText(),
                                    mCenterViewController.getLvlPVLH().getText(),
                                    mCenterViewController.getAtt1WLH().getText(),
                                    mCenterViewController.getAtt2WLH().getText(),
                                    mCenterViewController.getAtt3WLH().getText(),
                                    mCenterViewController.getAtt1VWLH().getText(),
                                    mCenterViewController.getAtt2VWLH().getText(),
                                    mCenterViewController.getAtt3VWLH().getText(),
                                    mCenterViewController.getAtt1ALH().getText(),
                                    mCenterViewController.getAtt2ALH().getText(),
                                    mCenterViewController.getAtt3ALH().getText(),
                                    mCenterViewController.getAtt1VALH().getText(),
                                    mCenterViewController.getAtt2VALH().getText(),
                                    mCenterViewController.getAtt3VALH().getText(),
                                    giveDmg(mCenterViewController.getDmgLH())));
                            mCenterViewController.getNameLH1().setText(deck.getH2());
                            fillHeroData(deck.getH2(), mCenterViewController.getDmgLH1(),
                                    mCenterViewController.getItemSWLH1(), mCenterViewController.getItemQWLH1(),
                                    mCenterViewController.getAtt1WLH1(), mCenterViewController.getAtt1VWLH1(),
                                    mCenterViewController.getAtt2WLH1(), mCenterViewController.getAtt2VWLH1(),
                                    mCenterViewController.getAtt3WLH1(), mCenterViewController.getAtt3VWLH1(),
                                    mCenterViewController.getItemSALH1(), mCenterViewController.getItemQALH1(),
                                    mCenterViewController.getAtt1ALH1(), mCenterViewController.getAtt2ALH1(),
                                    mCenterViewController.getAtt3ALH1(), mCenterViewController.getAtt1VALH1(),
                                    mCenterViewController.getAtt2VALH1(), mCenterViewController.getAtt3VALH1(),
                                    mCenterViewController.getLvlVLH1(), mCenterViewController.getLvlPVLH1(),
                                    mCenterViewController.getCdVLH1(), mCenterViewController.getManaVLH1(),
                                    mCenterViewController.getAmVLH1(), mCenterViewController.getAmLH1());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH1().getText(),
                                    mCenterViewController.getLvlVLH1().getText(),
                                    mCenterViewController.getLvlPVLH1().getText(),
                                    mCenterViewController.getAtt1WLH1().getText(),
                                    mCenterViewController.getAtt2WLH1().getText(),
                                    mCenterViewController.getAtt3WLH1().getText(),
                                    mCenterViewController.getAtt1VWLH1().getText(),
                                    mCenterViewController.getAtt2VWLH1().getText(),
                                    mCenterViewController.getAtt3VWLH1().getText(),
                                    mCenterViewController.getAtt1ALH1().getText(),
                                    mCenterViewController.getAtt2ALH1().getText(),
                                    mCenterViewController.getAtt3ALH1().getText(),
                                    mCenterViewController.getAtt1VALH1().getText(),
                                    mCenterViewController.getAtt2VALH1().getText(),
                                    mCenterViewController.getAtt3VALH1().getText(),
                                    giveDmg(mCenterViewController.getDmgLH1())));
                            mCenterViewController.getNameLH2().setText(deck.getH3());
                            fillHeroData(deck.getH3(), mCenterViewController.getDmgLH2(),
                                    mCenterViewController.getItemSWLH2(), mCenterViewController.getItemQWLH2(),
                                    mCenterViewController.getAtt1WLH2(), mCenterViewController.getAtt1VWLH2(),
                                    mCenterViewController.getAtt2WLH2(), mCenterViewController.getAtt2VWLH2(),
                                    mCenterViewController.getAtt3WLH2(), mCenterViewController.getAtt3VWLH2(),
                                    mCenterViewController.getItemSALH2(), mCenterViewController.getItemQALH2(),
                                    mCenterViewController.getAtt1ALH2(), mCenterViewController.getAtt2ALH2(),
                                    mCenterViewController.getAtt3ALH2(), mCenterViewController.getAtt1VALH2(),
                                    mCenterViewController.getAtt2VALH2(), mCenterViewController.getAtt3VALH2(),
                                    mCenterViewController.getLvlVLH2(), mCenterViewController.getLvlPVLH2(),
                                    mCenterViewController.getCdVLH2(), mCenterViewController.getManaVLH2(),
                                    mCenterViewController.getAmVLH2(), mCenterViewController.getAmLH2());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH2().getText(),
                                    mCenterViewController.getLvlVLH2().getText(),
                                    mCenterViewController.getLvlPVLH2().getText(),
                                    mCenterViewController.getAtt1WLH2().getText(),
                                    mCenterViewController.getAtt2WLH2().getText(),
                                    mCenterViewController.getAtt3WLH2().getText(),
                                    mCenterViewController.getAtt1VWLH2().getText(),
                                    mCenterViewController.getAtt2VWLH2().getText(),
                                    mCenterViewController.getAtt3VWLH2().getText(),
                                    mCenterViewController.getAtt1ALH2().getText(),
                                    mCenterViewController.getAtt2ALH2().getText(),
                                    mCenterViewController.getAtt3ALH2().getText(),
                                    mCenterViewController.getAtt1VALH2().getText(),
                                    mCenterViewController.getAtt2VALH2().getText(),
                                    mCenterViewController.getAtt3VALH2().getText(),
                                    giveDmg(mCenterViewController.getDmgLH2())));
                            mCenterViewController.getNameLH3().setText(deck.getH4());
                            fillHeroData(deck.getH4(), mCenterViewController.getDmgLH3(),
                                    mCenterViewController.getItemSWLH3(), mCenterViewController.getItemQWLH3(),
                                    mCenterViewController.getAtt1WLH3(), mCenterViewController.getAtt1VWLH3(),
                                    mCenterViewController.getAtt2WLH3(), mCenterViewController.getAtt2VWLH3(),
                                    mCenterViewController.getAtt3WLH3(), mCenterViewController.getAtt3VWLH3(),
                                    mCenterViewController.getItemSALH3(), mCenterViewController.getItemQALH3(),
                                    mCenterViewController.getAtt1ALH3(), mCenterViewController.getAtt2ALH3(),
                                    mCenterViewController.getAtt3ALH3(), mCenterViewController.getAtt1VALH3(),
                                    mCenterViewController.getAtt2VALH3(), mCenterViewController.getAtt3VALH3(),
                                    mCenterViewController.getLvlVLH3(), mCenterViewController.getLvlPVLH3(),
                                    mCenterViewController.getCdVLH3(), mCenterViewController.getManaVLH3(),
                                    mCenterViewController.getAmVLH3(), mCenterViewController.getAmLH3());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH3().getText(),
                                    mCenterViewController.getLvlVLH3().getText(),
                                    mCenterViewController.getLvlPVLH3().getText(),
                                    mCenterViewController.getAtt1WLH3().getText(),
                                    mCenterViewController.getAtt2WLH3().getText(),
                                    mCenterViewController.getAtt3WLH3().getText(),
                                    mCenterViewController.getAtt1VWLH3().getText(),
                                    mCenterViewController.getAtt2VWLH3().getText(),
                                    mCenterViewController.getAtt3VWLH3().getText(),
                                    mCenterViewController.getAtt1ALH3().getText(),
                                    mCenterViewController.getAtt2ALH3().getText(),
                                    mCenterViewController.getAtt3ALH3().getText(),
                                    mCenterViewController.getAtt1VALH3().getText(),
                                    mCenterViewController.getAtt2VALH3().getText(),
                                    mCenterViewController.getAtt3VALH3().getText(),
                                    giveDmg(mCenterViewController.getDmgLH3())));
                            mCenterViewController.getNameLH4().setText(deck.getH5());
                            fillHeroData(deck.getH5(), mCenterViewController.getDmgLH4(),
                                    mCenterViewController.getItemSWLH4(), mCenterViewController.getItemQWLH4(),
                                    mCenterViewController.getAtt1WLH4(), mCenterViewController.getAtt1VWLH4(),
                                    mCenterViewController.getAtt2WLH4(), mCenterViewController.getAtt2VWLH4(),
                                    mCenterViewController.getAtt3WLH4(), mCenterViewController.getAtt3VWLH4(),
                                    mCenterViewController.getItemSALH4(), mCenterViewController.getItemQALH4(),
                                    mCenterViewController.getAtt1ALH4(), mCenterViewController.getAtt2ALH4(),
                                    mCenterViewController.getAtt3ALH4(), mCenterViewController.getAtt1VALH4(),
                                    mCenterViewController.getAtt2VALH4(), mCenterViewController.getAtt3VALH4(),
                                    mCenterViewController.getLvlVLH4(), mCenterViewController.getLvlPVLH4(),
                                    mCenterViewController.getCdVLH4(), mCenterViewController.getManaVLH4(),
                                    mCenterViewController.getAmVLH4(), mCenterViewController.getAmLH4());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH4().getText(),
                                    mCenterViewController.getLvlVLH4().getText(),
                                    mCenterViewController.getLvlPVLH4().getText(),
                                    mCenterViewController.getAtt1WLH4().getText(),
                                    mCenterViewController.getAtt2WLH4().getText(),
                                    mCenterViewController.getAtt3WLH4().getText(),
                                    mCenterViewController.getAtt1VWLH4().getText(),
                                    mCenterViewController.getAtt2VWLH4().getText(),
                                    mCenterViewController.getAtt3VWLH4().getText(),
                                    mCenterViewController.getAtt1ALH4().getText(),
                                    mCenterViewController.getAtt2ALH4().getText(),
                                    mCenterViewController.getAtt3ALH4().getText(),
                                    mCenterViewController.getAtt1VALH4().getText(),
                                    mCenterViewController.getAtt2VALH4().getText(),
                                    mCenterViewController.getAtt3VALH4().getText(),
                                    giveDmg(mCenterViewController.getDmgLH4())));
                            mCenterViewController.getNameLH5().setText(deck.getH6());
                            fillHeroData(deck.getH6(), mCenterViewController.getDmgLH5(),
                                    mCenterViewController.getItemSWLH5(), mCenterViewController.getItemQWLH5(),
                                    mCenterViewController.getAtt1WLH5(), mCenterViewController.getAtt1VWLH5(),
                                    mCenterViewController.getAtt2WLH5(), mCenterViewController.getAtt2VWLH5(),
                                    mCenterViewController.getAtt3WLH5(), mCenterViewController.getAtt3VWLH5(),
                                    mCenterViewController.getItemSALH5(), mCenterViewController.getItemQALH5(),
                                    mCenterViewController.getAtt1ALH5(), mCenterViewController.getAtt2ALH5(),
                                    mCenterViewController.getAtt3ALH5(), mCenterViewController.getAtt1VALH5(),
                                    mCenterViewController.getAtt2VALH5(), mCenterViewController.getAtt3VALH5(),
                                    mCenterViewController.getLvlVLH5(), mCenterViewController.getLvlPVLH5(),
                                    mCenterViewController.getCdVLH5(), mCenterViewController.getManaVLH5(),
                                    mCenterViewController.getAmVLH5(), mCenterViewController.getAmLH5());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH5().getText(),
                                    mCenterViewController.getLvlVLH5().getText(),
                                    mCenterViewController.getLvlPVLH5().getText(),
                                    mCenterViewController.getAtt1WLH5().getText(),
                                    mCenterViewController.getAtt2WLH5().getText(),
                                    mCenterViewController.getAtt3WLH5().getText(),
                                    mCenterViewController.getAtt1VWLH5().getText(),
                                    mCenterViewController.getAtt2VWLH5().getText(),
                                    mCenterViewController.getAtt3VWLH5().getText(),
                                    mCenterViewController.getAtt1ALH5().getText(),
                                    mCenterViewController.getAtt2ALH5().getText(),
                                    mCenterViewController.getAtt3ALH5().getText(),
                                    mCenterViewController.getAtt1VALH5().getText(),
                                    mCenterViewController.getAtt2VALH5().getText(),
                                    mCenterViewController.getAtt3VALH5().getText(),
                                    giveDmg(mCenterViewController.getDmgLH5())));
                            mCenterViewController.getNameLH6().setText(deck.getH7());
                            fillHeroData(deck.getH7(), mCenterViewController.getDmgLH6(),
                                    mCenterViewController.getItemSWLH6(), mCenterViewController.getItemQWLH6(),
                                    mCenterViewController.getAtt1WLH6(), mCenterViewController.getAtt1VWLH6(),
                                    mCenterViewController.getAtt2WLH6(), mCenterViewController.getAtt2VWLH6(),
                                    mCenterViewController.getAtt3WLH6(), mCenterViewController.getAtt3VWLH6(),
                                    mCenterViewController.getItemSALH6(), mCenterViewController.getItemQALH6(),
                                    mCenterViewController.getAtt1ALH6(), mCenterViewController.getAtt2ALH6(),
                                    mCenterViewController.getAtt3ALH6(), mCenterViewController.getAtt1VALH6(),
                                    mCenterViewController.getAtt2VALH6(), mCenterViewController.getAtt3VALH6(),
                                    mCenterViewController.getLvlVLH6(), mCenterViewController.getLvlPVLH6(),
                                    mCenterViewController.getCdVLH6(), mCenterViewController.getManaVLH6(),
                                    mCenterViewController.getAmVLH6(), mCenterViewController.getAmLH6());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH6().getText(),
                                    mCenterViewController.getLvlVLH6().getText(),
                                    mCenterViewController.getLvlPVLH6().getText(),
                                    mCenterViewController.getAtt1WLH6().getText(),
                                    mCenterViewController.getAtt2WLH6().getText(),
                                    mCenterViewController.getAtt3WLH6().getText(),
                                    mCenterViewController.getAtt1VWLH6().getText(),
                                    mCenterViewController.getAtt2VWLH6().getText(),
                                    mCenterViewController.getAtt3VWLH6().getText(),
                                    mCenterViewController.getAtt1ALH6().getText(),
                                    mCenterViewController.getAtt2ALH6().getText(),
                                    mCenterViewController.getAtt3ALH6().getText(),
                                    mCenterViewController.getAtt1VALH6().getText(),
                                    mCenterViewController.getAtt2VALH6().getText(),
                                    mCenterViewController.getAtt3VALH6().getText(),
                                    giveDmg(mCenterViewController.getDmgLH6())));
                            mCenterViewController.getNameLH7().setText(deck.getH8());
                            fillHeroData(deck.getH8(), mCenterViewController.getDmgLH7(),
                                    mCenterViewController.getItemSWLH7(), mCenterViewController.getItemQWLH7(),
                                    mCenterViewController.getAtt1WLH7(), mCenterViewController.getAtt1VWLH7(),
                                    mCenterViewController.getAtt2WLH7(), mCenterViewController.getAtt2VWLH7(),
                                    mCenterViewController.getAtt3WLH7(), mCenterViewController.getAtt3VWLH7(),
                                    mCenterViewController.getItemSALH7(), mCenterViewController.getItemQALH7(),
                                    mCenterViewController.getAtt1ALH7(), mCenterViewController.getAtt2ALH7(),
                                    mCenterViewController.getAtt3ALH7(), mCenterViewController.getAtt1VALH7(),
                                    mCenterViewController.getAtt2VALH7(), mCenterViewController.getAtt3VALH7(),
                                    mCenterViewController.getLvlVLH7(), mCenterViewController.getLvlPVLH7(),
                                    mCenterViewController.getCdVLH7(), mCenterViewController.getManaVLH7(),
                                    mCenterViewController.getAmVLH7(), mCenterViewController.getAmLH7());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH7().getText(),
                                    mCenterViewController.getLvlVLH7().getText(),
                                    mCenterViewController.getLvlPVLH7().getText(),
                                    mCenterViewController.getAtt1WLH7().getText(),
                                    mCenterViewController.getAtt2WLH7().getText(),
                                    mCenterViewController.getAtt3WLH7().getText(),
                                    mCenterViewController.getAtt1VWLH7().getText(),
                                    mCenterViewController.getAtt2VWLH7().getText(),
                                    mCenterViewController.getAtt3VWLH7().getText(),
                                    mCenterViewController.getAtt1ALH7().getText(),
                                    mCenterViewController.getAtt2ALH7().getText(),
                                    mCenterViewController.getAtt3ALH7().getText(),
                                    mCenterViewController.getAtt1VALH7().getText(),
                                    mCenterViewController.getAtt2VALH7().getText(),
                                    mCenterViewController.getAtt3VALH7().getText(),
                                    giveDmg(mCenterViewController.getDmgLH7())));
                            mCenterViewController.getNameLH8().setText(deck.getH9());
                            fillHeroData(deck.getH9(), mCenterViewController.getDmgLH8(),
                                    mCenterViewController.getItemSWLH8(), mCenterViewController.getItemQWLH8(),
                                    mCenterViewController.getAtt1WLH8(), mCenterViewController.getAtt1VWLH8(),
                                    mCenterViewController.getAtt2WLH8(), mCenterViewController.getAtt2VWLH8(),
                                    mCenterViewController.getAtt3WLH8(), mCenterViewController.getAtt3VWLH8(),
                                    mCenterViewController.getItemSALH8(), mCenterViewController.getItemQALH8(),
                                    mCenterViewController.getAtt1ALH8(), mCenterViewController.getAtt2ALH8(),
                                    mCenterViewController.getAtt3ALH8(), mCenterViewController.getAtt1VALH8(),
                                    mCenterViewController.getAtt2VALH8(), mCenterViewController.getAtt3VALH8(),
                                    mCenterViewController.getLvlVLH8(), mCenterViewController.getLvlPVLH8(),
                                    mCenterViewController.getCdVLH8(), mCenterViewController.getManaVLH8(),
                                    mCenterViewController.getAmVLH8(), mCenterViewController.getAmLH8());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH8().getText(),
                                    mCenterViewController.getLvlVLH8().getText(),
                                    mCenterViewController.getLvlPVLH8().getText(),
                                    mCenterViewController.getAtt1WLH8().getText(),
                                    mCenterViewController.getAtt2WLH8().getText(),
                                    mCenterViewController.getAtt3WLH8().getText(),
                                    mCenterViewController.getAtt1VWLH8().getText(),
                                    mCenterViewController.getAtt2VWLH8().getText(),
                                    mCenterViewController.getAtt3VWLH8().getText(),
                                    mCenterViewController.getAtt1ALH8().getText(),
                                    mCenterViewController.getAtt2ALH8().getText(),
                                    mCenterViewController.getAtt3ALH8().getText(),
                                    mCenterViewController.getAtt1VALH8().getText(),
                                    mCenterViewController.getAtt2VALH8().getText(),
                                    mCenterViewController.getAtt3VALH8().getText(),
                                    giveDmg(mCenterViewController.getDmgLH8())));
                            mCenterViewController.getNameLH9().setText(deck.getH10());
                            fillHeroData(deck.getH10(), mCenterViewController.getDmgLH9(),
                                    mCenterViewController.getItemSWLH9(), mCenterViewController.getItemQWLH9(),
                                    mCenterViewController.getAtt1WLH9(), mCenterViewController.getAtt1VWLH9(),
                                    mCenterViewController.getAtt2WLH9(), mCenterViewController.getAtt2VWLH9(),
                                    mCenterViewController.getAtt3WLH9(), mCenterViewController.getAtt3VWLH9(),
                                    mCenterViewController.getItemSALH9(), mCenterViewController.getItemQALH9(),
                                    mCenterViewController.getAtt1ALH9(), mCenterViewController.getAtt2ALH9(),
                                    mCenterViewController.getAtt3ALH9(), mCenterViewController.getAtt1VALH9(),
                                    mCenterViewController.getAtt2VALH9(), mCenterViewController.getAtt3VALH9(),
                                    mCenterViewController.getLvlVLH9(), mCenterViewController.getLvlPVLH9(),
                                    mCenterViewController.getCdVLH9(), mCenterViewController.getManaVLH9(),
                                    mCenterViewController.getAmVLH9(), mCenterViewController.getAmLH9());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH9().getText(),
                                    mCenterViewController.getLvlVLH9().getText(),
                                    mCenterViewController.getLvlPVLH9().getText(),
                                    mCenterViewController.getAtt1WLH9().getText(),
                                    mCenterViewController.getAtt2WLH9().getText(),
                                    mCenterViewController.getAtt3WLH9().getText(),
                                    mCenterViewController.getAtt1VWLH9().getText(),
                                    mCenterViewController.getAtt2VWLH9().getText(),
                                    mCenterViewController.getAtt3VWLH9().getText(),
                                    mCenterViewController.getAtt1ALH9().getText(),
                                    mCenterViewController.getAtt2ALH9().getText(),
                                    mCenterViewController.getAtt3ALH9().getText(),
                                    mCenterViewController.getAtt1VALH9().getText(),
                                    mCenterViewController.getAtt2VALH9().getText(),
                                    mCenterViewController.getAtt3VALH9().getText(),
                                    giveDmg(mCenterViewController.getDmgLH9())));
                            mCenterViewController.getNameLH10().setText(deck.getH11());
                            fillHeroData(deck.getH11(), mCenterViewController.getDmgLH10(),
                                    mCenterViewController.getItemSWLH10(), mCenterViewController.getItemQWLH10(),
                                    mCenterViewController.getAtt1WLH10(), mCenterViewController.getAtt1VWLH10(),
                                    mCenterViewController.getAtt2WLH10(), mCenterViewController.getAtt2VWLH10(),
                                    mCenterViewController.getAtt3WLH10(), mCenterViewController.getAtt3VWLH10(),
                                    mCenterViewController.getItemSALH10(), mCenterViewController.getItemQALH10(),
                                    mCenterViewController.getAtt1ALH10(), mCenterViewController.getAtt2ALH10(),
                                    mCenterViewController.getAtt3ALH10(), mCenterViewController.getAtt1VALH10(),
                                    mCenterViewController.getAtt2VALH10(), mCenterViewController.getAtt3VALH10(),
                                    mCenterViewController.getLvlVLH10(), mCenterViewController.getLvlPVLH10(),
                                    mCenterViewController.getCdVLH10(), mCenterViewController.getManaVLH10(),
                                    mCenterViewController.getAmVLH10(), mCenterViewController.getAmLH10());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH10().getText(),
                                    mCenterViewController.getLvlVLH10().getText(),
                                    mCenterViewController.getLvlPVLH10().getText(),
                                    mCenterViewController.getAtt1WLH10().getText(),
                                    mCenterViewController.getAtt2WLH10().getText(),
                                    mCenterViewController.getAtt3WLH10().getText(),
                                    mCenterViewController.getAtt1VWLH10().getText(),
                                    mCenterViewController.getAtt2VWLH10().getText(),
                                    mCenterViewController.getAtt3VWLH10().getText(),
                                    mCenterViewController.getAtt1ALH10().getText(),
                                    mCenterViewController.getAtt2ALH10().getText(),
                                    mCenterViewController.getAtt3ALH10().getText(),
                                    mCenterViewController.getAtt1VALH10().getText(),
                                    mCenterViewController.getAtt2VALH10().getText(),
                                    mCenterViewController.getAtt3VALH10().getText(),
                                    giveDmg(mCenterViewController.getDmgLH10())));
                            mCenterViewController.getNameLH11().setText(deck.getH12());
                            fillHeroData(deck.getH12(), mCenterViewController.getDmgLH11(),
                                    mCenterViewController.getItemSWLH11(), mCenterViewController.getItemQWLH11(),
                                    mCenterViewController.getAtt1WLH11(), mCenterViewController.getAtt1VWLH11(),
                                    mCenterViewController.getAtt2WLH11(), mCenterViewController.getAtt2VWLH11(),
                                    mCenterViewController.getAtt3WLH11(), mCenterViewController.getAtt3VWLH11(),
                                    mCenterViewController.getItemSALH11(), mCenterViewController.getItemQALH11(),
                                    mCenterViewController.getAtt1ALH11(), mCenterViewController.getAtt2ALH11(),
                                    mCenterViewController.getAtt3ALH11(), mCenterViewController.getAtt1VALH11(),
                                    mCenterViewController.getAtt2VALH11(), mCenterViewController.getAtt3VALH11(),
                                    mCenterViewController.getLvlVLH11(), mCenterViewController.getLvlPVLH11(),
                                    mCenterViewController.getCdVLH11(), mCenterViewController.getManaVLH11(),
                                    mCenterViewController.getAmVLH11(), mCenterViewController.getAmLH11());
                            selectedGold.add(new Gold(mCenterViewController.getNameLH11().getText(),
                                    mCenterViewController.getLvlVLH11().getText(),
                                    mCenterViewController.getLvlPVLH11().getText(),
                                    mCenterViewController.getAtt1WLH11().getText(),
                                    mCenterViewController.getAtt2WLH11().getText(),
                                    mCenterViewController.getAtt3WLH11().getText(),
                                    mCenterViewController.getAtt1VWLH11().getText(),
                                    mCenterViewController.getAtt2VWLH11().getText(),
                                    mCenterViewController.getAtt3VWLH11().getText(),
                                    mCenterViewController.getAtt1ALH11().getText(),
                                    mCenterViewController.getAtt2ALH11().getText(),
                                    mCenterViewController.getAtt3ALH11().getText(),
                                    mCenterViewController.getAtt1VALH11().getText(),
                                    mCenterViewController.getAtt2VALH11().getText(),
                                    mCenterViewController.getAtt3VALH11().getText(),
                                    giveDmg(mCenterViewController.getDmgLH11())));
                            fillGoldCalc();
                        }
                    }
                });
        btnListener();
    }

    private void btnListener() {
        GameObjectConstructor goc = new GameObjectConstructor();
        btn = mCenterViewController.getCalcBtn();
        btn.setOnAction(event -> {
            for (Gold g : populateTabGoldcalc.getmTableView().getItems()) {
                try {
                    g.getFutDmgL().setText(
                            dmgHero(g.getNameL().getText(), g.getWantedL().getText(), g.getLevelPS(), g.getwAtt1(), g.getwAttV1(), g.getwAtt2(), g.getwAttV2(), g.getwAtt3(), g.getwAttV3(),
                                    g.getaAtt1(), g.getaAttV1(), g.getaAtt2(), g.getaAttV2(), g.getaAtt3(), g.getaAttV3(), goc.Label(),
                                    goc.Label()
                            ).substring(5));
                    g.getDmgDiff().setText(dmgDiff(g.getFutDmgL().getText(), g.getDmgL().getText()));
                    g.getTotalCost().setText(
                            totalUpgCost(g.getNameL().getText(), g.getLevelL().getText(), g.getWantedL().getText(), g.getUpgCost().getText()));
                    g.getGoldPerDmg().setText(goldPerDmg(g.getTotalCost().getText(), g.getDmgDiff().getText()));
                } catch (Exception e) {
                }
            }
        });
    }

    private String dmgDiff(String l, String s) {
        return String.valueOf(df.format(Double.parseDouble(l) - Double.parseDouble(s)));
    }

    private String goldPerDmg(String s, String s1) {
        s = s.replaceAll(",", "");
        BigDecimal bd = new BigDecimal(Double.parseDouble(s) / Double.parseDouble(s1));
        NumberFormat nf = NumberFormat.getInstance(new Locale("en_US"));
        return nf.format(bd.longValue());
    }

    private String totalUpgCost(String name, String lvl, String wlvl, String upgCost) {
        Double fixCost;
        if (name.equals("Bow Master") || name.equals("Ranger") || name.equals("Dark Bow Master") || name.equals(
                "Dark Ranger") || name.equals("Lightning Wizard") || name.equals("Lightning Sorcerer") || name.equals(
                "Dark Lightning Wizard") || name.equals("Dark Lightning Sorcerer") || name.equals(
                "Fire Wizard") || name.equals("Fire Sorcerer") || name.equals("Dark Fire Wizard") || name.equals(
                "Dark Fire Sorcerer") || name.equals("Deep Assassin") || name.equals("Dark Assassin")) {
            fixCost = 5500.0;
        } else {
            if (name.equals("Edward") || name.equals("Solar") || name.equals("Zero") || name.equals(
                    "Thor") || name.equals("Sara") || name.equals("Tony") || name.equals("Din")) {
                fixCost = 11000.0;
            } else {
                fixCost = 6500.0;
            }
        }
        Double lvlrange;
        Double finalCost;
        lvlrange = Double.parseDouble(wlvl) - Double.parseDouble(lvl);
        Double upgCostd = Double.parseDouble(upgCost);
        finalCost = lvlrange * ((fixCost / 2) * (lvlrange - 1.0) + upgCostd);
        BigDecimal bd = new BigDecimal(finalCost);
        NumberFormat nf = NumberFormat.getInstance(new Locale("en_US"));
        return nf.format(bd.longValue());
    }

    private void fillGoldCalc() {
        GameObjectConstructor goc = new GameObjectConstructor();
        DecimalFormat df = new DecimalFormat("#");
        goldTableItems.clear();
        for (Gold g : selectedGold) {
            if (g.getDmg().equals("0")) {
            } else {
                goldTableItems.add(new Gold(goc.Label(g.getNameS()), goc.Label(String.valueOf(
                        df.format(Double.parseDouble(g.getLevelS()) + Double.parseDouble(g.getLevelPS())))),
                        goc.Label(g.getDmg()), goc.loadLevelTextField(String.valueOf(
                        df.format(Double.parseDouble(g.getLevelS()) + Double.parseDouble(g.getLevelPS())))),
                        goc.levelTextField(), goc.Label(), goc.Label(), goc.Label(), goc.Label(),
                        g.getwAtt1(), g.getwAtt2(), g.getwAtt3(), g.getwAttV1(), g.getwAttV2(),
                        g.getwAttV3(), g.getaAtt1(), g.getaAtt2(), g.getaAtt3(), g.getaAttV1(),
                        g.getaAttV2(), g.getaAttV3(), "0"
                ));
            }
            populateTabGoldcalc.getmTableView().setItems(goldTableItems);
        }
    }

    private String giveDmg(Label l) {
        try {
            String s = l.getText();
            s = s.substring(5);
            return s;
        } catch (Exception npe) {
            return "0";
        }
    }

    private void findValuesTb(String s) {
        if (s.equals("Forge")) {
            vk.setHp(vk.getHp() + 0.1);
        }
        if (s.equals("Mana Henge")) {
            vk.setManaRec(vk.getManaRec() + 0.2);
        }
        if (s.equals("Archer Guild")) {
            vk.setArcherDmg(vk.getArcherDmg() + 0.3);
        }
        if (s.equals("Hero Guild")) {
            vk.setTbDmg(vk.getTbDmg() + 0.3);
        }
        if (s.equals("Mine")) {
            vk.setGoldBonus(vk.getGoldBonus() + 0.1);
        }
        if (s.equals("Tower")) {
            vk.setTowerDmg(vk.getTowerDmg() + 0.2);
        }
        if (s.equals("Spring Water")) {
            vk.setCdr(vk.getCdr() + 0.15);
        }
        if (s.equals("Bar")) {
            vk.setHumanSummonDmg(vk.getHumanSummonDmg() - 0.25);
            vk.setHumanSummons(vk.getHumanSummons() + 2.0);
        }
    }

    private void findValuesTwr(String s) {
        if (s.equals("Trophy")) {
            vk.setGoldBonus(vk.getGoldBonus() + 0.35);
        }
    }

    private void findValuesTreasures(String s) {
        if (s.equals("Red Potion")) {
            vk.setFinalHP(vk.getFinalHP() + 300);
        }
        if (s.equals("Blue Potion")) {
            vk.setFinalMP(vk.getFinalMP() + 300);
        }
        if (s.equals("Bronze Piece")) {
            vk.setGoldBonus(vk.getGoldBonus() + 0.13);
        }
        if (s.equals("Broken Shield")) {
            vk.setDefense(vk.getDefense() + 0.13);
        }
        if (s.equals("Web")) {
            vk.setSiegeDef(vk.getSiegeDef() + 0.4);
        }
        if (s.equals("Bottomless Red Potion")) {
            vk.setHp(vk.getHp() + 0.2);
        }
        if (s.equals("Power Glove")) {
            vk.setTreasureDmg(vk.getTreasureDmg() + 0.15);
        }
        //TODO import rest of treasures
    }

    private void findValuesTreasuresWeapons(String s) {
        if (s.equals("Sling")) {
            archerDmg = archerDmg + 25.0;
        }
        if (s.equals("Thorn Bow")) {
            archerDmg = archerDmg + 30.0;
            archerCrit = archerCrit + 10.0;
            heroCrit = heroCrit + 5.0;
        }
        if (s.equals("Flame Bow")) {
            archerDmg = archerDmg + 60.0;
            //TODO Objekt Townarcher Level;Dmg;Element;
        }
        if (s.equals("Frozen Bow")) {
        }
        if (s.equals("Cursed Knife")) {
            archerCrit = archerCrit + 60.0;
            archerDmg = archerDmg + 10.0;
            archerAS = archerAS + 10.0;
        }
        if (s.equals("Poison Bow")) {
        }
    }

    private void fillHeroData(String s, Label dmgHero, Label wItemS, Label wItemQ, Label wAtt1, Label wAtt1v, Label wAtt2, Label wAtt2v, Label wAtt3, Label wAtt3v, Label aItemS, Label aItemQ, Label aAtt1, Label aAtt2, Label aAtt3, Label aAtt1v, Label aAtt2v, Label aAtt3v, Label herolvl, Label heroplvl, Label cd, Label manal, Label attackMode, Label amName) {
        wItemS.setText("");
        wItemQ.setText("");
        wAtt1.setText("");
        wAtt1v.setText("");
        wAtt2.setText("");
        wAtt2v.setText("");
        wAtt3.setText("");
        wAtt3v.setText("");
        aAtt1.setText("");
        aAtt1v.setText("");
        aAtt2.setText("");
        aAtt2v.setText("");
        aAtt3.setText("");
        aAtt3v.setText("");
        cd.setText("");
        manal.setText("");
        aItemS.setText("");
        aItemQ.setText("");
        amName.setText("");
        attackMode.setText("");
        for (Hero h : mUHeroList) {
            if (s.equals(h.getPromotion().getSelectionModel().getSelectedItem().toString())) {
                herolvl.setText(h.getLevel().getText());
                heroplvl.setText("");
                for (Item i : mWeaponList) {
                    try {
                        if (h.getWeapon().getSelectionModel().getSelectedItem().toString().equals(i.getItemName())) {
                            wItemS.setText(i.getSortOfItem());
                            wItemQ.setText(i.getItemQuality());
                            wAtt1.setText(i.getAttribute1());
                            wAtt2.setText(i.getAttribute2());
                            wAtt3.setText(i.getAttribute3());
                            wAtt1v.setText(i.getAttribute1Value().toString());
                            wAtt2v.setText(i.getAttribute2Value().toString());
                            wAtt3v.setText(i.getAttribute3Value().toString());
                        }
                    } catch (NullPointerException npe) {
                    }
                }
                for (Item i : mAccessoryList) {
                    try {
                        if (h.getAccessory().getSelectionModel().getSelectedItem().toString().equals(i.getItemName())) {
                            aItemS.setText(i.getSortOfItem());
                            aItemQ.setText(i.getItemQuality());
                            aAtt1.setText(i.getAttribute1());
                            aAtt2.setText(i.getAttribute2());
                            aAtt3.setText(i.getAttribute3());
                            aAtt1v.setText(i.getAttribute1Value().toString());
                            aAtt2v.setText(i.getAttribute2Value().toString());
                            aAtt3v.setText(i.getAttribute3Value().toString());
                        }
                    } catch (NullPointerException npe) {
                    }
                }
            }
        }
        for (Hero h : mHeroList) {
            if (s.equals(h.getPromotion().getSelectionModel().getSelectedItem().toString())) {
                herolvl.setText(h.getLevel().getText());
                heroplvl.setText(h.getLevelPrestige().getText());
                amName.setText("Attackmode");
                attackMode.setText(h.getAttackMode().getSelectionModel().getSelectedItem().toString());
                for (Item i : mWeaponList) {
                    try {
                        if (h.getWeapon().getSelectionModel().getSelectedItem().toString().equals(i.getItemName())) {
                            wItemS.setText(i.getSortOfItem());
                            wItemQ.setText(i.getItemQuality());
                            wAtt1.setText(i.getAttribute1());
                            wAtt2.setText(i.getAttribute2());
                            wAtt3.setText(i.getAttribute3());
                            wAtt1v.setText(i.getAttribute1Value().toString());
                            wAtt2v.setText(i.getAttribute2Value().toString());
                            wAtt3v.setText(i.getAttribute3Value().toString());
                        }
                    } catch (NullPointerException npe) {
                    }
                }
                for (Item i : mAccessoryList) {
                    try {
                        if (h.getAccessory().getSelectionModel().getSelectedItem().toString().equals(i.getItemName())) {
                            aItemS.setText(i.getSortOfItem());
                            aItemQ.setText(i.getItemQuality());
                            aAtt1.setText(i.getAttribute1());
                            aAtt2.setText(i.getAttribute2());
                            aAtt3.setText(i.getAttribute3());
                            aAtt1v.setText(i.getAttribute1Value().toString());
                            aAtt2v.setText(i.getAttribute2Value().toString());
                            aAtt3v.setText(i.getAttribute3Value().toString());
                        }
                    } catch (NullPointerException npe) {
                    }
                }
            }
        }
        dmgHero.setText(
                dmgHero(s, herolvl.getText(), heroplvl.getText(), wAtt1.getText(), wAtt1v.getText(), wAtt2.getText(),
                        wAtt2v.getText(), wAtt3.getText(), wAtt3v.getText(), aAtt1.getText(), aAtt1v.getText(),
                        aAtt2.getText(), aAtt2v.getText(), aAtt3.getText(), aAtt3v.getText(), cd, manal));
    }

    private String dmgHero(String hero, String lvl, String lvlP, String wAtt1, String wAtt1v, String wAtt2, String wAtt2v, String wAtt3, String wAtt3v, String aAtt1, String aAtt1v, String aAtt2, String aAtt2v, String aAtt3, String aAtt3v, Label cdL, Label manaCost) {
        String finaldmg = "";
        Double baseManaCost = 1.0;
        Double cdBaseValue = 30.0;
        if (hero.equals("Dark Ranger") || hero.equals("Ranger") || hero.equals("Bow Master") || hero.equals(
                "Dark Bow Master")) {
            finaldmg = finalDMG(20.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Monster Hunter") || hero.equals("Dark Hunter")) {
            finaldmg = finalDMG(10.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Cross Hunter") || hero.equals("Sniper")) {
            finaldmg = finalDMG(15.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Deep Elf") || hero.equals("Dark Elf")) {
            finaldmg = finalDMG(5.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("High Elf") || hero.equals("White Elf")) {
            finaldmg = finalDMG(7.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Ice Wizard") || hero.equals("Dark Ice Wizard")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Ice Sorcerer") || hero.equals("Dark Ice Sorcerer")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Lightning Wizard") || hero.equals("Dark Lightning Wizard") || hero.equals(
                "Lightning Sorcerer") || hero.equals("Dark Lightning Sorcerer")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("LightningDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Fire Wizard") || hero.equals("Dark Fire Wizard") || hero.equals(
                "Fire Sorcerer") || hero.equals("Dark Fire Sorcerer")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Fire Ogre") || hero.equals("Flame Ogre")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Hammer Ogre") || hero.equals("Giant Ogre")) {
            finaldmg = finalDMG(10.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Stone Giant") || hero.equals("Stone Giant II") || hero.equals("Mad Giant") || hero.equals(
                "Mad Giant II")) {
            finaldmg = finalDMG(15.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Spear Slinger")) {
            finaldmg = finalDMG(15.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Poison Slinger")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("PoisonDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Poison Voodoo") || hero.equals("Venom Voodoo") || hero.equals("String Voodoo") || hero.equals(
                "String Voodoo II")) {
            finaldmg = finalDMG(5.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("PoisonDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Rambo") || hero.equals("Mechanic Rambo II") || hero.equals("Rocket Man") || hero.equals(
                "Rocket Man II")) {
            finaldmg = finalDMG(5.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Holy Knight") || hero.equals("Paladin") || hero.equals("Barbarian")) { // split ice/fire/normal
            finaldmg = finalDMG(10.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Fire Barbarian")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Ice Barbarian")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Lisa Fire I") || hero.equals("Lisa Fire II")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Lisa Ice I") || hero.equals("Lisa Ice II")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Lisa Poison I") || hero.equals("Lisa Poison II")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("PoisonDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Alice Fire I") || hero.equals("Alice Fire II")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Alice Ice I") || hero.equals("Alice Ice II")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Alice Poison I") || hero.equals("Alice Poison II")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("PoisonDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Dorothy Fire I") || hero.equals("Dorothy Fire II")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Dorothy Ice I") || hero.equals("Dorothy Ice II")) {
            finaldmg = finalDMG(7.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Dorothy Poison I") || hero.equals("Dorothy Poison II")) {
            finaldmg = finalDMG(7.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("PoisonDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Wolf Druid") || hero.equals("Wolf Druid II") || hero.equals("Hawk Druid") || hero.equals(
                "Hawk Druid II")) {
            finaldmg = finalDMG(15.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Dark Assassin") || hero.equals("Deep Assassin")) {
            finaldmg = finalDMG(15.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Fire Flying Orc")) {
            finaldmg = finalDMG(20.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Ice Flying Orc")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Poison Flying Orc")) {
            finaldmg = finalDMG(15.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("PoisonDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Fire Windy")) {
            finaldmg = finalDMG(12.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("FireDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Ice Windy")) {
            finaldmg = finalDMG(10.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("N/A")) {
            finaldmg = finalDMG(10.0, 0.0, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("CD Zeus I") || hero.equals("CD Zeus II")) {
            finaldmg = finalDMG(75.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("LightningDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Slow Zeus I") || hero.equals("Slow Zeus II")) {
            finaldmg = finalDMG(50.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("LightningDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        if (hero.equals("Zero")) {
            finaldmg = finalDMG(40.0, 0.1, lvl,
                    itemAttDmg("Damage", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v) + itemAttDmg("ColdDamage", wAtt1, wAtt1v, wAtt2,
                            wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v,
                            aAtt2, aAtt2v, aAtt3, aAtt3v),
                    baseDmg("DamagePlus", wAtt1, wAtt1v, wAtt2, wAtt2v, wAtt3, wAtt3v, aAtt1, aAtt1v, aAtt2,
                            aAtt2v, aAtt3, aAtt3v));
        }
        //dmg leader
        DecimalFormat df = new DecimalFormat("#");
        manaCost.setText(String.valueOf(df.format(Double.parseDouble(lvl) * baseManaCost)));
        cdL.setText(String.valueOf(df.format(cdBaseValue)));
        return finaldmg;
    }

    private String finalDMG(Double dmgOnLvl1, Double skillAttDmg, String lvl, Double itemValue, Double dmgPlus) {
        DecimalFormat df = new DecimalFormat("#");
        // Double baseDmg = (dmgOnLvl1 * (1 + Double.parseDouble(lvl) * 0.1));
        // Double finalDmg = (baseDmg + baseDmg * itemValue) * (1 + skillAttDmg) * (1 + vk.getSkillDmg() * (1 + vk.getTbDmg()) * (1 + 0.5) * (1 + vk.getTreasureDmg()));
        Double finalDmg = (dmgOnLvl1 * (1 + Double.parseDouble(
                lvl) * 0.1) + dmgPlus) * (1 + vk.getSkillDmg()) * (1 + vk.getTbDmg()) * (1 + vk.getTreasureDmg()) * (1 + skillAttDmg) * (1 + itemValue);
        //System.out.println(
        //       "(" + baseDmg + "+" + baseDmg + "*" + itemValue + ")*(1+" + skillAttDmg + ")*(1+" + vk.getSkillDmg() + ")*(1+" + vk.getTbDmg() + ")*(1+" + vk.getTreasureDmg() + ")=" + finalDmg);
        return "Dmg~: " + String.valueOf(df.format(finalDmg));
    }

    private String twrCCDmg(String name, String lvl, String lvlP) {
        DecimalFormat df = new DecimalFormat("#");
        Double dmgOnLvl1 = 0.0;
        Double skillAtt = 0.0;
        if (name.equals("Death Worm") || name.equals("Death Worm II")) {
            dmgOnLvl1 = 100.0;
        }
        if (name.equals("Burning Tower") || name.equals("Burning Tower II") || name.equals("Flame Tower")) {
            dmgOnLvl1 = 100.0;
            skillAtt = 0.1;
        }
        if (name.equals("Frozen Tower") || name.equals("Frozen Tower II")) {
            dmgOnLvl1 = 5.0;
            skillAtt = 0.1;
        }
        if (name.equals("Thunder Tower") || name.equals("Thunder Tower II") || name.equals("Lightning Tower")) {
            dmgOnLvl1 = 40.0;
            skillAtt = 0.1;
        }
        if (name.equals("Cannon")) {
            dmgOnLvl1 = 40.0;
            skillAtt = 0.1;
        }
        if (name.equals("Thorn Worm")) {
            dmgOnLvl1 = 30.0;
        }
        if (name.equals("Offensive Barracks") || name.equals("Defensive Barracks") || name.equals("Barracks")) {
            dmgOnLvl1 = 40.0;
        }
        if (name.equals("Turret")) {
            dmgOnLvl1 = 30.0;
        }
        if (name.equals("Cannon Castle")) {
            dmgOnLvl1 = 44.0;
            skillAtt = 0.1;
        }
        if (name.equals("Minigun Castle")) {
            dmgOnLvl1 = 33.0;
            skillAtt = 0.0;
        }
        if (name.equals("Poison Castle")) {
            dmgOnLvl1 = 44.0;
            skillAtt = 0.1;
        }
        if (name.equals("Lightning Castle")) {
            dmgOnLvl1 = 33.0;
            skillAtt = 0.1;
        }
        if (name.equals("Ballista Castle")) {
            dmgOnLvl1 = 55.0;
            skillAtt = 0.0;
        }
        if (name.equals("Poison CastleBase")) {
            dmgOnLvl1 = 33.0;
            skillAtt = 0.1;
        }
        Double finalV = (dmgOnLvl1 * (1 + (Double.parseDouble(lvl) + Double.parseDouble(
                lvlP)) * 0.1)) * (1 + skillAtt) * (1 + vk.getTowerDmg());
        return "Dmg~: " + String.valueOf(df.format(finalV));
    }

    private Double baseDmg(String s, String wAtt1, String wAtt1v, String wAtt2, String wAtt2v, String wAtt3, String wAtt3v, String aAtt1, String aAtt1v, String aAtt2, String aAtt2v, String aAtt3, String aAtt3v) {
        Double baseDmg = 0.0;
        try {
            if (wAtt1.equals(s)) {
                baseDmg = baseDmg + Double.parseDouble(wAtt1v);
            }
            if (wAtt2.equals(s)) {
                baseDmg = baseDmg + Double.parseDouble(wAtt2v);
            }
            if (wAtt3.equals(s)) {
                baseDmg = baseDmg + Double.parseDouble(wAtt3v);
            }
            if (aAtt1.equals(s)) {
                baseDmg = baseDmg + Double.parseDouble(aAtt1v);
            }
            if (aAtt2.equals(s)) {
                baseDmg = baseDmg + Double.parseDouble(aAtt2v);
            }
            if (aAtt3.equals(s)) {
                baseDmg = baseDmg + Double.parseDouble(aAtt3v);
            }
            return baseDmg;
        } catch (NullPointerException npe) {
            return baseDmg;
        }
    }

    private Double itemAttDmg(String s, String wAtt1, String wAtt1v, String wAtt2, String wAtt2v, String wAtt3, String wAtt3v, String aAtt1, String aAtt1v, String aAtt2, String aAtt2v, String aAtt3, String aAtt3v) {
        Double itemValue = 0.0;
        try {
            if (wAtt1.equals(s)) {
                itemValue = itemValue + Double.parseDouble(wAtt1v) / 100;
            }
            if (wAtt2.equals(s)) {
                itemValue = itemValue + Double.parseDouble(wAtt2v) / 100;
            }
            if (wAtt3.equals(s)) {
                itemValue = itemValue + Double.parseDouble(wAtt3v) / 100;
            }
            if (aAtt1.equals(s)) {
                itemValue = itemValue + Double.parseDouble(aAtt1v) / 100;
            }
            if (aAtt2.equals(s)) {
                itemValue = itemValue + Double.parseDouble(aAtt2v) / 100;
            }
            if (aAtt3.equals(s)) {
                itemValue = itemValue + Double.parseDouble(aAtt3v) / 100;
            }
            return itemValue;
        } catch (NullPointerException npe) {
            return itemValue;
        }
    }

    private String calcHP(String s) {
        DecimalFormat df = new DecimalFormat("#");
        Double baseHP = 100.0;
        Double incPerLvl = 50.0;
        return String.valueOf(df.format((baseHP + (Double.parseDouble(s) * incPerLvl) * (1 + vk.getHp()))));
    }

    private String calcMP(String s) {
        DecimalFormat df = new DecimalFormat("#");
        Double baseMP = 50.0;
        Double incPerLvl = 10.0;
        return String.valueOf(df.format((baseMP + (Double.parseDouble(s) * incPerLvl) * (1 + vk.getMp()))));
    }

    private void fillOverviewData(Deck deck, Label tb1, Label tb2, Label tb3, Label t1, Label t2, Label t3, Label t4, Label t5, Label twr1, Label twr2, Label twr3, Label twr4, ObservableList<Tower> towers, Label cc1, Label cc2, Label cc3, Label cc4, ObservableList<CastleComponent> castleComponents, Label ldr, ObservableList<Leader> ldrList) {
        tb1.setText(deck.getTownBuilding1());
        tb2.setText(deck.getTownBuilding2());
        tb3.setText(deck.getTownBuilding3());
        t1.setText(deck.getTreasure1());
        t2.setText(deck.getTreasure2());
        t3.setText(deck.getTreasure3());
        t4.setText(deck.getTreasure4());
        t5.setText(deck.getTreasure5());
        twr1.setText(deck.getTower1());
        twr2.setText(deck.getTower2());
        twr3.setText(deck.getTower3());
        twr4.setText(deck.getTower4());
        //TODO dmg calc /cc
        for (Tower twr : towers) {
            try {
                if (deck.getTower1().equals(twr.getName()) || deck.getTower2().equals(
                        twr.getName()) || deck.getTower3().equals(twr.getName()) || deck.getTower4().equals(
                        twr.getName())) {
                    if (deck.getTower1().equals(twr.getName())) {
                        mCenterViewController.getTwrLL().setText(twr.getLevel().getText());
                        mCenterViewController.getTwrAML().setText("");
                        mCenterViewController.getTwrDmgL().setText("");
                        mCenterViewController.getTwrAML().setText(
                                twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                        mCenterViewController.getTwrDmgL().setText(
                                twrCCDmg(twr.getName(), twr.getLevel().getText(), twr.getLevelPrestige().getText()));
                    }
                    if (deck.getTower2().equals(twr.getName())) {
                        mCenterViewController.getTwrLL1().setText(twr.getLevel().getText());
                        mCenterViewController.getTwrAML1().setText("");
                        mCenterViewController.getTwrDmgL1().setText("");
                        mCenterViewController.getTwrAML1().setText(
                                twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                        mCenterViewController.getTwrDmgL1().setText(
                                twrCCDmg(twr.getName(), twr.getLevel().getText(), twr.getLevelPrestige().getText()));
                    }
                    if (deck.getTower3().equals(twr.getName())) {
                        mCenterViewController.getTwrLL2().setText(twr.getLevel().getText());
                        mCenterViewController.getTwrAML2().setText("");
                        mCenterViewController.getTwrDmgL2().setText("");
                        mCenterViewController.getTwrAML2().setText(
                                twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                        mCenterViewController.getTwrDmgL2().setText(
                                twrCCDmg(twr.getName(), twr.getLevel().getText(), twr.getLevelPrestige().getText()));
                    }
                    if (deck.getTower4().equals(twr.getName())) {
                        mCenterViewController.getTwrLL3().setText(twr.getLevel().getText());
                        mCenterViewController.getTwrAML3().setText("");
                        mCenterViewController.getTwrDmgL3().setText("");
                        mCenterViewController.getTwrAML3().setText(
                                twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                        mCenterViewController.getTwrDmgL3().setText(
                                twrCCDmg(twr.getName(), twr.getLevel().getText(), twr.getLevelPrestige().getText()));
                    }
                } else {
                    if (deck.getTower1().equals(
                            twr.getPromotion().getSelectionModel().getSelectedItem()) || deck.getTower2().equals(
                            twr.getPromotion().getSelectionModel().getSelectedItem()) || deck.getTower3().equals(
                            twr.getPromotion().getSelectionModel().getSelectedItem()) || deck.getTower4().equals(
                            twr.getPromotion().getSelectionModel().getSelectedItem())) {
                        if (deck.getTower1().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                            mCenterViewController.getTwrLL().setText(twr.getLevel().getText());
                            mCenterViewController.getTwrAML().setText("");
                            mCenterViewController.getTwrDmgL().setText("");
                            mCenterViewController.getTwrAML().setText(
                                    twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                            mCenterViewController.getTwrDmgL().setText(twrCCDmg(twr.getName(), twr.getLevel().getText(),
                                    twr.getLevelPrestige().getText()));
                        }
                        if (deck.getTower2().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                            mCenterViewController.getTwrLL1().setText(twr.getLevel().getText());
                            mCenterViewController.getTwrAML1().setText("");
                            mCenterViewController.getTwrDmgL1().setText("");
                            mCenterViewController.getTwrAML1().setText(
                                    twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                            mCenterViewController.getTwrDmgL1().setText(
                                    twrCCDmg(twr.getName(), twr.getLevel().getText(),
                                            twr.getLevelPrestige().getText()));
                        }
                        if (deck.getTower3().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                            mCenterViewController.getTwrLL2().setText(twr.getLevel().getText());
                            mCenterViewController.getTwrAML2().setText("");
                            mCenterViewController.getTwrDmgL2().setText("");
                            mCenterViewController.getTwrAML2().setText(
                                    twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                            mCenterViewController.getTwrDmgL2().setText(
                                    twrCCDmg(twr.getName(), twr.getLevel().getText(),
                                            twr.getLevelPrestige().getText()));
                        }
                        if (deck.getTower4().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                            mCenterViewController.getTwrLL3().setText(twr.getLevel().getText());
                            mCenterViewController.getTwrAML3().setText("");
                            mCenterViewController.getTwrDmgL3().setText("");
                            mCenterViewController.getTwrAML3().setText(
                                    twr.getAttackMode().getSelectionModel().getSelectedItem().toString());
                            mCenterViewController.getTwrDmgL3().setText(
                                    twrCCDmg(twr.getName(), twr.getLevel().getText(),
                                            twr.getLevelPrestige().getText()));
                        }
                    }
                }
            } catch (NullPointerException npe) {
            }
        }
        cc1.setText(deck.getCC1());
        cc2.setText(deck.getCC2());
        cc3.setText(deck.getCC3());
        cc4.setText(deck.getCC4());
        for (CastleComponent cc : castleComponents) {
            try {
                if (deck.getCC1().equals(cc.getCcName())) {
                    mCenterViewController.getCcLL().setText(cc.getCcLevel().getText());
                    mCenterViewController.getCcAML().setText("");
                    mCenterViewController.getCcDmgL().setText("");
                    mCenterViewController.getCcAML().setText(
                            cc.getCcAM().getSelectionModel().getSelectedItem().toString());
                    mCenterViewController.getCcDmgL().setText(
                            twrCCDmg(cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText()));
                }
                if (deck.getCC2().equals(cc.getCcName())) {
                    mCenterViewController.getCcLL1().setText(cc.getCcLevel().getText());
                    mCenterViewController.getCcAML1().setText("");
                    mCenterViewController.getCcDmgL1().setText("");
                    mCenterViewController.getCcAML1().setText(
                            cc.getCcAM().getSelectionModel().getSelectedItem().toString());
                    mCenterViewController.getCcDmgL1().setText(
                            twrCCDmg(cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText()));
                }
                if (deck.getCC3().equals(cc.getCcName())) {
                    mCenterViewController.getCcLL2().setText(cc.getCcLevel().getText());
                    mCenterViewController.getCcAML2().setText("");
                    mCenterViewController.getCcDmgL2().setText("");
                    mCenterViewController.getCcAML2().setText(
                            cc.getCcAM().getSelectionModel().getSelectedItem().toString());
                    mCenterViewController.getCcDmgL2().setText(
                            twrCCDmg(cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText()));
                }
                if (deck.getCC4().equals(cc.getCcName())) {
                    mCenterViewController.getCcLL3().setText(cc.getCcLevel().getText());
                    mCenterViewController.getCcAML3().setText("");
                    mCenterViewController.getCcDmgL3().setText("");
                    mCenterViewController.getCcAML3().setText(
                            cc.getCcAM().getSelectionModel().getSelectedItem().toString());
                    mCenterViewController.getCcDmgL3().setText(
                            twrCCDmg(cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText()));
                }
            } catch (NullPointerException npe) {
            }
        }
        ldr.setText(deck.getLeader());
        String wAtt1 = "";
        String wAtt2 = "";
        String wAtt3 = "";
        String wAttV1 = "";
        String wAttV2 = "";
        String wAttV3 = "";
        String aAtt1 = "";
        String aAtt2 = "";
        String aAtt3 = "";
        String aAttV1 = "";
        String aAttV2 = "";
        String aAttV3 = "";
        Label cd = new Label("");
        Label manal = new Label("");
        for (Leader ldrs : ldrList) {
            if (deck.getLeader().equals(ldrs.getName())) {
                mCenterViewController.getLdrL().setText(ldrs.getName());
                mCenterViewController.getLdrLvlL().setText(ldrs.getLevel().getText());
                mCenterViewController.getLdrAML().setText(
                        ldrs.getAttackMode().getSelectionModel().getSelectedItem().toString());
                mCenterViewController.getLdrwAtt1().setText("");
                mCenterViewController.getLdrwAtt2().setText("");
                mCenterViewController.getLdrwAtt3().setText("");
                mCenterViewController.getLdraAtt1().setText("");
                mCenterViewController.getLdraAtt2().setText("");
                mCenterViewController.getLdraAtt3().setText("");
                for (Item i : mWeaponList) {
                    try {
                        if (ldrs.getWeapon().getSelectionModel().getSelectedItem().toString().equals(i.getItemName())) {
                            //  wItemS.setText(i.getSortOfItem());
                            //    wItemQ.setText(i.getItemQuality());
                            mCenterViewController.getLdrwAtt1().setText(
                                    i.getAttribute1() + "  " + i.getAttribute1Value().toString());
                            mCenterViewController.getLdrwAtt2().setText(
                                    i.getAttribute2() + "  " + i.getAttribute2Value().toString());
                            mCenterViewController.getLdrwAtt3().setText(
                                    i.getAttribute3() + "  " + i.getAttribute3Value().toString());
                            wAtt1 = i.getAttribute1();
                            wAtt2 = (i.getAttribute2());
                            wAtt3 = (i.getAttribute3());
                            wAttV1 = (i.getAttribute1Value().toString());
                            wAttV2 = (i.getAttribute2Value().toString());
                            wAttV3 = (i.getAttribute3Value().toString());
                        }
                    } catch (NullPointerException npe) {
                    }
                }
                for (Item i : mAccessoryList) {
                    try {
                        if (ldrs.getAccessory().getSelectionModel().getSelectedItem().toString().equals(
                                i.getItemName())) {
                            //aItemS.setText(i.getSortOfItem());
                            // aItemQ.setText(i.getItemQuality());
                            mCenterViewController.getLdraAtt1().setText(
                                    i.getAttribute1() + "  " + i.getAttribute1Value().toString());
                            mCenterViewController.getLdraAtt2().setText(
                                    i.getAttribute2() + "  " + i.getAttribute2Value().toString());
                            mCenterViewController.getLdraAtt3().setText(
                                    i.getAttribute3() + "  " + i.getAttribute3Value().toString());
                            aAtt1 = (i.getAttribute1());
                            aAtt2 = (i.getAttribute2());
                            aAtt3 = (i.getAttribute3());
                            aAttV1 = (i.getAttribute1Value().toString());
                            aAttV2 = (i.getAttribute2Value().toString());
                            aAttV3 = (i.getAttribute3Value().toString());
                        }
                    } catch (NullPointerException npe) {
                    }
                }
                mCenterViewController.getLdrDmgL().setText(
                        dmgHero(ldrs.getName(), ldrs.getLevel().getText(), ldrs.getLevelPrestige().getText(), wAtt1,
                                wAttV1, wAtt2, wAttV2, wAtt3, wAttV3, aAtt1, aAttV1, aAtt2, aAttV2, aAtt3, aAttV3, cd,
                                manal));
            }
        }
    }
}
