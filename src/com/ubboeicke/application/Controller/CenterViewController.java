package com.ubboeicke.application.Controller;

import com.ubboeicke.application.Controller.CenterSubController.Tabs.PopulateTab_Item;
import com.ubboeicke.application.Controller.CenterSubController.Tabs.PopulateTab_TWR_CC;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.Item;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;

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


    //TODO split controller to controllers for single tabs
    public void initialize(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("../View/Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
        PopulateTab_Item mPopulateTab = new PopulateTab_Item(this);
        PopulateTab_TWR_CC mPopulateTab_twr_cc = new PopulateTab_TWR_CC(this);


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

