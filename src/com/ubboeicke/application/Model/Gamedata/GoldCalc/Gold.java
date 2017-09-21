package com.ubboeicke.application.Model.Gamedata.GoldCalc;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Gold {
    private Label nameL;
    private Label levelL;
    private Label dmgL;
    private TextField wantedL;
    private TextField upgCost;
    private Label futDmgL;
    private Label totalCost;
    private Label dmgDiff;
    private Label goldPerDmg;
    private String nameS;
    private String levelS;
    private String levelPS;
    private String wAtt1;
    private String wAtt2;
    private String wAtt3;
    private String wAttV1;
    private String wAttV2;
    private String wAttV3;
    private String aAtt1;
    private String aAtt2;
    private String aAtt3;
    private String aAttV1;
    private String aAttV2;
    private String aAttV3;
    private String dmg;
    public Gold(Label nameL, Label levelL, Label dmgL, TextField wantedL, TextField upgCost, Label futDmgL, Label totalCost, Label dmgDiff, Label goldPerDmg, String wAtt1, String wAtt2, String wAtt3, String wAttV1, String wAttV2, String wAttV3, String aAtt1, String aAtt2, String aAtt3, String aAttV1, String aAttV2, String aAttV3, String levelPS) {
        this.nameL = nameL;
        this.levelL = levelL;
        this.dmgL = dmgL;
        this.wantedL = wantedL;
        this.upgCost = upgCost;
        this.futDmgL = futDmgL;
        this.totalCost = totalCost;
        this.dmgDiff = dmgDiff;
        this.goldPerDmg = goldPerDmg;
        this.wAtt1 = wAtt1;
        this.wAtt2 = wAtt2;
        this.wAtt3 = wAtt3;
        this.wAttV1 = wAttV1;
        this.wAttV2 = wAttV2;
        this.wAttV3 = wAttV3;
        this.aAtt1 = aAtt1;
        this.aAtt2 = aAtt2;
        this.aAtt3 = aAtt3;
        this.aAttV1 = aAttV1;
        this.aAttV2 = aAttV2;
        this.aAttV3 = aAttV3;
        this.levelPS = levelPS;
    }

    public Gold(String nameS, String levelS, String levelPS, String wAtt1, String wAtt2, String wAtt3, String wAttV1, String wAttV2, String wAttV3, String aAtt1, String aAtt2, String aAtt3, String aAttV1, String aAttV2, String aAttV3, String dmg) {
        this.nameS = nameS;
        this.levelS = levelS;
        this.levelPS = levelPS;
        this.wAtt1 = wAtt1;
        this.wAtt2 = wAtt2;
        this.wAtt3 = wAtt3;
        this.wAttV1 = wAttV1;
        this.wAttV2 = wAttV2;
        this.wAttV3 = wAttV3;
        this.aAtt1 = aAtt1;
        this.aAtt2 = aAtt2;
        this.aAtt3 = aAtt3;
        this.aAttV1 = aAttV1;
        this.aAttV2 = aAttV2;
        this.aAttV3 = aAttV3;
        this.dmg = dmg;
    }

    public String getNameS() {
        return nameS;
    }

    public String getLevelS() {
        return levelS;
    }

    public String getLevelPS() {
        return levelPS;
    }

    public String getwAtt1() {
        return wAtt1;
    }

    public String getwAtt2() {
        return wAtt2;
    }

    public String getwAtt3() {
        return wAtt3;
    }

    public String getwAttV1() {
        return wAttV1;
    }

    public String getwAttV2() {
        return wAttV2;
    }

    public String getwAttV3() {
        return wAttV3;
    }

    public String getaAtt1() {
        return aAtt1;
    }

    public String getaAtt2() {
        return aAtt2;
    }

    public String getaAtt3() {
        return aAtt3;
    }

    public String getaAttV1() {
        return aAttV1;
    }

    public String getaAttV2() {
        return aAttV2;
    }

    public String getaAttV3() {
        return aAttV3;
    }

    public String getDmg() {
        return dmg;
    }

    public Label getNameL() {
        return nameL;
    }

    public Label getLevelL() {
        return levelL;
    }

    public Label getDmgL() {
        return dmgL;
    }

    public TextField getWantedL() {
        return wantedL;
    }

    public TextField getUpgCost() {
        return upgCost;
    }

    public Label getFutDmgL() {
        return futDmgL;
    }

    public Label getTotalCost() {
        return totalCost;
    }

    public Label getDmgDiff() {
        return dmgDiff;
    }

    public Label getGoldPerDmg() {
        return goldPerDmg;
    }
}
