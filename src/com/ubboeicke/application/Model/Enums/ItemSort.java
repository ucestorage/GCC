package com.ubboeicke.application.Model.Enums;

/**
 * Created by Ubbo Eicke on 10.06.2017.
 */
public class ItemSort {
    public enum Sort {
        Bow("Bow"),
        Hammer("Hammer"),
        Staff("Staff"),
        Sword("Sword"),
        Bracelet("Bracelet"),
        Earrings("Earrings"),
            Necklace("Necklace"),
                Ring("Ring");
        private String mString;
        Sort(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
}
