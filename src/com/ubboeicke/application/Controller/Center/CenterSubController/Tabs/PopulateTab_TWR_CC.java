package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import com.ubboeicke.application.Model.Gamedata.Leaders.Leader;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class PopulateTab_TWR_CC {
    ComboBox<String> c1 = new ComboBox<>();
    ComboBox<String> c2 = new ComboBox<>();
    ComboBox<String> c3 = new ComboBox<>();
    ComboBox<String> c4 = new ComboBox<>();
    ComboBox<String> c5 = new ComboBox<>();
    ComboBox<String> c6 = new ComboBox<>();
    private CenterViewController mCenterViewController;
    private TableView<CastleComponent> mCastleComponentTableView;
    private TableView<Tower> mTowerTableView;
    private TableView<Leader> mLeaderTableView;
    private ObservableList<CastleComponent> mCastleComponents = FXCollections.observableArrayList();
    private ObservableList<Leader> mLeaders = FXCollections.observableArrayList();
    private ObservableList<Tower> mTowers = FXCollections.observableArrayList();
    private ObservableList<Item> mWeaponList;
    private ObservableList<Item> mAccessoryList;
    private GridPane mGridPane;
    private PopulateTab_Item mPopulateTabItem;
    private GameObjectConstructor goc;

    public PopulateTab_TWR_CC(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;
        mCastleComponentTableView = mCenterViewController.getCcTableView();
        mTowerTableView = mCenterViewController.getTwrTableView();
        mGridPane = mCenterViewController.getTclCOntainer();
        mLeaderTableView = mCenterViewController.getLeaderTableView();
        mPopulateTabItem = mCenterViewController.getmPopulateTabItem();
        goc = new GameObjectConstructor();
        mWeaponList = mCenterViewController.getItemWeaponTableView().getItems();
        mAccessoryList = mCenterViewController.getItemAccessoryTableView().getItems();
        setupTableView();
        addCastleComponents();
        addTowers();
        addLeaders();
    }

    public void setupTableView() {
        //TODO dynamic resizing
        TableColumn ldrCol = new TableColumn("Leaders");
        TableColumn ldrNameCol = new TableColumn("Name");
        ldrNameCol.setCellValueFactory(new PropertyValueFactory<Leader, String>("name"));
        ldrNameCol.setPrefWidth(125);
        TableColumn ldrLevelCol = new TableColumn("Level");
        ldrLevelCol.setCellValueFactory(new PropertyValueFactory<Leader, String>("level"));
        ldrLevelCol.setPrefWidth(125);
        TableColumn ldrLevelPCol = new TableColumn("Prestige Level");
        ldrLevelPCol.setCellValueFactory(new PropertyValueFactory<Leader, String>("levelPrestige"));
        ldrLevelPCol.setPrefWidth(125);
        TableColumn ldrAMCol = new TableColumn("Attack Mode");
        ldrAMCol.setCellValueFactory(new PropertyValueFactory<Leader, String>("attackMode"));
        ldrAMCol.setPrefWidth(100);
        TableColumn ldrWeaponCol = new TableColumn("Weapon");
        ldrWeaponCol.setCellValueFactory(new PropertyValueFactory<Leader, String>("weapon"));
        ldrWeaponCol.setPrefWidth(125);
        TableColumn ldrAccCol = new TableColumn("Accessory");
        ldrAccCol.setCellValueFactory(new PropertyValueFactory<Leader, String>("accessory"));
        ldrAccCol.setPrefWidth(125);
        TableColumn ccCol = new TableColumn("Castle Components");
        TableColumn ccNameCol = new TableColumn("Name");
        ccNameCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccName"));
        ccNameCol.setPrefWidth(125);
        TableColumn ccLevelCol = new TableColumn("Level");
        ccLevelCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, Integer>("ccLevel"));
        ccLevelCol.setPrefWidth(125);
        TableColumn ccLevelPCol = new TableColumn("Prestige Level");
        ccLevelPCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccLevelP"));
        ccLevelPCol.setPrefWidth(125);
        TableColumn ccAMCol = new TableColumn("Attack Mode");
        ccAMCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccAM"));
        ccAMCol.setPrefWidth(100);
        TableColumn twrCol = new TableColumn("Tower");
        TableColumn twrNameCol = new TableColumn("Name");
        twrNameCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("name"));
        twrNameCol.setPrefWidth(125);
        TableColumn twrPromoCol = new TableColumn("Promotion");
        twrPromoCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("promotion"));
        twrPromoCol.setPrefWidth(125);
        TableColumn twrLvlCol = new TableColumn("Level");
        twrLvlCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("level"));
        twrLvlCol.setPrefWidth(125);
        TableColumn twrLvlPCol = new TableColumn("Prestige Level");
        twrLvlPCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("levelPrestige"));
        twrLvlPCol.setPrefWidth(125);
        TableColumn twrAMCol = new TableColumn("Attack Mode");
        twrAMCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("attackMode"));
        twrAMCol.setPrefWidth(100);
        twrCol.getColumns().addAll(twrNameCol, twrPromoCol, twrLvlCol, twrLvlPCol, twrAMCol);
        ccCol.getColumns().addAll(ccNameCol, ccLevelCol, ccLevelPCol, ccAMCol);
        ldrCol.getColumns().addAll(ldrNameCol, ldrLevelCol, ldrLevelPCol, ldrAMCol, ldrWeaponCol, ldrAccCol);
        mLeaderTableView.getColumns().addAll(ldrCol);
        mLeaderTableView.setColumnResizePolicy(param -> true);
        mCastleComponentTableView.getColumns().addAll(ccCol);
        mCastleComponentTableView.setColumnResizePolicy((param -> true));
        mCastleComponentTableView.setOnKeyReleased(event -> {
            validatePrestigeCC();
        });
        mTowerTableView.setOnKeyReleased(event -> {
            validatePrestigeTWR();
        });
        mLeaderTableView.setOnKeyReleased(event -> {
            validatePrestigeLDR();
        });
        mTowerTableView.getColumns().addAll(twrCol);
        mTowerTableView.setColumnResizePolicy(param -> true);
    }

    public void addLeaders() {
        mLeaders.add(new Leader("Edward", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaders.add(new Leader("Solar", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaders.add(new Leader("Zero", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaders.add(new Leader("Thor", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaders.add(new Leader("Sara", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaders.add(new Leader("Tony", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaders.add(new Leader("Din", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mLeaderTableView.setItems(mLeaders);
    }

    public void addCastleComponents() {
        mCastleComponents.add(new CastleComponent("Cannon Castle", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mCastleComponents.add(new CastleComponent("Minigun Castle", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mCastleComponents.add(new CastleComponent("Poison Castle", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mCastleComponents.add(new CastleComponent("Lightning Castle", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mCastleComponents.add(new CastleComponent("Ballista Castle", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mCastleComponents.add(new CastleComponent("Shield Castle", goc.levelTextField()));
        mCastleComponents.add(new CastleComponent("Gold Castle", goc.levelTextField()));
        mCastleComponents.add(new CastleComponent("Fire CastleBase", goc.levelTextField()));
        mCastleComponents.add(new CastleComponent("Poison CastleBase", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mCastleComponents.add(new CastleComponent("Lightning CastleBase", goc.levelTextField()));
        mCastleComponents.add(new CastleComponent("Frozen CastleBase", goc.levelTextField()));
        mCastleComponentTableView.setItems(mCastleComponents);
    }

    public void addTowers() {
        c1.getItems().addAll("Death Worm ", "Death Worm II");
        c2.getItems().addAll("Crystal Tree", "Golden Tree");
        c3.getItems().addAll("Burning Tower", "Burning Tower II");
        c4.getItems().addAll("Frozen Tower II");
        c5.getItems().addAll("Thunder Tower", "Thunder Tower II");
        c6.getItems().addAll("Offensive Barracks", "Defensive Barracks");
        mTowers.add(new Tower("Worm", c1, goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Tree", c2, goc.levelTextField()));
        mTowers.add(new Tower("Trophy", goc.levelTextField()));
        mTowers.add(new Tower("Flame Tower", c3, goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Frozen Tower", c4, goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Lightning Tower", c5, goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Cannon", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Thorn Worm", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Barracks", c6, goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        mTowers.add(new Tower("Turret", goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB()));
        c1.getSelectionModel().selectFirst();
        c2.getSelectionModel().selectFirst();
        c3.getSelectionModel().selectFirst();
        c4.getSelectionModel().selectFirst();
        c5.getSelectionModel().selectFirst();
        c6.getSelectionModel().selectFirst();
        mTowerTableView.setItems(mTowers);
    }

    public void validatePrestigeCC() {
        for (CastleComponent cc : mCastleComponentTableView.getItems()) {
            if (cc.getCcName().equals("Gold Castle") || cc.getCcName().equals("Shield Castle") || cc.getCcName().equals("Fire CastleBase") || cc.getCcName().equals("Lightning CastleBase") || cc.getCcName().equals("Frozen CastleBase")) {
                if (cc.getCcLevel().equals("99")) {
                    cc.getCcLevel().setText("99(MAX)");
                }
            } else {
                if (!cc.getCcLevel().getText().equals("9999")) {
                    cc.getCcLevelP().setText("0");
                    cc.getCcLevelP().setDisable(true);
                } else {
                    cc.getCcLevelP().setDisable(false);
                }
            }
        }
    }

    public void validatePrestigeTWR() {
        for (Tower twr : mTowerTableView.getItems()) {
            if (twr.getName().equals("Tree") || twr.getName().equals("Trophy")) {
                if (twr.getLevel().equals("21")) {
                    twr.getLevel().setText("21(MAX)");
                }
            } else {
                if (!twr.getLevel().getText().equals("9999")) {
                    twr.getLevelPrestige().setText("0");
                    twr.getLevelPrestige().setDisable(true);
                } else {
                    twr.getLevelPrestige().setDisable(false);
                }
            }
        }
    }

    public void validatePrestigeLDR() {
        for (Leader ldr : mLeaderTableView.getItems()) {
            if (!ldr.getLevel().getText().equals("9999")) {
                ldr.getLevelPrestige().setText("0");
                ldr.getLevelPrestige().setDisable(true);
            } else {
                ldr.getLevelPrestige().setDisable(false);
            }
        }
    }

    public ObservableList<Leader> getLeaders() {
        return mLeaders;
    }

    public ObservableList<CastleComponent> getCastleComponents() {
        return mCastleComponents;
    }

    public ObservableList<Tower> getTowers() {
        return mTowers;
    }
}
