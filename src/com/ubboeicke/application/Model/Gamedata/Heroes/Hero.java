package com.ubboeicke.application.Model.Gamedata.Heroes;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Hero {
    private String Name;
    private ComboBox Promotion;
    private TextField Level;
    private TextField LevelPrestige;
    private ComboBox AttackMode;
    private ComboBox Weapon;
    private ComboBox Accessory;
    private Label goldLvl;
    private TextField wantLvl;
    private TextField UpgCost;
    private Label GoldDmg;
    private Label TotalGold;

    public Hero(String name, ComboBox promotion, TextField level, TextField levelPrestige, ComboBox attackMode, ComboBox weapon, ComboBox accessory) {
        Name = name;
        Promotion = promotion;
        Level = level;
        LevelPrestige = levelPrestige;
        AttackMode = attackMode;
        Weapon = weapon;
        Accessory = accessory;
    }

    public Hero(String name, ComboBox promotion, TextField level, ComboBox weapon, ComboBox accessory) {
        Name = name;
        Promotion = promotion;
        Level = level;
        Weapon = weapon;
        Accessory = accessory;
    }

    public Hero(String name, Label level, TextField wantedLevel, TextField upgCost, Label totalCost, Label dmgInc, Label goldPerDmg) {
        Name = name;
        goldLvl = level;
        wantLvl = wantedLevel;
        UpgCost = upgCost;
        TotalGold = totalCost;
    }

    public Label getTotalGold() {
        return TotalGold;
    }

    public void setTotalGold(Label totalGold) {
        TotalGold = totalGold;
    }

    public String getName() {
        return Name;
    }

    public ComboBox getPromotion() {
        return Promotion;
    }

    public TextField getLevel() {
        return Level;
    }

    public TextField getLevelPrestige() {
        return LevelPrestige;
    }

    public ComboBox getAttackMode() {
        return AttackMode;
    }

    public ComboBox getWeapon() {
        return Weapon;
    }

    public ComboBox getAccessory() {
        return Accessory;
    }

    public Label getGoldLvl() {
        return goldLvl;
    }

    public TextField getWantLvl() {
        return wantLvl;
    }

    public TextField getUpgCost() {
        return UpgCost;
    }

    public Label getGoldDmg() {
        return GoldDmg;
    }

    public void setGoldDmg(Label goldDmg) {
        GoldDmg = goldDmg;
    }
}