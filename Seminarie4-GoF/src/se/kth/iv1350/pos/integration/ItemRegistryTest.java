package se.kth.iv1350.pos.integration;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.kth.iv1350.pos.dto.Item;
import se.kth.iv1350.pos.util.InvalidItemIdentifierException;
import se.kth.iv1350.pos.util.ItemID;
import se.kth.iv1350.pos.util.ItemOutOfStockException;
import se.kth.iv1350.pos.util.NetworkException;

public class ItemRegistryTest {
	
	private ItemRegistry itemRegistry;

	@Before
	public void setUp() throws Exception {
		HashMap<Item, Integer> emptyInventory = new HashMap<Item, Integer>();
		itemRegistry = new ItemRegistry(emptyInventory);
	}

	@After
	public void tearDown() throws Exception {
		itemRegistry = null;
	}
	
	@Test(expected = NetworkException.class)
	public void testGetItemNetwork() throws NetworkException, ItemOutOfStockException, InvalidItemIdentifierException {
		itemRegistry.getItem(itemRegistry.buggedNetwork);
		fail("Item was found without a connection to the inventory server!");
	}
	
	@Test(expected = InvalidItemIdentifierException.class)
	public void testGetItemInvalid() throws NetworkException, ItemOutOfStockException, InvalidItemIdentifierException {
		itemRegistry.getItem(itemRegistry.buggedInvalid);
		fail("Item with invalid identifier was found!");
	}
	
	@Test(expected = ItemOutOfStockException.class)
	public void testGetItemOutOfStock() throws NetworkException, ItemOutOfStockException, InvalidItemIdentifierException {
		itemRegistry.getItem(itemRegistry.buggedOutOfStock);
		fail("Item out of stock was found!");
	}

	@Test
	public void testGetItem_Found() throws ItemOutOfStockException, InvalidItemIdentifierException, NetworkException {
		Item exampleItem = new Item(new ItemID(), "Test Item", "Testing", 1, 1);
		itemRegistry.addItem(exampleItem, 1);
		Item result = itemRegistry.getItem(exampleItem.getIdentifier());
		assertEquals("Item added to inventory could not be found later", exampleItem, result);
	}

	@Test
	public void testUpdate() {
		Item exampleItem = new Item(new ItemID(), "Test Item", "Testing", 1, 1);
		itemRegistry.addItem(exampleItem, 1);
		HashMap<Item, Integer> exampleSoldItems = new HashMap<Item, Integer>();
		exampleSoldItems.put(exampleItem, 1);
		itemRegistry.update(exampleSoldItems);
		assertTrue("Added and sold/remove item was not successful", itemRegistry.getInventory().size() == 0);
	}

}
