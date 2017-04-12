package c.autowiring._5removingduplicates;

class ConsoleLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("Console >> " + text);
	}

}
