import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String args[]) {
        GUI2 myGUI = new GUI2();
        myGUI.setVisible(true);
    }


    private static String[] earthInterest = {"Television", "Awkward apology", "Politics", "Computers", "Tease",
            "Games", "Music", "Aliens", "Puns", "Science"};

    private static String[] waterInterest = {"Angels", "Religion", "Star Signs", "Art", "The Supernatural",
            "Travel", "Deep Conversation", "Health", "Music", "Nature"};

    private static String[] fireInterest = {"Rugby", "Nature", "Phones", "Gym", "Clothes", "Swimming",
            "Hiking", "Social Media", "Humble Brag", "Hygiene"};

    private static String[] windInterest = {"Cooking", "Dancing", "Weather", "Shopping", "Money",
            "Museum", "Restaurants", "Tell a Joke", "Complain"};

    private static String[] averageInterest = {"Television", "Religion", "Phones", "Shopping",
            "Computers", "Travel", "Social Media", "Restaurants",
            "Aliens", "Complain"};

    public static String[] personalityType = new String[]{"Earth", "Wind", "Fire", "Water", "Average"};

    private static String getInterest(Personality p) {

        String interest;
        int random = (int) (Math.random() * 9) + 1;

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
    }

    public String personalityType(Personality player) {
        int upperLimitCheck, bounds = 8;

        if(player.getCourage() >= bounds)
            upperLimitCheck = 0;
        else if(player.getCreativity() >= bounds)
            upperLimitCheck = 1;
        else if(player.getCuriosity() >= bounds)
            upperLimitCheck = 2;
        else if(player.getEmpathy() >= bounds)
            upperLimitCheck = 3;
        else if(player.getHonesty() >= bounds)
            upperLimitCheck = 0;
        else if(player.getHumour() >= bounds)
            upperLimitCheck = 1;
        else if(player.getIntegrity() >= bounds)
            upperLimitCheck = 2;
        else if(player.getIntelligence() >= bounds)
            upperLimitCheck = 3;
        else if(player.getSelfAwareness() >= bounds)
            upperLimitCheck = 0;
        else
            upperLimitCheck = 4;

        return personalityType[upperLimitCheck];
    }

    public static Personality computerPersonality() {
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
}