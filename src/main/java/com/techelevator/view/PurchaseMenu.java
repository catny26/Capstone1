package com.techelevator.view;

import com.techelevator.model.*;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;

public class PurchaseMenu {

    private Menu menu;
//    public PurchaseMenu(Menu menu) {
//        this.menu = menu;
//    }


    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
    public VendingMachine vnd;
    public PurchaseMenu(Menu menu) {
        this.menu = menu;
    }
//        this.vendingMachine = vendingMachine;

    public PurchaseMenu(Menu menu, VendingMachine vnd) {
        this.menu = menu;
        this.vnd = vnd;
    }


    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
//            try {


            if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                // display money amount
                vnd.getMoney();
                System.out.println("Current Balance: " + (double) vnd.getBalance() / 100);
            } else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
                purchaseItem();
            } else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                System.out.println("Your change is: " + (double) vnd.getChange() / 100);
                break;
                //back to MainMenu
            }
//            } catch (NullPointerException e) {
//                System.out.println(e);
//            }


        }
    }

    public void purchaseItem() {
//        Inventory slotLocation = Inventory.getInv().keySet();
        Scanner userInput = new Scanner(System.in);

        for (Map.Entry<String, Item> entry : vnd.getInventory().entrySet()) {
            System.out.println(entry);
        }
        System.out.println("What would you like? (A1,B3,etc.)");

        String inPut = userInput.nextLine();
        Item purchased = null;
        try {
            purchased = vnd.purchase(inPut);
            System.out.println(purchased.getItemMsg());
            System.out.println("Current Balance: " + (double) vnd.getBalance() / 100);

        } catch (SoldoutException | InsufficientFundsException | UnavailableException e) {
            System.out.println(e.getMessage());
        }


    }
}


        





