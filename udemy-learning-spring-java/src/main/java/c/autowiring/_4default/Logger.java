package c.autowiring._4default;

class Logger {

	private ConsoleLogWriter consoleLogWriter;
	private FileLogWriter fileLogWriter;

	public void setConsoleLogWriter(ConsoleLogWriter consoleLogWriter) {
		this.consoleLogWriter = consoleLogWriter;
	}

	public void setFileLogWriter(FileLogWriter fileLogWriter) {
		this.fileLogWriter = fileLogWriter;
	}

	public void writeFile(String text) {
		fileLogWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleLogWriter.write(text);
	}

}
