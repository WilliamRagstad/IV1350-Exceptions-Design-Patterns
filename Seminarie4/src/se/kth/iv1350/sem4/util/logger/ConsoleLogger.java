package se.kth.iv1350.sem4.util.logger;

import java.io.PrintWriter;

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
