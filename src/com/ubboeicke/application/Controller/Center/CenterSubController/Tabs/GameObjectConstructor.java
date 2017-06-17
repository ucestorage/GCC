package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.AttackMode;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.List;

/**
 * Created by Ubbo Eicke on 17.06.2017.
 */
public class GameObjectConstructor {
    private CenterViewController mCenterViewController;

    private ObservableList<String> accessoryNameList;
    private PopulateTab_Item mPopulateTabItem;

    public GameObjectConstructor(CenterViewController centerViewController){
        mCenterViewController = centerViewController;
        mPopulateTabItem = mCenterViewController.getPopulateTabItem();


        accessoryNameList = mCenterViewController.getAccessoryNameList();





    }

    public ComboBox promotionCB(String[] strings) {
        ComboBox promoCB = new ComboBox<>();
        promoCB.getItems().addAll(strings);
        promoCB.getSelectionModel().selectFirst();
        return  promoCB;
    }
    public ComboBox loadPromotionCB(String s,String[] strings) {
        ComboBox promoCB = new ComboBox<>();
        ObservableList<String> obs = FXCollections.observableArrayList();

        obs.addAll(strings);
         promoCB.getItems().addAll(obs);
        promoCB.getSelectionModel().select(s);
        return  promoCB;
    }

    public ComboBox weaponCB(List<String> weaponNameList) {
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().setAll(weaponNameList);
        comboBox.getSelectionModel().selectFirst();

        return comboBox;
    }
    public ComboBox loadWeaponCB(String s,List<String> weaponNameList){
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().setAll(weaponNameList);
        comboBox.getSelectionModel().select(s);

     return  comboBox;
    }
    public ComboBox accessoryCB(){
        ComboBox comboBox= new ComboBox();

        comboBox.getItems().setAll(accessoryNameList);
        comboBox.getSelectionModel().selectFirst();
        return comboBox;
    }
    public ComboBox loadAccessoryCB(String s){
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().setAll(accessoryNameList);
        comboBox.getSelectionModel().select(s);
        return  comboBox;
    }
    public TextField levelTextField(){
        TextField lvltxt = new TextField("0");
        return lvltxt;

    }
    public TextField loadLevelTextField(String string){
        TextField lvltxt = new TextField(string);
        return lvltxt;

    }
    public TextField levelPrestigeTextField(){
        TextField lvlPtxt = new TextField("Prestige");
        return lvlPtxt;

    }
    public TextField loadLevelPrestigeTextField(String string){
        TextField lvlPtxt = new TextField(string);
        return lvlPtxt;

    }
    public ComboBox attackModeCB(){
        ComboBox<AttackMode.Mode> amcb = new ComboBox<>();
        amcb.getItems().addAll(AttackMode.Mode.values());
        amcb.getSelectionModel().selectFirst();
        return  amcb;
    }
    public ComboBox loadAttackModeCB(String s){
        ComboBox<AttackMode.Mode> amcb = new ComboBox<>();
        amcb.getItems().addAll(AttackMode.Mode.values());
        selectorAttackMode(s,amcb);
        return  amcb;
    }
    public void selectorAttackMode(String s, ComboBox cb){
        switch(s) {
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
