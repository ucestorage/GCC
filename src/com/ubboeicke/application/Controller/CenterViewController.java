package com.ubboeicke.application.Controller;

import com.ubboeicke.application.Model.ItemCreation.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */
public class CenterViewController {
    @FXML
    private TextField playerNameTextField;

    @FXML
    private Button createItem;
    @FXML
    private TableView<Item> itemTableView;
    private ObservableList<Item> itemObservableList = FXCollections.observableArrayList();

    //TODO split controller to controllers for single tabs
    public void initialize(TabPane tabPane) throws IOException {
        FXMLLoader loader = new FXMLLoader(CenterViewController.class.getResource("../View/Center.fxml"));
        loader.setRoot(tabPane);
        loader.setController(this);
        loader.load();
        createItem();
        setupTableView();

    }
    public ArrayList<String> getItemStrings(){
        ArrayList<String> test = new ArrayList<>();
        for (Item item : itemTableView.getItems()){
            String testS = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", item.getItemName(),item.getItemQuality(), item.getSortOfItem(), item.getItemLevel(),item.getAttribute1(),item.getAttribute1Value(),item.getAttribute2(),item.getAttribute2Value(),item.getAttribute3(),item.getAttribute3Value());
            test.add(testS);

        }
        System.out.println(test);
        return test;
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

        itemTableView.getColumns().addAll(itemNameCol,itemQualityCol,itemSortCol,itemLevelCol,itemAtt1Col,itemVal1Col,itemAtt2Col, itemVal2Col,itemAtt3Col,itemVal3Col);
        itemTableView.setColumnResizePolicy((param -> true));
    }

    public void createItem() {

        createItem.setOnAction((ActionEvent e) -> {

            try {

                ItemCreationController itemCreator = new ItemCreationController(this);
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

    public TextField getPlayerNameTextField() {
        return playerNameTextField;
    }

    public ObservableList<Item> getItemObservableList() {
        return itemObservableList;
    }

    public void setItemObservableList(ObservableList<Item> itemObservableList) {
        this.itemObservableList = itemObservableList;
    }

    public TableView<Item> getItemTableView() {
        return itemTableView;
    }


}

