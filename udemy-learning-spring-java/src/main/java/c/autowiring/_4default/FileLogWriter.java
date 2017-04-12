package c.autowiring._4default;

public class FileLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("File >> " + text);
	}

}
