package se.kth.iv1350.sem4.util.logger;


import java.io.PrintWriter;

public interface Logger {
	/**
	 * Log a message to a implementation based output stream.
	 * @param message is the message to be logged.
	 */
	void log(String message);
	
	/**
	 * Each implementation's Stream Writer source.
	 * @return the StreamWriter of a specific implementation.
	 */
	PrintWriter getStreamWriter();
}
