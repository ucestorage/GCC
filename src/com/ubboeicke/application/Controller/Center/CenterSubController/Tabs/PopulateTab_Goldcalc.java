package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import com.ubboeicke.application.Controller.Main.MainController;
import com.ubboeicke.application.Model.Gamedata.GoldCalc.Gold;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class PopulateTab_Goldcalc {
    private CenterViewController mCenterViewController;
  
    private MainController mMainController;
    private TableView<Gold> mTableView;
    public PopulateTab_Goldcalc(MainController mainController) {
        mMainController = mainController;
      
        mCenterViewController = mMainController.getCenterViewController();
        mTableView = mCenterViewController.getGoldHeroesTV();
        setupHeroTableView();
    }
    public TableView<Gold> getmTableView() {
        return mTableView;
    }
    private void setupHeroTableView() {
        TableColumn c1 = new TableColumn("Hero/Leader");
        c1.setPrefWidth(200.0);
        c1.setCellValueFactory(new PropertyValueFactory<Gold, String>("nameL"));
        TableColumn c2 = new TableColumn("Level");
        c2.setPrefWidth(200.0);
        c2.setCellValueFactory(new PropertyValueFactory<Gold, String>("levelL"));
        TableColumn c3 = new TableColumn("Damage");
        c3.setPrefWidth(200.0);
        c3.setCellValueFactory(new PropertyValueFactory<Gold, String>("dmgL"));
        TableColumn c4 = new TableColumn("Desired Level");
        c4.setPrefWidth(200.0);
        c4.setCellValueFactory(new PropertyValueFactory<Gold, String>("wantedL"));
        TableColumn c5 = new TableColumn("Upgrade Cost");
        c5.setPrefWidth(200.0);
        c5.setCellValueFactory(new PropertyValueFactory<Gold, String>("upgCost"));
        TableColumn c6 = new TableColumn("Damage after upgrade");
        c6.setPrefWidth(200.0);
        c6.setCellValueFactory(new PropertyValueFactory<Gold, String>("futDmgL"));
        TableColumn c7 = new TableColumn("Total Upgrade Cost");
        c7.setPrefWidth(200.0);
        c7.setCellValueFactory(new PropertyValueFactory<Gold, String>("totalCost"));
        TableColumn c8 = new TableColumn("Damage Difference");
        c8.setPrefWidth(200.0);
        c8.setCellValueFactory(new PropertyValueFactory<Gold, String>("dmgDiff"));
        TableColumn c9 = new TableColumn("Gold/Dmg");
        c9.setPrefWidth(200.0);
        c9.setCellValueFactory(new PropertyValueFactory<Gold, String>("goldPerDmg"));
        mTableView.getColumns().addAll(c1, c2, c3, c4, c5, c6, c7, c8, c9);
        mTableView.setColumnResizePolicy(param -> true);
    }
}
