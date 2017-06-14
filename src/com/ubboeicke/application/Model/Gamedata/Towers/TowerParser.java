package com.ubboeicke.application.Model.Gamedata.Towers;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.AttackMode;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class TowerParser {

    private CenterViewController mCenterViewController;
    private ArrayList<String> StringList;


    public TowerParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;

        StringList = new ArrayList<>();

    }

    public ArrayList<String> getStrings(){

        for (Tower twr : mCenterViewController.getTwrTableView().getItems()){
            String name = twr.getName();
            String s;
            if(name.equals("Tree") )
            {
              s   = String.format("%s,%s,%s", twr.getName(), twr.getPromotion(),twr.getLevel().getText());
            } else { if(twr.getName().equals("Trophy")){
                s = String.format("%s,%s",twr.getName(),twr.getLevel().getText());
            } else {
                if (name.equals("Cannon")||name.equals("Thorn Worm")||name.equals("Turret")){
                    s = String.format("%s,%s,%s,%s",twr.getName(),twr.getLevel().getText(),twr.getLevelPrestige().getText(),twr.getAttackMode().getSelectionModel().getSelectedItem().getString());
                } else {
                    s= String.format("%s,%s,%s,%s,%s",twr.getName(),twr.getPromotion(),twr.getLevel().getText(),twr.getLevelPrestige().getText(),twr.getAttackMode().getSelectionModel().getSelectedItem().getString());
                }
            }


            }
            StringList.add(s);

        }
        return StringList;
    }
    public Tower splitStrings(String string) {
        Tower twr = null;
        String mString = string;
        String[] parts = mString.split(",");
        String p0 = parts[0];
        String p1;
        String p4;
        TextField levelTF;
        TextField levelPTF;
        ComboBox promoCB;
        ComboBox amCB;

            if(p0.equals("Trophy")) {
                levelTF = new TextField(parts[1]);
                twr = new Tower(p0, levelTF);
            }

        if(p0.equals("Tree")) {
            p1 = parts[1];
            levelTF = new TextField(parts[2]);
            promoCB = new ComboBox();
            promoCB.getItems().addAll("Crystal Tree", "Golden Tree");
            if (p1.equals("Crystal Tree")) {
                promoCB.getSelectionModel().select(0);
            } else {
                promoCB.getSelectionModel().select(1);
            }
            twr = new Tower(p0, promoCB, levelTF);
        }

            if(p0.equals("Worm")) {
                p1 = parts[1];
                p4 = parts[4];
                levelTF = new TextField(parts[2]);
                levelPTF = new TextField(parts[3]);
                promoCB = new ComboBox();
                amCB = new ComboBox<>();
                promoCB.getItems().addAll("Death Worm ", "Death Worm II");
                if (p1.equals("Death Worm")) {
                    promoCB.getSelectionModel().select(0);
                } else {
                    promoCB.getSelectionModel().select(1);
                }
                amCB.getItems().setAll(AttackMode.Mode.values());
                selectorAttackMode(p4, amCB);
                twr = new Tower(p0, promoCB, levelTF, levelPTF, amCB);
            }
        if(p0.equals("Flame Tower")) {
            p1 = parts[1];
            p4 = parts[4];
            levelTF = new TextField(parts[2]);
            levelPTF = new TextField(parts[3]);
            promoCB = new ComboBox();
            amCB = new ComboBox<>();
            promoCB.getItems().addAll("Burning Tower", "Burning Tower II");
            if (p1.equals("Burning Tower")) {
                promoCB.getSelectionModel().select(0);
            } else {
                promoCB.getSelectionModel().select(1);
            }
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new Tower(p0, promoCB, levelTF, levelPTF, amCB);
        }
        if(p0.equals("Frozen Tower")) {
            p1 = parts[1];
            p4 = parts[4];
            levelTF = new TextField(parts[2]);
            levelPTF = new TextField(parts[3]);
            promoCB = new ComboBox();
            amCB = new ComboBox<>();
            promoCB.getItems().addAll("Frozen Tower II");
            promoCB.getSelectionModel().select(0);
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new  Tower(p0, promoCB, levelTF, levelPTF, amCB);
        }
        if(p0.equals("Lightning Tower")) {
            p1 = parts[1];
            p4 = parts[4];
            levelTF = new TextField(parts[2]);
            levelPTF = new TextField(parts[3]);
            promoCB = new ComboBox();
            amCB = new ComboBox<>();
            promoCB.getItems().addAll("Thunder Tower", "Thunder Tower II");
            if (p1.equals("Thunder Tower")) {
                promoCB.getSelectionModel().select(0);
            } else {
                promoCB.getSelectionModel().select(1);
            }
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new Tower(p0, promoCB, levelTF, levelPTF, amCB);
        }
        if(p0.equals("Barracks")) {
            p1 = parts[1];
            p4 = parts[4];
            levelTF = new TextField(parts[2]);
            levelPTF = new TextField(parts[3]);
            promoCB = new ComboBox();
            amCB = new ComboBox<>();
            promoCB.getItems().addAll("Offensive Barracks", "Defensive Barracks");
            if (p1.equals("Offensive Barracks")) {
                promoCB.getSelectionModel().select(0);
            } else {
                promoCB.getSelectionModel().select(1);
            }
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new Tower(p0, promoCB, levelTF, levelPTF, amCB);
        }
        if(p0.equals("Cannon")) {
            p4 = parts[3];
            levelTF = new TextField(parts[1]);
            levelPTF = new TextField(parts[2]);
            amCB = new ComboBox<>();
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new Tower(p0, levelTF, levelPTF, amCB);
        }
        if(p0.equals("Thorn Worm")) {
            p4 = parts[3];
            levelTF = new TextField(parts[1]);
            levelPTF = new TextField(parts[2]);
            amCB = new ComboBox<>();
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new Tower(p0, levelTF, levelPTF, amCB);
        }
        if(p0.equals("Turret")) {
            p4 = parts[3];
            levelTF = new TextField(parts[1]);
            levelPTF = new TextField(parts[2]);
            amCB = new ComboBox<>();
            amCB.getItems().setAll(AttackMode.Mode.values());
            selectorAttackMode(p4, amCB);
            twr = new Tower(p0, levelTF, levelPTF, amCB);
        }



        return twr;
    }


public void selectorAttackMode(String s, ComboBox cb){
    switch(s) {
        case "Auto":
            cb.getSelectionModel().select(0);
            break;
        case "Near":
            cb.getSelectionModel().select(1);
            break;
        case "LowHP":
            cb.getSelectionModel().select(2);
            break;
        case "Boss":
            cb.getSelectionModel().select(3);
            break;
        case "Flying":
            cb.getSelectionModel().select(4);
    }

}


    }


