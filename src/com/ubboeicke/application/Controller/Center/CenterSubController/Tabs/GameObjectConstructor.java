package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;
import com.ubboeicke.application.Model.Enums.AttackMode;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * Created by Ubbo Eicke on 17.06.2017.
 */
public class GameObjectConstructor {

    public ComboBox promotionCB(String[] strings) {
        ComboBox promoCB = new ComboBox<>();
        promoCB.getItems().addAll(strings);
        promoCB.getSelectionModel().selectFirst();
        return promoCB;
    }
    public Label lvlLabel(String s) {
        Label txt = new Label(s);
        return txt;
    }
    public Label Label() {
        Label l = new Label("");
        return l;
    }
    public Label Label(String s) {
        Label l = new Label(s);
        return l;
    }
    public ComboBox loadPromotionCB(String s, String[] strings) {
        ComboBox promoCB = new ComboBox<>();
        ObservableList<String> promoName = FXCollections.observableArrayList();
        promoName.addAll(strings);
        promoCB.getItems().addAll(promoName);
        promoCB.getSelectionModel().select(s);
        // System.out.println(promoCB.getSelectionModel().getSelectedItem());
        return promoCB;
    }
    public ComboBox weaponCB(ObservableList<Item> weaponNameList) {
        ComboBox comboBox = new ComboBox();
        ObservableList<String> weaponList = FXCollections.observableArrayList();
        for (Item item : weaponNameList) {
            weaponList.add(item.getItemName());
        }
        comboBox.getItems().addAll(weaponList);
        comboBox.getSelectionModel().selectFirst();
        return comboBox;
    }
    public ComboBox loadWeaponCB(String s, ObservableList<Item> weaponNameList) {
        ComboBox comboBox = new ComboBox();
        ObservableList<String> weaponList = FXCollections.observableArrayList();
        for (Item item : weaponNameList) {
            weaponList.add(item.getItemName());
        }
        comboBox.getItems().addAll(weaponList);
        comboBox.getSelectionModel().select(s);
        return comboBox;
    }
    public ComboBox accessoryCB(ObservableList<Item> accessoryNameList) {
        ComboBox comboBox = new ComboBox();
        ObservableList<String> accessoryList = FXCollections.observableArrayList();
        for (Item item : accessoryNameList) {
            accessoryList.add(item.getItemName());
        }
        comboBox.getItems().addAll(accessoryList);
        comboBox.getSelectionModel().selectFirst();
        return comboBox;
    }
    public ComboBox loadAccessoryCB(String s, ObservableList<Item> accessoryNameList) {
        ComboBox comboBox = new ComboBox();
        ObservableList<String> accessoryList = FXCollections.observableArrayList();
        for (Item item : accessoryNameList) {
            accessoryList.add(item.getItemName());
        }
        comboBox.getItems().addAll(accessoryList);
        comboBox.getSelectionModel().select(s);
        return comboBox;
    }
    public TextField levelTextField() {
        TextField lvltxt = new TextField("0");
        return lvltxt;
    }
    public TextField loadLevelTextField(String string) {
        TextField lvltxt = new TextField(string);
        return lvltxt;
    }
    public TextField levelPrestigeTextField() {
        TextField lvlPtxt = new TextField("Prestige");
        return lvlPtxt;
    }
    public TextField loadLevelPrestigeTextField(String string) {
        TextField lvlPtxt = new TextField(string);
        return lvlPtxt;
    }
    public ComboBox attackModeCB() {
        ComboBox<AttackMode.Mode> amcb = new ComboBox<>();
        amcb.getItems().addAll(AttackMode.Mode.values());
        amcb.getSelectionModel().selectFirst();
        return amcb;
    }
    public ComboBox loadAttackModeCB(String s) {
        ComboBox<AttackMode.Mode> amcb = new ComboBox<>();
        amcb.getItems().addAll(AttackMode.Mode.values());
        selectorAttackMode(s, amcb);
        return amcb;
    }
    public void selectorAttackMode(String s, ComboBox cb) {
        switch (s) {
            case "Auto":
                cb.getSelectionModel().select(0);
                break;
            case "Near":
                cb.getSelectionModel().select(1);
                break;
            case "LowHP":
                cb.getSelectionModel().select(2);
                break;
            case "Boss":
                cb.getSelectionModel().select(3);
                break;
            case "Flying":
                cb.getSelectionModel().select(4);
        }
    }
}
