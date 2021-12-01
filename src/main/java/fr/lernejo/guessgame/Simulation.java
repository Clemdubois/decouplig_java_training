package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("player1");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {

        this.player = player;
    }

    public void initialize(long numberToGuess) {

        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {

        logger.log("Entrez votre premier guess : ");
        long guess = player.askNextGuess();
        if(guess == numberToGuess){
            return true;
        }else {
            player.respond(guess > numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed() {

        while(!nextRound());
        logger.log("Félicitations, vous avez trouver le bon nombre !");
    }
}
