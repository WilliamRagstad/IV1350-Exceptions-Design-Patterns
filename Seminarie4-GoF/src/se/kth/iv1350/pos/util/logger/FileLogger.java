package se.kth.iv1350.pos.util.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 *	Implements a new strategy for the logger.
 *	A FileLogger logs all messages to a specified file output.
 */
public class FileLogger implements Logger {
	private PrintWriter stream;

	/**
	 * Creates a new instance and creates a new log file. Existing log file will be deleted.
	 * @param file is the file to write to.
	 * @throws IOException is thrown if the file could not be opened.
	 */
	public FileLogger(String file) throws IOException {
		stream = new PrintWriter(new FileWriter(file), true);
	}

	@Override
	public PrintWriter getStreamWriter() {
		return stream;
	}

	@Override
	public void log(String message) {
		stream.println(message);
	}

}
