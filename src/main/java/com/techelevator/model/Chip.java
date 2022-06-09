package com.techelevator.model;


import java.io.FileNotFoundException;

public class Chip extends Inventory{
    public Chip(String itemName, String itemCost) throws FileNotFoundException {
        super(itemName, itemCost);
    }

    private String itemMsg;


    public String getItemMsg() {
        return itemMsg;
    }
}
