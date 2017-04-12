package d.annotatedwiring._2qualifiers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

class Logger {

	@Autowired
	@Qualifier("toConsole")
	private LogWriter consoleLogWriter;

	@Autowired
	@Qualifier("toFile")
	private LogWriter fileLogWriter;

	public void writeFile(String text) {
		fileLogWriter.write(text);
	}

	public void writeConsole(String text) {
		consoleLogWriter.write(text);
	}

	@PostConstruct
	public void onCreate() {
		System.out.println("Logger Created.");
	}

	@PreDestroy
	public void onDelete() {
		System.out.println("Logger Deleted.");
	}
}
