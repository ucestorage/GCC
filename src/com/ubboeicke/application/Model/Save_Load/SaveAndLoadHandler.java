package com.ubboeicke.application.Model.Save_Load;

import com.ubboeicke.application.Controller.CenterViewController;
import com.ubboeicke.application.Controller.TopViewController;
import com.ubboeicke.application.Model.Gamedata.CastleComponents.CastleComponentParser;
import com.ubboeicke.application.Model.Gamedata.ItemCreation.ItemParser;
import com.ubboeicke.application.Model.MainModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Ubbo Eicke on 12.06.2017.
 */
public class SaveAndLoadHandler {
    private MainModel mMainModel;
    private TopViewController mTopViewController;
    private CenterViewController mCenterViewController;
    private ItemParser mItemParser;
    private CastleComponentParser mCastleComponentParser;

    public SaveAndLoadHandler(MainModel mainModel, CenterViewController centerViewController, TopViewController topViewController) {
        this.mMainModel = mainModel;
        this.mCenterViewController = centerViewController;
        this.mTopViewController = topViewController;
        mItemParser = new ItemParser(mCenterViewController);
        mCastleComponentParser = new CastleComponentParser(mCenterViewController);

    }
    public void saveGeneralInformation() {
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
    }
    public void saveItems() {
        for(String s :mItemParser.getItemStrings()){
            mMainModel.saveItems(s);
        }
    }
    public void saveCastleComponents(){
        for (String s : mCastleComponentParser.getCCStrings()){
            mMainModel.saveCC(s);
        }

    }
    public void showConfirmation(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved " + mMainModel.getSaved().size() + " textentries.\n" +
                "Saved "+mMainModel.getItemssaved().size()+" items.", ButtonType.CLOSE);
        alert.showAndWait();
    }

}
