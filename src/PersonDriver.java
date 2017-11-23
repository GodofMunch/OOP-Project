import javax.swing.*;
import java.awt.*;
public class PersonDriver {

    public static String[] personalityType = new String[] {"Earth", "Wind", "Fire", "Water", "Average"};
    public static Personality p;
    public static Person myPerson;

    public static void main(String args[]) {

            p = myPersonsPersonality();
            myPerson = myPerson();
            myTextArea(p, myPerson);
    }

    public static String setPersonalityType(Personality computer) {

        int upperLimitCheck, bounds = 8;

        if(computer.getCourage() >= bounds)
            upperLimitCheck=0;
        else if(computer.getCreativity() >= bounds)
            upperLimitCheck=1;
        else if(computer.getCuriosity() >= bounds)
            upperLimitCheck=2;
        else if(computer.getEmpathy() >= bounds)
            upperLimitCheck=3;
        else if(computer.getHonesty() >= bounds)
            upperLimitCheck=0;
        else if(computer.getHumour() >= bounds)
            upperLimitCheck=1;
        else if(computer.getIntegrity() >= bounds)
            upperLimitCheck=2;
        else if(computer.getIntelligence() >= bounds)
            upperLimitCheck=3;
        else if(computer.getSelfAwareness() >= bounds)
            upperLimitCheck=0;
        else
            upperLimitCheck=4;

        return personalityType[upperLimitCheck];
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

    public static JTextArea myTextArea(Personality p, Person myPerson) {
        JTextArea myTextArea = new JTextArea();
        Font myFont = new Font(Font.MONOSPACED, Font.PLAIN, 18);
        myTextArea.setFont(myFont);
        myTextArea.append(Name.getName(myPerson));
        myTextArea.append("\n\n");
        myTextArea.append(p.toString());
        myTextArea.append("\n" + setPersonalityType(p));
        JOptionPane.showMessageDialog(null, myTextArea);

        return myTextArea;
    }

    public static Personality myPersonsPersonality() {
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

    public static Person myPerson() {

        char gender = 'M';
        boolean valid = false;

        //gender = JOptionPane.showInputDialog("Please enter your gender: Male(M) or Female(F)").toUpperCase().charAt(0);

        Person myPerson = new Person(gender);

        while (!valid) {
            switch (gender) {
                case 'M': {
                    valid = true;
                    break;
                }
                case 'F': {
                    valid = true;
                    break;
                }
                default: {
                    gender = JOptionPane.showInputDialog("Invalid! - Please enter your gender: Male(M) or Female(F)").toUpperCase().charAt(0);
                    break;
                }
            }
        }
        return myPerson;
    }
}
