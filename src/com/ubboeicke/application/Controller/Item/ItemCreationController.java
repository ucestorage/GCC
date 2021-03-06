package com.ubboeicke.application.Controller.Item;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.PopulateTab_Item;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.ItemAttributes;
import com.ubboeicke.application.Model.Enums.ItemAttributesWithLegendaries;
import com.ubboeicke.application.Model.Enums.ItemQuality;
import com.ubboeicke.application.Model.Enums.ItemSort;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static com.ubboeicke.application.Model.Enums.ItemQuality.Quality.B;

/**
 * Created by Ubbo Eicke on 09.06.2017.
 */
public class ItemCreationController extends AnchorPane {
    @FXML
    private TextField itemNameTF;
    @FXML
    private ComboBox<ItemQuality.Quality> itemQCB;
    @FXML
    private GridPane container;
    @FXML
    private ComboBox<ItemAttributes.Attributes> itemA1CB;
    @FXML
    private ComboBox<ItemAttributes.Attributes> itemA2CB;
    @FXML
    private ComboBox<ItemAttributesWithLegendaries.AttributesWithLegendaries> itemA3CB;
    @FXML
    private TextField itemAV1TF;
    @FXML
    private TextField itemAV2TF;
    @FXML
    private TextField itemAV3TF;
    @FXML
    private TextField itemLVLTF;
    @FXML
    private ComboBox<ItemSort.Sort> itemSCB;
    @FXML
    private Button itemsaveBTN;
    private CenterViewController mCenterViewController;
    private ObservableList<Item> itemWeaponObservableList;
    private ObservableList<Item> itemAccessoryObservableList;
    private TableView<Item> itemWeaponTableView;
    private TableView<Item> itemAccessoryTableView;
    private String itemName;
    private String qualityString;
    private String sortString;
    private Double att1value;
    private Integer itemlvl;
    private Double att2value;
    private Double att3value;
    private String att1String;
    private String att2String;
    private String att3String;
    private ItemQuality.Quality quality;
    private PopulateTab_Item mPopulateTabItem;

