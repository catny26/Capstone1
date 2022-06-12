package com.techelevator.model;

import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VendingMachine {
    private Map<String, Item> inventory = new TreeMap<>();
    private int change; //change back to customer
    private static int balance = 0;    //balance in vending machine
    private int capacity = 5;
    private Menu menu;
    private PurchaseMenu purchaseMenu;

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

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public Item purchase(String slotID) throws SoldoutException, InsufficientFundsException, UnavailableException {
        //Check if inventory.contains key
        //if above equals false, throw exception
        Item selection = inventory.get(slotID);
//            if (selection.getItemCost() > getBalance()) {
//                throw new InsufficientFundsException("Insufficient Funds!");
        //check user's balance to see if it is >= product cost
        //if false, throw exception
        if (!inventory.containsKey(slotID)) {
            throw new UnavailableException("Invalid Entry");
        } else if (selection.getCount() <= 0) {
            throw new SoldoutException("This item is sold out!");
        } else if (selection.getItemCost() * 100 > getBalance()) {
            throw new SoldoutException("Insufficient Funds");
        } else {

            selection.getItem();
            balance -= selection.getItemCost() * 100;
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
            } else if (products[3].equals("Drink")) {
                itemMap.put(products[0], new Drink(products[1], Double.parseDouble(products[2])));
            } else if (products[3].equals("Candy")) {
                itemMap.put(products[0], new Candy(products[1], Double.parseDouble(products[2])));
            } else if (products[3].equals("Gum")) {
                itemMap.put(products[0], new Gum(products[1], Double.parseDouble(products[2])));
            }
        }
        return itemMap;
    }


}

