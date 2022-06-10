package com.techelevator;

import com.techelevator.model.Inventory;
import com.techelevator.model.VendingMachine;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseMenu;

import java.io.FileNotFoundException;
import java.util.Map;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

	private Menu menu;
	private PurchaseMenu purchaseMenu;
	private VendingMachine vendingMachine;
//	private static Menu purchaseMenu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		purchaseMenu = new PurchaseMenu(menu);
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				try {

					for (Map.Entry entry : Inventory.getInv().entrySet()) {
						System.out.println(entry);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
				purchaseMenu.run();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Your change is: " + VendingMachine.getChange());
				System.exit(1);
				//exit program
			}
		}
	}

		public static void main (String[] args) {
			Menu menu = new Menu(System.in, System.out);
			VendingMachineCLI cli = new VendingMachineCLI(menu);
			cli.run();
		}

	}

