package tests.se.kth.iv1350.sem4.integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.iv1350.sem4.integration.ItemRegistry;
import se.kth.iv1350.sem4.util.InvalidItemIdentifierException;
import se.kth.iv1350.sem4.util.ItemOutOfStockException;
import se.kth.iv1350.sem4.util.NetworkException;

public class ItemRegistryTest {
	private ItemRegistry itemRegistry;
	
	@Before
	public void setUp() throws Exception {
		itemRegistry = new ItemRegistry();
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

}
