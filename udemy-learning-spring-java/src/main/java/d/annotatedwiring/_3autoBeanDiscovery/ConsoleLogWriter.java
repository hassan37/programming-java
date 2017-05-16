package d.annotatedwiring._3autoBeanDiscovery;

import org.springframework.stereotype.Component;

@Component("toConsole")
public class ConsoleLogWriter implements LogWriter {

	@Override
	public void write(String text) {
		System.out.println("Console >> " + text);
	}

}
