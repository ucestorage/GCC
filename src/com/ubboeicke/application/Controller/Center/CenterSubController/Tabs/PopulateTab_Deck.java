package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.Decks.Deck;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class PopulateTab_Deck {
    private CenterViewController mCenterViewController;
    private TableView<Deck> mDeckTableView;

    private ObservableList<Deck> mDecks = FXCollections.observableArrayList();


    public PopulateTab_Deck(CenterViewController centerViewController){
        this.mCenterViewController = centerViewController;
        mDeckTableView = mCenterViewController.getDeckTableView();
        setupDeckTableView();



    }
    public void setupDeckTableView(){

        TableColumn Col1 = new TableColumn("Deck Name");
        Col1.setCellValueFactory(new PropertyValueFactory<Deck, String>("name"));

        TableColumn Col2 = new TableColumn("TB#1");
        Col2.setCellValueFactory(new PropertyValueFactory<Deck, String>("townBuilding1"));

        TableColumn Col3 = new TableColumn("TB#2");
        Col3.setCellValueFactory(new PropertyValueFactory<Deck, String>("townBuilding2"));

        TableColumn Col4 = new TableColumn("TB#3");
        Col4.setCellValueFactory(new PropertyValueFactory<Deck, String>("townBuilding3"));

        TableColumn Col5 = new TableColumn("Leader");
        Col5.setCellValueFactory(new PropertyValueFactory<Deck, String>("leader"));

        TableColumn Col6 = new TableColumn("T#1");
        Col6.setCellValueFactory(new PropertyValueFactory<Deck, String>("treasure1"));

        TableColumn Col7 = new TableColumn("T#2");
        Col7.setCellValueFactory(new PropertyValueFactory<Deck, String>("treasure2"));

        TableColumn Col8 = new TableColumn("T#3");
        Col8.setCellValueFactory(new PropertyValueFactory<Deck, String>("treasure3"));

        TableColumn Col9 = new TableColumn("T#4");
        Col9.setCellValueFactory(new PropertyValueFactory<Deck, String>("treasure4"));

        TableColumn Col10 = new TableColumn("T#5");
        Col10.setCellValueFactory(new PropertyValueFactory<Deck, String>("treasure5"));

        TableColumn Col11 = new TableColumn("TWR#1");
        Col11.setCellValueFactory(new PropertyValueFactory<Deck, String>("tower1"));
        TableColumn Col12 = new TableColumn("TWR#2");
        Col12.setCellValueFactory(new PropertyValueFactory<Deck, String>("tower2"));
        TableColumn Col13 = new TableColumn("TWR#3");
        Col13.setCellValueFactory(new PropertyValueFactory<Deck, String>("tower3"));
        TableColumn Col14 = new TableColumn("TWR#4");
        Col14.setCellValueFactory(new PropertyValueFactory<Deck, String>("tower4"));
        TableColumn Col15 = new TableColumn("CC#1");
        Col15.setCellValueFactory(new PropertyValueFactory<Deck, String>("CC1"));
        TableColumn Col16 = new TableColumn("CC#2");
        Col16.setCellValueFactory(new PropertyValueFactory<Deck, String>("CC2"));
        TableColumn Col17 = new TableColumn("CC#3");
        Col17.setCellValueFactory(new PropertyValueFactory<Deck, String>("CC3"));
        TableColumn Col18 = new TableColumn("CC#4");
        Col18.setCellValueFactory(new PropertyValueFactory<Deck, String>("CC4"));
        TableColumn Col19 = new TableColumn("H#1");
        Col19.setCellValueFactory(new PropertyValueFactory<Deck, String>("h1"));
        TableColumn Col20 = new TableColumn("H#2");
        Col20.setCellValueFactory(new PropertyValueFactory<Deck, String>("h2"));
        TableColumn Col21 = new TableColumn("H#3");
        Col21.setCellValueFactory(new PropertyValueFactory<Deck, String>("h3"));
        TableColumn Col22 = new TableColumn("H#4");
        Col22.setCellValueFactory(new PropertyValueFactory<Deck, String>("h4"));
        TableColumn Col23 = new TableColumn("H#5");
        Col23.setCellValueFactory(new PropertyValueFactory<Deck, String>("h5"));
        TableColumn Col24 = new TableColumn("H#6");
        Col24.setCellValueFactory(new PropertyValueFactory<Deck, String>("h6"));
        TableColumn Col25 = new TableColumn("H#7");
        Col25.setCellValueFactory(new PropertyValueFactory<Deck, String>("h7"));
        TableColumn Col26 = new TableColumn("H#8");
        Col26.setCellValueFactory(new PropertyValueFactory<Deck, String>("h8"));
        TableColumn Col27 = new TableColumn("H#9");
        Col27.setCellValueFactory(new PropertyValueFactory<Deck, String>("h9"));
        TableColumn Col28 = new TableColumn("H#10");
        Col28.setCellValueFactory(new PropertyValueFactory<Deck, String>("h10"));
        TableColumn Col29 = new TableColumn("H#11");
        Col29.setCellValueFactory(new PropertyValueFactory<Deck, String>("h11"));
        TableColumn Col30 = new TableColumn("H#12");
        Col30.setCellValueFactory(new PropertyValueFactory<Deck, String>("h12"));
        mDeckTableView.getColumns().addAll(Col1,Col2,Col3,Col4,Col6,Col7,Col8,Col9,Col10,Col5,Col11,Col12,Col13,Col14,Col15,Col16,Col17,Col18,Col19,Col20,Col21,Col22,Col23,Col24,Col25,Col26,Col27,Col28,Col29,Col30);
        mDeckTableView.setColumnResizePolicy((param -> true));
        mDeckTableView.setItems(mDecks);
    }

    public ObservableList<Deck> getDecks() {
        return mDecks;
    }
}
