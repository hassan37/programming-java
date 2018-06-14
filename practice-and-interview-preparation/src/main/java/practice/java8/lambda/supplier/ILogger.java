package practice.java8.lambda.supplier;


import java.util.function.Supplier;
import java.util.logging.Logger;

public interface ILogger {
	abstract static class LoggerHolder {
		private static Logger LOGGER = Logger.getLogger("Generic");
	}
	default <T> void info(Supplier<T> s) {
		LoggerHolder.LOGGER.info(String.valueOf(s.toString()));
	}
}

