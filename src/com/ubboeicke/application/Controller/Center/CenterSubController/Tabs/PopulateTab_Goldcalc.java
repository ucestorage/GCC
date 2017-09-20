package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PopulateTab_Goldcalc {
    private CenterViewController mCenterViewController;
    private TableView<Hero> mHeroTableView;
    private ObservableList<Hero> mHeroList = FXCollections.observableArrayList();
    private GameObjectConstructor goc;
    private TableView<Hero> getmHeroTableView;
    //TODO make ghold calc

    public PopulateTab_Goldcalc(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;
        mHeroTableView = mCenterViewController.getGoldHeroesTV();
        getmHeroTableView = mCenterViewController.getHeroTableView1();
        goc = new GameObjectConstructor();
        setupHeroTableView();


    }

    private void setupHeroTableView() {
        TableColumn c1 = new TableColumn("Hero");
        c1.setPrefWidth(200.0);
        c1.setCellValueFactory(new PropertyValueFactory<Hero, String>("Name"));
        TableColumn c2 = new TableColumn("Level");
        c2.setPrefWidth(200.0);
        c2.setCellValueFactory(new PropertyValueFactory<Hero, String>("goldLvl"));
        TableColumn c3 = new TableColumn("Desired Level");
        c3.setPrefWidth(200.0);
        c3.setCellValueFactory(new PropertyValueFactory<Hero, String>("wantLvl"));
        TableColumn c4 = new TableColumn("Upgrade Cost");
        c4.setPrefWidth(200.0);
        c4.setCellValueFactory(new PropertyValueFactory<Hero, String>("UpgCost"));
        TableColumn c5 = new TableColumn("Total Gold Cost");
        c5.setPrefWidth(200.0);
        c5.setCellValueFactory(new PropertyValueFactory<Hero, String>("TotalGold"));
        TableColumn c6 = new TableColumn("Gold/Dmg");
        c6.setPrefWidth(200.0);
        c6.setCellValueFactory(new PropertyValueFactory<Hero, String>("GoldDmg"));
        mHeroTableView.getColumns().addAll(c1, c2, c3, c4, c5, c6);
        mHeroTableView.setColumnResizePolicy(param -> true);


    }

    public void goldCalc() {
        Double upgCost = 0.0;

        for (
                Hero h : mHeroTableView.getItems())

        {
            if (h.getName().equals("Archer") || h.getName().equals("Lightning Mage") || h.getName().equals("Fire Mage") || h.getName().equals("Assassin")) {
                upgCost = 5500.0;
            } else {
                upgCost = 6050.0;
            }

            h.getTotalGold().setText(goldLabel(h.getGoldLvl(),h.getWantLvl(),h.getUpgCost(),upgCost));
            h.getGoldDmg().setText("Test");

            // mCenterViewController.getmPopulateGold().goldLabel(h.getTotalGold(),h.getLevel().getText(),h.getWantLvl().getText(),h.getUpgCost().getText(),upgCost);
        }

    }
    private String goldDmg(){

        Double finalGoldDmg = 0.0;
        BigDecimal bd = new BigDecimal(finalGoldDmg);
        NumberFormat nf = NumberFormat.getInstance(new Locale("en_US"));
        //TODO make gold per dmg calc, get calc dmg make new dmg calc with wantlvl calc diff; Total Gold Cost / Diff
        return nf.format(bd.longValue());
    }
    private String goldLabel(Label lvl, TextField wantLvl, TextField upgCost, Double lvlCost) {

        if (wantLvl.getText().equals(lvl.getText()) || Double.parseDouble(wantLvl.getText()) <= Double.parseDouble(lvl.getText())) {
            return "Please change values!";
        } else {
            Double lvlrange = 0.0;
            Double lvlCostd = 0.0;
            Double finalCost = 0.0;

            lvlrange = Double.parseDouble(wantLvl.getText()) - Double.parseDouble(lvl.getText());

            Double upgCostd = Double.parseDouble(upgCost.getText());
            finalCost = lvlrange * ((lvlCost/2) * (lvlrange - 1.0) + upgCostd);
            BigDecimal bd = new BigDecimal(finalCost);
            NumberFormat nf = NumberFormat.getInstance(new Locale("en_US"));

            return nf.format(bd.longValue());
        }

    }

    public void addHeroes() {

        for (Hero h : mCenterViewController.getHeroTableView1().getItems()) {
            // System.out.println(h.getPromotion().getSelectionModel().getSelectedItem().toString()+h.getLevel().getText());
            mHeroList.add(new Hero(h.getName(), goc.lvlLabel(h.getLevel().getText()), goc.loadLevelTextField(h.getLevel().getText()), goc.levelTextField(), goc.Label("0"), goc.Label("0")));
        }
        mHeroTableView.setItems(mHeroList);
    }
}
