package log4j.html;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class HtmlLayout {
	private static Logger logger = Logger.getRootLogger();
	
	private static void startLogging(Layout layout, String logFile) {
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
	
	public static void main(String[] args) {
		startLogging(new HTMLLayout(), "logs/logs.html"); 
	}

}
