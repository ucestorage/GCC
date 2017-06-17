package com.ubboeicke.application.Model.Gamedata.Heroes;

import com.ubboeicke.application.Model.Enums.AttackMode;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Hero {
    private String Name;
    private ComboBox<String> Promotion;
    private TextField Level;
    private TextField LevelPrestige;
    private ComboBox<AttackMode.Mode> AttackMode;
    private ComboBox Weapon;
    private ComboBox Accessory;

    public Hero(String name, ComboBox<String> promotion, TextField level, TextField levelPrestige, ComboBox attackMode, ComboBox weapon, ComboBox accessory) {
        Name = name;
        Promotion = promotion;
        Level = level;
        LevelPrestige = levelPrestige;
        AttackMode = attackMode;
        Weapon = weapon;
        Accessory = accessory;

    }

    public Hero(String name, ComboBox<String> promotion, TextField level, ComboBox weapon, ComboBox accessory) {
        Name = name;
        Promotion = promotion;
        Level = level;
        Weapon = weapon;
        Accessory = accessory;
    }

    public String getName() {
        return Name;
    }

    public ComboBox<String> getPromotion() {
        return Promotion;
    }

    public TextField getLevel() {
        return Level;
    }

    public TextField getLevelPrestige() {
        return LevelPrestige;
    }

    public ComboBox<com.ubboeicke.application.Model.Enums.AttackMode.Mode> getAttackMode() {
        return AttackMode;
    }

    public ComboBox getWeapon() {
        return Weapon;
    }

    public ComboBox getAccessory() {
        return Accessory;
    }
}