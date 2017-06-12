package com.ubboeicke.application.Controller;

import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponent;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponentParser;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.ItemParser;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.Item;
import com.ubboeicke.application.Model.MainModel;

import com.ubboeicke.application.Model.Save_Load.SaveAndLoadHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * Created by Ubbo Eicke on 02.06.2017.
 */


public class MainController extends BorderPane {
    @FXML
    private VBox vboxTop;
    @FXML
    private TabPane centerContainer;
    private final TopViewController mTopViewController;
    private final MainModel mMainModel;
    private final CenterViewController mCenterViewController;
    private ObservableList<Item> mItemObservableList;
    private  TableView<Item> mItemTableView;
    private ItemParser mItemParser;
    private SaveAndLoadHandler mSaveAndLoadHandler;
    private CastleComponentParser mCastleComponentParser;




    public MainController(MainModel mainModel, CenterViewController centerViewController, TopViewController topViewController) throws IOException {
        this.mCenterViewController = centerViewController;
        this.mTopViewController = topViewController;
        this.mMainModel = mainModel;
        this.mSaveAndLoadHandler = new SaveAndLoadHandler(mMainModel,mCenterViewController,mTopViewController);
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../View/MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
       centerViewController.initialize(getCenterContainer());
       mTopViewController.initialize(getContentHolder());
        mItemParser = new ItemParser(mCenterViewController);
        mCastleComponentParser = new CastleComponentParser(mCenterViewController);


    }

    private VBox getContentHolder() {
        return vboxTop;
    }

    private TabPane getCenterContainer() {
        return centerContainer;
    }

    public void save() {
       mSaveAndLoadHandler.saveGeneralInformation();
       mSaveAndLoadHandler.saveItems();
       mSaveAndLoadHandler.saveCastleComponents();
      // mSaveAndLoadHandler.showConfirmation();

    }
    public void load(){
        mItemObservableList = mCenterViewController.getItemObservableList();
        mItemTableView = mCenterViewController.getItemTableView();
        for (String s : mMainModel.loadItems()){
            mItemObservableList.add(mItemParser.splitItem(s));

        }
        mItemTableView.setItems(mItemObservableList);
        TableView<CastleComponent> tvcc = mCenterViewController.getCcTableView();
        ObservableList<CastleComponent> obsv = FXCollections.observableArrayList();
        for (String s : mMainModel.loadCC()){
            obsv.add(mCastleComponentParser.splitCC(s));
        }tvcc.setItems(obsv);



        //TODO improve loading
        mTopViewController.setPlayerNameLabel(mMainModel.load().get(0));
        mTopViewController.setPlayerLevelLabel(mMainModel.load().get(1));
        mTopViewController.setGuildLabel(mMainModel.load().get(2));
        mTopViewController.setstartDateLabel(mMainModel.load().get(3));
        mTopViewController.setWaveCountTextField(mMainModel.load().get(4));
        mTopViewController.seteColoLabel(mMainModel.load().get(5));
        mTopViewController.sethColoLabel(mMainModel.load().get(6));
        mTopViewController.setoColoLabel(mMainModel.load().get(7));
        mTopViewController.setTwLabel(mMainModel.load().get(8));
        mTopViewController.setOwLabel(mMainModel.load().get(9));







    }

    private void writeValues(TextField textField, Label label){
        textField.setOnKeyReleased(e -> label.setText(textField.getText()));

    }
    public void writerLabel(String string, Label label){
        label.setText(string);

    }
    public void writerTextField(String string, TextField textField) {
        textField.setText(string);
    }
}
