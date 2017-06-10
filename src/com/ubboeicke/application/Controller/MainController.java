package com.ubboeicke.application.Controller;

import com.ubboeicke.application.Model.ItemCreation.Item;
import com.ubboeicke.application.Model.MainModel;

import javafx.collections.ObservableArray;
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




    public MainController(MainModel mainModel, CenterViewController centerViewController, TopViewController topViewController) throws IOException {
        this.mCenterViewController = centerViewController;
        this.mTopViewController = topViewController;
        this.mMainModel = mainModel;

        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("../View/MainView.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
       centerViewController.initialize(getCenterContainer());
       mTopViewController.initialize(getContentHolder());


        writeValues(centerViewController.getPlayerNameTextField(),mTopViewController.getPlayerNameLabel());


    }

    private VBox getContentHolder() {
        return vboxTop;
    }

    private TabPane getCenterContainer() {
        return centerContainer;
    }

    public void save() {


        mMainModel.save(mTopViewController.getPlayerNameLabel().getText());
        mMainModel.save(mTopViewController.getPlayerLevelLabel().getText());
        mMainModel.save(mTopViewController.getGuildLabel().getText());
        mMainModel.save(mTopViewController.getStartDateLabel().getText());
        mMainModel.save(mTopViewController.getWaveCountTextField().getText());
        mMainModel.save(mTopViewController.geteColoLabel().getText());
        mMainModel.save(mTopViewController.gethColoLabel().getText());
        mMainModel.save(mTopViewController.getoColoLabel().getText());
        mMainModel.save(mTopViewController.getTwLabel().getText());
        mMainModel.save(mTopViewController.getOwLabel().getText());
        mMainModel.save(mCenterViewController.getItemStrings().get(0));
        mMainModel.save(mCenterViewController.getItemStrings().get(1));

           Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved " + mMainModel.getSaved().size() + " entries.", ButtonType.CLOSE);
          alert.showAndWait();

    }
    public Item splitItem(String string){
        String mString = string;
        String[]  parts = mString.split(",");
        String p1 = parts[0];
        String p2 = parts[1];
        String p3 = parts[2];
        Integer p4 = Integer.parseInt(parts[3]);
        String p5 = parts[4];
        Double p6 = Double.parseDouble(parts[5]);
        String p7 = parts[6];
        Double p8;
        Double p10;
        if (!parts[7].equals("null"))
        {
            p8 = Double.parseDouble(parts[7]);
        } else {
            p8 = null;
        }
        if (!parts[9].equals("null"))
        {
            p10 = Double.parseDouble(parts[9]);
        } else {
            p10 = null;
        }

        String p9 = parts[8];
        return new Item(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10);
    }
    public void load(){
        mItemObservableList = mCenterViewController.getItemObservableList();
        mItemTableView = mCenterViewController.getItemTableView();

        mItemObservableList.add(splitItem(mMainModel.load().get(10)));
        mItemObservableList.add(splitItem(mMainModel.load().get(11)));
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

        mItemTableView.setItems(mItemObservableList);





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
