package com.ubboeicke.application.Model.Gamedata.Items;

import com.ubboeicke.application.Controller.Center.CenterViewController;


import java.util.ArrayList;

/**
 * Created by Ubbo Eicke on 11.06.2017.
 */
public class ItemParser {
    private CenterViewController mCenterViewController;
    private ArrayList<String> itemStringList;

    public ItemParser(CenterViewController centerViewController) {
        this.mCenterViewController = centerViewController;

        itemStringList = new ArrayList<>();

    }

    public ArrayList<String> getItemStrings(){

        for (Item item : mCenterViewController.getItemTableView().getItems()){
            String testS = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", item.getItemName(),item.getItemQuality(), item.getSortOfItem(), item.getItemLevel(),item.getAttribute1(),item.getAttribute1Value(),item.getAttribute2(),item.getAttribute2Value(),item.getAttribute3(),item.getAttribute3Value());
            itemStringList.add(testS);

        }
        return itemStringList;
    }
    public Item splitItem(String string) {
        Item item;
        String mString = string;
        String[] parts = mString.split(",");
        String p0 = parts[0];
        String p1 = parts[1];
        String p2 = parts[2];
        Integer p3 = Integer.parseInt(parts[3]);
        String p4 = parts[4];
        Double p5 = Double.parseDouble(parts[5]);


        if (p1.equals("A") || p1.equals("S")) {
            String p6 = parts[6];
            Double p7 = Double.parseDouble(parts[7]);
            item = new Item(p0, p1, p2, p3, p4, p5, p6, p7);
        } else if (p1.equals("L")) {
            String p6 = parts[6];
            Double p7 = Double.parseDouble(parts[7]);
            String p8 = parts[8];
            Double p9 = Double.parseDouble(parts[9]);
            item = new  Item(p0,p1,p2,p3,p4,p5,p6,p7,p8,p9);
        } else {
            item =  new Item(p0, p1, p2, p3, p4, p5);
        }
        return item;




    }
}
