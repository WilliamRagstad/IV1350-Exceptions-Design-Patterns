package se.kth.iv1350.pos.util.logger;

import java.io.PrintWriter;

/**
 *	Implements a new strategy for the logger.
 *	A ConsoleLogger logs all messages to the standard output stream.
 */
public class ConsoleLogger implements Logger {
	
	@Override
	public void log(String message) {
		System.out.println(message);
	}

	@Override
	public PrintWriter getStreamWriter() {
		return new PrintWriter(System.out);
	}

}
