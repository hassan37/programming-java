package c.autowiring._2byname;

class ConsoleLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("Console >> " + text);
	}

}
