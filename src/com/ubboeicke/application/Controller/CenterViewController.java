package com.ubboeicke.application.Controller;

import com.ubboeicke.application.Controller.CenterSubController.Tabs.PopulateTab_Item;
import com.ubboeicke.application.Controller.CenterSubController.Tabs.PopulateTab_TWR_CC;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

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
    private ObservableList<Item> mItemObservableList = FXCollections.observableArrayList();
    private PopulateTab_Item mPopulateTab;
    private PopulateTab_TWR_CC mPopulateTab_twr_cc;

    //TODO split controller to controllers for single tabs
    public void initialize(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("../View/Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
        mPopulateTab = new PopulateTab_Item(this);
        mPopulateTab_twr_cc = new PopulateTab_TWR_CC(this);


    }
    public TableView<Item> getItemTableView() {return itemTableView;}
    public TableView<CastleComponent> getCcTableView() {
        return ccTableView;
    }

    public void setCcTableView(TableView<CastleComponent> ccTableView) {
        this.ccTableView = ccTableView;
    }

    public ObservableList<Item> getItemObservableList() {
        return mItemObservableList;
    }

    public void setItemObservableList(ObservableList<Item> itemObservableList) {
        mItemObservableList = itemObservableList;
    }

    public Button getCreateItem() {
        return createItem;
    }

    public void setCreateItem(Button createItem) {
        this.createItem = createItem;
    }

    public void setItemTableView(TableView<Item> itemTableView) {
        this.itemTableView = itemTableView;
    }



}

