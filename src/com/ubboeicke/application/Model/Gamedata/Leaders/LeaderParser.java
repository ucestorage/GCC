package com.ubboeicke.application.Model.Gamedata.Leaders;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.GameObjectConstructor;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.AttackMode;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class LeaderParser {

    private CenterViewController mCenterViewController;
    private ArrayList<String> StringList;
    private GameObjectConstructor goc;
    private ObservableList<Item> mWeaponList;
    private ObservableList<Item> mAccessoryList;


    public LeaderParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;
        goc = new GameObjectConstructor();
        mWeaponList = mCenterViewController.getItemWeaponList();
        mAccessoryList = mCenterViewController.getItemAcccessoryList();
        StringList = new ArrayList<>();

    }
    //TODO save/load leader

    public ArrayList<String> getStrings(){

        for (Leader ldr : mCenterViewController.getLeaderTableView().getItems()){
            String s;
            s = String.format("%s,%s,%s,%s,%s,%s",ldr.getName(),ldr.getLevel().getText(),ldr.getLevelPrestige().getText(),ldr.getAttackMode().getSelectionModel().getSelectedItem(),ldr.getWeapon().getSelectionModel().getSelectedItem(),ldr.getAccessory().getSelectionModel().getSelectedItem());
            StringList.add(s);

        }
        return StringList;
    }
    public Leader splitStrings(String string) {


        Leader ldr;
        String mString = string;
        String[] parts = mString.split(",");
        String p0 = parts[0];
        String p1 = parts[1];
        String p2 = parts[2];
        String p3 = parts[3];
        String p4 = parts[4];
        String p5 = parts[5];

        ldr = new Leader(p0,goc.loadLevelTextField(p1),goc.loadLevelPrestigeTextField(p2),goc.loadAttackModeCB(p3),goc.loadWeaponCB(p4,mWeaponList),goc.loadAccessoryCB(p5,mAccessoryList));
        return ldr;
    }




    }


