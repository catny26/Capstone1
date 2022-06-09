package com.techelevator.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {

    private int change; //change back to customer
    private int money;  //money that customer has to use
//    private List<>
    private int balance = 0;    //balance in vending machine
    private int capacity = 5;
    private String menu = "";
    private String log;     //log of every action taken and documented


    public VendingMachine(String menu) {
        this.menu = menu;
    }

    private int getChange() {
        return balance;
    }

    private int getMoney() {
        balance += 100;
        return money;
    }

//    private List getInventory() {
////        return Inventory;
//    }

    private int getBalance() {
        return balance;
    }

    private void setLog(String log) {
        this.log = log;
    }


    //(line.split)
    //String[] parts = line.split("\\|");
    //for(String part : parts) {
    //  soutprintln(part)
    //}

    //Finish Transaction: give change back
    //



}
