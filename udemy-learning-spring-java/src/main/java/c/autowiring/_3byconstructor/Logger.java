package c.autowiring._3byconstructor;

class Logger {

	private LogWriter consoleLogWriter;
	private LogWriter fileLogWriter;

	public Logger(LogWriter consoleLogWriter, LogWriter fileLogWriter) {
		this.consoleLogWriter = consoleLogWriter;
		this.fileLogWriter = fileLogWriter;
	}

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
