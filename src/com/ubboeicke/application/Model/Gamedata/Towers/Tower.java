package com.ubboeicke.application.Model.Gamedata.Towers;

import com.ubboeicke.application.Model.Enums.AttackMode;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Tower {
    private String Name;
    private ComboBox<String> Promotion;
    private TextField Level;
    private TextField LevelPrestige;
    private ComboBox<AttackMode.Mode> AttackMode;

    public Tower(String name, ComboBox<String> promotion, TextField level, TextField levelPrestige, ComboBox<AttackMode.Mode> attackMode) {
        Name = name;
        Promotion = promotion;
        Level = level;
        LevelPrestige = levelPrestige;
        AttackMode = attackMode;
    }

    public Tower(String name, TextField level, TextField levelPrestige, ComboBox<com.ubboeicke.application.Model.Enums.AttackMode.Mode> attackMode) {
        Name = name;
        Level = level;
        LevelPrestige = levelPrestige;
        AttackMode = attackMode;
    }

    public Tower(String name, ComboBox<String> promotion, TextField level) {
        Name = name;
        Promotion = promotion;
        Level = level;
    }

    public Tower(String name, TextField level) {
        Name = name;
        Level = level;
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
}