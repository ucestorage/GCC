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

import java.text.DecimalFormat;

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
    private ValueKeeper vk = new ValueKeeper();


    Double summonedUnitDmg = 0.0;
    Double fireDmg = 10.0;
    Double poisonDmg = 10.0;
    Double lightningDmg = 10.0;
    Double coldDmg = 10.0;
    Double hp = 0.0;
    Double manaRec = 0.0;
    Double archerDmg = 0.0;
    Double heroDmg = 0.0;
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
    public OverviewController(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;
    }
    public void populateDeckCB() {
        deckList = mCenterViewController.getDeckTableView().getItems();
        ComboBox cb = mCenterViewController.getDeckCB();
        for (Deck d : deckList) {
            deckStringList.add(d.getName());
        }
        cb.getItems().addAll(deckStringList);
        onChangeDeckCB();

    }
    public void calculateBasicValues(String leader, String tb1, String tb2, String tb3, String t1, String t2, String t3,
                                     String t4, String t5, String twr1, String twr2, String twr3, String twr4) {

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
    public void onChangeDeckCB(){
        mCastleComponents = mCenterViewController.getCcTableView().getItems();
        mTowers = mCenterViewController.getTwrTableView().getItems();
        mHeroList.addAll(mCenterViewController.getHeroTableView1().getItems());
        mUHeroList.addAll(mCenterViewController.getHeroTableView2().getItems());
        mWeaponList.addAll(mCenterViewController.getItemWeaponList());
        mAccessoryList.addAll(mCenterViewController.getItemAcccessoryList());

        mCenterViewController.getDeckCB().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            for (Deck deck : mCenterViewController.getDeckTableView().getItems()) {
                if (newValue.equals(deck.getName())) {
                    vk.reset();
                    fillOVerviewData(deck,mCenterViewController.getTbL1(), mCenterViewController.getTbL2(),mCenterViewController.getTbL3(),mCenterViewController.gettL1(),
                            mCenterViewController.gettL2(),mCenterViewController.gettL3(),mCenterViewController.gettL4(),mCenterViewController.gettL5(),
                            mCenterViewController.getTwrL1(),mCenterViewController.getTwrL2(),mCenterViewController.getTwrL3(),mCenterViewController.getTwrL4(),
                            mTowers,mCenterViewController.getCcL1(),mCenterViewController.getCcL2(),mCenterViewController.getCcL3(),mCenterViewController.getCcL4(),
                            mCastleComponents);
                    calculateBasicValues(deck.getLeader(),deck.getTownBuilding1(),deck.getTownBuilding2(),deck.getTownBuilding3(),
                            deck.getTreasure1(),deck.getTreasure2(),deck.getTreasure3(),deck.getTreasure4(),deck.getTreasure5(),
                            deck.getTower1(),deck.getTower2(),deck.getTower3(),deck.getTower4());


                    mCenterViewController.getH1NameL().setText(deck.getH1());
                    fillHeroData(deck.getH1(), mCenterViewController.getH1itemSL1(), mCenterViewController.getH1itemQL1(),
                            mCenterViewController.getH1att1L1(), mCenterViewController.getH1attv1L1(), mCenterViewController.getH1att2L1(),
                            mCenterViewController.getH1attv2L1(), mCenterViewController.getH1att3L1(), mCenterViewController.getH1attv3L1(),
                            mCenterViewController.getH1itemSL2(), mCenterViewController.getH1itemQL2(), mCenterViewController.getH1att1L2(),
                            mCenterViewController.getH1att2L2(), mCenterViewController.getH1att3L2(), mCenterViewController.getH1attv1L2(),
                            mCenterViewController.getH1attv2L2(), mCenterViewController.getH1attv3L2(), mCenterViewController.getH1LvlL(),
                            mCenterViewController.getH1PLvlL(), mCenterViewController.getH1CDL(), mCenterViewController.getH1ManaL()
                    );

                }

            }

                mCenterViewController.getH1DmgL().setText(
                        dmgHero(mCenterViewController.getH1NameL().getText(),mCenterViewController.getH1LvlL().getText(),
                                mCenterViewController.getH1PLvlL(),
                                mCenterViewController.getH1att1L1().getText(),mCenterViewController.getH1attv1L1().getText(),
                                mCenterViewController.getH1att1L2().getText(),mCenterViewController.getH1attv2L1().getText(),
                                mCenterViewController.getH1att3L1().getText(),mCenterViewController.getH1attv3L1().getText(),
                                mCenterViewController.getH1att1L2().getText(),mCenterViewController.getH1attv1L2().getText(),
                                mCenterViewController.getH1att2L2().getText(),mCenterViewController.getH1attv2L2().getText(),
                                mCenterViewController.getH1att3L2().getText(),mCenterViewController.getH1attv3L2().getText(),
                                mCenterViewController.getH1CDL(),mCenterViewController.getH1ManaL()
                        )   );

        });
    }

    public void findValuesTb(String s) {
        if (s.equals("Forge")) {
            hp = hp + 10.0;
        }
        if (s.equals("Mana Henge")) {
            manaRec = manaRec + 20.0;
        }
        if (s.equals("Archer Guild")) {
            archerDmg = archerDmg + 30.0;
        }
        if (s.equals("Hero Guild")) {
            vk.setTbDmg(vk.getTbDmg()+0.3);
        }
        if (s.equals("Mine")) {
            vk.setGoldBonus(vk.getGoldBonus()+0.1);

        }
        if (s.equals("Tower")) {
            towerDmg = towerDmg + 20.0;
        }
        if (s.equals("Spring Water")) {
            cdr = cdr + 15.0;
        }
        if (s.equals("Bar")) {
            humanSummons = humanSummons + 2.0;
            humanSummonDmg = humanSummonDmg - 25.0;
        }
    }

    public void findValuesTwr(String s) {
        if (s.equals("Trophy")) {
            vk.setGoldBonus(vk.getGoldBonus()+0.35);
        }
    }
    public void findValuesTreasures(String s){
    if (s.equals("Red Potion")){
        finalHP = finalHP + 300;
    }
        if (s.equals("Blue Potion")){
    finalMP = finalMP + 150;
        }
        if (s.equals("Bronze Piece")){
            vk.setGoldBonus(vk.getGoldBonus()+0.13);
        }
        if (s.equals("Broken Shield")){
            defense =  defense + 13.0;

        }
        if (s.equals("Web")){
        siegeDef = siegeDef + 40.0;
        }
        if (s.equals("Bottomless Red Potion")){
        hp = hp + 20.0;
        }
        if (s.equals("Power Glove")){vk.setTreasureDmg(vk.getTreasureDmg()+0.15);
        }
        if (s.equals("")){

        }
        if (s.equals("")){

        }
        if (s.equals("")){

        }if (s.equals("")){

        }if (s.equals("")){

        }



    }
    public void findValuesTreasuresWeapons(String s) {
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

    //TODO Methode die date ndes helden in overview befüllt, alle label mitgeben die geändert werden sollen, dann if abfragen wegen änderung
    public void fillHeroData(String s, Label wItemS, Label wItemQ, Label wAtt1, Label wAtt1v, Label wAtt2, Label wAtt2v,
                             Label wAtt3, Label wAtt3v, Label aItemS, Label aItemQ, Label aAtt1, Label aAtt2, Label aAtt3,
                             Label aAtt1v, Label aAtt2v, Label aAtt3v, Label herolvl, Label heroplvl, Label cd, Label manal) {
        wItemS.setText("");wItemQ.setText("");wAtt1.setText("");wAtt1v.setText("");wAtt2.setText("");wAtt2v.setText("");
        wAtt3.setText("");wAtt3v.setText("");aAtt1.setText("");aAtt1v.setText("");aAtt2.setText("");aAtt2v.setText("");
        aAtt3.setText("");aAtt3v.setText("");cd.setText("");manal.setText("");
        for (Hero h : mUHeroList) {
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
            //TODO Methode dmg calculation
            //TODO dmg calc in eigene klasse auslagern


         /*   String lvl = h.getLevel().getText();
            Integer i = Integer.parseInt(lvl);
            Double d = i * 3.5; //TODO get hero dmg multiplier; calculate items
            String calc = d.toString();
            Integer integer = i * 10;
            String mana = integer.toString();
            cd.setText("30");
            manal.setText(mana);
           // dmg.setText("Dmg~:  " + calc);*/
        }

    }
    public String dmgHero(String hero, String lvl,Label lvlP, String wAtt1, String wAtt1v, String wAtt2, String wAtt2v,
                          String wAtt3, String wAtt3v, String aAtt1, String aAtt1v, String aAtt2,String aAtt2v,String aAtt3,
                          String aAtt3v, Label cdL, Label manaCost){

        String finaldmg ="";
        Double finalDmg = 0.0;
        Double dmgOnLvl1 = 0.0;
        Double baseDmg = 0.0;
        Double baseManaCost = 1.0;
        Double cdBaseValue = 30.0;
        Double itemValue = 0.0;
        Double skillDmg = 0.5;
        Double townBuildingDmg = vk.getTbDmg();
        Double treasureDmg = vk.getTreasureDmg();
        DecimalFormat df = new DecimalFormat("#");



        if (hero.equals("Dark Ranger")||hero.equals("Ranger")||hero.equals("Bow Master")||hero.equals("Dark Bow Master")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Monster Hunter")||hero.equals("Dark Hunter")||hero.equals("Cross Hunter")||hero.equals("Sniper")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Deep Elf")||hero.equals("Dark Elf")||hero.equals("High Elf")||hero.equals("White Elf")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Ice Wizard")||hero.equals("Dark Ice Wizard")||hero.equals("Ice Sorcerer")||hero.equals("Dark Ice Sorcerer")){
            dmgOnLvl1 = 3.5;
            if (wAtt1.equals("ColdDamage")){
                itemValue = itemValue+Double.parseDouble(wAtt1v)/100;
            }
            if (wAtt2.equals("ColdDamage")){
                itemValue = itemValue + Double.parseDouble(wAtt2v)/100;
            }
            if (wAtt3.equals("ColdDamage")){
                itemValue = itemValue + Double.parseDouble(wAtt3v)/100;
            }
            if (aAtt1.equals("ColdDamage")){
                itemValue = itemValue+Double.parseDouble(aAtt1v)/100;
            }
            if (aAtt2.equals("ColdDamage")){
                itemValue = itemValue + Double.parseDouble(aAtt2v)/100;
            }
            if (aAtt3.equals("ColdDamage")){
                itemValue = itemValue + Double.parseDouble(aAtt3v)/100;
            }
        }
        if (hero.equals("Lightning Wizard")||hero.equals("Dark Lightning Wizard")||hero.equals("Lightning Sorcerer")||hero.equals("Dark Lightning Sorcerer")){
            dmgOnLvl1 = 3.5;
            if (wAtt1.equals("LightningDamage")){
                itemValue = itemValue+Double.parseDouble(wAtt1v)/100;
            }
            if (wAtt2.equals("LightningDamage")){
                itemValue = itemValue + Double.parseDouble(wAtt2v)/100;
            }
            if (wAtt3.equals("LightningDamage")){
                itemValue = itemValue + Double.parseDouble(wAtt3v)/100;
            }
            if (aAtt1.equals("LightningDamage")){
                itemValue = itemValue+Double.parseDouble(aAtt1v)/100;
            }
            if (aAtt2.equals("LightningDamage")){
                itemValue = itemValue + Double.parseDouble(aAtt2v)/100;
            }
            if (aAtt3.equals("LightningDamage")){
                itemValue = itemValue + Double.parseDouble(aAtt3v)/100;
            }
        }
        if (hero.equals("Fire Wizard")||hero.equals("Dark Fire Wizard")||hero.equals("Fire Sorcerer")||hero.equals("Dark Fire Sorcerer")){
            dmgOnLvl1 = 3.5;
            if (wAtt1.equals("FireDamage")){
                itemValue = itemValue+Double.parseDouble(wAtt1v)/100;
            }
            if (wAtt2.equals("FireDamage")){
                itemValue = itemValue + Double.parseDouble(wAtt2v)/100;
            }
            if (wAtt3.equals("FireDamage")){
                itemValue = itemValue + Double.parseDouble(wAtt3v)/100;
            }
            if (aAtt1.equals("FireDamage")){
                itemValue = itemValue+Double.parseDouble(aAtt1v)/100;
            }
            if (aAtt2.equals("FireDamage")){
                itemValue = itemValue + Double.parseDouble(aAtt2v)/100;
            }
            if (aAtt3.equals("FireDamage")){
                itemValue = itemValue + Double.parseDouble(aAtt3v)/100;
            }
        }
        if (hero.equals("Fire Ogre")||hero.equals("Flame Ogre")){ //evtl split flame ogre fire/ hammer ogre normal
            dmgOnLvl1 = 3.5;
            try {
                if (wAtt1.equals("FireDamage")) {
                    itemValue = itemValue + Double.parseDouble(wAtt1v) / 100;
                }
                if (wAtt2.equals("FireDamage")) {
                    itemValue = itemValue + Double.parseDouble(wAtt2v) / 100;
                }
                if (wAtt3.equals("FireDamage")) {
                    itemValue = itemValue + Double.parseDouble(wAtt3v) / 100;
                }
                if (aAtt1.equals("FireDamage")) {
                    itemValue = itemValue + Double.parseDouble(aAtt1v) / 100;
                }
                if (aAtt2.equals("FireDamage")) {
                    itemValue = itemValue + Double.parseDouble(aAtt2v) / 100;
                }
                if (aAtt3.equals("FireDamage")) {
                    itemValue = itemValue + Double.parseDouble(aAtt3v) / 100;
                }

            } catch (NullPointerException npe){

            }
        }
        if (hero.equals("Hammer Ogre")||hero.equals("Giant Ogre")){ //evtl split flame ogre fire/ hammer ogre normal
            dmgOnLvl1 = 3.5;
        }

        if (hero.equals("Stone Giant")||hero.equals("Stone Giant II")||hero.equals("Mad Giant")||hero.equals("Mad Giant II")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Poison Slinger")||hero.equals("Spear Slinger")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Poison Voodoo")||hero.equals("Venom Voodoo")||hero.equals("String Voodoo")||hero.equals("String Voodoo II")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Rambo")||hero.equals("Mechanic Rambo II")||hero.equals("Rocket Man")||hero.equals("Rocket Man II")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Holy Knight")||hero.equals("Paladin")||hero.equals("Barbarian")||hero.equals("Fire Barbarian")||hero.equals("Ice Barbarian")){ // split ice/fire/normal
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Lisa Fire I")||hero.equals("Lisa Fire II")||hero.equals("Lisa Ice I")||hero.equals("Lisa Ice II")||hero.equals("Lisa Poison I")||hero.equals("Lisa Poison II")){ // split ice/fire/poison
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Alice Fire I")||hero.equals("Alice Fire II")||hero.equals("Alice Ice I")||hero.equals("Alice Ice II")||hero.equals("Alice Poison I")||hero.equals("Alice Poison II")){ // split ice/fire/poison
            dmgOnLvl1 = 11.0;
        }
        if (hero.equals("Dorothy Fire I")||hero.equals("Dorothy Fire II")||hero.equals("Dorothy Ice I")||hero.equals("Dorothy Ice II")||hero.equals("Dorothy Poison I")||hero.equals("Dorothy Poison II")){ // split ice/fire/poison
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Wolf Druid")||hero.equals("Wolf Druid II")||hero.equals("Hawk Druid")||hero.equals("Hawk Druid II")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Dark Assassin")||hero.equals("Deep Assassin")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Fire Flying Orc")||hero.equals("Ice Flying Orc")||hero.equals("Poison Flying Orc")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("Fire Windy")||hero.equals("Ice Windy")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("N/A")){
            dmgOnLvl1 = 3.5;
        }
        if (hero.equals("CD Zeus I")||hero.equals("CD Zeus II")||hero.equals("Slow Zeus I")||hero.equals("Slow Zeus II")){
            dmgOnLvl1 = 3.5;
        }
        try {
            if (wAtt1.equals("Damage")) {
                itemValue = itemValue + Double.parseDouble(wAtt1v) / 100;
            }
            if (wAtt2.equals("Damage")) {
                itemValue = itemValue + Double.parseDouble(wAtt2v) / 100;
            }
            if (wAtt3.equals("Damage")) {
                itemValue = itemValue + Double.parseDouble(wAtt3v) / 100;
            }
            if (aAtt1.equals("Damage")) {
                itemValue = itemValue + Double.parseDouble(aAtt1v) / 100;
            }
            if (aAtt2.equals("Damage")) {
                itemValue = itemValue + Double.parseDouble(aAtt2v) / 100;
            }
            if (aAtt3.equals("Damage")) {
                itemValue = itemValue + Double.parseDouble(aAtt3v) / 100;
            }
            if (lvlP.getText().equals("Prestige")) {
                lvlP.setText("0");
            }
        } catch (NullPointerException npe){

        }

        baseDmg = dmgOnLvl1 * (1+Double.parseDouble(lvl)*0.1);
        finalDmg = (baseDmg + baseDmg * itemValue)*(1+skillDmg)*(1+treasureDmg)*(1+townBuildingDmg);
        finaldmg = "Dmg~: "+String.valueOf(df.format(finalDmg));
        manaCost.setText(String.valueOf(df.format(Double.parseDouble(lvl)*baseManaCost)));
        cdL.setText(String.valueOf(df.format(cdBaseValue)));


        return finaldmg;
    }



    public void fillOVerviewData(Deck deck, Label tb1, Label tb2, Label tb3, Label t1, Label t2, Label t3, Label t4, Label t5,
                                 Label twr1, Label twr2, Label twr3, Label twr4,ObservableList<Tower> towers,
                                 Label cc1, Label cc2, Label cc3, Label cc4, ObservableList<CastleComponent> castleComponents){
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
        for (Tower twr : towers) {
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
        }
        cc1.setText(deck.getCC1());
        cc2.setText(deck.getCC2());
        cc3.setText(deck.getCC3());
        cc4.setText(deck.getCC4());
        for (CastleComponent cc : castleComponents) {
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
    }
}
