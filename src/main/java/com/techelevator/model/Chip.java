package com.techelevator.model;


import java.io.FileNotFoundException;

public class Chip extends Item {
    public Chip(String itemName, Double itemCost) throws FileNotFoundException {
        super(itemName, itemCost);
    }

    private String itemMsg;


    public String getItemMsg() {
        itemMsg = "crunch crunch yum!";


        return itemMsg;
    }
}
