import javax.swing.*;
import java.awt.*;
public class PersonDriver {

    public static String[] personalityType = new String[] {"Earth", "Wind", "Fire", "Water", "Average"};
    public static Personality p;
    public static Person myPerson;
    static int totalEarth=0, totalWind=0, totalFire = 0, totalWater = 0, totalAverage=0;

    public static void main(String args[]) {

        JTextArea ta;
        for (int i = 0; i < 400; i++) {
            p = myPersonsPersonality();
            myPerson = myPerson();
            ta = myTextArea(p, myPerson, i);
        }

        System.out.print("Fire : " + totalFire + "\nWater" + totalWater + "\nEarth" + totalEarth + "\nWind" + totalWind + "\nAverage" + totalAverage);

    }
    public static String setPersonalityType(Personality computer) {

        int i;

        /*if (computer.getCourage() >= 7 && (computer.getHonesty() >= 4 || computer.getCuriosity() >= 4)) {
            i = 2;
            totalFire++;
        }
        else if (computer.getIntelligence() >= 7 && (computer.getIntegrity() >= 4 || computer.getSelfAwareness() >=4)) {
            totalEarth++;
            i = 0;
        }
        else if(computer.getHumour() >= 6 && (computer.getCuriosity() >= 4 || computer.getHonesty()>=4)) {
            totalWater++;
            i = 3;
        }
        else if(computer.getCreativity()>= 6 && (computer.getCuriosity()>=4 || computer.getEmpathy()>=4 )) {
            i = 1;
            totalWind++;

        }
        else {
            i = 4;
            totalAverage++;
        }*/
        if
        return personalityType[i];

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

    public static JTextArea myTextArea(Personality p, Person myPerson, int i) {
        JTextArea myTextArea = new JTextArea();
        Font myFont = new Font(Font.MONOSPACED, Font.PLAIN, 18);
        myTextArea.setFont(myFont);
        myTextArea.append(Name.getName(myPerson));
        myTextArea.append("\n\n" + i + "\n\n");
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
/*
if (computer.getCourage() >= 6 && computer.getEmpathy() <= 3 || (computer.getHonesty() >= 6 && computer.getCuriosity() >= 6)) {
            i = 2;
            totalFire++;
        }
        else if ((computer.getIntelligence() >= 6 && computer.getIntegrity() >= 6) || (computer.getSelfAwareness() >=6 && computer.getCreativity()<=3)) {
            totalEarth++;
            i = 0;
        }
        else if((computer.getHumour() >= 6 && computer.getHonesty() <=3) || (computer.getCuriosity()>=6 && computer.getEmpathy() <=3)) {
            totalWater++;
            i = 3;
        }
        else if((computer.getCreativity()>=6 && computer.getCuriosity()>=6) || (computer.getHonesty()<=3 && computer.getEmpathy()>=6)) {
            i = 1;
            totalWind++;
        }
        else {
            i = 4;
            totalAverage++;
        }
 */
        /* after 400
        Fire : 106
        Water44
        Earth66
        Wind34
        Average150
         */

        /*after 2nd 400
        Fire : 100
        Water28
        Earth80
        Wind39
        Average153
         */
    /*
    private int empathy;
    private int humour;
    private int intelligence;
    private int curiosity;
    private int honesty;
    private int courage;
    private int integrity;
    private int selfAwareness;
    private int creativity;
    private String type;
    */
