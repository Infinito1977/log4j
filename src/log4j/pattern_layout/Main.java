package log4j.pattern_layout;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Main {
	private static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		try {
			PatternLayout layout = new PatternLayout("%d %l: %-5p [%t]: %m (%r)%n");
			DailyRollingFileAppender fileAppender = new DailyRollingFileAppender(layout, "logs/logs.log",
					"'.'yyyy-MM-dd_HH-mm");
			logger.addAppender(fileAppender);
			logger.setLevel(Level.ALL);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		logger.debug("Debug-Meldung");
		logger.info("Info-Meldung");
		logger.warn("Warn-Meldung");
		logger.error("Error-Meldung");
		logger.fatal("Fatal-Meldung");
	}
}