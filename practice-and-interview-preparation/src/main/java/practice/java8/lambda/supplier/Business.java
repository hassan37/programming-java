package practice.java8.lambda.supplier;




public class Business implements ILogger {
	
	public static void main(String[] args) {
		new Business().info(() -> "info log message.");
	}
}
