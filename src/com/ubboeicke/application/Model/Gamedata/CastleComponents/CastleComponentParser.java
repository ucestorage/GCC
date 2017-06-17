package com.ubboeicke.application.Model.Gamedata.CastleComponents;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.GameObjectConstructor;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.AttackMode;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class CastleComponentParser {

    private CenterViewController mCenterViewController;
    private ArrayList<String> ccStringList;
    private GameObjectConstructor goc;


    public CastleComponentParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;
        goc = new GameObjectConstructor();

        ccStringList = new ArrayList<>();

    }

    public ArrayList<String> getCCStrings(){

        for (CastleComponent cc : mCenterViewController.getCcTableView().getItems()){
            String ccS;

            if(cc.getCcName().equals("Gold Castle") || cc.getCcName().equals("Shield Castle") || cc.getCcName().equals("Fire CastleBase") || cc.getCcName().equals("Lightning CastleBase") || cc.getCcName().equals("Frozen CastleBase"))
            {
              ccS   = String.format("%s,%s", cc.getCcName(), cc.getCcLevel().getText());
            } else {
                ccS   = String.format("%s,%s,%s,%s", cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText(), cc.getCcAM().getSelectionModel().getSelectedItem().toString());
            }
            ccStringList.add(ccS);

        }
        return ccStringList;
    }
    public CastleComponent splitCC(String string) {
        CastleComponent cc;

        String[] parts = string.split(",");
        String p0 = parts[0];
        String p1 = parts[1];



        if (p0.equals("Gold Castle") || p0.equals("Shield Castle") || p0.equals("Fire CastleBase") || p0.equals("Lightning CastleBase") || p0.equals("Frozen CastleBase")) {
            cc = new CastleComponent(p0,goc.loadLevelTextField(p1));
        } else {
            String p2 = parts[2];
            String p3 = parts[3];
            cc = new CastleComponent(p0,goc.loadLevelTextField(p1),goc.loadLevelPrestigeTextField(p2),goc.loadAttackModeCB(p3));

        }
        return cc;




    }
}
