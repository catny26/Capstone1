package com.techelevator.view;

import com.techelevator.VendingMachineCLI;
import com.techelevator.model.Inventory;
import com.techelevator.model.VendingMachine;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Scanner;

public class PurchaseMenu {

    private Menu menu;
    private VendingMachine vendingMachine;

//    public PurchaseMenu(Menu menu) {
//        this.menu = menu;
//    }


    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};

    public PurchaseMenu(Menu menu) {
        this.menu = menu;
    }
//        this.vendingMachine = vendingMachine;

//    public PurchaseMenu(Menu menu, VendingMachine vendingMachine) {
//        this.menu = menu;
//        this.vendingMachine = vendingMachine;
//    }


    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

            if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                // display money amount
                VendingMachine.getMoney();
                System.out.println("Current Balance: " + (double)VendingMachine.getBalance()/100);
            } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                VendingMachine.getItem();
            } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                System.out.println("Your change is: " + (double)VendingMachine.getChange()/100);
                System.exit(1);
                break;
                //exit program
            }


        }
    }
}


        





