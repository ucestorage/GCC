package com.ubboeicke.application.Model.Enums;

/**
 * Created by Ubbo Eicke on 17.06.2017.
 */
public class Promotions {
    public static final String[] Archer = {"Bow Master" , "Dark Bow Master","Ranger","Dark Ranger"};
    public static final String[] Hunter = {"Monster Hunter","Dark Hunter", "Cross Hunter", "Sniper"};
    public static final String[] Elf = {"Deep Elf","Dark Elf","High Elf","White Elf"};
    public static final String[] IceMage = {"Ice Wizard","Dark Ice Wizard","Ice Sorcerer","Dark Ice Sorcerer"};
    public static final String[] LightningMage = {"Lightning Wizard","Dark Lightning Wizard", "Lightning Sorcerer", "Dark Lightning Sorcerer"};
    public static final String[] FireMage = {"Fire Wizard","Dark Fire Wizard","Fire Sorcerer", "Dark Fire Sorcerer"};
    public static final String[] Ogre = {"Fire Ogre","Flame Ogre","Hammer Ogre","Giant Ogre"};
    public static final String[] TinyGiant = {"Stone Giant","Stone Giant II","Mad Giant","Mad Giant II"};
    public static final String[] Slinger = {"Poison Slinger", "Spear Slinger"};
    public static final String[] Voodoo = {"Poison Voodoo","Venom Voodoo","String Voodoo","String Voodoo II"};
    public static final String[] BazookaMan = {"Rambo","Mechanic Rambo II","Rocket Man","Rocket Man II"};
    public static final String[] Knight = {"Holy Knight","Paladin","Barbarian","Fire Barbarian","Ice Barbarian"};
    public static final String[] Lisa = {"Lisa Fire I","Lisa Fire II","Lisa Ice I","Lisa Ice II","Lisa Poison I", "Lisa Poison II"};
    public static final String[] Alice = {"Alice Fire I","Alice Fire II","Alice Ice I","Alice Ice II","Alice Poison I", "Alice Poison II"};
    public static final String[] Dorothy = {"Dorothy Fire I","Dorothy Fire II","Dorothy Ice I","Dorothy Ice II","Dorothy Poison I", "Dorothy Poison II"};
    public static final String[] Druid = {"Wolf Druid","Wolf Druid II","Hawk Druid","Hawk Druid II"};
    public static final String[] Assassin = {"Dark Assassin","Deep Assassin"};
    public static final String[] FlyingOrc = {"Fire Flying Orc", "Ice Flying Orc", "Poison Flying Orc"};
    public static final String[] Windy = {"Ice Windy","Fire Windy"};
    public static final String[] Angel = {"N/A"};
    public static final String[] Zeus = {"CD Zeus I", "CD Zeus II", "Slow Zeus I", "Slow Zeus II"};
    public static final String[] WhiteMage = {"White Wizard","Pure Wizard","White Sorcerer","Pure Sorcerer"};
    public static final String[] Necromancer = {"Evil Necromancer","Dark Necromancer","Nightmare","Dark Nightmare"};
    public static final String[] MBandF = {"Military Band (F) II"};
    public static final String[] MBandM = {"Military Band (M) II"};
    public static final String[] Priest = {"Cleric","Bishop"};
    public static final String[] Smith = {"Smith II", "STOS"};
    public static final String[] Architect = {"Careful Architect", "Skilled Architect","Great Architect"};

    public static final String[] Tree = {"Crystal Tree", "Golden Tree"};
    public static final String[] Worm = {"Death Worm ", "Death Worm II"};
    public static final String[] FlameTower = {"Burning Tower", "Burning Tower II"};
    public static final String[] FrozenTower= {"Frozen Tower II"};
    public static final String[] LightningTower= {"Thunder Tower", "Thunder Tower II"};
    public static final String[] Barracks= {"Offensive Barracks", "Defensive Barracks"};
    public static String[] getPromotion(String s){
        String[] strings = null;
        if (s.equals("Worm")){
            strings = Worm;
        }
        if (s.equals("Flame Tower")){
            strings = FlameTower;
        }
        if (s.equals("Frozen Tower")){
            strings = FrozenTower;
        }
        if (s.equals("Lightning Tower")){
            strings = LightningTower;
        }
        if (s.equals("Barracks")){
            strings = Barracks;
        }
        if (s.equals("Archer")){
            strings = Archer;
        }
        if (s.equals("Hunter")){
            strings = Hunter;
        }
        if (s.equals("Elf")){
            strings = Elf;
        }
        if (s.equals("Ice Mage")){
            strings = IceMage;
        }
        if (s.equals("Lightning Mage")){
            strings = LightningMage;
        }
        if (s.equals("Fire Mage")){
            strings = FireMage;
        }
        if (s.equals("Ogre")){
            strings = Ogre;
        }
        if (s.equals("Tiny Giant")){
            strings = TinyGiant;
        }
        if (s.equals("Slinger")){
            strings = Slinger;
        }
        if (s.equals("Voodoo")){
            strings = Voodoo;
        }
        if (s.equals("Bazooka Man")){
            strings = BazookaMan;
        }
        if (s.equals("Knight")){
            strings = Knight;
        }
        if (s.equals("Lisa")){
            strings = Lisa;
        }
        if (s.equals("Alice")){
            strings = Alice;
        }
        if (s.equals("Dorothy")){
            strings = Dorothy;
        }
        if (s.equals("Druid")){
            strings = Druid;
        }
        if (s.equals("Assassin")){
            strings = Assassin;
        }
        if (s.equals("Flying Orc")){
            strings = FlyingOrc;
        }
        if (s.equals("Windy")){
            strings = Windy;
        }
        if (s.equals("Angel")){
            strings = Angel;
        }
        if (s.equals("Zeus")){
            strings = Zeus;
        }
        if (s.equals("White Mage")){
            strings = WhiteMage;
        }
        if (s.equals("Necromancer")){
            strings = Necromancer;
        }
        if (s.equals("Military Band (F)")){
            strings = MBandF;
        }
        if (s.equals("Military Band (M)")){
            strings = MBandM;
        }
        if (s.equals("Priest")){
            strings = Priest;
        }
        if (s.equals("Smith")){
            strings = Smith;
        }
        if (s.equals("Architect")){
            strings = Architect;
        }


        return strings;
    }
    
    
    
}
