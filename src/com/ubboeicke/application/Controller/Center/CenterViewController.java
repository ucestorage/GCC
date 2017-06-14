package com.ubboeicke.application.Controller.Center;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Item;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_TWR_CC;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
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
    @FXML private GridPane tclContainer;
    private PopulateTab_Item mPopulateTabItem;
    private PopulateTab_TWR_CC mPopulateTabTwrCc;


    //TODO split controller to controllers for single tabs
    public void initialize(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
        mPopulateTabItem = new PopulateTab_Item(this);
        mPopulateTabTwrCc = new PopulateTab_TWR_CC(this);


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

