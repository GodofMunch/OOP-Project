import javax.swing.*;
import java.awt.*;

public class PersonDriver {

    public static void main(String args[]) {
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

                Personality myPersonsPersonality = new Personality();

                myPersonsPersonality.setEmpathy(randomNumber("empathy"));
                myPersonsPersonality.setHumour(randomNumber("humour"));
                myPersonsPersonality.setIntelligence(randomNumber("intelligenge"));
                myPersonsPersonality.setCuriosity(randomNumber("curiosity"));
                myPersonsPersonality.setHonesty(randomNumber("honesty"));
                myPersonsPersonality.setCourage(randomNumber("courage"));
                myPersonsPersonality.setIntegrity(randomNumber("Integrity"));
                myPersonsPersonality.setSelfAwareness(randomNumber("self awareness"));
                myPersonsPersonality.setCreativity(randomNumber("creativity"));


                JTextArea myTextArea = new JTextArea();
                Font myFont = new Font(Font.MONOSPACED, Font.PLAIN, 18);
                myTextArea.setFont(myFont);
                myTextArea.append(Name.getName(myPerson));
                myTextArea.append("\n\n");
                myTextArea.append(myPersonsPersonality.toString());
                JOptionPane.showMessageDialog(null, myTextArea);
            }
        }

public static int randomNumber(String type) {
        int random = (int)(Math.random()*9)+1;
        System.out.print("\n" + type + "\n");
        if(random<3) {
            random = (int) (Math.random() * 5) + 1;
            System.out.print( "\n    random <3 = " + random);

            if(random<2){
                random = (int) (Math.random() * 5) + 1;
                System.out.print( "\n    random <2 = " + random);
            }
        }
        else if(random>8){
            random = (int)(Math.random()*5)+6;
            System.out.print( "\n    random >8 = " + random);
            if(random >9 ){
                random = (int)(Math.random()*5)+6;
                System.out.print( "\n    random >9 = " + random);
            }
        }
        return random;
    }
}
