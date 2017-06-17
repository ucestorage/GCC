package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Item.ItemCreationController;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class PopulateTab_Item {
    private CenterViewController mCenterViewController;
    private TableView<Item> mItemWeaponTableView;
    private TableView<Item> mItemAccessoryTableView;
    private ObservableList<Item> mItemWeaponList = FXCollections.observableArrayList();
    private ObservableList<Item> mItemAccessoryList = FXCollections.observableArrayList();


    public PopulateTab_Item(CenterViewController centerViewController){
        this.mCenterViewController = centerViewController;
        mItemWeaponTableView = mCenterViewController.getItemWeaponTableView();
        mItemAccessoryTableView = mCenterViewController.getItemAccessoryTableView();
        setupWeaponTableView();
        setupAccessoryTableView();


    }
    public void setupWeaponTableView(){

        TableColumn itemNameCol = new TableColumn("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        itemNameCol.setPrefWidth(90);

        TableColumn itemQualityCol = new TableColumn("Item Quality");
        itemQualityCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemQuality"));
        itemQualityCol.setPrefWidth(90);

        TableColumn itemSortCol = new TableColumn("Item Sort");
        itemSortCol.setCellValueFactory(new PropertyValueFactory<Item, String>("sortOfItem"));
        itemSortCol.setPrefWidth(90);

        TableColumn itemLevelCol = new TableColumn("Item Level");
        itemLevelCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemLevel"));
        itemLevelCol.setPrefWidth(90);

        TableColumn itemAtt1Col = new TableColumn("Attribute#1");
        itemAtt1Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute1"));
        itemAtt1Col.setPrefWidth(90);

        TableColumn itemVal1Col = new TableColumn("Value#1");
        itemVal1Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute1Value"));
        itemVal1Col.setPrefWidth(90);

        TableColumn itemAtt2Col = new TableColumn("Attribute#2");
        itemAtt2Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute2"));
        itemAtt2Col.setPrefWidth(90);

        TableColumn itemVal2Col = new TableColumn("Value#2");
        itemVal2Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute2Value"));
        itemVal2Col.setPrefWidth(90);

        TableColumn itemAtt3Col = new TableColumn("Attribute#3");
        itemAtt3Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute3"));
        itemAtt3Col.setPrefWidth(90);

        TableColumn itemVal3Col = new TableColumn("Value#3");
        itemVal3Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute3Value"));
        itemVal3Col.setPrefWidth(90);

        mItemWeaponTableView.getColumns().addAll(itemNameCol,itemQualityCol,itemSortCol,itemLevelCol,itemAtt1Col,itemVal1Col,itemAtt2Col, itemVal2Col,itemAtt3Col,itemVal3Col);
        mItemWeaponTableView.setColumnResizePolicy((param -> true));

       // mItemWeaponList.add(new Item("WeaponShowCase","L","Sword",100,"ColdDamage",25.0,"ColdDamage",25.0,"Slow",2.0));
        mItemWeaponTableView.setItems(mItemWeaponList);

    }
    public void setupAccessoryTableView(){

        TableColumn itemNameCol = new TableColumn("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        itemNameCol.setPrefWidth(90);

        TableColumn itemQualityCol = new TableColumn("Item Quality");
        itemQualityCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemQuality"));
        itemQualityCol.setPrefWidth(90);

        TableColumn itemSortCol = new TableColumn("Item Sort");
        itemSortCol.setCellValueFactory(new PropertyValueFactory<Item, String>("sortOfItem"));
        itemSortCol.setPrefWidth(90);

        TableColumn itemLevelCol = new TableColumn("Item Level");
        itemLevelCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemLevel"));
        itemLevelCol.setPrefWidth(90);

        TableColumn itemAtt1Col = new TableColumn("Attribute#1");
        itemAtt1Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute1"));
        itemAtt1Col.setPrefWidth(90);

        TableColumn itemVal1Col = new TableColumn("Value#1");
        itemVal1Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute1Value"));
        itemVal1Col.setPrefWidth(90);

        TableColumn itemAtt2Col = new TableColumn("Attribute#2");
        itemAtt2Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute2"));
        itemAtt2Col.setPrefWidth(90);

        TableColumn itemVal2Col = new TableColumn("Value#2");
        itemVal2Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute2Value"));
        itemVal2Col.setPrefWidth(90);

        TableColumn itemAtt3Col = new TableColumn("Attribute#3");
        itemAtt3Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute3"));
        itemAtt3Col.setPrefWidth(90);

        TableColumn itemVal3Col = new TableColumn("Value#3");
        itemVal3Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute3Value"));
        itemVal3Col.setPrefWidth(90);

        mItemAccessoryTableView.getColumns().addAll(itemNameCol,itemQualityCol,itemSortCol,itemLevelCol,itemAtt1Col,itemVal1Col,itemAtt2Col, itemVal2Col,itemAtt3Col,itemVal3Col);
        mItemAccessoryTableView.setColumnResizePolicy((param -> true));
      //  mItemAccessoryList.add(new Item("AccessoryShowCase","L","Bracelet",100,"FireDamage",25.0,"FireDamage",25.0,"AreaDamage",100.0));
        mItemAccessoryTableView.setItems(mItemAccessoryList);

    }



    public ObservableList<Item> getItemWeaponList() {
        return mItemWeaponList;
    }

    public ObservableList<Item> getItemAccessoryList() {
        return mItemAccessoryList;
    }


}
