package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.Towers.Tower;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class PopulateTab_TWR_CC {
    private CenterViewController mCenterViewController;

    private TableView<CastleComponent> mCastleComponentTableView;
    private TableView<Tower> mTowerTableView;
    private ObservableList<CastleComponent> mCastleComponents = FXCollections.observableArrayList();
    private ObservableList<Tower> mTowers = FXCollections.observableArrayList();
    private GridPane mGridPane;

    ComboBox<String> c1 = new ComboBox<>();
    ComboBox<String> c2 = new ComboBox<>();
    ComboBox<String> c3 = new ComboBox<>();
    ComboBox<String> c4 = new ComboBox<>();
    ComboBox<String> c5= new ComboBox<>();
    ComboBox<String> c6 = new ComboBox<>();



    public PopulateTab_TWR_CC(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;
        mCastleComponentTableView = mCenterViewController.getCcTableView();
        mTowerTableView = mCenterViewController.getTwrTableView();
        mGridPane = mCenterViewController.getTclContainer();
        setupTableView();
        addCastleComponents();
        addTowers();


    }

    public void setupTableView(){



        TableColumn ccCol = new TableColumn("Castle Components");
        ccCol.setPrefWidth(633);


        TableColumn ccNameCol = new TableColumn("Name");
        ccNameCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccName"));
        ccNameCol.setPrefWidth(158.25);

        TableColumn ccLevelCol = new TableColumn("Level");
        ccLevelCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, Integer>("ccLevel"));
        ccLevelCol.setPrefWidth(158.25);

        TableColumn ccLevelPCol = new TableColumn("Prestige Level");
        ccLevelPCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccLevelP"));
          ccLevelPCol.setPrefWidth(158.25);

        TableColumn ccAMCol = new TableColumn("Attack Mode");
        ccAMCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccAM"));
        ccAMCol.setPrefWidth(158.25);

        TableColumn twrCol = new TableColumn("Tower");
        twrCol.setPrefWidth(633);

        TableColumn twrNameCol = new TableColumn("Name");
        twrNameCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("name"));
        twrNameCol.setPrefWidth(126.6);

        TableColumn twrPromoCol = new TableColumn("Promotion");
        twrPromoCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("promotion"));
        twrPromoCol.setPrefWidth(126.6);

        TableColumn twrLvlCol = new TableColumn("Level");
        twrLvlCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("level"));
        twrLvlCol.setPrefWidth(126.6);

        TableColumn twrLvlPCol = new TableColumn("Prestige Level");
        twrLvlPCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("levelPrestige"));
        twrLvlPCol.setPrefWidth(126.6);

        TableColumn twrAMCol = new TableColumn("Attack Mode");
        twrAMCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("attackMode"));
        twrAMCol.setPrefWidth(126.6);

        twrCol.getColumns().addAll(twrNameCol,twrPromoCol,twrLvlCol,twrLvlPCol,twrAMCol);
        ccCol.getColumns().addAll(ccNameCol,ccLevelCol,ccLevelPCol, ccAMCol);
        mCastleComponentTableView.getColumns().addAll(ccCol);
        mCastleComponentTableView.setColumnResizePolicy((param -> true));
        mCastleComponentTableView.setOnKeyReleased(event -> {
            validatePrestige();
                });
        mTowerTableView.getColumns().addAll(twrCol);
        mTowerTableView.setColumnResizePolicy(param -> true);
    }
    public void addCastleComponents(){
        mCastleComponents.add(new CastleComponent("Cannon Castle",new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mCastleComponents.add(new CastleComponent("Minigun Castle",new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mCastleComponents.add(new CastleComponent("Poison Castle",new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mCastleComponents.add(new CastleComponent("Lightning Castle",new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mCastleComponents.add(new CastleComponent("Ballista Castle",new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mCastleComponents.add(new CastleComponent("Shield Castle",new TextField("0")));
        mCastleComponents.add(new CastleComponent("Gold Castle",new TextField("0")));
        mCastleComponents.add(new CastleComponent("Fire CastleBase",new TextField("0")));
        mCastleComponents.add(new CastleComponent("Poison CastleBase",new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mCastleComponents.add(new CastleComponent("Lightning CastleBase",new TextField("0")));
        mCastleComponents.add(new CastleComponent("Frozen CastleBase",new TextField("0")));
       mCastleComponentTableView.setItems(mCastleComponents);
    }
    public void addTowers(){
        c1.getItems().addAll("Death Worm ","Death Worm II");
        c2.getItems().addAll("Crystal Tree", "Golden Tree");
        c3.getItems().addAll("Burning Tower","Burning Tower II");
        c4.getItems().addAll("Frozen Tower II");
        c5.getItems().addAll("Thunder Tower","Thunder Tower II");
        c6.getItems().addAll("Offensive Barracks", "Defensive Barracks");
        mTowers.add(new Tower("Worm",c1,new TextField("0"), new TextField("Prestige"),new ComboBox()));
        mTowers.add(new Tower("Tree",c2,new TextField("21")));
        mTowers.add(new Tower("Trophy",new TextField("21")));
        mTowers.add(new Tower("Flame Tower",c3,new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mTowers.add(new Tower("Frozen Tower",c4,new TextField("0"),new TextField("Prestige"), new ComboBox()));
        mTowers.add(new Tower("Lightning Tower",c5,new TextField("0"), new TextField("Prestige"), new ComboBox()));
        mTowers.add(new Tower("Cannon",new TextField("0"), new TextField("Prestige"), new ComboBox()));
        mTowers.add(new Tower("Thorn Worm", new TextField("0"), new TextField("Prestige"), new ComboBox()));
        mTowers.add(new Tower("Barracks", c6, new TextField("0"), new TextField("Prestige"),new ComboBox()));
        mTowers.add(new Tower("Turret",new TextField("0"),new TextField("Prestige"), new ComboBox()));


        mTowerTableView.setItems(mTowers);
    }
    public void validatePrestige(){
        for(CastleComponent cc : mCastleComponentTableView.getItems()){


            if(cc.getCcName().equals("Gold Castle") || cc.getCcName().equals("Shield Castle") || cc.getCcName().equals("Fire CastleBase") || cc.getCcName().equals("Lightning CastleBase") || cc.getCcName().equals("Frozen CastleBase")){

            } else {
                if (!cc.getCcLevel().getText().equals("9999")) {
                    cc.getCcLevelP().setDisable(true);
                } else {
                    cc.getCcLevelP().setDisable(false);
                }

            }
}
    }


}
