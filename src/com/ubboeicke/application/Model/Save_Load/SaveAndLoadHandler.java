package com.ubboeicke.application.Model.Save_Load;

import com.ubboeicke.application.Model.GlobalConstants.GlobalConstants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ubbo Eicke on 08.06.2017.
 */
public class SaveAndLoadHandler {
    private List<String> mStringList = new ArrayList<>();

    private LocalObjectDB mLocalObjectDB;

    public SaveAndLoadHandler(LocalObjectDB localObjectDB) {
        this.mLocalObjectDB = localObjectDB;

    }




    public List<String> load() {
        mLocalObjectDB = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GlobalConstants.FILENAME))) {
                mLocalObjectDB = (LocalObjectDB) ois.readObject();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLocalObjectDB.getList();

    }



    public void save(String item) {

        mStringList.add(item);



        mLocalObjectDB.setList(mStringList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GlobalConstants.FILENAME))) {
                oos.writeObject(mLocalObjectDB);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getStringList() {
        return mStringList;
    }
}
