package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    long nbDepart1;
    Logger logger = LoggerFactory.getLogger("");
    long min = 0;
    long max = 100;

    public ComputerPlayer(long nbDepart){
         this.nbDepart1 = nbDepart;
    }

    @Override
    public long askNextGuess() {
        return nbDepart1;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        logger.log("Guess : " + nbDepart1);
        if (lowerOrGreater) {
            logger.log("Plus petit");
            this.max = nbDepart1;
            this.nbDepart1/=2;

        } else {
            logger.log("PLus grand");
            this.min = nbDepart1;
            this.nbDepart1 = nbDepart1 + (this.max - nbDepart1)/2;

        }
    }
}
