package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PopulateTab_Goldcalc {
    private CenterViewController mCenterViewController;
    private TableView<Hero> mHeroTableView;
    private ObservableList<Hero> mHeroList = FXCollections.observableArrayList();
    private GameObjectConstructor goc;
    private TableView<Hero> getmHeroTableView;
    //TODO make ghold calc

    public PopulateTab_Goldcalc(CenterViewController centerViewController){
        mCenterViewController = centerViewController;
        mHeroTableView = mCenterViewController.getGoldHeroesTV();
        getmHeroTableView = mCenterViewController.getHeroTableView1();
        goc = new GameObjectConstructor();
        setupHeroTableView();
        heroPaneListener();


    }
    private void setupHeroTableView(){
        TableColumn c1 = new TableColumn("Hero");
        c1.setCellValueFactory(new PropertyValueFactory<Hero, String>("name"));
        TableColumn c2 = new TableColumn("Level");
        c2.setCellValueFactory(new PropertyValueFactory<Hero, String>("level"));
        TableColumn c3 = new TableColumn("Desired Level");
        c3.setCellValueFactory(new PropertyValueFactory<Hero, String>("wantLevel"));
        TableColumn c4 = new TableColumn("Gold Cost");
        c4.setCellValueFactory(new PropertyValueFactory<Hero, String>("upgCost"));
        TableColumn c5 = new TableColumn("Gold/Dmg");
        c5.setCellValueFactory(new PropertyValueFactory<Hero, String>("goldDmg"));
        mHeroTableView.getColumns().addAll(c1,c2,c3,c4,c5);
        mHeroTableView.setColumnResizePolicy(param -> true);
        mHeroTableView.setItems(mHeroList);



    }
    private void heroPaneListener(){
        mCenterViewController.getGoldHeroesPane().setOnMouseClicked(event -> {
            addHeroes();
                }

        );

    }
    private void addHeroes(){
        for (Hero h : getmHeroTableView.getItems()) {
            //System.out.println(h.getLevel().getText());
            mHeroList.add(new Hero(h.getName(), h.getLevel(), goc.levelTextField(), goc.Label(), goc.Label()));
        }
    }
}
