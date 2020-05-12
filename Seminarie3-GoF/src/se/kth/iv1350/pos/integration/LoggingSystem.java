package se.kth.iv1350.pos.integration;

import java.io.IOException;

import se.kth.iv1350.pos.util.logger.ConsoleLogger;
import se.kth.iv1350.pos.util.logger.FileLogger;
import se.kth.iv1350.pos.util.logger.Logger;

/**
 *	Singleton logging system shared between layers in the project,
 *	this is persistent during the program execution.
 *
 *  This is implementing one of my GoF patterns (Singleton) in the Process Sale program!
 *  ииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииии
 *  Combining the strategy pattern into this singleton wrapper produces the lastly needed
 *  GoF pattern, offers flexible logging for the whole system.
 */
public class LoggingSystem {
	/**
	 * Singleton
	 */
	private static LoggingSystem instance;
	public static LoggingSystem getInstance() {
		if (instance == null) instance = new LoggingSystem();
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
	
	/**
	 * @return the front-end logger
	 */
	public Logger getFrontend() {
		return frontend;
	}
	/**
	 * @return the back-end logger
	 */
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
