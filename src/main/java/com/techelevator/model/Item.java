package com.techelevator.model;

import java.io.FileNotFoundException;
import java.util.Objects;

public class Item {

    private Double itemCost;
    private String itemName;
    private int count = 5;


    public Item(String itemName, Double itemCost) throws FileNotFoundException {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public Item() {
    }

    public String getItemMsg() {
        return null;
    }


    public Double getItemCost() {
//        itemCost = Double.parseDouble(String.valueOf(itemCost));
        return itemCost;

    }


    public String getItemName() {
        return itemName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return count == item.count && Objects.equals(itemCost, item.itemCost) && Objects.equals(itemName, item.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemCost, itemName, count);
    }

    @Override
    public String toString() {
        return " " + itemName + " | " + itemCost + " | " + count + " Remaining";
    }
}

