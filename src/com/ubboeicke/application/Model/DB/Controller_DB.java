package com.ubboeicke.application.Model.DB;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Controller_DB {
    private DB_CastleComponent mDBCastleComponent;
    private DB_Items mDBItems;
    private DB_Strings mDBStrings;
    private DB_Towers mDBTowers;

    public Controller_DB() {
        mDBCastleComponent = new DB_CastleComponent();
        mDBItems = new DB_Items();
        mDBStrings = new DB_Strings();
        mDBTowers = new DB_Towers();
    }

    public DB_Towers getDBTowers() {
        return mDBTowers;
    }

    public DB_CastleComponent getDBCastleComponent() {
        return mDBCastleComponent;
    }

    public DB_Items getDBItems() {
        return mDBItems;
    }

    public DB_Strings getDBStrings() {
        return mDBStrings;
    }
}
