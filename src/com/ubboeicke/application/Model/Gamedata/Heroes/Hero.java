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
    private Label UpgCost;
    private Label GoldDmg;

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
    public Hero(String name, TextField level,TextField wantLevel,Label upgCost, Label goldDmg){
        Name = name;
        Level = level;
        wantLvl = wantLevel;
        UpgCost = upgCost;
        GoldDmg = goldDmg;



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

    public Label getUpgCost() {
        return UpgCost;
    }

    public Label getGoldDmg() {
        return GoldDmg;
    }
}