package se.kth.iv1350.sem4.integration;

import java.io.IOException;

import se.kth.iv1350.sem4.util.logger.ConsoleLogger;
import se.kth.iv1350.sem4.util.logger.FileLogger;
import se.kth.iv1350.sem4.util.logger.Logger;

/**
 *	Singleton logging system shared between layers in the project
 */
public class LoggingSystem {
	/**
	 * Singleton
	 */
	private static LoggingSystem instance;
	public static LoggingSystem getInstance() {
		if (instance == null)
			instance = new LoggingSystem();
		return instance;
	}

	/**
	 * Logging text to the user interface
	 */
	private Logger frontend; 
	/**
	 * Used for logging information interesting for developers
	 */
	private Logger backend;
	
	public Logger getFrontend() {
		return frontend;
	}
	public Logger getBackend() {
		return backend;
	}
	
	LoggingSystem() {
		this.frontend = new ConsoleLogger();
		
		try {
			this.backend = new FileLogger("developer_log.txt");
		} catch (IOException e) {
			System.out.println("Failed to setup back-end file logger!");
			e.printStackTrace();
		}
	}
	
	/**
	 * Logs a message to the front-end
	 * @param message to be logged
	 */
	public void LogFrontend(String message) {
		frontend.log(message);
	}

	
	/**
	 * Logs a message to the back-end
	 * @param message to be logged
	 */
	public void LogBackend(String message) {
		backend.log(message);
	}
}
