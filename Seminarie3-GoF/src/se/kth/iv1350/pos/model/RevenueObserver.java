package se.kth.iv1350.pos.model;

/**
 * A listener interface for receiving notifications about new revenues.
 */
public interface RevenueObserver {
	/**
	 * Invoked when a new revenue has been registered.
	 * @param recievedAmmount is the newly added amount of money payed by a customer.
	 */
	void newRevenue(float recievedAmmount);
}
