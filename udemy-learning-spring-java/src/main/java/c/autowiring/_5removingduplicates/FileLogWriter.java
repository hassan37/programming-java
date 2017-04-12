package c.autowiring._5removingduplicates;

public class FileLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("File >> " + text);
	}

}
