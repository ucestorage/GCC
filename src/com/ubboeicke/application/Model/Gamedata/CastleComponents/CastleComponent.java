package com.ubboeicke.application.Model.Gamedata.CastleComponents;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class CastleComponent {
    private String ccName;
    private TextField ccLevel;
    private TextField ccLevelP;
    private ComboBox ccAM;

    public CastleComponent(String ccName, TextField ccLevel, TextField ccLevelP, ComboBox ccAM) {
        this.ccAM = ccAM;
        this.ccName = ccName;
        this.ccLevel = ccLevel;
        this.ccLevelP = ccLevelP;
    }

    public CastleComponent(String ccName, TextField ccLevel) {
        this.ccName = ccName;
        this.ccLevel = ccLevel;
    }

    public String getCcName() {
        return ccName;
    }

    public TextField getCcLevel() {
        return ccLevel;
    }

    public TextField getCcLevelP() {
        return ccLevelP;
    }

    public ComboBox getCcAM() {
        return ccAM;
    }
}
