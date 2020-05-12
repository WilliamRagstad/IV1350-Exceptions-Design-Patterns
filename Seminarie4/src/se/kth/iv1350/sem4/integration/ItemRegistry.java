package se.kth.iv1350.sem4.integration;

import se.kth.iv1350.sem4.util.*;

/**
 * Takes care of the inventory. This is just a simulation of a real item registry.
 */
public class ItemRegistry {
	public static final ItemID buggedNetwork = new ItemID(123);
	public static final ItemID buggedOutOfStock = new ItemID(456);
	public static final ItemID buggedInvalid = new ItemID(789);
	
	/**
	 * Returns the searched item from the inventory.
	 * @param identifier used to find the item.
	 * @return the found item.
	 * @throws NetworkException is thrown if the connection to the database is not working correctly.
	 * @throws ItemOutOfStockException is thrown if the found item has a stock quantity of zero.
	 * @throws InvalidItemIdentifierException is thrown if the identifier does not match with an item.
	 */
	public Item getItem(ItemID identifier) throws NetworkException, ItemOutOfStockException, InvalidItemIdentifierException
	{
		if (identifier.equals(buggedNetwork)) throw new NetworkException("SQL Database Failure: Could not connect to the ItemRegistry Database!");
		if (identifier.equals(buggedOutOfStock)) throw new ItemOutOfStockException("The item with identifier: " + identifier.getIdentifier() + " was out of stock.");
		if (identifier.equals(buggedInvalid)) throw new InvalidItemIdentifierException("Invalid item identifier: " + identifier.getIdentifier());
		return new Item();
	}
}
