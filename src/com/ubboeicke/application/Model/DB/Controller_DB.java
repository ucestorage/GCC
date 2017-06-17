package com.ubboeicke.application.Model.DB;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Controller_DB {
    private DB_CastleComponent mDBCastleComponent;
    private DB_Items mDBItems;
    private DB_Strings mDBStrings;
    private DB_Towers mDBTowers;
    private DB_Heroes_OH mDBHeroesOh;
    private DB_Heroes_UH mDBHeroesUh;
    private DB_Leaders mDBLeaders;

    public Controller_DB() {
        mDBCastleComponent = new DB_CastleComponent();
        mDBItems = new DB_Items();
        mDBStrings = new DB_Strings();
        mDBTowers = new DB_Towers();
        mDBHeroesOh = new DB_Heroes_OH();
        mDBHeroesUh = new DB_Heroes_UH();
        mDBLeaders = new DB_Leaders();
    }

    public DB_Heroes_UH getDBHeroesUh() {
        return mDBHeroesUh;
    }

    public DB_Heroes_OH getDBHeroesOh() {
        return mDBHeroesOh;
    }

    public DB_Leaders getDBLeaders() {
        return mDBLeaders;
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
