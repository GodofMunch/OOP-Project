import javax.swing.*;
import java.awt.*;

public class Game {

    private static String[] earthInterest = {"Television", "Awkward apology", "Politics", "Computers", "Tease",
                                             "Games", "Music", "Aliens", "Puns", "Science"};

    private static String[] waterInterest = {"Angels", "Religion", "Star Signs", "Art", "The Supernatural",
                                             "Travel", "Deep Conversation", "Health", "Music", "Nature"};

    private static String[] fireInterest = {"Rugby", "Nature", "Phones", "Gym", "Clothes", "Swimming",
                                            "Hiking", "Social Media", "Humble Brag", "Hygiene"};

    private static String[] windInterest = {"Cooking", "Dancing", "Weather", "Shopping", "Money",
                                            "Museum", "Restaraunts", "Tell a Joke", "Complain"};

    private static String[] averageInterest = {"Television", "Religion", "Phones", "Shopping",
                                               "Computers", "Travel", "Social Media", "Restaraunts",
                                                "Aliens", "Complain"};


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
}
