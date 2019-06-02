package log4j.properties_file;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPatternLayout extends Thread {
	private static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		// Use custom properties file and reload it every 5th second
		PropertyConfigurator.configureAndWatch("log4j-custom.properties", 1000);
		new Log4jPatternLayout().start();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logger.debug("Debug-Meldung");
			logger.info("Info-Meldung");
			logger.warn("Warn-Meldung");
			logger.error("Error-Meldung");
			logger.fatal("Fatal-Meldung");
		}
	}
}