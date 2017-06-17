package com.ubboeicke.application.Model.DB;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class Controller_DB {
    private DB_CastleComponent mDBCastleComponent;
    private DB_Items_Weapons mDBItemsWeapons;
    private DB_Items_Accessories mDBItemsAccessories;
    private DB_Strings mDBStrings;
    private DB_Towers mDBTowers;
    private DB_Heroes_OH mDBHeroesOh;
    private DB_Heroes_UH mDBHeroesUh;
    private DB_Leaders mDBLeaders;

    public Controller_DB() {
        mDBCastleComponent = new DB_CastleComponent();
        mDBItemsWeapons = new DB_Items_Weapons();
        mDBItemsAccessories = new DB_Items_Accessories();
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

    public DB_Items_Weapons getDBItemsWeapons() {
        return mDBItemsWeapons;
    }

    public DB_Items_Accessories getDBItemsAccessories() {
        return mDBItemsAccessories;
    }

    public DB_Strings getDBStrings() {
        return mDBStrings;
    }


}
