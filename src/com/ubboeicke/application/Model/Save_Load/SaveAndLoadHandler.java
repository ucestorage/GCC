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
    private List<String> mItemList = new ArrayList<>();
    private LocalObjectDB mLocalObjectDB;
    private LocalItemDB mLocalItemDB;

    public SaveAndLoadHandler(LocalObjectDB localObjectDB, LocalItemDB localItemDB) {
        this.mLocalObjectDB = localObjectDB;
        this.mLocalItemDB = localItemDB;
    }

    public List<String> load() {
        mLocalObjectDB = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GlobalConstants.FILENAME_STRING))) {
                mLocalObjectDB = (LocalObjectDB) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLocalObjectDB.getList();
    }
    public List<String> loadItems() {
        mLocalItemDB = null;
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GlobalConstants.FILENAME_ITEM))) {
                mLocalItemDB = (LocalItemDB) ois.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mLocalItemDB.getList();
    }
    public void save(String item) {
        mStringList.add(item);
        mLocalObjectDB.setList(mStringList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GlobalConstants.FILENAME_STRING))) {
                oos.writeObject(mLocalObjectDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveItem(String item) {
        mItemList.add(item);
        mLocalItemDB.setList(mItemList);
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GlobalConstants.FILENAME_ITEM))) {
                oos.writeObject(mLocalItemDB);
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
