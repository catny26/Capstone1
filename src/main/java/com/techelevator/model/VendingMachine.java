package com.techelevator.model;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    private int change; //change back to customer
//    private List<Inventory> inv = new ArrayList<>();
    private static int balance = 0;    //balance in vending machine
    private int capacity = 5;
    private String menu = "";
    private String log;     //log of every action taken and documented
    private Inventory item;


    public VendingMachine(String menu, int balance) {
        this.menu = menu;
        this.balance = balance;
    }

    public static int getChange() {
        return balance;
    }

    public static int getMoney() {
        balance += 100;
        return balance;
    }

    public static int getItem(){
        try (Scanner userInput = new Scanner(System.in)) {

            for (Map.Entry entry : Inventory.getInv().entrySet()) {
                System.out.println(entry);
            }
            System.out.println("What would you like? (A1,B3,etc.)");
            String inPut = userInput.nextLine();
            for (String entry : Inventory.getInv().keySet()) {
                if (entry.containsKey(inPut)) {
                    if (balance >= Inventory.getItemCost()) {
                        balance -= Inventory.getItemCost();
                        //System.out.println(Inventory.getItemMsg());
                    } else {
                        System.out.println("insufficient funds...");
                        break;
                    }

                } else {
                    System.out.println("invalid entry. Try again");
                    break;
                }
            }
        }
            catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        return balance;
    }

//    private List getInventory() {
////        return Inventory;
//    }

    public static int getBalance() {
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
