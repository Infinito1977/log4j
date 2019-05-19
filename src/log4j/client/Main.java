package log4j.client;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;

public class Main {
	private static Logger logger = Logger.getRootLogger();
	
	private static void simpleLogging(Layout layout, String logFile) {
		try {
			ConsoleAppender consoleAppender = new ConsoleAppender(layout);
			logger.addAppender(consoleAppender);
			FileAppender fileAppender = new FileAppender(layout, logFile, false);
			logger.addAppender(fileAppender);
			// ALL | DEBUG | INFO | WARN | ERROR | FATAL | OFF:
			logger.setLevel(Level.WARN);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		logger.debug("Debug-Meldung");
		logger.info("Info-Meldung");
		logger.warn("Warn-Meldung");
		logger.error("Error-Meldung");
		logger.fatal("Fatal-Meldung");
	}
	
	private static void simpleLayout() {
		simpleLogging(new SimpleLayout(), "logs/logs.log");
	}
	
	private static void patternLayout() {
		simpleLogging(new PatternLayout("%d %l: %-5p [%t]: %m (%r)%n"), "logs/logs.log");
	}
	
	private static void htmlLayout() {
		simpleLogging(new HTMLLayout(), "logs/logs.html"); 
	}
	
	public static void main(String[] args) {
//		simpleLayout();
		patternLayout();
//		htmlLayout();
	}

}
