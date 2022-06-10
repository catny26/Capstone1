package com.techelevator.model;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Inventory {

    private Map<String, Array> inv;
    private String productCode;
    private static String itemCost;
    private Scanner csv;
    private String itemName;

    public Inventory(String itemName, String itemCost) throws FileNotFoundException {
        this.itemName = itemName;
        this.itemCost = itemCost;

    }


    public Inventory(Map<String, Array> inv, Scanner csv) {
        this.inv = new TreeMap<>();
        this.csv = csv;
    }

    public  String getItemMsg() {
        return null;
    }


    public Scanner getCsv() {
        return csv;
    }


    public static Map<String, Inventory> getInv() throws FileNotFoundException {
        File csv = new File("src/test/resources/inventoryCsv");
        Map<String, Inventory> itemMap = new TreeMap<>();
        Scanner doc = new Scanner(csv);

        while (doc.hasNextLine()) {
            String line = doc.nextLine();
            String[] products = line.split("\\|");
            if (products[3].equals("Chip")) {
                itemMap.put(products[0], new Chip(products[1], (products[2])));
            } else if (products[3].equals("Drink")) {
                itemMap.put(products[0], new Drink(products[1], (products[2])));
            } else if (products[3].equals("Candy")) {
                itemMap.put(products[0], new Candy(products[1], (products[2])));
            } else {
                itemMap.put(products[0], new Candy(products[1], (products[2])));
            }
        }
        return itemMap;
    }

        public static Double getItemCost() {
        Double cost = Double.parseDouble(itemCost);
            return cost;

        }
        public String getProductCode () {
            return productCode;
        }


        public String getItemName () {
            return itemName;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(inv, inventory.inv) && Objects.equals(productCode, inventory.productCode) && Objects.equals(itemCost, inventory.itemCost) && Objects.equals(csv, inventory.csv) && Objects.equals(itemName, inventory.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inv, productCode, itemCost, csv, itemName);
    }

    @Override
    public String toString() {
        return "" + itemName + " | " +  itemCost;
    }
}

