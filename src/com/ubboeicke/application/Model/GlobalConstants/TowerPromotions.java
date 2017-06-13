package com.ubboeicke.application.Model.GlobalConstants;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class TowerPromotions {
    public enum Worm {
        DeathWorm("Death Worm"),
        DeathWormII("Death Worm II");
        private String mString;
        Worm(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
    public enum Tree {
        CrystalTree("Crystal Tree"),
        GoldenTree("Golden Tree");
        private String mString;
        Tree(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
    public enum FlameTower {
        BurningTower("Burning Tower"),
        BurningTowerII("Burning Tower II");
        private String mString;
        FlameTower(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
    public enum FrozenTower {
        FrozenTowerII("Frozen Tower II");
        private String mString;
        FrozenTower(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
    public enum LightningTower {
        ThunderTower("Thunder Tower"),
        ThunderTowerII("Thunder Tower II");
        private String mString;
        LightningTower(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
    public enum Barracks {
        OBarracks("Offensive Barracks"),
        DBarracks("Defensive Barracks");
        private String mString;
        Barracks(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
}
