package log4j.properties_file;

import org.apache.log4j.Logger;

public class DefaultPropertiesFile extends Thread {
	private static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		// Load default properties file src/log4j.properties
		new DefaultPropertiesFile().start();
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