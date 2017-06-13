package com.ubboeicke.application.Model.GlobalConstants;

/**
 * Created by Ubbo Eicke on 13.06.2017.
 */
public class AttackMode {
    public enum Mode {
        Auto("Auto"),
        Near ("Near"),
        LowHP("LowHP"),
        Boss("Boss"),
        Flying("Flying");

        private String mString;
        Mode(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }

}
