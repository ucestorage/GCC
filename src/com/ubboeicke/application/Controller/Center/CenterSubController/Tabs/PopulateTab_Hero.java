package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Enums.Promotions;
import com.ubboeicke.application.Model.Gamedata.Heroes.Hero;
import com.ubboeicke.application.Model.Gamedata.Items.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Ubbo Eicke on 16.06.2017.
 */
public class PopulateTab_Hero {
    private CenterViewController mCenterViewController;
    private TableView<Hero> mHeroTableView1;
    private TableView<Hero> mHeroTableView2;
    private ObservableList<Hero> mHeroes1 = FXCollections.observableArrayList();
    private ObservableList<Hero> mHeroes2 = FXCollections.observableArrayList();
    private GameObjectConstructor goc;
    private ObservableList<Item> mWeaponList;
    private ObservableList<Item> mAccessoryList;

    public PopulateTab_Hero(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;
        mHeroTableView1 = mCenterViewController.getHeroTableView1();
        mHeroTableView2 = mCenterViewController.getHeroTableView2();
        goc = new GameObjectConstructor();
        mWeaponList = mCenterViewController.getItemWeaponTableView().getItems();
        mAccessoryList = mCenterViewController.getItemAccessoryTableView().getItems();
        setupTableView_OH();
        setuupTableView_UH();
        addHeroes();
    }

    public void setupTableView_OH() {
        TableColumn heroCol = new TableColumn("Heroes");
        TableColumn heroNameCol = new TableColumn("Name");
        heroNameCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("name"));
        heroNameCol.setPrefWidth(114.28);
        TableColumn heroPromotionCol = new TableColumn("Promotion");
        heroPromotionCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("promotion"));
        heroPromotionCol.setPrefWidth(114.28);
        TableColumn heroLevelCol = new TableColumn("Level");
        heroLevelCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("level"));
        heroLevelCol.setPrefWidth(114.28);
        TableColumn heroLevelPCol = new TableColumn("Prestige Level");
        heroLevelPCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("levelPrestige"));
        heroLevelPCol.setPrefWidth(114.28);
        TableColumn heroAMCol = new TableColumn("Attack Mode");
        heroAMCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("attackMode"));
        heroAMCol.setPrefWidth(114.28);
        TableColumn heroWeaponCol = new TableColumn("Weapon");
        heroWeaponCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("weapon"));
        heroWeaponCol.setPrefWidth(114.28);
        TableColumn heroAccCol = new TableColumn("Accessory");
        heroAccCol.setCellValueFactory(new PropertyValueFactory<Hero, String>("accessory"));
        heroAccCol.setPrefWidth(114.28);
        heroCol.getColumns().addAll(heroNameCol, heroPromotionCol, heroLevelCol, heroLevelPCol, heroAMCol, heroWeaponCol, heroAccCol);
        mHeroTableView1.getColumns().addAll(heroCol);
    }

    public void setuupTableView_UH() {
        TableColumn hero2Col = new TableColumn("Utility Heroes");
        TableColumn heroName2Col = new TableColumn("Name");
        heroName2Col.setCellValueFactory(new PropertyValueFactory<Hero, String>("name"));
        heroName2Col.setPrefWidth(114.28);
        TableColumn heroPromotion2Col = new TableColumn("Promotion");
        heroPromotion2Col.setCellValueFactory(new PropertyValueFactory<Hero, String>("promotion"));
        heroPromotion2Col.setPrefWidth(114.28);
        TableColumn heroLevel2Col = new TableColumn("Level");
        heroLevel2Col.setCellValueFactory(new PropertyValueFactory<Hero, String>("level"));
        heroLevel2Col.setPrefWidth(114.28);
        TableColumn heroWeapon2Col = new TableColumn("Weapon");
        heroWeapon2Col.setCellValueFactory(new PropertyValueFactory<Hero, String>("weapon"));
        heroWeapon2Col.setPrefWidth(114.28);
        TableColumn heroAcc2Col = new TableColumn("Accessory");
        heroAcc2Col.setCellValueFactory(new PropertyValueFactory<Hero, String>("accessory"));
        heroAcc2Col.setPrefWidth(114.28);
        hero2Col.getColumns().addAll(heroName2Col, heroPromotion2Col, heroLevel2Col, heroWeapon2Col, heroAcc2Col);
        mHeroTableView2.getColumns().addAll(hero2Col);
    }

    public void addHeroes() {
        mHeroes1.add(new Hero("Archer", goc.promotionCB(Promotions.Archer), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Hunter", goc.promotionCB(Promotions.Hunter), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Elf", goc.promotionCB(Promotions.Elf), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Ice Mage", goc.promotionCB(Promotions.IceMage), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Lightning Mage", goc.promotionCB(Promotions.LightningMage), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Fire Mage", goc.promotionCB(Promotions.FireMage), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Ogre", goc.promotionCB(Promotions.Ogre), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Tiny Giant", goc.promotionCB(Promotions.TinyGiant), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Slinger", goc.promotionCB(Promotions.Slinger), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Voodoo", goc.promotionCB(Promotions.Voodoo), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Bazooka Man", goc.promotionCB(Promotions.BazookaMan), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Knight", goc.promotionCB(Promotions.Knight), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Lisa", goc.promotionCB(Promotions.Lisa), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Alice", goc.promotionCB(Promotions.Alice), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Dorothy", goc.promotionCB(Promotions.Dorothy), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Druid", goc.promotionCB(Promotions.Druid), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Assassin", goc.promotionCB(Promotions.Assassin), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Flying Orc", goc.promotionCB(Promotions.FlyingOrc), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Windy", goc.promotionCB(Promotions.Windy), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Angel", goc.promotionCB(Promotions.Angel), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Zeus", goc.promotionCB(Promotions.Zeus), goc.levelTextField(), goc.levelPrestigeTextField(), goc.attackModeCB(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Golem Master", goc.promotionCB(Promotions.GolemMaster), goc.levelTextField(),goc.levelPrestigeTextField(),goc.attackModeCB(),goc.weaponCB(mWeaponList),goc.accessoryCB(mAccessoryList)));
        mHeroes1.add(new Hero("Succubus", goc.promotionCB(Promotions.Succubus),goc.levelTextField(),goc.levelPrestigeTextField(),goc.attackModeCB(),goc.weaponCB(mWeaponList),goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("White Mage", goc.promotionCB(Promotions.WhiteMage), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Necromancer", goc.promotionCB(Promotions.Necromancer), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Military Band (F)", goc.promotionCB(Promotions.MBandF), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Military Band (M)", goc.promotionCB(Promotions.MBandM), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Priest", goc.promotionCB(Promotions.Priest), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Smith", goc.promotionCB(Promotions.Smith), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Architect", goc.promotionCB(Promotions.Architect), goc.levelTextField(), goc.weaponCB(mWeaponList), goc.accessoryCB(mAccessoryList)));
        mHeroes2.add(new Hero("Orc Band", goc.promotionCB(Promotions.OrcBand),goc.levelTextField(),goc.weaponCB(mWeaponList),goc.accessoryCB(mAccessoryList)));
        mHeroTableView1.setItems(mHeroes1);
        mHeroTableView2.setItems(mHeroes2);
        mHeroTableView1.setOnKeyReleased(event -> {
            validatePrestige();
        });
    }

    private void validatePrestige() {
        for (Hero h : mCenterViewController.getHeroTableView1().getItems()) {
            if (!h.getLevel().getText().equals("9999")) {
                h.getLevelPrestige().setText("0");
                h.getLevelPrestige().setDisable(true);
            } else {
                h.getLevelPrestige().setDisable(false);
            }
        }
    }
}
