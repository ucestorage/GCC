package com.ubboeicke.application.Controller.Deck;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Deck;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Model.Enums.TownBuildings;
import com.ubboeicke.application.Model.Enums.Treasures;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 20.06.2017.
 */
public class DeckCreationController extends AnchorPane {
    @FXML
    private ComboBox tbCB1;
    @FXML
    private ComboBox tbCB2;
    @FXML
    private ComboBox tbCB3;
    @FXML
    private ComboBox ldrCB;
    @FXML
    private ComboBox tCB1;
    @FXML
    private ComboBox tCB2;
    @FXML
    private ComboBox tCB3;
    @FXML
    private ComboBox tCB4;
    @FXML
    private ComboBox tCB5;
    @FXML
    private ComboBox twrCB1;
    @FXML
    private ComboBox twrCB2;
    @FXML
    private ComboBox twrCB3;
    @FXML
    private ComboBox twrCB4;
    @FXML
    private ComboBox ccCB1;
    @FXML
    private ComboBox ccCB2;
    @FXML
    private ComboBox ccCB3;
    @FXML
    private ComboBox ccCB4;
    @FXML
    private ComboBox h1CB;
    @FXML
    private ComboBox h2CB;
    @FXML
    private ComboBox h3CB;
    @FXML
    private ComboBox h4CB;
    @FXML
    private ComboBox h5CB;
    @FXML
    private ComboBox h6CB;
    @FXML
    private ComboBox h7CB;
    @FXML
    private ComboBox h8CB;
    @FXML
    private ComboBox h9CB;
    @FXML
    private ComboBox h10CB;
    @FXML
    private ComboBox h11CB;
    @FXML
    private ComboBox h12CB;
    @FXML
    private TextField nameTF;
    @FXML
    private Button saveBTN;
    private String s1;
    private CenterViewController mCenterViewController;
    private MainController mMainController;
    private PopulateTab_Deck mPopulateTabDeck;
    private ObservableList<Deck>mDeckObservableList;
    private TableView<Deck> mDeckTableView;

