package c.autowiring._2byname;

class Logger {

	private LogWriter consoleLogWriter;
	private LogWriter fileLogWriter;
	
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
