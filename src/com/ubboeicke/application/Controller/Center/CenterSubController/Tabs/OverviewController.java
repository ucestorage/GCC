package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

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
    private CenterViewController mCenterViewController;

    public OverviewController(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;


    }
//TODO Methode die date ndes helden in overview befüllt, alle label mitgeben die geändert werden sollen, dann if abfragen wegen änderung
    public void fillHeroData(String s, Label wItemS, Label wItemQ, Label wAtt1, Label wAtt1v, Label wAtt2, Label wAtt2v, Label wAtt3, Label wAtt3v,Label aItemS,Label aItemQ, Label aAtt1,Label aAtt2,Label aAtt3, Label aAtt1v, Label aAtt2v, Label aAtt3v, Label herolvl, Label heroplvl) {
        for (Hero h :mUHeroList){
            if (s.equals(h.getPromotion().getSelectionModel().getSelectedItem().toString())) {
                herolvl.setText(h.getLevel().getText());
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
                if (wAtt2v.getText().equals("Att#2 Value")) {
                    wAtt2v.setText("");
                }
                if (aAtt2v.getText().equals("Att#2 Value")) {
                    aAtt2v.setText("");
                }
                if (wAtt3v.getText().equals("Att#3 Value")) {
                    wAtt3v.setText("");
                }
                if (aAtt3v.getText().equals("Att#3 Value")) {
                    aAtt3v.setText("");
                }
            }
        }
        for (Hero h : mHeroList) {
            if (s.equals(h.getPromotion().getSelectionModel().getSelectedItem().toString())) {
                herolvl.setText(h.getLevel().getText());
                heroplvl.setText(h.getLevelPrestige().getText());
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
                if (wAtt2v.getText().equals("Att#2 Value")) {
                    wAtt2v.setText("");
                }
                if (aAtt2v.getText().equals("Att#2 Value")) {
                    aAtt2v.setText("");
                }
                if (wAtt3v.getText().equals("Att#3 Value")) {
                    wAtt3v.setText("");
                }
                if (aAtt3v.getText().equals("Att#3 Value")) {
                    aAtt3v.setText("");
                }
            }
                String lvl = h.getLevel().getText();

                Integer i = Integer.parseInt(lvl);
                Double d = i * 3.5; //TODO get hero dmg multiplier; calculate items
                String calc = d.toString();
                Integer integer = i * 10;
                String mana = integer.toString();
                mCenterViewController.getH1CDL().setText("30");
                mCenterViewController.getH1ManaL().setText(mana);
                mCenterViewController.getHeroDmg1().setText("Dmg~:  " + calc);
            }

        }



    public void populateDeckCB() {
        mCastleComponents = mCenterViewController.getCcTableView().getItems();
        mTowers = mCenterViewController.getTwrTableView().getItems();
        deckList = mCenterViewController.getDeckTableView().getItems();

        ComboBox cb = mCenterViewController.getDeckCB();
        for (Deck d : deckList) {
            deckStringList.add(d.getName());
        }

        cb.getItems().addAll(deckStringList);
        mHeroList.addAll(mCenterViewController.getHeroTableView1().getItems());
        mUHeroList.addAll(mCenterViewController.getHeroTableView2().getItems());
        mWeaponList.addAll(mCenterViewController.getItemWeaponList());
        mAccessoryList.addAll(mCenterViewController.getItemAcccessoryList());

        cb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            for (Deck deck : deckList) {
                if (newValue.equals(deck.getName())) {
                    mCenterViewController.getTbL1().setText(deck.getTownBuilding1());
                    mCenterViewController.getTbL2().setText(deck.getTownBuilding2());
                    mCenterViewController.getTbL3().setText(deck.getTownBuilding3());
                    mCenterViewController.gettL1().setText(deck.getTreasure1());
                    mCenterViewController.gettL2().setText(deck.getTreasure2());
                    mCenterViewController.gettL3().setText(deck.getTreasure3());
                    mCenterViewController.gettL4().setText(deck.getTreasure4());
                    mCenterViewController.gettL5().setText(deck.getTreasure5());
                    mCenterViewController.getTwrL1().setText(deck.getTower1());
                    mCenterViewController.getTwrL2().setText(deck.getTower2());
                    mCenterViewController.getTwrL3().setText(deck.getTower3());
                    mCenterViewController.getTwrL4().setText(deck.getTower4());
                    for (Tower twr : mTowers) {

                        if (deck.getTower1().equals(twr.getName()) || deck.getTower2().equals(twr.getName()) || deck.getTower3().equals(twr.getName()) || deck.getTower4().equals(twr.getName())) {
                            if (deck.getTower1().equals(twr.getName())) {
                                mCenterViewController.getTwrLL1().setText(twr.getLevel().getText());
                            }
                            if (deck.getTower2().equals(twr.getName())) {
                                mCenterViewController.getTwrLL2().setText(twr.getLevel().getText());
                            }
                            if (deck.getTower3().equals(twr.getName())) {
                                mCenterViewController.getTwrLL3().setText(twr.getLevel().getText());
                            }
                            if (deck.getTower4().equals(twr.getName())) {
                                mCenterViewController.getTwrLL4().setText(twr.getLevel().getText());
                            }

                        } else {
                            try {
                                if (deck.getTower1().equals(twr.getPromotion().getSelectionModel().getSelectedItem()) || deck.getTower2().equals(twr.getPromotion().getSelectionModel().getSelectedItem()) || deck.getTower3().equals(twr.getPromotion().getSelectionModel().getSelectedItem()) || deck.getTower4().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                                    if (deck.getTower1().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                                        mCenterViewController.getTwrLL1().setText(twr.getLevel().getText());
                                    }
                                    if (deck.getTower2().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                                        mCenterViewController.getTwrLL2().setText(twr.getLevel().getText());
                                    }
                                    if (deck.getTower3().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                                        mCenterViewController.getTwrLL3().setText(twr.getLevel().getText());
                                    }
                                    if (deck.getTower4().equals(twr.getPromotion().getSelectionModel().getSelectedItem())) {
                                        mCenterViewController.getTwrLL4().setText(twr.getLevel().getText());

                                    }
                                }
                            } catch (NullPointerException npe) {

                            }

                        }
                        mCenterViewController.getCcL1().setText(deck.getCC1());
                        mCenterViewController.getCcL2().setText(deck.getCC2());
                        mCenterViewController.getCcL3().setText(deck.getCC3());
                        mCenterViewController.getCcL4().setText(deck.getCC4());
                        for (CastleComponent cc : mCastleComponents) {
                            if (deck.getCC1().equals(cc.getCcName())) {
                                mCenterViewController.getCcLL1().setText(cc.getCcLevel().getText());
                            }
                            if (deck.getCC2().equals(cc.getCcName())) {
                                mCenterViewController.getCcLL2().setText(cc.getCcLevel().getText());
                            }
                            if (deck.getCC3().equals(cc.getCcName())) {
                                mCenterViewController.getCcLL3().setText(cc.getCcLevel().getText());
                            }
                            if (deck.getCC4().equals(cc.getCcName())) {
                                mCenterViewController.getCcLL4().setText(cc.getCcLevel().getText());
                            }
                        }
                        mCenterViewController.getHeroL1().setText(deck.getH1());
                        fillHeroData(deck.getH1(),mCenterViewController.getH1itemSL1(),mCenterViewController.getH1itemQL1());


                    }


                }
            }
        });
    }
}