    public DeckCreationController(MainController mainController) throws IOException {
        mMainController = mainController;
        mCenterViewController = mMainController.getCenterViewController();
        mPopulateTabDeck = mCenterViewController.getmPopulateTabDeck();
        mDeckObservableList = mCenterViewController.getDeckTableView().getItems();
        mDeckTableView = mCenterViewController.getDeckTableView();

        FXMLLoader loader = new FXMLLoader(DeckCreationController.class.getResource("DeckCreation.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();

        populateTB_CB();
        populateLDR_CB();
        populateT_CB();
        populateTWR_CB();
        populateCC_CB();
        populateHero_CB();
        btnListener();
    }

    public void btnListener() {
      /*  mDeckTableView = mCenterViewController.getDeckTableView();
       // mDeckObservableList= mDeckTableView.getItems();
        mDeckObservableList= mPopulateTabDeck.getDecks();*/

        saveBTN.setOnAction(event -> {
            s1 = nameTF.getText();
            Deck d = new Deck(s1, tbCB1.getSelectionModel().getSelectedItem().toString(), tbCB2.getSelectionModel().getSelectedItem().toString(), tbCB3.getSelectionModel().getSelectedItem().toString(), ldrCB.getSelectionModel().getSelectedItem().toString(), tCB1.getSelectionModel().getSelectedItem().toString(), tCB2.getSelectionModel().getSelectedItem().toString(), tCB3.getSelectionModel().getSelectedItem().toString(), tCB4.getSelectionModel().getSelectedItem().toString(), tCB5.getSelectionModel().getSelectedItem().toString(), twrCB1.getSelectionModel().getSelectedItem().toString(), twrCB2.getSelectionModel().getSelectedItem().toString(), twrCB3.getSelectionModel().getSelectedItem().toString(), twrCB4.getSelectionModel().getSelectedItem().toString(), ccCB1.getSelectionModel().getSelectedItem().toString(), ccCB2.getSelectionModel().getSelectedItem().toString(), ccCB3.getSelectionModel().getSelectedItem().toString(), ccCB4.getSelectionModel().getSelectedItem().toString(), h1CB.getSelectionModel().getSelectedItem().toString(), h2CB.getSelectionModel().getSelectedItem().toString(), h3CB.getSelectionModel().getSelectedItem().toString(), h4CB.getSelectionModel().getSelectedItem().toString(), h5CB.getSelectionModel().getSelectedItem().toString(), h6CB.getSelectionModel().getSelectedItem().toString(), h7CB.getSelectionModel().getSelectedItem().toString(), h8CB.getSelectionModel().getSelectedItem().toString(), h9CB.getSelectionModel().getSelectedItem().toString(), h10CB.getSelectionModel().getSelectedItem().toString(), h11CB.getSelectionModel().getSelectedItem().toString(), h12CB.getSelectionModel().getSelectedItem().toString());

            mDeckObservableList.add(d);
          mDeckTableView.setItems(mDeckObservableList);
            mMainController.getStageDeck().close();


        });
    }

    public void populateTB_CB() {
        tbCB1.getItems().setAll(TownBuildings.TB);

        tbCB2.getItems().setAll(TownBuildings.TB);

        tbCB3.getItems().setAll(TownBuildings.TB);
        tbCB1.getSelectionModel().selectFirst();
        tbCB2.getSelectionModel().selectFirst();
        tbCB3.getSelectionModel().selectFirst();
    }

    public void populateLDR_CB() {
        ObservableList<String> ldrName = FXCollections.observableArrayList();
        for (Leader ldr : mMainController.getMainModel().getSaveAndLoadHandler().getLDRList()) {
            ldrName.add(ldr.getName());
        }
        ldrCB.getItems().setAll(ldrName);
        ldrCB.getSelectionModel().selectFirst();
    }

    public void populateT_CB() {
        tCB1.getItems().setAll(Treasures.weapons);
        tCB2.getItems().setAll(Treasures.treasures);
        tCB3.getItems().setAll(Treasures.treasures);
        tCB4.getItems().setAll(Treasures.treasures);
        tCB5.getItems().setAll(Treasures.treasures);
        tCB1.getSelectionModel().selectFirst();
        tCB2.getSelectionModel().selectFirst();
        tCB3.getSelectionModel().selectFirst();
        tCB4.getSelectionModel().selectFirst();
        tCB5.getSelectionModel().selectFirst();

    }

    public void populateTWR_CB() {
        ObservableList<String> twrName = FXCollections.observableArrayList();

        for (Tower twr : mMainController.getMainModel().getSaveAndLoadHandler().getTWRList()) {
            if (twr.getName().equals("Trophy") || twr.getName().equals("Cannon") || twr.getName().equals("Thorn Worm") || twr.getName().equals("Turret")) {
                twrName.add(twr.getName());
            } else {
                twrName.add(twr.getPromotion().getSelectionModel().getSelectedItem());

            }
        }
        twrCB1.getItems().setAll(twrName);
        twrCB2.getItems().setAll(twrName);
        twrCB3.getItems().setAll(twrName);
        twrCB4.getItems().setAll(twrName);
        twrCB1.getSelectionModel().selectFirst();
        twrCB2.getSelectionModel().selectFirst();
        twrCB3.getSelectionModel().selectFirst();
        twrCB4.getSelectionModel().selectFirst();
    }

    public void populateCC_CB() {
        ObservableList<String> ccName = FXCollections.observableArrayList();
        for (CastleComponent cc : mMainController.getMainModel().getSaveAndLoadHandler().getCCList()) {
            ccName.add(cc.getCcName());
        }
        ccCB1.getItems().setAll(ccName);
        ccCB2.getItems().setAll(ccName);
        ccCB3.getItems().setAll(ccName);
        ccCB4.getItems().setAll(ccName);
        ccCB1.getSelectionModel().selectFirst();
        ccCB2.getSelectionModel().selectFirst();
        ccCB3.getSelectionModel().selectFirst();
        ccCB4.getSelectionModel().selectFirst();
    }

    public void populateHero_CB() {
        ObservableList<String> heroName = FXCollections.observableArrayList();
        for (Hero h : mMainController.getMainModel().getSaveAndLoadHandler().getHeroList()) {
            if (h.getName().equals("Angel")) {
                heroName.add(h.getName());
            } else {
                heroName.add(h.getPromotion().getSelectionModel().getSelectedItem().toString());
            }
            h1CB.getItems().setAll(heroName);
            h2CB.getItems().setAll(heroName);
            h3CB.getItems().setAll(heroName);
            h4CB.getItems().setAll(heroName);
            h5CB.getItems().setAll(heroName);
            h6CB.getItems().setAll(heroName);
            h7CB.getItems().setAll(heroName);
            h8CB.getItems().setAll(heroName);
            h9CB.getItems().setAll(heroName);
            h10CB.getItems().setAll(heroName);
            h11CB.getItems().setAll(heroName);
            h12CB.getItems().setAll(heroName);
            h1CB.getSelectionModel().selectFirst();
            h2CB.getSelectionModel().selectFirst();
            h3CB.getSelectionModel().selectFirst();
            h4CB.getSelectionModel().selectFirst();
            h5CB.getSelectionModel().selectFirst();
            h6CB.getSelectionModel().selectFirst();
            h7CB.getSelectionModel().selectFirst();
            h8CB.getSelectionModel().selectFirst();
            h9CB.getSelectionModel().selectFirst();
            h10CB.getSelectionModel().selectFirst();
            h11CB.getSelectionModel().selectFirst();
            h12CB.getSelectionModel().selectFirst();

        }
    }
}
