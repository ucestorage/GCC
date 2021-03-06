package com.ubboeicke.application.Model.Gamedata.Heroes;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.GameObjectConstructor;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.Promotions;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class HeroParser {
    private CenterViewController mCenterViewController;
    private ArrayList<String> StringList_OH = new ArrayList<>();
    private ArrayList<String> StringList_UH = new ArrayList<>();
    private ObservableList<Item> mWeaponList;
    private ObservableList<Item> mAccessoryList;
    private GameObjectConstructor goc;

    public HeroParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;
        goc = new GameObjectConstructor();
        mWeaponList = mCenterViewController.getItemWeaponTableView().getItems();
        mAccessoryList = mCenterViewController.getItemAccessoryTableView().getItems();
    }

    public ArrayList<String> getStrings_OH() {
        for (Hero hero : mCenterViewController.getHeroTableView1().getItems()) {
            String s;
            s = String.format("%s,%s,%s,%s,%s,%s,%s", hero.getName(), hero.getPromotion().getSelectionModel().getSelectedItem(), hero.getLevel().getText(), hero.getLevelPrestige().getText(), hero.getAttackMode().getSelectionModel().getSelectedItem().toString(), hero.getWeapon().getSelectionModel().getSelectedItem(), hero.getAccessory().getSelectionModel().getSelectedItem());
            StringList_OH.add(s);
        }
        return StringList_OH;
    }

    public ArrayList<String> getStrings_UH() {
        for (Hero hero : mCenterViewController.getHeroTableView2().getItems()) {
            String s;
            s = String.format("%s,%s,%s,%s,%s", hero.getName(), hero.getPromotion().getSelectionModel().getSelectedItem(), hero.getLevel().getText(), hero.getWeapon().getSelectionModel().getSelectedItem(), hero.getAccessory().getSelectionModel().getSelectedItem());
            StringList_UH.add(s);
        }
        return StringList_UH;
    }

    public Hero splitStrings_OH(String string) {
        Hero hero;
        String mString = string;
        String[] parts = mString.split(",");
        String p0 = parts[0];
        String p1 = parts[1];
        String p2 = parts[2];
        String p3 = parts[3];
        String p4 = parts[4];
        String p5 = parts[5];
        String p6 = parts[6];
        hero = new Hero(p0, goc.loadPromotionCB(p1, Promotions.getPromotion(p0)), goc.loadLevelTextField(p2), goc.loadLevelPrestigeTextField(p3), goc.loadAttackModeCB(p4), goc.loadWeaponCB(p5, mWeaponList), goc.loadAccessoryCB(p6, mAccessoryList));
        return hero;
    }

    public Hero splitStrings_UH(String string) {
        Hero hero;
        String mString = string;
        String[] parts = mString.split(",");
        String p0 = parts[0];
        String p1 = parts[1];
        String p2 = parts[2];
        String p3 = parts[3];
        String p4 = parts[4];
        hero = new Hero(p0, goc.loadPromotionCB(p1, Promotions.getPromotion(p0)), goc.loadLevelTextField(p2), goc.loadWeaponCB(p3, mWeaponList), goc.loadAccessoryCB(p4, mAccessoryList));
        return hero;
    }
}
