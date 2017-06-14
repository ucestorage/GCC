package com.ubboeicke.application.Model.DB.Save_Load;
import com.ubboeicke.application.Model.DB.*;
import com.ubboeicke.application.Model.Enums.Filename;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Ubbo Eicke on 08.06.2017.
 */
public class SaveAndLoadController {
    private List<String> mStringList = new ArrayList<>();
    private List<String> mItemList = new ArrayList<>();
    private List<String> mCCList = new ArrayList<>();
    private List<String> mTWRList = new ArrayList<>();
    private DB_Strings mDBStrings;
    private DB_Items mDBItems;
    private DB_CastleComponent mDBCastleComponent;
    private Controller_DB mControllerDb;
    private DB_Towers mDBTowers;
    public SaveAndLoadController() {
        this.mControllerDb = new Controller_DB();
        this.mDBStrings = mControllerDb.getDBStrings();
        this.mDBItems = mControllerDb.getDBItems();
        this.mDBCastleComponent = mControllerDb.getDBCastleComponent();
        this.mDBTowers = mControllerDb.getDBTowers();
    }
// LOAD STRINGS
    public List<String> load() {
        mDBStrings = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.STRING))) {
                mDBStrings = (DB_Strings) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBStrings.getList();
    }
    // LOAD ITEMS
    public List<String> loadItems() {
        mDBItems = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.ITEM))) {
                mDBItems = (DB_Items) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBItems.getList();
    }
    // LOAD CASTLE COMPONENTS
    public List<String> loadCC() {
        mDBCastleComponent = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.CC))) {
                mDBCastleComponent = (DB_CastleComponent) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBCastleComponent.getList();
    }
    // LOAD TOWERS
    public List<String> loadTWR() {
        mDBTowers = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.TWR))) {
                mDBTowers = (DB_Towers) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBTowers.getList();
    }

//SAVE STRINGS
    public void save(String item) {
        mStringList.add(item);
        mDBStrings.setList(mStringList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.STRING))) {
                oos.writeObject(mDBStrings);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //SAVE ITEMS
    public void saveItems(String item) {
        mItemList.add(item);
        mDBItems.setList(mItemList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.ITEM))) {
                oos.writeObject(mDBItems);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //SAVE CASTLE COMPONENTS
    public void saveCC(String item) {
        mCCList.add(item);
        mDBCastleComponent.setList(mCCList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.CC))) {
                oos.writeObject(mDBCastleComponent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //SAVE TOWERS
    public void saveTowers(String item) {
        mTWRList.add(item);
        mDBTowers.setList(mTWRList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.TWR))) {
                oos.writeObject(mDBTowers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getStringList() {
        return mStringList;
    }

    public List<String> getItemList() {
        return mItemList;
    }

}
