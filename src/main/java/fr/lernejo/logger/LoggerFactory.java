package fr.lernejo.logger;

import fr.lernejo.guessgame.ContextualLogger;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new ContextualLogger(FileLogger.class.getName(),new FileLogger("log.txt"));
    }
}
