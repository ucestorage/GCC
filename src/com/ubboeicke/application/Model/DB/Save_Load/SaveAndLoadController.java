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
    private List<String> mLDRList = new ArrayList<>();
    private List<String> mOHeroList = new ArrayList<>();
    private List<String> mUHeroList = new ArrayList<>();
    private DB_Strings mDBStrings;
    private DB_Items mDBItems;
    private DB_CastleComponent mDBCastleComponent;
    private Controller_DB mControllerDb;
    private DB_Towers mDBTowers;
    private DB_Leaders mDBLeaders;
    private DB_Heroes_OH mDBHeroesOh;
    private DB_Heroes_UH mDBHeroesUh;
    public SaveAndLoadController() {
        this.mControllerDb = new Controller_DB();
        this.mDBStrings = mControllerDb.getDBStrings();
        this.mDBItems = mControllerDb.getDBItems();
        this.mDBCastleComponent = mControllerDb.getDBCastleComponent();
        this.mDBTowers = mControllerDb.getDBTowers();
        mDBLeaders = mControllerDb.getDBLeaders();
        mDBHeroesOh = mControllerDb.getDBHeroesOh();
        mDBHeroesUh = mControllerDb.getDBHeroesUh();
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
    // LOAD Leaders
    public List<String> loadLDR() {
        mDBLeaders = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.LDR))) {
                mDBLeaders = (DB_Leaders) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBLeaders.getList();
    }
    // LOAD Heroes_OH
    public List<String> loadHeroesOh() {
        mDBHeroesOh = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.HERO_OH))) {
                mDBHeroesOh = (DB_Heroes_OH) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBHeroesOh.getList();
    }
    // LOAD Heroes_UH
    public List<String> loadHeroesUh() {
        mDBHeroesUh = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Filename.HERO_UH))) {
                mDBHeroesUh = (DB_Heroes_UH) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mDBHeroesUh.getList();
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
        //SAVE LEADERS
    public void saveLeaders(String item) {
        mLDRList.add(item);
        mDBLeaders.setList(mLDRList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.LDR))) {
                oos.writeObject(mDBLeaders);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //SAVE HEROES_OH
    public void saveHeroesOh(String item) {
        mOHeroList.add(item);
        mDBHeroesOh.setList(mOHeroList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.HERO_OH))) {
                oos.writeObject(mDBHeroesOh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //SAVE HEROES_UH
    public void saveHeroesUh(String item) {
        mUHeroList.add(item);
        mDBHeroesUh.setList(mUHeroList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Filename.HERO_UH))) {
                oos.writeObject(mDBHeroesUh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
