package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    Logger logger = LoggerFactory.getLogger("");

    @Override
    public long askNextGuess() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if(lowerOrGreater){
            logger.log("Le nombre qu'il faut trouver est plus petit !");
        }else{
            logger.log("Le nombre qu'il faut trouver est plus grand !");
        }
    }
}
