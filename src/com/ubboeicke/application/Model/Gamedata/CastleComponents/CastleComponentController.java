package com.ubboeicke.application.Model.Gamedata.CastleComponents;

import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Model.GlobalConstants.AttackMode;
import javafx.scene.control.ComboBox;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class CastleComponentController {
    private CenterViewController mCenterViewController;
    private CastleComponent mCastleComponent;
    private ComboBox<AttackMode.Mode> mAttackModeComboBox;

    public  CastleComponentController(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;
        mAttackModeComboBox = mCastleComponent.getCcAM();
    }

}
