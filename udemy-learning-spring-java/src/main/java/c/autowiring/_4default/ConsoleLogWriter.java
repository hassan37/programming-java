package c.autowiring._4default;

class ConsoleLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("Console >> " + text);
	}

}
