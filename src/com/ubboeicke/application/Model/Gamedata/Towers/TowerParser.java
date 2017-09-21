package com.ubboeicke.application.Model.Gamedata.Towers;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.GameObjectConstructor;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.Promotions;

import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class TowerParser {
    private CenterViewController mCenterViewController;
    private ArrayList<String> StringList;
    private GameObjectConstructor goc;

    public TowerParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;
        goc = new GameObjectConstructor();
        StringList = new ArrayList<>();
    }

    public ArrayList<String> getStrings() {
        for (Tower twr : mCenterViewController.getTwrTableView().getItems()) {
            String name = twr.getName();
            String s;
            if (name.equals("Tree")) {
                s = String.format("%s,%s,%s", twr.getName(), twr.getPromotion().getSelectionModel().getSelectedItem(), twr.getLevel().getText());
            } else {
                if (twr.getName().equals("Trophy")) {
                    s = String.format("%s,%s", twr.getName(), twr.getLevel().getText());
                } else {
                    if (name.equals("Cannon") || name.equals("Thorn Worm") || name.equals("Turret")) {
                        s = String.format("%s,%s,%s,%s", twr.getName(), twr.getLevel().getText(), twr.getLevelPrestige().getText(), twr.getAttackMode().getSelectionModel().getSelectedItem().getString());
                    } else {
                        s = String.format("%s,%s,%s,%s,%s", twr.getName(), twr.getPromotion().getSelectionModel().getSelectedItem(), twr.getLevel().getText(), twr.getLevelPrestige().getText(), twr.getAttackMode().getSelectionModel().getSelectedItem().getString());
                    }
                }
            }
            StringList.add(s);
        }
        return StringList;
    }

    public Tower splitStrings(String string) {
        Tower twr = null;
        String[] parts = string.split(",");
        String p0 = parts[0];
        if (p0.equals("Trophy")) {
            twr = new Tower(p0, goc.loadLevelTextField(parts[1]));
        }
        if (p0.equals("Tree")) {
            twr = new Tower(p0, goc.loadPromotionCB(parts[1], Promotions.Tree), goc.loadLevelTextField(parts[2]));
        }
        if (p0.equals("Worm") || p0.equals("Flame Tower") || p0.equals("Frozen Tower") || p0.equals("Lightning Tower") || p0.equals("Barracks")) {
            String p1 = parts[1];
            twr = new Tower(p0, goc.loadPromotionCB(p1, Promotions.getPromotion(p0)), goc.loadLevelTextField(parts[2]), goc.loadLevelPrestigeTextField(parts[3]), goc.loadAttackModeCB(parts[4]));
        }
        if (p0.equals("Cannon") || p0.equals("Thorn Worm") || p0.equals("Turret")) {
            twr = new Tower(p0, goc.loadLevelTextField(parts[1]), goc.loadLevelPrestigeTextField(parts[2]), goc.loadAttackModeCB(parts[3]));
        }
        return twr;
    }

}
