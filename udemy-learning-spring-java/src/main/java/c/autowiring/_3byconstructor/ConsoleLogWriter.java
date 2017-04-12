package c.autowiring._3byconstructor;

class ConsoleLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("Console >> " + text);
	}

}
