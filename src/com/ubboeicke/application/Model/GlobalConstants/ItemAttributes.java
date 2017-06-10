package com.ubboeicke.application.Model.GlobalConstants;

/**
 * Created by Ubbo Eicke on 10.06.2017.
 */
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
