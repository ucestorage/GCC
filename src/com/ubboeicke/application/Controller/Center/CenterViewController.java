package com.ubboeicke.application.Controller.Center;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Hero;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Item;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_TWR_CC;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class CenterViewController {

    @FXML
    private TableView<Item> itemWeaponTableView;
    @FXML
    private TableView<Item> itemAccessoryTableView;
    @FXML
    private TableView<CastleComponent> ccTableView;
    @FXML
    private TableView<Tower> twrTableView;
    @FXML private TableView<Leader> leaderTableView;
    @FXML private TableView<Hero> heroTableView1;
    @FXML private TableView<Hero> heroTableView2;
    @FXML private GridPane tclContainer;
    private ObservableList<Item> mItemWeaponList;
    private ObservableList<Item> mItemAcccessoryList;
    private PopulateTab_Item mPopulateTabItem;
    private PopulateTab_TWR_CC mPopulateTabTwrCc;
    private PopulateTab_Hero mPopulateTabHero;



    //TODO split controller to controllers for single tabs
    public void initialize(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
        mPopulateTabItem = new PopulateTab_Item(this);
        mPopulateTabTwrCc = new PopulateTab_TWR_CC(this);
        mPopulateTabHero = new PopulateTab_Hero(this);




    }

    public ObservableList<Item> getItemWeaponList() {
        mItemWeaponList = mPopulateTabItem.getItemWeaponList();
        return mItemWeaponList;
    }

    public ObservableList<Item> getItemAcccessoryList() {
        mItemAcccessoryList = mPopulateTabItem.getItemAccessoryList();
        return mItemAcccessoryList;
    }

    public TableView<Item> getItemWeaponTableView() {
        return itemWeaponTableView;
    }

    public TableView<Item> getItemAccessoryTableView() {
        return itemAccessoryTableView;
    }

    public TableView<CastleComponent> getCcTableView() {
        return ccTableView;
    }

    public TableView<Tower> getTwrTableView() {
        return twrTableView;
    }

    public TableView<Leader> getLeaderTableView() {
        return leaderTableView;
    }

    public TableView<Hero> getHeroTableView1() {
        return heroTableView1;
    }

    public TableView<Hero> getHeroTableView2() {
        return heroTableView2;
    }

    public GridPane getTclContainer() {
        return tclContainer;
    }

    public PopulateTab_Item getPopulateTabItem() {
        return mPopulateTabItem;
    }

    public PopulateTab_TWR_CC getPopulateTabTwrCc() {
        return mPopulateTabTwrCc;
    }

    public PopulateTab_Hero getPopulateTabHero() {
        return mPopulateTabHero;
    }
}

