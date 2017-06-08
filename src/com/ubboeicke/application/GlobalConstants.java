package com.ubboeicke.application;

/**
 * Created by Ubbo Eicke on 08.06.2017.
 */
public class GlobalConstants {
    private GlobalConstants(){

    }
    public static boolean SAVEGAME_AVAILABLE;
    public static final String FILENAME = "LocalObjectDB";
    public static final String ISSAVED = "Saved";

    public static boolean isSavegameAvailable() {
        return SAVEGAME_AVAILABLE;
    }

    public static void setSavegameAvailable(boolean savegameAvailable) {
        SAVEGAME_AVAILABLE = savegameAvailable;
    }
}
