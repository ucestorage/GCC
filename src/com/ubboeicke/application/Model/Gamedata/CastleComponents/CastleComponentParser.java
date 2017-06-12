package com.ubboeicke.application.Model.Gamedata.CastleComponents;

import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.Item;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class CastleComponentParser {

    private CenterViewController mCenterViewController;
    private ArrayList<String> ccStringList;

    public CastleComponentParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;

        ccStringList = new ArrayList<>();

    }

    public ArrayList<String> getCCStrings(){

        for (CastleComponent cc : mCenterViewController.getCcTableView().getItems()){
            String ccS;
            if(cc.getCcName().equals("Shield Castle") || cc.getCcName().equals("Fire CastleBase") || cc.getCcName().equals("Lightning CastleBase") || cc.getCcName().equals("Frozen CastleBase"))
            {
              ccS   = String.format("%s,%s", cc.getCcName(), cc.getCcLevel().getText());
            } else {
                ccS   = String.format("%s,%s,%s", cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText());
            }
            System.out.println(ccS);
            ccStringList.add(ccS);

        }
        return ccStringList;
    }
    public CastleComponent splitCC(String string) {
        CastleComponent cc;
        String mString = string;
        String[] parts = mString.split(",");
        String p0 = parts[0];
        TextField p1 = new TextField(parts[1]);




        if (p0.equals("Shield Castle") || p0.equals("Fire CastleBase") || p0.equals("Lightning CastleBase") || p0.equals("Frozen CastleBase")) {
            cc = new CastleComponent(p0,p1);
        } else {
            TextField p2 = new TextField(parts[2]);
            cc = new CastleComponent(p0,p1,p2);

        }
        return cc;




    }
}
