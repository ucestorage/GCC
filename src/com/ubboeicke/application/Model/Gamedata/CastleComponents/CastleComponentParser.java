package com.ubboeicke.application.Model.Gamedata.CastleComponents;

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


    public CastleComponentParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;

        ccStringList = new ArrayList<>();

    }

    public ArrayList<String> getCCStrings(){

        for (CastleComponent cc : mCenterViewController.getCcTableView().getItems()){
            String ccS;
            AttackMode.Mode mMode;
            if(cc.getCcName().equals("Gold Castle") || cc.getCcName().equals("Shield Castle") || cc.getCcName().equals("Fire CastleBase") || cc.getCcName().equals("Lightning CastleBase") || cc.getCcName().equals("Frozen CastleBase"))
            {
              ccS   = String.format("%s,%s", cc.getCcName(), cc.getCcLevel().getText());
            } else {
                mMode = cc.getCcAM().getSelectionModel().getSelectedItem();
                String test2 = mMode.getString();
                ccS   = String.format("%s,%s,%s,%s", cc.getCcName(), cc.getCcLevel().getText(), cc.getCcLevelP().getText(), test2);
            }
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

        if (p0.equals("Gold Castle") || p0.equals("Shield Castle") || p0.equals("Fire CastleBase") || p0.equals("Lightning CastleBase") || p0.equals("Frozen CastleBase")) {
            cc = new CastleComponent(p0,p1);
        } else {
            String p3 = parts[3];
            ComboBox<AttackMode.Mode> c1 = new ComboBox<>();
            c1.getItems().setAll(AttackMode.Mode.values());
            switch(p3){
                case "Auto":
                    c1.getSelectionModel().select(0);
                    break;
                case "Near":
                    c1.getSelectionModel().select(1);
                    break;
                case "LowHP":
                    c1.getSelectionModel().select(2);
                    break;
                case "Boss":
                    c1.getSelectionModel().select(3);
                    break;
                case "Flying":
                    c1.getSelectionModel().select(4);
                    break;
            }


            TextField p2 = new TextField(parts[2]);
            cc = new CastleComponent(p0,p1,p2,c1);

        }
        return cc;




    }
}
