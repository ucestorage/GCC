package com.ubboeicke.application.Model.Enums;

/**
 * Created by Ubbo Eicke on 10.06.2017.
 */
public class ItemQuality {
    public enum Quality {
        B("B"),
        A("A"),
        S("S"),
        L("L");
        private String mString;
        Quality(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
}
