package com.ubboeicke.application.Controller.Center;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Deck;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Hero;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Item;
import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_TWR_CC;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
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
    @FXML
    private Tab overviewTab;

    @FXML
    private Label tL1;

    @FXML
    private Label tL2;

    @FXML
    private Label tL3;

    @FXML
    private Label tL4;

    @FXML
    private Label tL5;

    @FXML
    private Label ldrL;

    @FXML
    private Label ldrLvlL;

    @FXML
    private Label ldrAML;

    @FXML
    private Label ldrDmgL;

    @FXML
    private Label tbL1;

    @FXML
    private Label tbL2;

    @FXML
    private Label tbL3;

    @FXML
    private ComboBox<String> deckCB;

    @FXML
    private Label nameLH;

    @FXML
    private Label lvlLH;

    @FXML
    private Label lvlVLH;

    @FXML
    private Label dmgLH;

    @FXML
    private Label lvlPLH;

    @FXML
    private Label lvlPVLH;

    @FXML
    private Label att1WLH;

    @FXML
    private Label att2WLH;

    @FXML
    private Label att3WLH;

    @FXML
    private Label itemSWLH;

    @FXML
    private Label itemQWLH;

    @FXML
    private Label att1ALH;

    @FXML
    private Label att2ALH;

    @FXML
    private Label att3ALH;

    @FXML
    private Label itemSALH;

    @FXML
    private Label itemQALH;

    @FXML
    private Label att1VWLH;

    @FXML
    private Label att2VWLH;

    @FXML
    private Label att3VWLH;

    @FXML
    private Label att1VALH;

    @FXML
    private Label manaLH;

    @FXML
    private Label manaVLH;

    @FXML
    private Label cdLH;

    @FXML
    private Label cdVLH;

    @FXML
    private Label att2VALH;

    @FXML
    private Label att3VALH;

    @FXML
    private Label amLH;

    @FXML
    private Label amVLH;

    @FXML
    private Label nameLH1;

    @FXML
    private Label lvlLH1;

    @FXML
    private Label lvlVLH1;

    @FXML
    private Label dmgLH1;

    @FXML
    private Label lvlPLH1;

    @FXML
    private Label lvlPVLH1;

    @FXML
    private Label att1WLH1;

    @FXML
    private Label att2WLH1;

    @FXML
    private Label att3WLH1;

    @FXML
    private Label itemSWLH1;

    @FXML
    private Label itemQWLH1;

    @FXML
    private Label att1ALH1;

    @FXML
    private Label att2ALH1;

    @FXML
    private Label att3ALH1;

    @FXML
    private Label itemSALH1;

    @FXML
    private Label itemQALH1;

    @FXML
    private Label att1VWLH1;

    @FXML
    private Label att2VWLH1;

    @FXML
    private Label att3VWLH1;

    @FXML
    private Label att1VALH1;

    @FXML
    private Label manaLH1;

    @FXML
    private Label manaVLH1;

    @FXML
    private Label cdLH1;

    @FXML
    private Label cdVLH1;

    @FXML
    private Label att2VALH1;

    @FXML
    private Label att3VALH1;

    @FXML
    private Label amLH1;

    @FXML
    private Label amVLH1;

    @FXML
    private Label nameLH2;

    @FXML
    private Label lvlLH2;

    @FXML
    private Label lvlVLH2;

    @FXML
    private Label dmgLH2;

    @FXML
    private Label lvlPLH2;

    @FXML
    private Label lvlPVLH2;

    @FXML
    private Label att1WLH2;

    @FXML
    private Label att2WLH2;

    @FXML
    private Label att3WLH2;

    @FXML
    private Label itemSWLH2;

    @FXML
    private Label itemQWLH2;

    @FXML
    private Label att1ALH2;

    @FXML
    private Label att2ALH2;

    @FXML
    private Label att3ALH2;

    @FXML
    private Label itemSALH2;

    @FXML
    private Label itemQALH2;

    @FXML
    private Label att1VWLH2;

    @FXML
    private Label att2VWLH2;

    @FXML
    private Label att3VWLH2;

    @FXML
    private Label att1VALH2;

    @FXML
    private Label manaLH2;

    @FXML
    private Label manaVLH2;

    @FXML
    private Label cdLH2;

    @FXML
    private Label cdVLH2;

    @FXML
    private Label att2VALH2;

    @FXML
    private Label att3VALH2;

    @FXML
    private Label amLH2;

    @FXML
    private Label amVLH2;

    @FXML
    private Label nameLH3;

    @FXML
    private Label lvlLH3;

    @FXML
    private Label lvlVLH3;

    @FXML
    private Label dmgLH3;

    @FXML
    private Label lvlPLH3;

    @FXML
    private Label lvlPVLH3;

    @FXML
    private Label att1WLH3;

    @FXML
    private Label att2WLH3;

    @FXML
    private Label att3WLH3;

    @FXML
    private Label itemSWLH3;

    @FXML
    private Label itemQWLH3;

    @FXML
    private Label att1ALH3;

    @FXML
    private Label att2ALH3;

    @FXML
    private Label att3ALH3;

    @FXML
    private Label itemSALH3;

    @FXML
    private Label itemQALH3;

    @FXML
    private Label att1VWLH3;

    @FXML
    private Label att2VWLH3;

    @FXML
    private Label att3VWLH3;

    @FXML
    private Label att1VALH3;

    @FXML
    private Label manaLH3;

    @FXML
    private Label manaVLH3;

    @FXML
    private Label cdLH3;

    @FXML
    private Label cdVLH3;

    @FXML
    private Label att2VALH3;

    @FXML
    private Label att3VALH3;

    @FXML
    private Label amLH3;

    @FXML
    private Label amVLH3;

    @FXML
    private Label nameLH4;

    @FXML
    private Label lvlLH4;

    @FXML
    private Label lvlVLH4;

    @FXML
    private Label dmgLH4;

    @FXML
    private Label lvlPLH4;

    @FXML
    private Label lvlPVLH4;

    @FXML
    private Label att1WLH4;

    @FXML
    private Label att2WLH4;

    @FXML
    private Label att3WLH4;

    @FXML
    private Label itemSWLH4;

    @FXML
    private Label itemQWLH4;

    @FXML
    private Label att1ALH4;

    @FXML
    private Label att2ALH4;

    @FXML
    private Label att3ALH4;

    @FXML
    private Label itemSALH4;

    @FXML
    private Label itemQALH4;

    @FXML
    private Label att1VWLH4;

    @FXML
    private Label att2VWLH4;

    @FXML
    private Label att3VWLH4;

    @FXML
    private Label att1VALH4;

    @FXML
    private Label manaLH4;

    @FXML
    private Label manaVLH4;

    @FXML
    private Label cdLH4;

    @FXML
    private Label cdVLH4;

    @FXML
    private Label att2VALH4;

    @FXML
    private Label att3VALH4;

    @FXML
    private Label amLH4;

    @FXML
    private Label amVLH4;

    @FXML
    private Label nameLH5;

    @FXML
    private Label lvlLH5;

    @FXML
    private Label lvlVLH5;

    @FXML
    private Label dmgLH5;

    @FXML
    private Label lvlPLH5;

    @FXML
    private Label lvlPVLH5;

    @FXML
    private Label att1WLH5;

    @FXML
    private Label att2WLH5;

    @FXML
    private Label att3WLH5;

    @FXML
    private Label itemSWLH5;

    @FXML
    private Label itemQWLH5;

    @FXML
    private Label att1ALH5;

    @FXML
    private Label att2ALH5;

    @FXML
    private Label att3ALH5;

    @FXML
    private Label itemSALH5;

    @FXML
    private Label itemQALH5;

    @FXML
    private Label att1VWLH5;

    @FXML
    private Label att2VWLH5;

    @FXML
    private Label att3VWLH5;

    @FXML
    private Label att1VALH5;

    @FXML
    private Label manaLH5;

    @FXML
    private Label manaVLH5;

    @FXML
    private Label cdLH5;

    @FXML
    private Label cdVLH5;

    @FXML
    private Label att2VALH5;

    @FXML
    private Label att3VALH5;

    @FXML
    private Label amLH5;

    @FXML
    private Label amVLH5;

    @FXML
    private Label nameLH6;

    @FXML
    private Label lvlLH6;

    @FXML
    private Label lvlVLH6;

    @FXML
    private Label dmgLH6;

    @FXML
    private Label lvlPLH6;

    @FXML
    private Label lvlPVLH6;

    @FXML
    private Label att1WLH6;

    @FXML
    private Label att2WLH6;

    @FXML
    private Label att3WLH6;

    @FXML
    private Label itemSWLH6;

    @FXML
    private Label itemQWLH6;

    @FXML
    private Label att1ALH6;

    @FXML
    private Label att2ALH6;

    @FXML
    private Label att3ALH6;

    @FXML
    private Label itemSALH6;

    @FXML
    private Label itemQALH6;

    @FXML
    private Label att1VWLH6;

    @FXML
    private Label att2VWLH6;

    @FXML
    private Label att3VWLH6;

    @FXML
    private Label att1VALH6;

    @FXML
    private Label manaLH6;

    @FXML
    private Label manaVLH6;

    @FXML
    private Label cdLH6;

    @FXML
    private Label cdVLH6;

    @FXML
    private Label att2VALH6;

    @FXML
    private Label att3VALH6;

    @FXML
    private Label amLH6;

    @FXML
    private Label amVLH6;

    @FXML
    private Label nameLH7;

    @FXML
    private Label lvlLH7;

    @FXML
    private Label lvlVLH7;

    @FXML
    private Label dmgLH7;

    @FXML
    private Label lvlPLH7;

    @FXML
    private Label lvlPVLH7;

    @FXML
    private Label att1WLH7;

    @FXML
    private Label att2WLH7;

    @FXML
    private Label att3WLH7;

    @FXML
    private Label itemSWLH7;

    @FXML
    private Label itemQWLH7;

    @FXML
    private Label att1ALH7;

    @FXML
    private Label att2ALH7;

    @FXML
    private Label att3ALH7;

    @FXML
    private Label itemSALH7;

    @FXML
    private Label itemQALH7;

    @FXML
    private Label att1VWLH7;

    @FXML
    private Label att2VWLH7;

    @FXML
    private Label att3VWLH7;

    @FXML
    private Label att1VALH7;

    @FXML
    private Label manaLH7;

    @FXML
    private Label manaVLH7;

    @FXML
    private Label cdLH7;

    @FXML
    private Label cdVLH7;

    @FXML
    private Label att2VALH7;

    @FXML
    private Label att3VALH7;

    @FXML
    private Label amLH7;

    @FXML
    private Label amVLH7;

    @FXML
    private Label nameLH8;

    @FXML
    private Label lvlLH8;

    @FXML
    private Label lvlVLH8;

    @FXML
    private Label dmgLH8;

    @FXML
    private Label lvlPLH8;

    @FXML
    private Label lvlPVLH8;

    @FXML
    private Label att1WLH8;

    @FXML
    private Label att2WLH8;

    @FXML
    private Label att3WLH8;

    @FXML
    private Label itemSWLH8;

    @FXML
    private Label itemQWLH8;

    @FXML
    private Label att1ALH8;

    @FXML
    private Label att2ALH8;

    @FXML
    private Label att3ALH8;

    @FXML
    private Label itemSALH8;

    @FXML
    private Label itemQALH8;

    @FXML
    private Label att1VWLH8;

    @FXML
    private Label att2VWLH8;

    @FXML
    private Label att3VWLH8;

    @FXML
    private Label att1VALH8;

    @FXML
    private Label manaLH8;

    @FXML
    private Label manaVLH8;

    @FXML
    private Label cdLH8;

    @FXML
    private Label cdVLH8;

    @FXML
    private Label att2VALH8;

    @FXML
    private Label att3VALH8;

    @FXML
    private Label amLH8;

    @FXML
    private Label amVLH8;

    @FXML
    private Label nameLH9;

    @FXML
    private Label lvlLH9;

    @FXML
    private Label lvlVLH9;

    @FXML
    private Label dmgLH9;

    @FXML
    private Label lvlPLH9;

    @FXML
    private Label lvlPVLH9;

    @FXML
    private Label att1WLH9;

    @FXML
    private Label att2WLH9;

    @FXML
    private Label att3WLH9;

    @FXML
    private Label itemSWLH9;

    @FXML
    private Label itemQWLH9;

    @FXML
    private Label att1ALH9;

    @FXML
    private Label att2ALH9;

    @FXML
    private Label att3ALH9;

    @FXML
    private Label itemSALH9;

    @FXML
    private Label itemQALH9;

    @FXML
    private Label att1VWLH9;

    @FXML
    private Label att2VWLH9;

    @FXML
    private Label att3VWLH9;

    @FXML
    private Label att1VALH9;

    @FXML
    private Label manaLH9;

    @FXML
    private Label manaVLH9;

    @FXML
    private Label cdLH9;

    @FXML
    private Label cdVLH9;

    @FXML
    private Label att2VALH9;

    @FXML
    private Label att3VALH9;

    @FXML
    private Label amLH9;

    @FXML
    private Label amVLH9;

    @FXML
    private Label nameLH10;

    @FXML
    private Label lvlLH10;

    @FXML
    private Label lvlVLH10;

    @FXML
    private Label dmgLH10;

    @FXML
    private Label lvlPLH10;

    @FXML
    private Label lvlPVLH10;

    @FXML
    private Label att1WLH10;

    @FXML
    private Label att2WLH10;

    @FXML
    private Label att3WLH10;

    @FXML
    private Label itemSWLH10;

    @FXML
    private Label itemQWLH10;

    @FXML
    private Label att1ALH10;

    @FXML
    private Label att2ALH10;

    @FXML
    private Label att3ALH10;

    @FXML
    private Label itemSALH10;

    @FXML
    private Label itemQALH10;

    @FXML
    private Label att1VWLH10;

    @FXML
    private Label att2VWLH10;

    @FXML
    private Label att3VWLH10;

    @FXML
    private Label att1VALH10;

    @FXML
    private Label manaLH10;

    @FXML
    private Label manaVLH10;

    @FXML
    private Label cdLH10;

    @FXML
    private Label cdVLH10;

    @FXML
    private Label att2VALH10;

    @FXML
    private Label att3VALH10;

    @FXML
    private Label amLH10;

    @FXML
    private Label amVLH10;

    @FXML
    private Label nameLH11;

    @FXML
    private Label lvlLH11;

    @FXML
    private Label lvlVLH11;

    @FXML
    private Label dmgLH11;

    @FXML
    private Label lvlPLH11;

    @FXML
    private Label lvlPVLH11;

    @FXML
    private Label att1WLH11;

    @FXML
    private Label att2WLH11;

    @FXML
    private Label att3WLH11;

    @FXML
    private Label itemSWLH11;

    @FXML
    private Label itemQWLH11;

    @FXML
    private Label att1ALH11;

    @FXML
    private Label att2ALH11;

    @FXML
    private Label att3ALH11;

    @FXML
    private Label itemSALH11;

    @FXML
    private Label itemQALH11;

    @FXML
    private Label att1VWLH11;

    @FXML
    private Label att2VWLH11;

    @FXML
    private Label att3VWLH11;

    @FXML
    private Label att1VALH11;

    @FXML
    private Label manaLH11;

    @FXML
    private Label manaVLH11;

    @FXML
    private Label cdLH11;

    @FXML
    private Label cdVLH11;

    @FXML
    private Label att2VALH11;

    @FXML
    private Label att3VALH11;

    @FXML
    private Label amLH11;

    @FXML
    private Label amVLH11;

    @FXML
    private Label twrL;

    @FXML
    private Label twrLL;

    @FXML
    private Label twrAML;

    @FXML
    private Label twrDmgL;

    @FXML
    private Label twrL1;

    @FXML
    private Label twrLL1;

    @FXML
    private Label twrAML1;

    @FXML
    private Label twrDmgL1;

    @FXML
    private Label twrL2;

    @FXML
    private Label twrLL2;

    @FXML
    private Label twrAML2;

    @FXML
    private Label twrDmgL2;

    @FXML
    private Label twrL3;

    @FXML
    private Label twrLL3;

    @FXML
    private Label twrAML3;

    @FXML
    private Label twrDmgL3;

    @FXML
    private Label ccL;

    @FXML
    private Label ccLL;

    @FXML
    private Label ccAML;

    @FXML
    private Label ccDmgL;

    @FXML
    private Label ccL1;

    @FXML
    private Label ccLL1;

    @FXML
    private Label ccAML1;

    @FXML
    private Label ccDmgL1;

    @FXML
    private Label ccL2;

    @FXML
    private Label ccLL2;

    @FXML
    private Label ccAML2;

    @FXML
    private Label ccDmgL2;

    @FXML
    private Label ccL3;

    @FXML
    private Label ccLL3;

    @FXML
    private Label ccAML3;

    @FXML
    private Label ccDmgL3;

    @FXML
    private TableView<Hero> heroTableView1;

    @FXML
    private TableView<Hero> heroTableView2;

    @FXML
    private GridPane tclCOntainer;

    @FXML
    private TableView<CastleComponent> ccTableView;

    @FXML
    private TableView<Tower> twrTableView;

    @FXML
    private TableView<Leader> leaderTableView;

    @FXML
    private TableView<Item> itemWeaponTableView;

    @FXML
    private TableView<Item> itemAccessoryTableView;

    @FXML
    private TableView<Deck> deckTableView;


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

    public PopulateTab_Item getmPopulateTabItem() {
        return mPopulateTabItem;
    }

    public PopulateTab_TWR_CC getmPopulateTabTwrCc() {
        return mPopulateTabTwrCc;
    }

    public PopulateTab_Hero getmPopulateTabHero() {
        return mPopulateTabHero;
    }

    public PopulateTab_Deck getmPopulateTabDeck() {
        return mPopulateTabDeck;
    }

    public Tab getOverviewTab() {
        return overviewTab;
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

    public Label getLdrL() {
        return ldrL;
    }

    public Label getLdrLvlL() {
        return ldrLvlL;
    }

    public Label getLdrAML() {
        return ldrAML;
    }

    public Label getLdrDmgL() {
        return ldrDmgL;
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

    public ComboBox<String> getDeckCB() {
        return deckCB;
    }

    public Label getNameLH() {
        return nameLH;
    }

    public Label getLvlLH() {
        return lvlLH;
    }

    public Label getLvlVLH() {
        return lvlVLH;
    }

    public Label getDmgLH() {
        return dmgLH;
    }

    public Label getLvlPLH() {
        return lvlPLH;
    }

    public Label getLvlPVLH() {
        return lvlPVLH;
    }

    public Label getAtt1WLH() {
        return att1WLH;
    }

    public Label getAtt2WLH() {
        return att2WLH;
    }

    public Label getAtt3WLH() {
        return att3WLH;
    }

    public Label getItemSWLH() {
        return itemSWLH;
    }

    public Label getItemQWLH() {
        return itemQWLH;
    }

    public Label getAtt1ALH() {
        return att1ALH;
    }

    public Label getAtt2ALH() {
        return att2ALH;
    }

    public Label getAtt3ALH() {
        return att3ALH;
    }

    public Label getItemSALH() {
        return itemSALH;
    }

    public Label getItemQALH() {
        return itemQALH;
    }

    public Label getAtt1VWLH() {
        return att1VWLH;
    }

    public Label getAtt2VWLH() {
        return att2VWLH;
    }

    public Label getAtt3VWLH() {
        return att3VWLH;
    }

    public Label getAtt1VALH() {
        return att1VALH;
    }

    public Label getManaLH() {
        return manaLH;
    }

    public Label getManaVLH() {
        return manaVLH;
    }

    public Label getCdLH() {
        return cdLH;
    }

    public Label getCdVLH() {
        return cdVLH;
    }

    public Label getAtt2VALH() {
        return att2VALH;
    }

    public Label getAtt3VALH() {
        return att3VALH;
    }

    public Label getAmLH() {
        return amLH;
    }

    public Label getAmVLH() {
        return amVLH;
    }

    public Label getNameLH1() {
        return nameLH1;
    }

    public Label getLvlLH1() {
        return lvlLH1;
    }

    public Label getLvlVLH1() {
        return lvlVLH1;
    }

    public Label getDmgLH1() {
        return dmgLH1;
    }

    public Label getLvlPLH1() {
        return lvlPLH1;
    }

    public Label getLvlPVLH1() {
        return lvlPVLH1;
    }

    public Label getAtt1WLH1() {
        return att1WLH1;
    }

    public Label getAtt2WLH1() {
        return att2WLH1;
    }

    public Label getAtt3WLH1() {
        return att3WLH1;
    }

    public Label getItemSWLH1() {
        return itemSWLH1;
    }

    public Label getItemQWLH1() {
        return itemQWLH1;
    }

    public Label getAtt1ALH1() {
        return att1ALH1;
    }

    public Label getAtt2ALH1() {
        return att2ALH1;
    }

    public Label getAtt3ALH1() {
        return att3ALH1;
    }

    public Label getItemSALH1() {
        return itemSALH1;
    }

    public Label getItemQALH1() {
        return itemQALH1;
    }

    public Label getAtt1VWLH1() {
        return att1VWLH1;
    }

    public Label getAtt2VWLH1() {
        return att2VWLH1;
    }

    public Label getAtt3VWLH1() {
        return att3VWLH1;
    }

    public Label getAtt1VALH1() {
        return att1VALH1;
    }

    public Label getManaLH1() {
        return manaLH1;
    }

    public Label getManaVLH1() {
        return manaVLH1;
    }

    public Label getCdLH1() {
        return cdLH1;
    }

    public Label getCdVLH1() {
        return cdVLH1;
    }

    public Label getAtt2VALH1() {
        return att2VALH1;
    }

    public Label getAtt3VALH1() {
        return att3VALH1;
    }

    public Label getAmLH1() {
        return amLH1;
    }

    public Label getAmVLH1() {
        return amVLH1;
    }

    public Label getNameLH2() {
        return nameLH2;
    }

    public Label getLvlLH2() {
        return lvlLH2;
    }

    public Label getLvlVLH2() {
        return lvlVLH2;
    }

    public Label getDmgLH2() {
        return dmgLH2;
    }

    public Label getLvlPLH2() {
        return lvlPLH2;
    }

    public Label getLvlPVLH2() {
        return lvlPVLH2;
    }

    public Label getAtt1WLH2() {
        return att1WLH2;
    }

    public Label getAtt2WLH2() {
        return att2WLH2;
    }

    public Label getAtt3WLH2() {
        return att3WLH2;
    }

    public Label getItemSWLH2() {
        return itemSWLH2;
    }

    public Label getItemQWLH2() {
        return itemQWLH2;
    }

    public Label getAtt1ALH2() {
        return att1ALH2;
    }

    public Label getAtt2ALH2() {
        return att2ALH2;
    }

    public Label getAtt3ALH2() {
        return att3ALH2;
    }

    public Label getItemSALH2() {
        return itemSALH2;
    }

    public Label getItemQALH2() {
        return itemQALH2;
    }

    public Label getAtt1VWLH2() {
        return att1VWLH2;
    }

    public Label getAtt2VWLH2() {
        return att2VWLH2;
    }

    public Label getAtt3VWLH2() {
        return att3VWLH2;
    }

    public Label getAtt1VALH2() {
        return att1VALH2;
    }

    public Label getManaLH2() {
        return manaLH2;
    }

    public Label getManaVLH2() {
        return manaVLH2;
    }

    public Label getCdLH2() {
        return cdLH2;
    }

    public Label getCdVLH2() {
        return cdVLH2;
    }

    public Label getAtt2VALH2() {
        return att2VALH2;
    }

    public Label getAtt3VALH2() {
        return att3VALH2;
    }

    public Label getAmLH2() {
        return amLH2;
    }

    public Label getAmVLH2() {
        return amVLH2;
    }

    public Label getNameLH3() {
        return nameLH3;
    }

    public Label getLvlLH3() {
        return lvlLH3;
    }

    public Label getLvlVLH3() {
        return lvlVLH3;
    }

    public Label getDmgLH3() {
        return dmgLH3;
    }

    public Label getLvlPLH3() {
        return lvlPLH3;
    }

    public Label getLvlPVLH3() {
        return lvlPVLH3;
    }

    public Label getAtt1WLH3() {
        return att1WLH3;
    }

    public Label getAtt2WLH3() {
        return att2WLH3;
    }

    public Label getAtt3WLH3() {
        return att3WLH3;
    }

    public Label getItemSWLH3() {
        return itemSWLH3;
    }

    public Label getItemQWLH3() {
        return itemQWLH3;
    }

    public Label getAtt1ALH3() {
        return att1ALH3;
    }

    public Label getAtt2ALH3() {
        return att2ALH3;
    }

    public Label getAtt3ALH3() {
        return att3ALH3;
    }

    public Label getItemSALH3() {
        return itemSALH3;
    }

    public Label getItemQALH3() {
        return itemQALH3;
    }

    public Label getAtt1VWLH3() {
        return att1VWLH3;
    }

    public Label getAtt2VWLH3() {
        return att2VWLH3;
    }

    public Label getAtt3VWLH3() {
        return att3VWLH3;
    }

    public Label getAtt1VALH3() {
        return att1VALH3;
    }

    public Label getManaLH3() {
        return manaLH3;
    }

    public Label getManaVLH3() {
        return manaVLH3;
    }

    public Label getCdLH3() {
        return cdLH3;
    }

    public Label getCdVLH3() {
        return cdVLH3;
    }

    public Label getAtt2VALH3() {
        return att2VALH3;
    }

    public Label getAtt3VALH3() {
        return att3VALH3;
    }

    public Label getAmLH3() {
        return amLH3;
    }

    public Label getAmVLH3() {
        return amVLH3;
    }

    public Label getNameLH4() {
        return nameLH4;
    }

    public Label getLvlLH4() {
        return lvlLH4;
    }

    public Label getLvlVLH4() {
        return lvlVLH4;
    }

    public Label getDmgLH4() {
        return dmgLH4;
    }

    public Label getLvlPLH4() {
        return lvlPLH4;
    }

    public Label getLvlPVLH4() {
        return lvlPVLH4;
    }

    public Label getAtt1WLH4() {
        return att1WLH4;
    }

    public Label getAtt2WLH4() {
        return att2WLH4;
    }

    public Label getAtt3WLH4() {
        return att3WLH4;
    }

    public Label getItemSWLH4() {
        return itemSWLH4;
    }

    public Label getItemQWLH4() {
        return itemQWLH4;
    }

    public Label getAtt1ALH4() {
        return att1ALH4;
    }

    public Label getAtt2ALH4() {
        return att2ALH4;
    }

    public Label getAtt3ALH4() {
        return att3ALH4;
    }

    public Label getItemSALH4() {
        return itemSALH4;
    }

    public Label getItemQALH4() {
        return itemQALH4;
    }

    public Label getAtt1VWLH4() {
        return att1VWLH4;
    }

    public Label getAtt2VWLH4() {
        return att2VWLH4;
    }

    public Label getAtt3VWLH4() {
        return att3VWLH4;
    }

    public Label getAtt1VALH4() {
        return att1VALH4;
    }

    public Label getManaLH4() {
        return manaLH4;
    }

    public Label getManaVLH4() {
        return manaVLH4;
    }

    public Label getCdLH4() {
        return cdLH4;
    }

    public Label getCdVLH4() {
        return cdVLH4;
    }

    public Label getAtt2VALH4() {
        return att2VALH4;
    }

    public Label getAtt3VALH4() {
        return att3VALH4;
    }

    public Label getAmLH4() {
        return amLH4;
    }

    public Label getAmVLH4() {
        return amVLH4;
    }

    public Label getNameLH5() {
        return nameLH5;
    }

    public Label getLvlLH5() {
        return lvlLH5;
    }

    public Label getLvlVLH5() {
        return lvlVLH5;
    }

    public Label getDmgLH5() {
        return dmgLH5;
    }

    public Label getLvlPLH5() {
        return lvlPLH5;
    }

    public Label getLvlPVLH5() {
        return lvlPVLH5;
    }

    public Label getAtt1WLH5() {
        return att1WLH5;
    }

    public Label getAtt2WLH5() {
        return att2WLH5;
    }

    public Label getAtt3WLH5() {
        return att3WLH5;
    }

    public Label getItemSWLH5() {
        return itemSWLH5;
    }

    public Label getItemQWLH5() {
        return itemQWLH5;
    }

    public Label getAtt1ALH5() {
        return att1ALH5;
    }

    public Label getAtt2ALH5() {
        return att2ALH5;
    }

    public Label getAtt3ALH5() {
        return att3ALH5;
    }

    public Label getItemSALH5() {
        return itemSALH5;
    }

    public Label getItemQALH5() {
        return itemQALH5;
    }

    public Label getAtt1VWLH5() {
        return att1VWLH5;
    }

    public Label getAtt2VWLH5() {
        return att2VWLH5;
    }

    public Label getAtt3VWLH5() {
        return att3VWLH5;
    }

    public Label getAtt1VALH5() {
        return att1VALH5;
    }

    public Label getManaLH5() {
        return manaLH5;
    }

    public Label getManaVLH5() {
        return manaVLH5;
    }

    public Label getCdLH5() {
        return cdLH5;
    }

    public Label getCdVLH5() {
        return cdVLH5;
    }

    public Label getAtt2VALH5() {
        return att2VALH5;
    }

    public Label getAtt3VALH5() {
        return att3VALH5;
    }

    public Label getAmLH5() {
        return amLH5;
    }

    public Label getAmVLH5() {
        return amVLH5;
    }

    public Label getNameLH6() {
        return nameLH6;
    }

    public Label getLvlLH6() {
        return lvlLH6;
    }

    public Label getLvlVLH6() {
        return lvlVLH6;
    }

    public Label getDmgLH6() {
        return dmgLH6;
    }

    public Label getLvlPLH6() {
        return lvlPLH6;
    }

    public Label getLvlPVLH6() {
        return lvlPVLH6;
    }

    public Label getAtt1WLH6() {
        return att1WLH6;
    }

    public Label getAtt2WLH6() {
        return att2WLH6;
    }

    public Label getAtt3WLH6() {
        return att3WLH6;
    }

    public Label getItemSWLH6() {
        return itemSWLH6;
    }

    public Label getItemQWLH6() {
        return itemQWLH6;
    }

    public Label getAtt1ALH6() {
        return att1ALH6;
    }

    public Label getAtt2ALH6() {
        return att2ALH6;
    }

    public Label getAtt3ALH6() {
        return att3ALH6;
    }

    public Label getItemSALH6() {
        return itemSALH6;
    }

    public Label getItemQALH6() {
        return itemQALH6;
    }

    public Label getAtt1VWLH6() {
        return att1VWLH6;
    }

    public Label getAtt2VWLH6() {
        return att2VWLH6;
    }

    public Label getAtt3VWLH6() {
        return att3VWLH6;
    }

    public Label getAtt1VALH6() {
        return att1VALH6;
    }

    public Label getManaLH6() {
        return manaLH6;
    }

    public Label getManaVLH6() {
        return manaVLH6;
    }

    public Label getCdLH6() {
        return cdLH6;
    }

    public Label getCdVLH6() {
        return cdVLH6;
    }

    public Label getAtt2VALH6() {
        return att2VALH6;
    }

    public Label getAtt3VALH6() {
        return att3VALH6;
    }

    public Label getAmLH6() {
        return amLH6;
    }

    public Label getAmVLH6() {
        return amVLH6;
    }

    public Label getNameLH7() {
        return nameLH7;
    }

    public Label getLvlLH7() {
        return lvlLH7;
    }

    public Label getLvlVLH7() {
        return lvlVLH7;
    }

    public Label getDmgLH7() {
        return dmgLH7;
    }

    public Label getLvlPLH7() {
        return lvlPLH7;
    }

    public Label getLvlPVLH7() {
        return lvlPVLH7;
    }

    public Label getAtt1WLH7() {
        return att1WLH7;
    }

    public Label getAtt2WLH7() {
        return att2WLH7;
    }

    public Label getAtt3WLH7() {
        return att3WLH7;
    }

    public Label getItemSWLH7() {
        return itemSWLH7;
    }

    public Label getItemQWLH7() {
        return itemQWLH7;
    }

    public Label getAtt1ALH7() {
        return att1ALH7;
    }

    public Label getAtt2ALH7() {
        return att2ALH7;
    }

    public Label getAtt3ALH7() {
        return att3ALH7;
    }

    public Label getItemSALH7() {
        return itemSALH7;
    }

    public Label getItemQALH7() {
        return itemQALH7;
    }

    public Label getAtt1VWLH7() {
        return att1VWLH7;
    }

    public Label getAtt2VWLH7() {
        return att2VWLH7;
    }

    public Label getAtt3VWLH7() {
        return att3VWLH7;
    }

    public Label getAtt1VALH7() {
        return att1VALH7;
    }

    public Label getManaLH7() {
        return manaLH7;
    }

    public Label getManaVLH7() {
        return manaVLH7;
    }

    public Label getCdLH7() {
        return cdLH7;
    }

    public Label getCdVLH7() {
        return cdVLH7;
    }

    public Label getAtt2VALH7() {
        return att2VALH7;
    }

    public Label getAtt3VALH7() {
        return att3VALH7;
    }

    public Label getAmLH7() {
        return amLH7;
    }

    public Label getAmVLH7() {
        return amVLH7;
    }

    public Label getNameLH8() {
        return nameLH8;
    }

    public Label getLvlLH8() {
        return lvlLH8;
    }

    public Label getLvlVLH8() {
        return lvlVLH8;
    }

    public Label getDmgLH8() {
        return dmgLH8;
    }

    public Label getLvlPLH8() {
        return lvlPLH8;
    }

    public Label getLvlPVLH8() {
        return lvlPVLH8;
    }

    public Label getAtt1WLH8() {
        return att1WLH8;
    }

    public Label getAtt2WLH8() {
        return att2WLH8;
    }

    public Label getAtt3WLH8() {
        return att3WLH8;
    }

    public Label getItemSWLH8() {
        return itemSWLH8;
    }

    public Label getItemQWLH8() {
        return itemQWLH8;
    }

    public Label getAtt1ALH8() {
        return att1ALH8;
    }

    public Label getAtt2ALH8() {
        return att2ALH8;
    }

    public Label getAtt3ALH8() {
        return att3ALH8;
    }

    public Label getItemSALH8() {
        return itemSALH8;
    }

    public Label getItemQALH8() {
        return itemQALH8;
    }

    public Label getAtt1VWLH8() {
        return att1VWLH8;
    }

    public Label getAtt2VWLH8() {
        return att2VWLH8;
    }

    public Label getAtt3VWLH8() {
        return att3VWLH8;
    }

    public Label getAtt1VALH8() {
        return att1VALH8;
    }

    public Label getManaLH8() {
        return manaLH8;
    }

    public Label getManaVLH8() {
        return manaVLH8;
    }

    public Label getCdLH8() {
        return cdLH8;
    }

    public Label getCdVLH8() {
        return cdVLH8;
    }

    public Label getAtt2VALH8() {
        return att2VALH8;
    }

    public Label getAtt3VALH8() {
        return att3VALH8;
    }

    public Label getAmLH8() {
        return amLH8;
    }

    public Label getAmVLH8() {
        return amVLH8;
    }

    public Label getNameLH9() {
        return nameLH9;
    }

    public Label getLvlLH9() {
        return lvlLH9;
    }

    public Label getLvlVLH9() {
        return lvlVLH9;
    }

    public Label getDmgLH9() {
        return dmgLH9;
    }

    public Label getLvlPLH9() {
        return lvlPLH9;
    }

    public Label getLvlPVLH9() {
        return lvlPVLH9;
    }

    public Label getAtt1WLH9() {
        return att1WLH9;
    }

    public Label getAtt2WLH9() {
        return att2WLH9;
    }

    public Label getAtt3WLH9() {
        return att3WLH9;
    }

    public Label getItemSWLH9() {
        return itemSWLH9;
    }

    public Label getItemQWLH9() {
        return itemQWLH9;
    }

    public Label getAtt1ALH9() {
        return att1ALH9;
    }

    public Label getAtt2ALH9() {
        return att2ALH9;
    }

    public Label getAtt3ALH9() {
        return att3ALH9;
    }

    public Label getItemSALH9() {
        return itemSALH9;
    }

    public Label getItemQALH9() {
        return itemQALH9;
    }

    public Label getAtt1VWLH9() {
        return att1VWLH9;
    }

    public Label getAtt2VWLH9() {
        return att2VWLH9;
    }

    public Label getAtt3VWLH9() {
        return att3VWLH9;
    }

    public Label getAtt1VALH9() {
        return att1VALH9;
    }

    public Label getManaLH9() {
        return manaLH9;
    }

    public Label getManaVLH9() {
        return manaVLH9;
    }

    public Label getCdLH9() {
        return cdLH9;
    }

    public Label getCdVLH9() {
        return cdVLH9;
    }

    public Label getAtt2VALH9() {
        return att2VALH9;
    }

    public Label getAtt3VALH9() {
        return att3VALH9;
    }

    public Label getAmLH9() {
        return amLH9;
    }

    public Label getAmVLH9() {
        return amVLH9;
    }

    public Label getNameLH10() {
        return nameLH10;
    }

    public Label getLvlLH10() {
        return lvlLH10;
    }

    public Label getLvlVLH10() {
        return lvlVLH10;
    }

    public Label getDmgLH10() {
        return dmgLH10;
    }

    public Label getLvlPLH10() {
        return lvlPLH10;
    }

    public Label getLvlPVLH10() {
        return lvlPVLH10;
    }

    public Label getAtt1WLH10() {
        return att1WLH10;
    }

    public Label getAtt2WLH10() {
        return att2WLH10;
    }

    public Label getAtt3WLH10() {
        return att3WLH10;
    }

    public Label getItemSWLH10() {
        return itemSWLH10;
    }

    public Label getItemQWLH10() {
        return itemQWLH10;
    }

    public Label getAtt1ALH10() {
        return att1ALH10;
    }

    public Label getAtt2ALH10() {
        return att2ALH10;
    }

    public Label getAtt3ALH10() {
        return att3ALH10;
    }

    public Label getItemSALH10() {
        return itemSALH10;
    }

    public Label getItemQALH10() {
        return itemQALH10;
    }

    public Label getAtt1VWLH10() {
        return att1VWLH10;
    }

    public Label getAtt2VWLH10() {
        return att2VWLH10;
    }

    public Label getAtt3VWLH10() {
        return att3VWLH10;
    }

    public Label getAtt1VALH10() {
        return att1VALH10;
    }

    public Label getManaLH10() {
        return manaLH10;
    }

    public Label getManaVLH10() {
        return manaVLH10;
    }

    public Label getCdLH10() {
        return cdLH10;
    }

    public Label getCdVLH10() {
        return cdVLH10;
    }

    public Label getAtt2VALH10() {
        return att2VALH10;
    }

    public Label getAtt3VALH10() {
        return att3VALH10;
    }

    public Label getAmLH10() {
        return amLH10;
    }

    public Label getAmVLH10() {
        return amVLH10;
    }

    public Label getNameLH11() {
        return nameLH11;
    }

    public Label getLvlLH11() {
        return lvlLH11;
    }

    public Label getLvlVLH11() {
        return lvlVLH11;
    }

    public Label getDmgLH11() {
        return dmgLH11;
    }

    public Label getLvlPLH11() {
        return lvlPLH11;
    }

    public Label getLvlPVLH11() {
        return lvlPVLH11;
    }

    public Label getAtt1WLH11() {
        return att1WLH11;
    }

    public Label getAtt2WLH11() {
        return att2WLH11;
    }

    public Label getAtt3WLH11() {
        return att3WLH11;
    }

    public Label getItemSWLH11() {
        return itemSWLH11;
    }

    public Label getItemQWLH11() {
        return itemQWLH11;
    }

    public Label getAtt1ALH11() {
        return att1ALH11;
    }

    public Label getAtt2ALH11() {
        return att2ALH11;
    }

    public Label getAtt3ALH11() {
        return att3ALH11;
    }

    public Label getItemSALH11() {
        return itemSALH11;
    }

    public Label getItemQALH11() {
        return itemQALH11;
    }

    public Label getAtt1VWLH11() {
        return att1VWLH11;
    }

    public Label getAtt2VWLH11() {
        return att2VWLH11;
    }

    public Label getAtt3VWLH11() {
        return att3VWLH11;
    }

    public Label getAtt1VALH11() {
        return att1VALH11;
    }

    public Label getManaLH11() {
        return manaLH11;
    }

    public Label getManaVLH11() {
        return manaVLH11;
    }

    public Label getCdLH11() {
        return cdLH11;
    }

    public Label getCdVLH11() {
        return cdVLH11;
    }

    public Label getAtt2VALH11() {
        return att2VALH11;
    }

    public Label getAtt3VALH11() {
        return att3VALH11;
    }

    public Label getAmLH11() {
        return amLH11;
    }

    public Label getAmVLH11() {
        return amVLH11;
    }

    public Label getTwrL() {
        return twrL;
    }

    public Label getTwrLL() {
        return twrLL;
    }

    public Label getTwrAML() {
        return twrAML;
    }

    public Label getTwrDmgL() {
        return twrDmgL;
    }

    public Label getTwrL1() {
        return twrL1;
    }

    public Label getTwrLL1() {
        return twrLL1;
    }

    public Label getTwrAML1() {
        return twrAML1;
    }

    public Label getTwrDmgL1() {
        return twrDmgL1;
    }

    public Label getTwrL2() {
        return twrL2;
    }

    public Label getTwrLL2() {
        return twrLL2;
    }

    public Label getTwrAML2() {
        return twrAML2;
    }

    public Label getTwrDmgL2() {
        return twrDmgL2;
    }

    public Label getTwrL3() {
        return twrL3;
    }

    public Label getTwrLL3() {
        return twrLL3;
    }

    public Label getTwrAML3() {
        return twrAML3;
    }

    public Label getTwrDmgL3() {
        return twrDmgL3;
    }

    public Label getCcL() {
        return ccL;
    }

    public Label getCcLL() {
        return ccLL;
    }

    public Label getCcAML() {
        return ccAML;
    }

    public Label getCcDmgL() {
        return ccDmgL;
    }

    public Label getCcL1() {
        return ccL1;
    }

    public Label getCcLL1() {
        return ccLL1;
    }

    public Label getCcAML1() {
        return ccAML1;
    }

    public Label getCcDmgL1() {
        return ccDmgL1;
    }

    public Label getCcL2() {
        return ccL2;
    }

    public Label getCcLL2() {
        return ccLL2;
    }

    public Label getCcAML2() {
        return ccAML2;
    }

    public Label getCcDmgL2() {
        return ccDmgL2;
    }

    public Label getCcL3() {
        return ccL3;
    }

    public Label getCcLL3() {
        return ccLL3;
    }

    public Label getCcAML3() {
        return ccAML3;
    }

    public Label getCcDmgL3() {
        return ccDmgL3;
    }

    public TableView<Hero> getHeroTableView1() {
        return heroTableView1;
    }

    public TableView<Hero> getHeroTableView2() {
        return heroTableView2;
    }

    public GridPane getTclCOntainer() {
        return tclCOntainer;
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

    public TableView<Item> getItemWeaponTableView() {
        return itemWeaponTableView;
    }

    public TableView<Item> getItemAccessoryTableView() {
        return itemAccessoryTableView;
    }

    public TableView<Deck> getDeckTableView() {
        return deckTableView;
    }
}
