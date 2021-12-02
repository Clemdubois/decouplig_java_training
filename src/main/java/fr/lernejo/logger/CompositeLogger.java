package fr.lernejo.logger;

public class CompositeLogger implements Logger{

    private ConsoleLogger log1;
    private ContextualLogger log2;

    public CompositeLogger(ConsoleLogger logger1, ContextualLogger logger2){
        this.log1 = logger1;
        this.log2 = logger2;
    }

    @Override
    public void log(String message) {
        log1.log(message);
        log2.log(message);
    }
}
