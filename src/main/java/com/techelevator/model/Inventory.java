package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

private List <String> inv;
private String productCode;
private int itemCost;
private String itemMsg;


    public Inventory(List<String> inv){

        this.inv = new ArrayList<>();
    }

public Inventory(String productCode, String itemMsg, int itemCost){

   this.inv = new ArrayList<>();
   this.productCode = productCode;
   this.itemMsg = itemMsg;
   this.itemCost = itemCost;
}

    public List<String> getInv() {
        return inv;
    }

    public int getItemCost() {
        return itemCost;

    }
    public String getProductCode(){
    return productCode;
    }

    public String getItemMsg() {
        return itemMsg;
    }
}
