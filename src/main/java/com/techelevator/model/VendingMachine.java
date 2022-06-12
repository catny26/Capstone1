package com.techelevator.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
    private Map<String, Item> inventory = new TreeMap<>();
    private int change; //change back to customer
    private static int balance = 0;    //balance in vending machine
    private int capacity = 5;
    private String log;     //log of every action taken and documented

    public VendingMachine() throws FileNotFoundException {
        this.balance = 0;
        this.change = 0;
        this.inventory = loadInventory();
    }

    public int getChange() {
        return balance;
    }

    public int getMoney() {
        balance += 100;
        return balance;
    }

    public int getBalance() {
        return balance;
    }

    private void setLog(String log) {
        this.log = log;
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public Item purchase(String slotID) throws SoldoutException {
        //Check if inventory.contains key
        //if above equals false, throw exception
        Item selection = inventory.get(slotID);
        //check user's balance to see if it is >= product cost
        //if false, throw exception
        if (selection.getCount() <= 0){
            throw new SoldoutException("This item is sold out!");
        }


        return selection;
    }


    public Map<String, Item> loadInventory() throws FileNotFoundException {
        File csv = new File("src/test/resources/inventoryCsv");
        Map<String, Item> itemMap = new TreeMap<>();
        Scanner doc = new Scanner(csv);

        while (doc.hasNextLine()) {
            String line = doc.nextLine();
            String[] products = line.split("\\|");
            if (products[3].equals("Chip")) {
                itemMap.put(products[0], new Chip(products[1], Double.parseDouble(products[2])));
            }
            else if (products[3].equals("Drink")) {
                itemMap.put(products[0], new Drink(products[1], Double.parseDouble(products[2])));
            } else if (products[3].equals("Candy")) {
                itemMap.put(products[0], new Candy(products[1], Double.parseDouble(products[2])));
            } else if(products[3].equals("Gum")){
                itemMap.put(products[0], new Gum(products[1], Double.parseDouble(products[2])));
            }
        }
        return itemMap;
    }

//(line.split)
    //String[] parts = line.split("\\|");
    //for(String part : parts) {
    //  soutprintln(part)
    //}

    //Finish Transaction: give change back
    //



}
