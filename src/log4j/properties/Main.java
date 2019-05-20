package log4j.properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	private static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		// Use custom properties file and reload it every 5th second
		PropertyConfigurator.configureAndWatch("log4j-custom.properties", 5 * 1000);
		logger.debug("Debug-Meldung");
		logger.info("Info-Meldung");
		logger.warn("Warn-Meldung");
		logger.error("Error-Meldung");
		logger.fatal("Fatal-Meldung");
	}
}