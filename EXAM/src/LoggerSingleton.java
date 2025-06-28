import java.util.logging.*;

public class LoggerSingleton {
    private static final Logger logger = Logger.getLogger("BookExplorerLogger");

    static {
        logger.setUseParentHandlers(false);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
    }

    private LoggerSingleton() {}

    public static Logger getLogger() {
        return logger;
    }
}