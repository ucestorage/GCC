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
    private Button createItem;
    @FXML
    private TableView<Item> itemTableView;
    @FXML
    private TableView<CastleComponent> ccTableView;
    @FXML
    private TableView<Tower> twrTableView;
    @FXML private TableView<Leader> leaderTableView;
    @FXML private TableView<Hero> heroTableView1;
    @FXML private TableView<Hero> heroTableView2;
    @FXML private GridPane tclContainer;
    private PopulateTab_Item mPopulateTabItem;
    private PopulateTab_TWR_CC mPopulateTabTwrCc;
    private PopulateTab_Hero mPopulateTabHero;
    private ObservableList<String> weaponNameList = FXCollections.observableArrayList();
    private ObservableList<String> accessoryNameList = FXCollections.observableArrayList();


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
    public void splitItemList() {

        for (Item item : mPopulateTabItem.getItemList()) {

            if (item.getSortOfItem().equals("Bracelet")||item.getSortOfItem().equals("Earrings")||item.getSortOfItem().equals("Necklace")||item.getSortOfItem().equals("Ring")) {
                accessoryNameList.add(item.getItemName());
            }
        }
        for (Item item : mPopulateTabItem.getItemList()) {

            if (item.getSortOfItem().equals("Sword") || item.getSortOfItem().equals("Staff") || item.getSortOfItem().equals("Bow") || item.getSortOfItem().equals("Hammer")) {
                weaponNameList.add(item.getItemName());
            }
        }

    }

    public ObservableList<String> getWeaponNameList() {
        return weaponNameList;
    }

    public ObservableList<String> getAccessoryNameList() {
        return accessoryNameList;
    }

    public TableView<Hero> getHeroTableView1() {
        return heroTableView1;
    }

    public TableView<Hero> getHeroTableView2() {
        return heroTableView2;
    }

    public TableView<Leader> getLeaderTableView() {
        return leaderTableView;
    }

    public PopulateTab_Item getPopulateTabItem() {
        return mPopulateTabItem;
    }

    public PopulateTab_TWR_CC getPopulateTabTwrCc() {
        return mPopulateTabTwrCc;
    }

    public GridPane getTclContainer() {
        return tclContainer;
    }

    public TableView<Tower> getTwrTableView() {
        return twrTableView;
    }


    public TableView<Item> getItemTableView() {
        return itemTableView;
    }

    public TableView<CastleComponent> getCcTableView() {
        return ccTableView;
    }




    public Button getCreateItem() {
        return createItem;
    }


}

