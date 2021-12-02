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

        long guess = player.askNextGuess();
        if(guess == numberToGuess){
            return true;
        }else {
            player.respond(guess > numberToGuess);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long nbMax) {
        long restant = 0;
        long time1 = System.currentTimeMillis();
        while (!this.nextRound() && restant < nbMax) {
            restant++;
        }
        long res = System.currentTimeMillis() - time1;
        if(restant < nbMax){
            long secondes = res/1000;
            long milli = res%1000;
            logger.log("Félicitations, vous avez trouver le bon nombre en : " + secondes + "." + milli + "s");
            logger.log("Temps en millisecondes : " + res);
        } else if(restant == nbMax){
            logger.log("Nombres d'itérations maximum atteinte.");
        }

    }
}
