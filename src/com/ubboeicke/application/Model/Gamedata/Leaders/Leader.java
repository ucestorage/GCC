package com.ubboeicke.application.Model.Gamedata.Leaders;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Leader {
    private String Name;
    private TextField Level;
    private TextField LevelPrestige;
    private ComboBox AttackMode;
    private ComboBox Weapon;
    private ComboBox Accessory;

    public Leader(String name, TextField level, TextField levelPrestige, ComboBox attackMode, ComboBox weapon, ComboBox accessory) {
        Name = name;
        Level = level;
        LevelPrestige = levelPrestige;
        AttackMode = attackMode;
        Weapon = weapon;
        Accessory = accessory;
    }

    public String getName() {
        return Name;
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
}