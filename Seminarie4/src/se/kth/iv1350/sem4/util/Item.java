package se.kth.iv1350.sem4.util;

/**
 * An item that can exist in a store
 */
public class Item {
	private ItemID identifier;
	private String name;
	private float price;

	public Item() { }
	public Item(ItemID identifier, String name, float price) {
		this.identifier = identifier;
		this.name = name;
		this.price = price;
	}
	

	public ItemID getIdentifier() {
		return identifier;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
}
