package log4j.pattern_layout;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Log4jPatternLayout2Threads extends Thread {
	private static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		try {
			PatternLayout layout = new PatternLayout("%d %l: %-5p [%t]: %m (%r)%n");
			ConsoleAppender consoleAppender = new ConsoleAppender(layout);
			logger.addAppender(consoleAppender);
			DailyRollingFileAppender fileAppender = new DailyRollingFileAppender(layout, "logs/logs.log",
					"'.'yyyy-MM-dd_HH-mm");
			logger.addAppender(fileAppender);
			logger.setLevel(Level.ALL);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		new Log4jPatternLayout2Threads().start();
		new Log4jPatternLayout2Threads().start();
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