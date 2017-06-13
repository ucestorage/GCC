package com.ubboeicke.application.Model.Gamedata.CastleComponents;

import com.ubboeicke.application.Model.GlobalConstants.AttackMode;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class CastleComponent {
    private String ccName;
    private TextField ccLevel;
    private TextField ccLevelP;
    private ComboBox<AttackMode.Mode> ccAM;

    public CastleComponent(String ccName, TextField ccLevel, TextField ccLevelP, ComboBox ccAM) {
        this.ccAM = ccAM;
        this.ccName = ccName;
        this.ccLevel = ccLevel;
        this.ccLevelP = ccLevelP;
        ccAM.getItems().setAll(AttackMode.Mode.values());
       // ccAM.getSelectionModel().selectFirst();

    }
    public CastleComponent(String ccName, TextField ccLevel){
        this.ccName = ccName;
        this.ccLevel = ccLevel;
    }

    public ComboBox<AttackMode.Mode> getCcAM() {
        return ccAM;
    }

    public void setCcAM(ComboBox<AttackMode.Mode> ccAM) {
        this.ccAM = ccAM;
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
