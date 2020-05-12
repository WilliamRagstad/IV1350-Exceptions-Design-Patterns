package se.kth.iv1350.sem4.util;

/**
 * Hold data about an item's identifier.
 * In this case, it's formatted as an integer.
 */
public class ItemID {
	private int identifier;

	public ItemID() {
		this( (int)(Math.random() * 10000));
	}
	
	public ItemID(int identifier) {
		this.identifier = identifier;
	}
	
	public int getIdentifier() {
		return identifier;
	}
}
