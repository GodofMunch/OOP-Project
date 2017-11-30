import javax.swing.*;
import java.awt.*;

public class Game {

    static int multiplier;
    public static Personality computerPersonality = getComputerPersonality();
    public static Person computerName = new Person(GUI2.player.getGender());


    public static void main(String args[]) {
        GUI2 myGUI = new GUI2();
        myGUI.setVisible(true);
    }


    public static String[] earthInterest = {"Television", "Awkward apology", "Politics", "Computers", "Tease",
            "Games", "Music", "Aliens", "Puns", "Science"};

    public static String[] waterInterest = {"Angels", "Religion", "Star Signs", "Art", "The Supernatural",
            "Travel", "Deep Conversation", "Health", "Music", "Nature"};

    public static String[] fireInterest = {"Rugby", "Nature", "Phones", "Gym", "Clothes", "Swimming",
            "Hiking", "Social Media", "Humble Brag", "Hygiene"};

    public static String[] windInterest = {"Cooking", "Dancing", "Weather", "Shopping", "Money",
            "Museum", "Restaurants", "Tell a Joke", "Complain", "Flirt"};

    public static String[] averageInterest = {"Television", "Religion", "Phones", "Shopping",
            "Computers", "Travel", "Social Media", "Restaurants", "Aliens", "Complain"};

   /* public static String getInterest(Personality p) {

        String interest;
        int random = (int) (Math.random() * 10) + 1;

        if(p.getPersonalityType(p).equals("Earth"))
            interest = earthInterest[random];
        else if(p.getPersonalityType(p).equals("Wind"))
            interest = windInterest[random];
        else if(p.getPersonalityType(p).equals("Water"))
            interest = waterInterest[random];
        else if(p.getPersonalityType(p).equals("Fire"))
            interest = fireInterest[random];
        else
            interest = averageInterest[random];

        return interest;
    }*/


    public static Personality getComputerPersonality() {
        Personality myPersonsPersonality = new Personality();

        myPersonsPersonality.setEmpathy(randomNumber());
        myPersonsPersonality.setHumour(randomNumber());
        myPersonsPersonality.setIntelligence(randomNumber());
        myPersonsPersonality.setCuriosity(randomNumber());
        myPersonsPersonality.setHonesty(randomNumber());
        myPersonsPersonality.setCourage(randomNumber());
        myPersonsPersonality.setIntegrity(randomNumber());
        myPersonsPersonality.setSelfAwareness(randomNumber());
        myPersonsPersonality.setCreativity(randomNumber());

        return myPersonsPersonality;
    }

    public static int randomNumber() {
        int random = (int) (Math.random() * 9) + 1;
        if (random < 3) {
            random = (int) (Math.random() * 5) + 1;

            if (random < 2) {
                random = (int) (Math.random() * 5) + 1;
            }
        } else if (random > 8) {
            random = (int) (Math.random() * 5) + 6;
            if (random > 9) {
                random = (int) (Math.random() * 5) + 6;
            }
        }
        return random;
    }

    public static int decideMultiplier(String playerType, String computerType) {
        int negativeMultiplierAverage = -2;
        int positiveMultiplierAverage = 2;
        int neutralMultiplier = 1;
        int positiveMultiplierExtreme = 3;
        int negativeMultiplierExtreme = -3;


        if((computerType.equals("Earth") && playerType.equals("Wind")) || (computerType.equals("Fire") && playerType.equals("Water"))
                || (computerType.equals("Wind") && playerType.equals("Earth")) || (computerType.equals("Fire") && playerType.equals("Water")))
            multiplier = negativeMultiplierExtreme;

        else if((computerType.equals("Earth") && playerType.equals("Fire")) || (computerType.equals("Fire") && playerType.equals("Wind"))
                || (computerType.equals("Wind") && playerType.equals("Water")) || (computerType.equals("Water") && playerType.equals("Earth")))
            multiplier = negativeMultiplierAverage;

        else if((computerType.equals("Wind") && playerType.equals("Earth")) || (computerType.equals("Wind") && playerType.equals("Fire"))
                || (computerType.equals("Water") && playerType.equals("Wind")) || (computerType.equals("Earth") && playerType.equals("Water")))
            multiplier = positiveMultiplierAverage;

        else if((computerType.equals("Earth") && playerType.equals("Earth")) || (computerType.equals("Fire") && playerType.equals("Fire"))
                || (computerType.equals("Wind") && playerType.equals("Wind")) || (computerType.equals("Water") && playerType.equals("Water")))
            multiplier = positiveMultiplierExtreme;

        else
            multiplier = neutralMultiplier;

        return multiplier;
    }

    public static void startGame()
    {

        String computerType = Personality.getPersonalityType(getComputerPersonality());

        Personality playerPersonality = GUI2.playerPersonality;

        //Couldnt get GUI2 to save values without causing trouble for display, so calling a random personality for the player

        playerPersonality.setEmpathy(randomNumber());
        playerPersonality.setHonesty(randomNumber());
        playerPersonality.setCourage(randomNumber());
        playerPersonality.setHumour(randomNumber());
        playerPersonality.setCreativity(randomNumber());
        playerPersonality.setSelfAwareness(randomNumber());
        playerPersonality.setIntegrity(randomNumber());
        playerPersonality.setCuriosity(randomNumber());
        playerPersonality.setIntelligence(randomNumber());


        String playerType = Personality.getPersonalityType(GUI2.playerPersonality);
        multiplier = decideMultiplier(playerType, computerType);

    }

    public static void  positiveEarth() {
        //maths for score

        //set score
        //update progress bar
    }

    public static void negativeEarth() {

    }

    public static void positiveWind() {

    }

    public static void negativeWind() {

    }

    public static void positiveFire() {

    }

    public static void negativeFire() {

    }

    public static void positiveWater() {

    }

    public static void negativeWater() {

    }

}