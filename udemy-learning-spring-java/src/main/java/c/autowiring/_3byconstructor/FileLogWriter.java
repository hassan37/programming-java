package c.autowiring._3byconstructor;

public class FileLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("File >> " + text);
	}

}
