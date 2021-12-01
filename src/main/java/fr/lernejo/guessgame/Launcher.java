package fr.lernejo.guessgame;

import com.sun.tools.javac.Main;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        HumanPlayer human1 = new HumanPlayer();
        Simulation simulation = new Simulation(human1);
        SecureRandom numberToGuess = new SecureRandom();
        long randomNumber = numberToGuess.nextInt(100);
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}
