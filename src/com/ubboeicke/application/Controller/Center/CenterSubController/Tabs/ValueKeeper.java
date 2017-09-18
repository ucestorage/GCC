package com.ubboeicke.application.Controller.Center.CenterSubController.Tabs;

public class ValueKeeper {
    Double summonedUnitDmg = 0.0;
    Double fireDmg = 10.0;
    Double poisonDmg = 10.0;
    Double lightningDmg = 10.0;
    Double coldDmg = 10.0;
    Double hp = 0.0;
    Double mp = 0.0;
    Double manaRec = 0.0;
    Double archerDmg = 0.0;
    Double heroDmg = 0.0;
    Double goldBonus = 0.0;
    Double towerDmg = 0.0;
    Double cdr = 0.0;
    Double humanSummons = 0.0;
    Double humanSummonDmg = 0.0;
    Double archerCrit = 0.0;
    Double heroCrit = 0.0;
    Double archerAS = 0.0;
    Double defense = 0.0;
    Double tbDmg = 0.0;
    Double siegeDef = 0.0;
    Double treasureDmg = 0.0;
    Integer finalHP = 0;
    Integer finalMP = 0;
    Double skillDmg = 0.5;
    public ValueKeeper(){

    }
    public void reset() {
        summonedUnitDmg = 0.0;
        fireDmg = 10.0;
        poisonDmg = 10.0;
        lightningDmg = 10.0;
        coldDmg = 10.0;
        hp = 0.0;
        manaRec = 0.0;
        archerDmg = 0.0;
        heroDmg = 0.0;
        goldBonus = 0.0;
        towerDmg = 0.0;
        cdr = 0.0;
        humanSummons = 0.0;
        humanSummonDmg = 0.0;
        archerCrit = 0.0;
        heroCrit = 0.0;
        archerAS = 0.0;
        defense = 0.0;
        siegeDef = 0.0;
        finalHP = 0;
        finalMP = 0;
        tbDmg = 0.0;
        treasureDmg = 0.0;
        mp = 0.0;

    }

    public Double getSkillDmg() {
        return skillDmg;
    }

    public void setSkillDmg(Double skillDmg) {
        this.skillDmg = skillDmg;
    }

    public Double getTreasureDmg() {
        return treasureDmg;
    }

    public void setTreasureDmg(Double treasureDmg) {
        this.treasureDmg = treasureDmg;
    }

    public Double getMp() {
        return mp;
    }

    public void setMp(Double mp) {
        this.mp = mp;
    }

    public Double getTbDmg() {
        return tbDmg;
    }

    public void setTbDmg(Double tbDmg) {
        this.tbDmg = tbDmg;
    }

    public Double getSummonedUnitDmg() {
        return summonedUnitDmg;
    }

    public void setSummonedUnitDmg(Double summonedUnitDmg) {
        this.summonedUnitDmg = summonedUnitDmg;
    }

    public Double getFireDmg() {
        return fireDmg;
    }

    public void setFireDmg(Double fireDmg) {
        this.fireDmg = fireDmg;
    }

    public Double getPoisonDmg() {
        return poisonDmg;
    }

    public void setPoisonDmg(Double poisonDmg) {
        this.poisonDmg = poisonDmg;
    }

    public Double getLightningDmg() {
        return lightningDmg;
    }

    public void setLightningDmg(Double lightningDmg) {
        this.lightningDmg = lightningDmg;
    }

    public Double getColdDmg() {
        return coldDmg;
    }

    public void setColdDmg(Double coldDmg) {
        this.coldDmg = coldDmg;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Double getManaRec() {
        return manaRec;
    }

    public void setManaRec(Double manaRec) {
        this.manaRec = manaRec;
    }

    public Double getArcherDmg() {
        return archerDmg;
    }

    public void setArcherDmg(Double archerDmg) {
        this.archerDmg = archerDmg;
    }

    public Double getHeroDmg() {
        return heroDmg;
    }

    public void setHeroDmg(Double heroDmg) {
        this.heroDmg = heroDmg;
    }

    public Double getGoldBonus() {
        return goldBonus;
    }

    public void setGoldBonus(Double goldBonus) {
        this.goldBonus = goldBonus;
    }

    public Double getTowerDmg() {
        return towerDmg;
    }

    public void setTowerDmg(Double towerDmg) {
        this.towerDmg = towerDmg;
    }

    public Double getCdr() {
        return cdr;
    }

    public void setCdr(Double cdr) {
        this.cdr = cdr;
    }

    public Double getHumanSummons() {
        return humanSummons;
    }

    public void setHumanSummons(Double humanSummons) {
        this.humanSummons = humanSummons;
    }

    public Double getHumanSummonDmg() {
        return humanSummonDmg;
    }

    public void setHumanSummonDmg(Double humanSummonDmg) {
        this.humanSummonDmg = humanSummonDmg;
    }

    public Double getArcherCrit() {
        return archerCrit;
    }

    public void setArcherCrit(Double archerCrit) {
        this.archerCrit = archerCrit;
    }

    public Double getHeroCrit() {
        return heroCrit;
    }

    public void setHeroCrit(Double heroCrit) {
        this.heroCrit = heroCrit;
    }

    public Double getArcherAS() {
        return archerAS;
    }

    public void setArcherAS(Double archerAS) {
        this.archerAS = archerAS;
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public Double getSiegeDef() {
        return siegeDef;
    }

    public void setSiegeDef(Double siegeDef) {
        this.siegeDef = siegeDef;
    }

    public Integer getFinalHP() {
        return finalHP;
    }

    public void setFinalHP(Integer finalHP) {
        this.finalHP = finalHP;
    }

    public Integer getFinalMP() {
        return finalMP;
    }

    public void setFinalMP(Integer finalMP) {
        this.finalMP = finalMP;
    }
}
