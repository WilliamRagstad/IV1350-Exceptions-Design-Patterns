package se.kth.iv1350.sem4.view;

import java.util.Random;

import se.kth.iv1350.sem4.controller.Controller;
import se.kth.iv1350.sem4.integration.ItemRegistry;
import se.kth.iv1350.sem4.integration.LoggingSystem;
import se.kth.iv1350.sem4.util.*;


/**
 * This is a placeholder for the real view. It contains a hard-coded execution with calls to all
 * system operations in the controller.
 */
public class View {
	private Controller controller;
	private Random rnd;

	public View(Controller controller) {
		this.controller = controller;
		rnd = new Random();
	}
	
	/**
	 * Simulates a inputs from a real PoS situation.
	 */
	public void sampleExecution() {
		System.out.println("Starting new sale!\n");

		for(int i = 0; i < 10; i++) {
			try {
				ItemID item;
				if (rnd.nextBoolean() && rnd.nextBoolean()) item = ItemRegistry.buggedNetwork;
				else if (rnd.nextBoolean() && rnd.nextBoolean()) item = ItemRegistry.buggedOutOfStock;
				else if (rnd.nextBoolean() && rnd.nextBoolean()) item = ItemRegistry.buggedInvalid;
				else item = new ItemID();
				
				controller.addItem(item); 
				LoggingSystem.getInstance().LogFrontend("Added item to sale!");
			}
			catch(InvalidItemIdentifierException e) {
				// Notify developers.
				e.printStackTrace(LoggingSystem.getInstance().getBackend().getStreamWriter());
				// Notify users.
				LoggingSystem.getInstance().LogFrontend("Invalid item identifier! The item did not exist in the inventory catalog.");
			}
			catch(ItemOutOfStockException e) {
				// Notify developers.
				e.printStackTrace(LoggingSystem.getInstance().getBackend().getStreamWriter());
				// Notify users.
				LoggingSystem.getInstance().LogFrontend("The item was out of stock!");
			}
		}

		System.out.println("\nSale ended.");
	}
}
