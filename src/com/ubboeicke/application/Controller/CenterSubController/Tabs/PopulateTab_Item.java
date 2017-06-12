package com.ubboeicke.application.Controller.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Controller.ItemCreationController;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.Item;
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
    private Button createitem;
    private TableView<Item> mItemTableView;

    public PopulateTab_Item(CenterViewController centerViewController){
        this.mCenterViewController = centerViewController;
        createitem = mCenterViewController.getCreateItem();
        mItemTableView = mCenterViewController.getItemTableView();
        setupTableView();
        createItem();

    }
    public void setupTableView(){

        TableColumn itemNameCol = new TableColumn("Item Name");
        itemNameCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));
        itemNameCol.setPrefWidth(300);

        TableColumn itemQualityCol = new TableColumn("Item Quality");
        itemQualityCol.setCellValueFactory(new PropertyValueFactory<Item, String>("itemQuality"));
        itemQualityCol.setPrefWidth(100);

        TableColumn itemSortCol = new TableColumn("Item Sort");
        itemSortCol.setCellValueFactory(new PropertyValueFactory<Item, String>("sortOfItem"));
        itemSortCol.setPrefWidth(150);

        TableColumn itemLevelCol = new TableColumn("Item Level");
        itemLevelCol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("itemLevel"));
        itemLevelCol.setPrefWidth(100);

        TableColumn itemAtt1Col = new TableColumn("Attribute#1");
        itemAtt1Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute1"));
        itemAtt1Col.setPrefWidth(200);

        TableColumn itemVal1Col = new TableColumn("Value#1");
        itemVal1Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute1Value"));
        itemVal1Col.setPrefWidth(100);

        TableColumn itemAtt2Col = new TableColumn("Attribute#2");
        itemAtt2Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute2"));
        itemAtt2Col.setPrefWidth(200);

        TableColumn itemVal2Col = new TableColumn("Value#2");
        itemVal2Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute2Value"));
        itemVal2Col.setPrefWidth(100);

        TableColumn itemAtt3Col = new TableColumn("Attribute#3");
        itemAtt3Col.setCellValueFactory(new PropertyValueFactory<Item, String>("attribute3"));
        itemAtt3Col.setPrefWidth(200);

        TableColumn itemVal3Col = new TableColumn("Value#3");
        itemVal3Col.setCellValueFactory(new PropertyValueFactory<Item, Double>("attribute3Value"));
        itemVal3Col.setPrefWidth(100);

        mItemTableView.getColumns().addAll(itemNameCol,itemQualityCol,itemSortCol,itemLevelCol,itemAtt1Col,itemVal1Col,itemAtt2Col, itemVal2Col,itemAtt3Col,itemVal3Col);
        mItemTableView.setColumnResizePolicy((param -> true));
    }

    public void createItem() {

        createitem.setOnAction((ActionEvent e) -> {

            try {

                ItemCreationController itemCreator = new ItemCreationController(mCenterViewController);
                Scene scene = new Scene(itemCreator);
                Stage stage = new Stage();
                stage.setScene(scene);

                stage.setTitle("Item Creation");
                stage.show();

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        });

    }
}
