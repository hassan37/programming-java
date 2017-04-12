package c.autowiring._2byname;

public class FileLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("File >> " + text);
	}

}
