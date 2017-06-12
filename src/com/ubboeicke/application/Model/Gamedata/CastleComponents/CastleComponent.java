package com.ubboeicke.application.Model.Gamedata.CastleComponents;

import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class CastleComponent {
    private String ccName;
    private TextField ccLevel;
    private TextField ccLevelP;

    public CastleComponent(String ccName, TextField ccLevel, TextField ccLevelP) {
        this.ccName = ccName;
        this.ccLevel = ccLevel;
        this.ccLevelP = ccLevelP;
    }
    public CastleComponent(String ccName, TextField ccLevel){
        this.ccName = ccName;
        this.ccLevel = ccLevel;
    }

    public String getCcName() {
        return ccName;
    }

    public void setCcName(String ccName) {
        this.ccName = ccName;
    }

    public TextField getCcLevel() {
        return ccLevel;
    }

    public void setCcLevel(TextField ccLevel) {
        this.ccLevel = ccLevel;
    }

    public TextField getCcLevelP() {
        return ccLevelP;
    }

    public void setCcLevelP(TextField ccLevelP) {
        this.ccLevelP = ccLevelP;
    }
}
