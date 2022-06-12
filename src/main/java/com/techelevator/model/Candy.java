package com.techelevator.model;


import java.io.FileNotFoundException;

public class Candy extends Item {


    private String itemMsg;

    public Candy(String itemName, Double itemCost) throws FileNotFoundException {
        super(itemName, itemCost);
    }


    public String getItemMsg() {
        return itemMsg;
    }
}
