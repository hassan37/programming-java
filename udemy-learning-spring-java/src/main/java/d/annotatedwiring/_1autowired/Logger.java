package d.annotatedwiring._1autowired;

import org.springframework.beans.factory.annotation.Autowired;

class Logger {

	@Autowired
	private ConsoleLogWriter consoleLogWriter;

	@Autowired
	private FileLogWriter fileLogWriter;

	public void writeFile(String text) {
		fileLogWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleLogWriter.write(text);
	}

}
