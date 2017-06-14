package com.ubboeicke.application.Model.Enums;

/**
 * Created by Ubbo Eicke on 10.06.2017.
 */
public class ItemAttributesWithLegendaries {
    public enum AttributesWithLegendaries {
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
        GoldPerHit("GPH"),
        BossDamage("BD"),
        Slow("Slow"),
        SummonedTime("ST"),
        SummonedUnits("SU"),
        Cooldown("CD"),
        AreaSkillDamage("ASD"),
        FlyingDamage("FD"),
        ChainLightning("CL"),
        ExtraArrow("EA"),
        LeaderDefense("LD");
        private String mString;
        AttributesWithLegendaries(String string){
            this.mString = string;
        }
        public String getString() {
            return mString;
        }
    }
}
