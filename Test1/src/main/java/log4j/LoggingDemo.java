package log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {
    private static final Logger log = (Logger) LogManager.getLogger(LoggingDemo.class.getName());

    public static void main(String[] args) {
        log.error("哈哈");
        log.debug("debug");
        log.info("info");

    }
}
