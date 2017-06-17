package com.ubboeicke.application.Model.Gamedata.Items;


/**
 * Created by Ubbo Eicke on 10.06.2017.
 */
public  class Item {
    private String mItemName;
    private String mItemQuality;
    private String mSortOfItem;
    private Integer mItemLevel;
    private String mAttribute1;
    private Double mAttribute1Value;
    private String mAttribute2;
    private Double mAttribute2Value;
    private String mAttribute3;
    private Double mAttribute3Value;



    public Item(String itemName, String itemQuality, String sortOfItem, Integer itemLevel, String attribute1, Double attribute1Value, String attribute2, Double attribute2Value, String attribute3, Double attribute3Value) {
        mItemName = itemName;
        mItemQuality = itemQuality;
        mSortOfItem = sortOfItem;
        mItemLevel = itemLevel;
        mAttribute1 = attribute1;
        mAttribute1Value = attribute1Value;
        mAttribute2 = attribute2;
        mAttribute2Value = attribute2Value;
        mAttribute3 = attribute3;
        mAttribute3Value = attribute3Value;
    }
    public Item (String itemName, String itemQuality, String sortOfItem, Integer itemLevel, String attribute1, Double attribute1Value) {
        mItemName = itemName;
        mItemQuality = itemQuality;
        mSortOfItem = sortOfItem;
        mItemLevel = itemLevel;
        mAttribute1 = attribute1;
        mAttribute1Value = attribute1Value;
    }
    public Item (String itemName, String itemQuality, String sortOfItem, Integer itemLevel, String attribute1, Double attribute1Value, String attribute2, Double attribute2Value) {
        mItemName = itemName;
        mItemQuality = itemQuality;
        mSortOfItem = sortOfItem;
        mItemLevel = itemLevel;
        mAttribute1 = attribute1;
        mAttribute1Value = attribute1Value;
        mAttribute2 = attribute2;
        mAttribute2Value = attribute2Value;
    }
    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public String getItemQuality() {
        return mItemQuality;
    }

    public void setItemQuality(String itemQuality) {
        mItemQuality = itemQuality;
    }

    public String getSortOfItem() {
        return mSortOfItem;
    }

    public void setSortOfItem(String sortOfItem) {
        mSortOfItem = sortOfItem;
    }

    public Integer getItemLevel() {
        return mItemLevel;
    }

    public void setItemLevel(Integer itemLevel) {
        mItemLevel = itemLevel;
    }

    public String getAttribute1() {
        return mAttribute1;
    }

    public void setAttribute1(String attribute1) {
        mAttribute1 = attribute1;
    }

    public Double getAttribute1Value() {
        return mAttribute1Value;
    }

    public void setAttribute1Value(Double attribute1Value) {
        mAttribute1Value = attribute1Value;
    }

    public String getAttribute2() {
        return mAttribute2;
    }

    public void setAttribute2(String attribute2) {
        mAttribute2 = attribute2;
    }

    public Double getAttribute2Value() {
        return mAttribute2Value;
    }

    public void setAttribute2Value(Double attribute2Value) {
        mAttribute2Value = attribute2Value;
    }

    public String getAttribute3() {
        return mAttribute3;
    }

    public void setAttribute3(String attribute3) {
        mAttribute3 = attribute3;
    }

    public Double getAttribute3Value() {
        return mAttribute3Value;
    }

    public void setAttribute3Value(Double attribute3Value) {
        mAttribute3Value = attribute3Value;
    }
}
