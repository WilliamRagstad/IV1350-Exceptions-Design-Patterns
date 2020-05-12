package se.kth.iv1350.pos.util.logger;


import java.io.PrintWriter;

/**
 *	Enables for logging to an abstract output stream from the program.
 *	Shall be implemented by a class providing a way of logging to a unique output.
 *
 *  This is implementing one of my GoF patterns (Strategy) in the Process Sale program!
 *  иииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииииии
 *  By providing different strategies of logging information to different output streams.
 *  One example is the FileLogger, is a strategy of file integration to the logging system.
 */
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
