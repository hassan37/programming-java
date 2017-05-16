package d.annotatedwiring._3autoBeanDiscovery;

import org.springframework.stereotype.Component;

@Component("toFile")
public class FileLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("File >> " + text);
	}

}
