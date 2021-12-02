package fr.lernejo.logger;

import fr.lernejo.logger.Logger;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ContextualLogger implements Logger {

    Logger logger;
    String name;

    public ContextualLogger(String name, Logger log){
        this.logger=log;
        this.name = name;
    }

    @Override
    public void log(String message) {
        DateTimeFormatter obj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        logger.log(LocalDateTime.now().format(obj) + " " + name + " " + message);
    }
}
