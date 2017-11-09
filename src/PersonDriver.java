import javax.swing.*;
import java.awt.*;

public class PersonDriver {

    public static void main(String args[])
    {
        char gender;
        boolean valid=false;
        gender = JOptionPane.showInputDialog("Please enter your gender: Male(M) or Female(F)").toUpperCase().charAt(0);

        Person myPerson = new Person(gender);

        while(!valid) {
            switch (gender) {
                case 'M': {

                    valid=true;
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


            JTextArea myTextArea= new JTextArea();
            Font myFont = new Font(Font.MONOSPACED, Font.PLAIN, 18);
            myTextArea.append(Name.getName(myPerson));
            myTextArea.append("\n\n");
            myTextArea.append(myPersonsPersonality.toString());
            JOptionPane.showMessageDialog(null, myTextArea);
        }
    }

    public static int randomNumber()
    {
        int random = (int)(Math.random()*10)+1;

        if(random<=2)
            random = (int)(Math.random()*5)+1;

        else if(random>=8)
            random = (int)(Math.random()*5)+6;

        return random;
    }
}
