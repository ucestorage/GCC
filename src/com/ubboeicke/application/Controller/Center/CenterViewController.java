package com.ubboeicke.application.Controller.Center;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.*;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class CenterViewController {
    @FXML private Label tbL1;
    @FXML private Label tbL2;
    @FXML private Label tbL3;
    @FXML private Label tL1;
    @FXML private Label tL2;
    @FXML private Label tL3;
    @FXML private Label tL4;
    @FXML private Label tL5;
    @FXML private Label twrL1;
    @FXML private Label twrL2;
    @FXML private Label twrL3;
    @FXML private Label twrL4;
    @FXML private Label twrLL1;
    @FXML private Label twrLL2;
    @FXML private Label twrLL3;
    @FXML private Label twrLL4;
    @FXML private Label ccL1;
    @FXML private Label ccL2;
    @FXML private Label ccL3;
    @FXML private Label ccL4;
    @FXML private Label ccLL1;
    @FXML private Label ccLL2;
    @FXML private Label ccLL3;
    @FXML private Label ccLL4;
    @FXML private Label heroL1;
    @FXML private Label heroLL1;
    @FXML private Label heroDmg1;
    @FXML private Label heroPL1;
    @FXML private Label h1itemSL1;
    @FXML private Label h1itemSL2;
    @FXML private Label h1itemQL1;
    @FXML private Label h1itemQL2;
    @FXML private Label h1attv1L1;
    @FXML private Label h1attv2L1;
    @FXML private Label h1attv3L1;
    @FXML private Label h1attv1L2;
    @FXML private Label h1attv2L2;
    @FXML private Label h1attv3L2;
    @FXML private Label h1att1L1;
    @FXML private Label h1att2L1;
    @FXML private Label h1att3L1;
    @FXML private Label h1att1L2;
    @FXML private Label h1att2L2;
    @FXML private Label h1att3L2;
    @FXML private Label h1ManaL;
    @FXML private Label h1CDL;
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
    @FXML private TableView<Deck> deckTableView;
    @FXML private GridPane tclContainer;
    @FXML
    private ComboBox deckCB;

    private ObservableList<Item> mItemWeaponList;
    private ObservableList<Item> mItemAcccessoryList;
    private PopulateTab_Item mPopulateTabItem;
    private PopulateTab_TWR_CC mPopulateTabTwrCc;
    private PopulateTab_Hero mPopulateTabHero;
    private PopulateTab_Deck mPopulateTabDeck;




    //TODO split controller to controllers for single tabs
    public void initialize(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
        mPopulateTabItem = new PopulateTab_Item(this);
        mPopulateTabTwrCc = new PopulateTab_TWR_CC(this);
        mPopulateTabHero = new PopulateTab_Hero(this);
        mPopulateTabDeck = new PopulateTab_Deck(this);





    }

    public Label getH1ManaL() {
        return h1ManaL;
    }

    public Label getH1CDL() {
        return h1CDL;
    }

    public Label getH1att1L1() {
        return h1att1L1;
    }

    public Label getH1att2L1() {
        return h1att2L1;
    }

    public Label getH1att3L1() {
        return h1att3L1;
    }

    public Label getH1att1L2() {
        return h1att1L2;
    }

    public Label getH1att2L2() {
        return h1att2L2;
    }

    public Label getH1att3L2() {
        return h1att3L2;
    }

    public Label getHeroL1() {
        return heroL1;
    }

    public Label getH1itemSL1() {
        return h1itemSL1;
    }

    public Label getH1itemSL2() {
        return h1itemSL2;
    }

    public Label getH1itemQL1() {
        return h1itemQL1;
    }

    public Label getH1itemQL2() {
        return h1itemQL2;
    }

    public Label getH1attv1L1() {
        return h1attv1L1;
    }

    public Label getH1attv2L1() {
        return h1attv2L1;
    }

    public Label getH1attv3L1() {
        return h1attv3L1;
    }

    public Label getH1attv1L2() {
        return h1attv1L2;
    }

    public Label getH1attv2L2() {
        return h1attv2L2;
    }

    public Label getH1attv3L2() {
        return h1attv3L2;
    }

    public Label getHeroLL1() {
        return heroLL1;
    }

    public Label getHeroDmg1() {
        return heroDmg1;
    }

    public Label getHeroPL1() {
        return heroPL1;
    }

    public Label getCcL1() {
        return ccL1;
    }

    public Label getCcL2() {
        return ccL2;
    }

    public Label getCcL3() {
        return ccL3;
    }

    public Label getCcL4() {
        return ccL4;
    }

    public Label getCcLL1() {
        return ccLL1;
    }

    public Label getCcLL2() {
        return ccLL2;
    }

    public Label getCcLL3() {
        return ccLL3;
    }

    public Label getCcLL4() {
        return ccLL4;
    }

    public Label getTwrL1() {
        return twrL1;
    }

    public Label getTwrL2() {
        return twrL2;
    }

    public Label getTwrL3() {
        return twrL3;
    }

    public Label getTwrL4() {
        return twrL4;
    }

    public Label getTwrLL1() {
        return twrLL1;
    }

    public Label getTwrLL2() {
        return twrLL2;
    }

    public Label getTwrLL3() {
        return twrLL3;
    }

    public Label getTwrLL4() {
        return twrLL4;
    }

    public Label getTbL1() {
        return tbL1;
    }

    public Label getTbL2() {
        return tbL2;
    }

    public Label getTbL3() {
        return tbL3;
    }

    public Label gettL1() {
        return tL1;
    }

    public Label gettL2() {
        return tL2;
    }

    public Label gettL3() {
        return tL3;
    }

    public Label gettL4() {
        return tL4;
    }

    public Label gettL5() {
        return tL5;
    }

    public ComboBox getDeckCB() {
        return deckCB;
    }

    public ObservableList<Item> getItemWeaponList() {
        mItemWeaponList = mPopulateTabItem.getItemWeaponList();
        return mItemWeaponList;
    }

    public ObservableList<Item> getItemAcccessoryList() {
        mItemAcccessoryList = mPopulateTabItem.getItemAccessoryList();
        return mItemAcccessoryList;
    }

    public TableView<Deck> getDeckTableView() {
        return deckTableView;
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

    public PopulateTab_Deck getPopulateTabDeck() {
        return mPopulateTabDeck;
    }
}