    public ItemCreationController(CenterViewController centerViewController) throws IOException {
        this.mCenterViewController = centerViewController;
        this.mPopulateTabItem = mCenterViewController.getmPopulateTabItem();
        FXMLLoader loader = new FXMLLoader(ItemCreationController.class.getResource("ItemCreation.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
        populateCombobox();
        comboBoxListener();
        saveItem();
    }

    public void saveItem() {
        itemWeaponObservableList = mPopulateTabItem.getItemWeaponList();
        itemAccessoryObservableList = mPopulateTabItem.getItemAccessoryList();
        itemWeaponTableView = mCenterViewController.getItemWeaponTableView();
        itemAccessoryTableView = mCenterViewController.getItemAccessoryTableView();
        itemsaveBTN.setOnAction(event -> {
            //  System.out.println("Saving Item.");
            try {
                quality = itemQCB.getSelectionModel().getSelectedItem();
                itemName = itemNameTF.getText();
                qualityString = itemQCB.getSelectionModel().getSelectedItem().toString();
                sortString = itemSCB.getSelectionModel().getSelectedItem().toString();
                itemlvl = Integer.parseInt(itemLVLTF.getText());
                att1value = Double.parseDouble(itemAV1TF.getText());
                att1String = itemA1CB.getSelectionModel().getSelectedItem().toString();
                switch (quality) {
                    case B:
                        if (sortString.equals("Bow") || sortString.equals("Sword") || sortString.equals("Staff") || sortString.equals("Hammer")) {
                            itemWeaponObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value));
                        } else {
                            itemAccessoryObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value));
                        }
                        break;
                    case A:
                        att2String = itemA2CB.getSelectionModel().getSelectedItem().toString();
                        att2value = Double.parseDouble(itemAV2TF.getText());
                        if (sortString.equals("Bow") || sortString.equals("Sword") || sortString.equals("Staff") || sortString.equals("Hammer")) {
                            itemWeaponObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value, att2String, att2value));
                        } else {
                            itemAccessoryObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value, att2String, att2value));
                        }
                        break;
                    case S:
                        att2String = itemA2CB.getSelectionModel().getSelectedItem().toString();
                        att2value = Double.parseDouble(itemAV2TF.getText());
                        if (sortString.equals("Bow") || sortString.equals("Sword") || sortString.equals("Staff") || sortString.equals("Hammer")) {
                            itemWeaponObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value, att2String, att2value));
                        } else {
                            itemAccessoryObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value, att2String, att2value));
                        }
                        break;
                    case L:
                        att2String = itemA2CB.getSelectionModel().getSelectedItem().toString();
                        att2value = Double.parseDouble(itemAV2TF.getText());
                        att3String = itemA3CB.getSelectionModel().getSelectedItem().toString();
                        att3value = Double.parseDouble(itemAV3TF.getText());
                        if (sortString.equals("Bow") || sortString.equals("Sword") || sortString.equals("Staff") || sortString.equals("Hammer")) {
                            itemWeaponObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value, att2String, att2value, att3String, att3value));
                        } else {
                            itemAccessoryObservableList.add(new Item(itemName, qualityString, sortString, itemlvl, att1String, att1value, att2String, att2value, att3String, att3value));
                        }
                        break;
                }
                itemWeaponTableView.setItems(itemWeaponObservableList);
                itemAccessoryTableView.setItems(itemAccessoryObservableList);
                // mPopulateTabItem.getStage().close();
            } catch (Exception e) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Please use . as seperator!");
                a.showAndWait();
            }
        });
    }

    private void populateCombobox() {
        itemQCB.getItems().setAll(ItemQuality.Quality.values());
        itemSCB.getItems().setAll(ItemSort.Sort.values());
        itemA1CB.getItems().setAll(ItemAttributes.Attributes.values());
        itemA2CB.getItems().setAll(ItemAttributes.Attributes.values());
        itemA3CB.getItems().setAll(ItemAttributesWithLegendaries.AttributesWithLegendaries.values());
    }

    private void comboBoxListener() {
        //TODO if elseif durch switch case ersetzen
        itemA1CB.setDisable(true);
        itemA2CB.setDisable(true);
        itemA3CB.setDisable(true);
        itemAV1TF.setDisable(true);
        itemAV2TF.setDisable(true);
        itemAV3TF.setDisable(true);
        itemQCB.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(B)) {
                itemA1CB.setDisable(false);
                itemAV1TF.setDisable(false);
                itemA2CB.getSelectionModel().clearSelection();
                itemA3CB.getSelectionModel().clearSelection();
                itemAV2TF.setText("");
                itemAV3TF.setText("");
                itemA2CB.setDisable(true);
                itemAV2TF.setDisable(true);
                itemA3CB.setDisable(true);
                itemAV3TF.setDisable(true);
            } else {
                if (newValue.equals(ItemQuality.Quality.A)) {
                    itemA1CB.setDisable(false);
                    itemAV1TF.setDisable(false);
                    itemA2CB.setDisable(false);
                    itemAV2TF.setDisable(false);
                    itemA3CB.setDisable(true);
                    itemAV3TF.setDisable(true);
                    itemA3CB.getSelectionModel().clearSelection();
                    itemAV3TF.setText("");
                } else {
                    if (newValue.equals(ItemQuality.Quality.S)) {
                        itemA1CB.setDisable(false);
                        itemAV1TF.setDisable(false);
                        itemA2CB.setDisable(false);
                        itemAV2TF.setDisable(false);
                        itemA3CB.setDisable(true);
                        itemAV3TF.setDisable(true);
                        itemA3CB.getSelectionModel().clearSelection();
                        itemAV3TF.setText("");
                    } else {
                        if (newValue.equals(ItemQuality.Quality.L)) {
                            itemA1CB.setDisable(false);
                            itemAV1TF.setDisable(false);
                            itemA2CB.setDisable(false);
                            itemAV2TF.setDisable(false);
                            itemA3CB.setDisable(false);
                            itemAV3TF.setDisable(false);
                        }
                    }
                }
            }
        });
    }
}
