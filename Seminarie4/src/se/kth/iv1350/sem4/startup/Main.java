package se.kth.iv1350.sem4.startup;

import se.kth.iv1350.sem4.controller.Controller;
import se.kth.iv1350.sem4.view.View;

/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main {
	private static Controller controller;
	private static View view;
	
	/**
	 * The main method used to start the entire application.
	 * @param args The application does not take any command line parameters.
	 */
	public static void main(String[] args) {
		
		// Create Controller and View
		controller = new Controller();
		view = new View(controller);
		
		// Run sample execution that simulates a real PoS situation
		view.sampleExecution();
	}
	
}
