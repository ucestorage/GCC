package com.ubboeicke.application.Controller.CenterSubController.Tabs;

import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class PopulateTab_TWR_CC {
    private CenterViewController mCenterViewController;
    private TableView<CastleComponent> mCastleComponentTableView;
    private ObservableList<CastleComponent> mCastleComponents = FXCollections.observableArrayList();

    public PopulateTab_TWR_CC(CenterViewController centerViewController) {
        mCenterViewController = centerViewController;
        mCastleComponentTableView = mCenterViewController.getCcTableView();

        setupTableView();
        addCastleComponents();
    }

    public TableView<CastleComponent> getCastleComponentTableView() {
        return mCastleComponentTableView;
    }

    public void setCastleComponentTableView(TableView<CastleComponent> castleComponentTableView) {
        mCastleComponentTableView = castleComponentTableView;
    }

    public ObservableList<CastleComponent> getCastleComponents() {
        return mCastleComponents;
    }

    public void setCastleComponents(ObservableList<CastleComponent> castleComponents) {
        mCastleComponents = castleComponents;
    }

    public void setupTableView(){
        TableColumn ccCol = new TableColumn("Castle Components");

        TableColumn ccNameCol = new TableColumn("Name");
        ccNameCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccName"));
        ccNameCol.setPrefWidth(150);

        TableColumn ccLevelCol = new TableColumn("Level");
        ccLevelCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, Integer>("ccLevel"));
        ccLevelCol.setPrefWidth(100);

        TableColumn ccLevelPCol = new TableColumn("Prestige Level");
        ccLevelPCol.setCellValueFactory(new PropertyValueFactory<CastleComponent, String>("ccLevelP"));
        ccLevelPCol.setPrefWidth(100);

        /*TableColumn twrCol = new TableColumn("Tower");

        TableColumn twrNameCol = new TableColumn("Name");
        twrNameCol.setCellValueFactory(new PropertyValueFactory<Tower, String>("twrName"));
        twrNameCol.setPrefWidth(100);

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
        itemVal3Col.setPrefWidth(100);*/
        ccCol.getColumns().addAll(ccNameCol,ccLevelCol,ccLevelPCol);
        mCastleComponentTableView.getColumns().addAll(ccCol);
        mCastleComponentTableView.setColumnResizePolicy((param -> true));
    }
    public void addCastleComponents(){
        mCastleComponents.add(new CastleComponent("Cannon Castle",new TextField(""),new TextField("")));
        mCastleComponents.add(new CastleComponent("Minigun Castle",new TextField(""),new TextField("")));
        mCastleComponents.add(new CastleComponent("Poison Castle",new TextField(""),new TextField("")));
        mCastleComponents.add(new CastleComponent("Lightning Castle",new TextField(""),new TextField("")));
        mCastleComponents.add(new CastleComponent("Ballista Castle",new TextField(""),new TextField("")));
        mCastleComponents.add(new CastleComponent("Shield Castle",new TextField("")));
        mCastleComponents.add(new CastleComponent("Fire CastleBase",new TextField("")));
        mCastleComponents.add(new CastleComponent("Poison CastleBase",new TextField(""),new TextField("")));
        mCastleComponents.add(new CastleComponent("Lightning CastleBase",new TextField("")));
        mCastleComponents.add(new CastleComponent("Frozen CastleBase",new TextField("")));

       mCastleComponentTableView.setItems(mCastleComponents);

    }


}
