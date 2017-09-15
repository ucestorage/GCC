package com.ubboeicke.application.Model.Gamedata.Decks;

import com.ubboeicke.application.Controller.Center.CenterSubController.Tabs.GameObjectConstructor;
import com.ubboeicke.application.Controller.Center.CenterViewController;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 24.06.2017.
 */
public class DeckParser {
    private CenterViewController mCenterViewController;
    private ArrayList<String> mDeckStringList = new ArrayList<>();
    private ObservableList<Deck> mDeckList;

    public DeckParser(CenterViewController centerViewController){
        mCenterViewController = centerViewController;


    }
    public ArrayList<String> getDeckStrings(){
        mDeckList = mCenterViewController.getDeckTableView().getItems();
        for (Deck d : mDeckList){
            String s = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",d.getName(),d.getTownBuilding1(),d.getTownBuilding2(),d.getTownBuilding3(),d.getLeader(),d.getTreasure1(),d.getTreasure2(),d.getTreasure3(),d.getTreasure4(),d.getTreasure5(),d.getTower1(),d.getTower2(),d.getTower3(),d.getTower4(),d.getCC1(),d.getCC2(),d.getCC3(),d.getCC4(),d.getH1(),d.getH2(),d.getH3(),d.getH4(),d.getH5(),d.getH6(),d.getH7(),d.getH8(),d.getH9(),d.getH10(),d.getH11(),d.getH12());
            mDeckStringList.add(s);

        }
        return  mDeckStringList;
    }
    public Deck splitStrings(String s){
        Deck deck;
        String part[] = s.split(",");
        String p0 = part[0];
        String p1 = part[1];
        String p2 = part[2];
        String p3 = part[3];
        String p4 = part[4];
        String p5 = part[5];
        String p6 = part[6];
        String p7 = part[7];
        String p8 = part[8];
        String p9 = part[9];
        String p10 = part[10];
        String p11 = part[11];
        String p12 = part[12];
        String p13 = part[13];
        String p14 = part[14];
        String p15 = part[15];
        String p16 = part[16];
        String p17 = part[17];
        String p18 = part[18];
        String p19 = part[19];
        String p20 = part[20];
        String p21 = part[21];
        String p22 = part[22];
        String p23 = part[23];
        String p24 = part[24];
        String p25 = part[25];
        String p26 = part[26];
        String p27 = part[27];
        String p28 = part[28];
        String p29 = part[29];




        deck = new Deck(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29);
        return deck;
    }
}
