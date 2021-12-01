package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{

    long nbDepart1;
    Logger logger = LoggerFactory.getLogger("");
    long min = 0;
    long max = Long.MAX_VALUE;

    public ComputerPlayer(long nbDepart){
         this.nbDepart1 = nbDepart;
    }

    @Override
    public long askNextGuess() {
        return nbDepart1;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        System.out.println("Guess : " + nbDepart1);
        if (lowerOrGreater) {
            this.max = nbDepart1;
            this.nbDepart1/=2;
        } else {
            this.min = nbDepart1;
            this.nbDepart1 = nbDepart1 + (this.max - nbDepart1)/2;
        }
    }
}
