package se.kth.iv1350.pos.util;

@SuppressWarnings("serial")
public class ItemOutOfStockException extends Exception {

	public ItemOutOfStockException(String message) {
		super(message);
	}

}
