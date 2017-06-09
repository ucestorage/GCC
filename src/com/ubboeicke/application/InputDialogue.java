package com.ubboeicke.application;

import com.ubboeicke.UI.TopView.TopViewController;
import javafx.scene.control.*;

import java.util.Optional;

/**
 * Created by Ubbo Eicke on 09.06.2017.
 */
public class InputDialogue{
    private String mButtonText;
    private String mContentText;
    private String mTitleText;
    private String mHeaderText;
    private String mInput;
    private ButtonType okBtn;
    private TextInputDialog tid;



    public InputDialogue(String buttonText, String titleText, String contentText, String headerText) {

        this.mContentText = contentText;
        this.mTitleText = titleText;
        this.mHeaderText = headerText;
        this.mButtonText = buttonText;
        okBtn = new ButtonType(mButtonText, ButtonBar.ButtonData.OK_DONE);
        tid = new TextInputDialog();


    }

    public void dialogueHandler() {
        tid.setContentText(mContentText);
        tid.setTitle(mTitleText);
        tid.setHeaderText(mHeaderText);
        tid.getDialogPane().getButtonTypes().removeAll(ButtonType.OK, ButtonType.CANCEL);
        tid.getDialogPane().getButtonTypes().add(okBtn);
        tid.showAndWait();
        mInput = tid.getResult();



    }

    public String getInput() {
        return mInput;
    }
}

