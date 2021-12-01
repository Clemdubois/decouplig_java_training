package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {

    private static boolean isDigit(String params) {
        try{
            Integer.parseInt(params);
            return true;
        }catch (NumberFormatException e){
            e.getMessage();
            return false;
        }
    }

    public static void main(String[] args) {
        if(args[0].compareTo("-interactive")==0){
            HumanPlayer human1 = new HumanPlayer();
            Simulation simulation = new Simulation(human1);
            SecureRandom numberToGuess = new SecureRandom();
            long randomNumber = numberToGuess.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if(args[0].compareTo("-auto")==0 && isDigit(args[1]) ){
            long nbDepart = Long.parseLong(args[1]);
            ComputerPlayer computer1 = new ComputerPlayer(nbDepart);
            Simulation simulation = new Simulation(computer1);
            SecureRandom numberToGuess = new SecureRandom();
            long randomNumber = numberToGuess.nextLong(Long.MAX_VALUE);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(1000);
        }
        else{
            System.out.println("Les paramètres ne sont pas valides !");
            System.out.println("Il faut soit utiliser \"-interactive\", qui va lancer une partie avec l'utilisateur, ");
            System.out.println("soit utiliser \"-auto\", qui va lancer une partie automatique avec l'ordinateur.");
        }





    }
}
