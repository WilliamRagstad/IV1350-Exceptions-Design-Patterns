package se.kth.iv1350.sem4.controller;

import se.kth.iv1350.sem4.integration.ItemRegistry;
import se.kth.iv1350.sem4.integration.LoggingSystem;
import se.kth.iv1350.sem4.util.*;
/**
 * This is the application controller.
 * All calls to the model pass through this class.
 */
public class Controller {
	
	private ItemRegistry itemRegistry;
	
	public Controller() {
		itemRegistry = new ItemRegistry();
	}
	
	/**
	 * Add an item to the current sale
	 * @param identifier specifies the item to be added
	 * @param quantity specifies how many of that item should be added
	 * @throws ItemOutOfStockException is thrown if the item id is not valid
	 * @throws InvalidItemIdentifierException is thrown if an item identifier is invalid
	 */
	public void addItem(ItemID identifier) throws ItemOutOfStockException, InvalidItemIdentifierException
	{
		try {
			Item item = itemRegistry.getItem(identifier);
		}
		catch(NetworkException e) {
			e.printStackTrace(LoggingSystem.getInstance().getBackend().getStreamWriter());
		}
	}
}
