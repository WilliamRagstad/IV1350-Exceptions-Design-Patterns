package se.kth.iv1350.pos.integration;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.pos.dto.Discount;
import se.kth.iv1350.pos.dto.Item;
import se.kth.iv1350.pos.dto.Receipt;
import se.kth.iv1350.pos.model.RevenueObserver;

/**
 * Takes care of the communication to the physical register.
 */
public class Register {
	PrintStream receiptPrinter;
	private float money;
	private List<RevenueObserver> revenueObservers = new ArrayList<>();
	 
	public float getMoney() {
		return money;
	}
	
	public Register() {
		this(0, System.out);
	}
	public Register(float money, PrintStream stream) {
		this.receiptPrinter = new PrintStream(stream);
		this.money = money;
	}

	/**
	 * Adds money to the register
	 * @param ammount to be added
	 */
	public void registerRevenue(float ammount) {
		money += ammount;
		notifyRevenueObservers(ammount);
	}
	
	/**
	 * Prints a receipt from the physical receipt printer.
	 * @param receipt holding information about the sale to be printed.
	 */
	public void printReceipt(Receipt receipt) {
		// Simulate printing physical receipt from the register
		receiptPrinter.println("========= Receipt =========");
		receiptPrinter.println("Thanks for shopping at " + receipt.getStore() + "!");
		receiptPrinter.println("Date: " + receipt.getDate());
		receiptPrinter.println("ID Nr: " + receipt.getID());
		receiptPrinter.println("\nItems:");
		for(Item item : receipt.getItems().keySet()) {
			receiptPrinter.println("  - " + item.getName() + ", " + item.getDescription() + ": " + item.getPrice() + "kr x" + receipt.getItems().get(item));
		}
		receiptPrinter.println("\nDiscounts:");
		for(Discount discount : receipt.getDiscounts()) {
			receiptPrinter.println("  - " + discount.getDescription() + ": " + (int)(discount.getValue() * 100) + "%");
		}
		receiptPrinter.println("\nTax Rate: " + (1 - receipt.getTaxRate()));
		receiptPrinter.println("Total: " + receipt.getTotal() + "kr");
		receiptPrinter.println("===========================");
		// Receipt is printed.
	}

	private void notifyRevenueObservers(float recievedAmmount) {
		for(RevenueObserver observer : revenueObservers) {
			observer.newRevenue(recievedAmmount);
		}
	}
	
	/**
	 * Adds a new revenue observer to the list of observers.
	 * @param observer to be added.
	 */
	public void attachRevenueObserver(RevenueObserver observer) {
		revenueObservers.add(observer);
	}
}
