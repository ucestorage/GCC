package com.ubboeicke.application.Model.Enums;

/**
 * Created by Ubbo Eicke on 10.06.2017.
 */
//TODO zusammenfassen ITEMS -> different enums
public class ItemAttributes {
    public enum Attributes {
        FireDamage("Bow"),
        LightningDamage("Hammer"),
        PoisonDamage("Staff"),
       ColdDamage("Sword"),
        Damage("Bracelet"),
        DamagePlus("Earrings"),
        AttackSpeed("Necklace"),
        CriticalHitChance("Ring"),
        CriticalHitDamage("CHD"),
        CooldownReduction("CDR"),
        ManaCostDecrease("-MP"),
        StunChance("STUN"),
        KnockbackChance("KB"),
        GoldPerHit("GPH");
        private String mString;
        Attributes(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }

}
