package se.kth.iv1350.pos.view;

import se.kth.iv1350.pos.model.RevenueObserver;
import se.kth.iv1350.pos.util.logger.ConsoleLogger;
import se.kth.iv1350.pos.util.logger.Logger;

public class TotalRevenueView implements RevenueObserver {
	private float totalRevenue;
	private Logger logger;
	
	public TotalRevenueView(float initialRevenue, Logger logger) {
		this.totalRevenue = initialRevenue;
		this.logger = logger;
	}
	
	public TotalRevenueView(float initialRevenue) {
		this(initialRevenue, new ConsoleLogger());
	}

	@Override
	public void newRevenue(float recievedAmmount) {
		// TODO Auto-generated method stub
		totalRevenue += recievedAmmount;
		
		logger.log("\n[NEW UPDATED REVENUE] Current total Revenue: " + totalRevenue + "kr\n");
	}
}
