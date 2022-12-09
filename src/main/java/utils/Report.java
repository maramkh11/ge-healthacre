package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Report {

    public static final Logger LOGGER = LogManager.getLogger(Report.class);

    public static void info(String message, Object... params) {
        LOGGER.info(String.format(message, params));
    }

    public static void warn(String message, Object... params) {
        LOGGER.warn(String.format(message, params));
    }

    public static void error(String message, Exception e) {
        LOGGER.error(message, e);
    }

    public static void fatal(String message) {
        LOGGER.fatal(message);
    }

    public static void debug(String message) {
        LOGGER.debug(message);
    }

}