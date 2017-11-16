import javax.swing.*;
import java.awt.*;
public class PersonDriver {
    public static enum computerStarSign {Earth, Wind, Fire, Water}
    public static enum playerStarSign {Earth, Wind, Fire, Water}
    public static Personality p;
    public static Person myPerson;

    public static void main(String args[]) {

        JTextArea ta;
        for (int i = 0; i < 400; i++) {
            p = myPersonsPersonality();
            myPerson = myPerson();
            //setEnum(myPersonsPersonality);
            ta = myTextArea(p, myPerson);
        }
    }

    private static void setEnum(Personality p) {

        if (p.getCourage() >= 7 && p.getEmpathy() <= 3 && p.getHonesty() >= 7 && p.getCuriosity() >= 7) {
            //computerStarSign = computerStarSign.Fire;
        }
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

        char gender;
        boolean valid = false;

        gender = JOptionPane.showInputDialog("Please enter your gender: Male(M) or Female(F)").toUpperCase().charAt(0);

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
