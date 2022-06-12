package com.techelevator.model;


import java.io.FileNotFoundException;

public class Drink extends Item {
    public Drink(String itemName, Double itemCost) throws FileNotFoundException {
        super(itemName, itemCost);
    }

    private String itemMsg;


    public String getItemMsg() {
        return itemMsg;
    }
}
