import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToolBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUI2 extends JFrame implements ActionListener {

    private JMenu fileMenu;
    private JMenu namesMenu;
    private Container myPane;
    private JMenuItem newName;
    private JMenuItem display;
    private JMenuItem exit;
    private JMenuItem save;
    private JMenuItem open;
    private JMenuItem game;
    private ImageIcon couple = new ImageIcon("src\\Resources\\Images\\Couple.jpg");
    private ImageIcon me = new ImageIcon("src\\Resources\\Images\\me.png");
    private ImageIcon man = new ImageIcon("src\\Resources\\Images\\man.jpg");
    private ImageIcon woman = new ImageIcon("src\\Resources\\Images\\woman.jpg");
    private JLabel womanHolder = new JLabel(woman);
    private JLabel manHolder = new JLabel(man);
    private JLabel coupleHolder = new JLabel(couple);
    private static JTextArea questionHolder;
    private static JFrame playerQuestionsFrame;
    private static JPanel questionButtons;
    private JFrame questionTime = new JFrame(("Questions"));
    private JButton welcomeContinue;
    private JButton notLikely = new JButton();
    private JButton somewhatLikely = new JButton();
    private JButton likely = new JButton();
    public static JProgressBar score;
    private final int width = 800;
    private static int i = 1;
    public static Personality playerPersonality = new Personality();
    private static char gender;
    public static Person player = new Person(gender);
    private JButton one = new JButton();
    private JButton two = new JButton();
    private JButton three = new JButton();
    private JButton four = new JButton();
    public static String name = "";
    private boolean startBoolean = false;
    String[] dateNames = new String[10];
    private int j=0;

    public static void main(String args[]) {
        GUI2 myGUI = new GUI2();
        myGUI.setVisible(true);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Contains the code that displays the initial GUI
     */
    public GUI2() {
        this.setTitle("Dating Simulator 2017");
        this.setVisible(true);
        myPane = getContentPane();
        this.setLayout(new BorderLayout());
        //myPane.add(new JLabel(new ImageIcon("src\\Resources\\Images\\Couple.jpg")), BorderLayout.CENTER);
        myPane.add(coupleHolder, BorderLayout.CENTER);
        // myPane.add(new JLabel(new ImageIcon("C:\\Users\\t00139303\\Documents\\GitHub\\Resources\\Images\\Couple.jpg")), BorderLayout.CENTER);

        setBounds(300, 200, width, 650);
        setLocation(50, 50);

        createFileMenu();
        createNamesMenu();
        JMenuBar myMenuBar = new JMenuBar();
        setJMenuBar(myMenuBar);
        myMenuBar.add(fileMenu);
        myMenuBar.add(namesMenu);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");

        fileMenu.add(game = new JMenuItem("New Game"));
        game.addActionListener(this);

        fileMenu.add(save = new JMenuItem("Save"));
        save.addActionListener(this);

        fileMenu.add(open = new JMenuItem("Open"));
        open.addActionListener(this);

        fileMenu.add(exit = new JMenuItem("Exit"));
        exit.addActionListener(this);
    }

    private void createNamesMenu() {

        namesMenu = new JMenu("Names");

        newName = new JMenuItem("New");
        newName.addActionListener(this);
        namesMenu.add(newName);

        display = new JMenuItem("Display");
        display.addActionListener(this);
        namesMenu.add(display);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Contains the code that deals with events
     *
     * @param e of type ActionEvent
     */
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == newName) {
            newNameCall();
        }

        if(e.getSource() == display) {
            displayCall();
        }

        if(e.getSource() == exit) {
            exitCall();
        }

        if(e.getSource() == game) {
            createPlayer();
        }

        if(e.getSource() == save) {
            try {
                saveGame();
            } catch(Exception e1) {
                e1.printStackTrace();
            }
        }

        if(e.getSource() == open)
            try {
                loadGame();
            } catch(Exception e1) {
                e1.printStackTrace();
            }

        //if(e.getSource() == likely || e.getSource() == somewhatLikely || e.getSource() == notLikely || e.getSource() == welcomeContinue)
        if(e.getSource() == welcomeContinue) {
            //System.out.print("ASKING QUESTIONS");
            playerQuestionsFrame.setVisible(false);
            i=1;
            playerQuestions();
        }

        if(i > 1 && i <= 10)
            playerQuestions();
        if(e.getSource() == notLikely || e.getSource() == somewhatLikely || e.getSource() == likely) {

            if(e.getSource() == notLikely) {
                if(i == 1)
                    playerPersonality.setEmpathy(randomLow());
                else if(i == 2)
                    playerPersonality.setHonesty(randomLow());
                else if(i == 3)
                    playerPersonality.setCourage(randomLow());
                else if(i == 4)
                    playerPersonality.setHumour(randomLow());
                else if(i == 5)
                    playerPersonality.setCreativity(randomLow());
                else if(i == 6)
                    playerPersonality.setSelfAwareness(randomLow());
                else if(i == 7)
                    playerPersonality.setIntegrity(randomHigh());
                else if(i == 8)
                    playerPersonality.setCuriosity(randomLow());
                else if(i == 9)
                    playerPersonality.setIntelligence(randomHigh());
                else {
                    questionTime.setVisible(false);
                    Game.startGame();
                    newGameCall();
                }
            }

            if(e.getSource() == somewhatLikely) {
                if(i == 1)
                    playerPersonality.setEmpathy(randomMid());
                else if(i == 2)
                    playerPersonality.setHonesty(randomMid());
                else if(i == 3)
                    playerPersonality.setCourage(randomMid());
                else if(i == 4)
                    playerPersonality.setHumour(randomMid());
                else if(i == 5)
                    playerPersonality.setCreativity(randomMid());
                else if(i == 6)
                    playerPersonality.setSelfAwareness(randomMid());
                else if(i == 7)
                    playerPersonality.setIntegrity(randomMid());
                else if(i == 8)
                    playerPersonality.setCuriosity(randomMid());
                else if(i == 9)
                    playerPersonality.setIntelligence(randomMid());
                else {
                    questionTime.setVisible(false);
                    Game.startGame();
                    newGameCall();
                }
            }


            if(e.getSource() == likely) {
                if(i == 1)
                    playerPersonality.setEmpathy(randomHigh());
                else if(i == 2)
                    playerPersonality.setHonesty(randomHigh());
                else if(i == 3)
                    playerPersonality.setCourage(randomHigh());
                else if(i == 4)
                    playerPersonality.setHumour(randomHigh());
                else if(i == 5)
                    playerPersonality.setCreativity(randomHigh());
                else if(i == 6)
                    playerPersonality.setSelfAwareness(randomHigh());
                else if(i == 7)
                    playerPersonality.setIntegrity(randomLow());
                else if(i == 8)
                    playerPersonality.setCuriosity(randomHigh());
                else if(i == 9)
                    playerPersonality.setIntelligence(randomLow());
                else {
                    questionTime.setVisible(false);
                    Game.startGame();
                    newGameCall();
                    j++;
                }
            }
        }
        if(i<=11)
            i++;
        //

        if(i==11){
            questionTime.setVisible(false);
            Game.startGame();
            newGameCall();
        }
        //
       // System.out.print(playerPersonality.toString());
        if(e.getSource() == one) {
            String type = Personality.getPersonalityType(Game.computerPersonality);

            if(type.equals("Earth"))
                earthCheck(one);
            else if(type.equals("Wind"))
                windCheck(one);
            else if(type.equals("Fire"))
                fireCheck(one);
            else if(type.equals("Water"))
                waterCheck(one);
            else averageCheck(one);
        }

        if(e.getSource() == two) {
            String type = Personality.getPersonalityType(Game.computerPersonality);

            if(type.equals("Earth"))
                earthCheck(two);
            else if(type.equals("Wind"))
                windCheck(two);
            else if(type.equals("Fire"))
                fireCheck(two);
            else if(type.equals("Water"))
                waterCheck(two);
            else
                averageCheck(two);
        }
        if(e.getSource() == three) {
            String type = Personality.getPersonalityType(Game.computerPersonality);

            if(type.equals("Earth"))
                earthCheck(three);
            else if(type.equals("Wind"))
                windCheck(three);
            else if(type.equals("Fire"))
                fireCheck(three);
            else if(type.equals("Water"))
                waterCheck(three);
            else
                averageCheck(three);
        }
        if(e.getSource() == four) {
            String type = Personality.getPersonalityType(Game.computerPersonality);

            if(type.equals("Earth"))
                earthCheck(four);
            else if(type.equals("Wind"))
                windCheck(four);
            else if(type.equals("Fire"))
                fireCheck(four);
            else if(type.equals("Water"))
                waterCheck(four);
            else
                averageCheck(four);
        }
        if(e.getSource() == one || e.getSource() == two || e.getSource() == three || e.getSource() == four) {
            one.setText(buttonPicker());
            two.setText(buttonPicker());
            three.setText(buttonPicker());
            four.setText(buttonPicker());
            myPane.validate();
        }

    }

    /**
     * @author Dave O'Sullivan - T00139303
     *
     * Takes in a JButton to see if the text in it corrolates with the dates Interest's
     * if found to be positive or negative then call the appropriate method
     *
     * @param button
     */

    private void fireCheck(JButton button) {
        boolean goodGuess = false;

        for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
            if(button.getText().equals(Game.fireInterest[fireCheck])) {
                goodGuess = true;
            }
        }

        if(goodGuess) {
            Game.positiveFire();
        } else {
            Game.negativeFire();
        }
    }

    /**
     * @author Dave O'Sullivan - T00139303
     *
     * Takes in a JButton to see if the text in it corrolates with the dates Interest's
     * if found to be positive or negative then call the appropriate method
     *
     * @param button
     */
    private void waterCheck(JButton button) {
        boolean goodGuess = false;
        for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
            if(button.getText().equals(Game.waterInterest[waterCheck])) {
                goodGuess = true;
            }
        }

        if(goodGuess) {
            Game.positiveWater();
        } else {
            Game.negativeWater();
        }
    }

    /**
     * @author Dave O'Sullivan - T00139303
     *
     * Takes in a JButton to see if the text in it corrolates with the dates Interest's
     * if found to be positive or negative then call the appropriate method
     *
     * @param button
     */
    private void windCheck(JButton button) {
        boolean goodGuess = false;

        for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
            if(button.getText().equals(Game.windInterest[windCheck])) {
                goodGuess = true;
            }
        }

        if(goodGuess) {
            Game.positiveWind();
        } else {
            Game.negativeWind();
        }

    }

    /**
     * @author Dave O'Sullivan - T00139303
     *
     * Takes in a JButton to see if the text in it corrolates with the dates Interest's
     * if found to be positive or negative then call the appropriate method
     *
     * @param button
     */
    private void earthCheck(JButton button) {
        boolean goodGuess = false;

        for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
            if(button.getText().equals(Game.earthInterest[earthCheck])) {
                goodGuess = true;
            }
        }

        if(goodGuess) {
            Game.positiveEarth();
        } else {
            Game.negativeEarth();
        }


    }

    /**
     * @author Dave O'Sullivan - T00139303
     *
     * Takes in a JButton to see if the text in it corrolates with the dates Interest's
     * if found to be positive or negative then call the appropriate method
     *
     * @param button
     */
    private void averageCheck(JButton button) {
        boolean goodGuess = false;

        for(int averageCheck = 0; averageCheck < Game.averageInterest.length; averageCheck++) {
            if(button.getText().equals(Game.averageInterest[averageCheck])) {
                goodGuess = true;
            }
        }

        if(goodGuess) {
            Game.positiveEarth();
        } else {
            Game.negativeEarth();
        }

    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Chooses a random number between 4 and 7
     * @return int
     */
    private int randomMid() {
        return (int) ((Math.random() * 3) + 4);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Chooses a random number between 1 and 3
     * @return int
     */
    private int randomLow() {
        return (int) ((Math.random() * 2) + 1);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Chooses a random number between 8 and 10
     * @return int
     */

    private int randomHigh() {
        return (int) ((Math.random() * 3) + 7);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Contains The GUI code for the new game
     *
     * This is called from the JMenuItem newGame in the actionPerformed method
     */

    private void newGameCall() {

        //System.out.print("New Game");


        /*try {
            Image tv = ImageIO.read(getClass().getResource("Resources/Images/tv.png"));
            one.setIcon(new ImageIcon(tv));
        } catch(Exception ex) {
            System.out.println(ex);
        }*/


        JPanel scoreHolder = new JPanel();
        scoreHolder.setLayout(new BorderLayout());
        String type = Personality.getPersonalityType(Game.computerPersonality);
        JLabel typeDisplay = new JLabel(type + "   ");
        scoreHolder.add(typeDisplay, BorderLayout.WEST);
        typeDisplay.setFont(new Font("Ariel", Font.BOLD, 16));
        typeDisplay.setForeground(Color.blue);
        scoreHolder.setBackground(Color.pink);
        score = new JProgressBar(0, 100);  //https://stackoverflow.com/questions/15199091/progress-bar-java
        score.setValue(30);                //https://stackoverflow.com/questions/15199091/progress-bar-java
        score.setBackground(Color.pink);
        score.setForeground(Color.blue);
        JToolBar scoreToolbar = new JToolBar();
        scoreToolbar.add(scoreHolder);
        genderSelect();
        JLabel nameDisplay = new JLabel("   " + name);
        dateNames[j] = name;
        nameDisplay.setFont(new Font("Ariel", Font.BOLD, 16));
        scoreHolder.add(nameDisplay, BorderLayout.EAST);
        nameDisplay.setForeground(Color.blue);
        scoreToolbar.setPreferredSize(new Dimension(width, 40));
        scoreHolder.add(score, BorderLayout.CENTER);
        myPane.remove(coupleHolder);
        if(gender == 'M')
            myPane.add(manHolder, BorderLayout.CENTER);
        else
            myPane.add(womanHolder, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.pink);

        myPane.add(scoreToolbar, BorderLayout.NORTH);

        one = new JButton(buttonPicker());
        one.setBackground(Color.pink);
        one.setForeground(Color.blue);
        one.addActionListener(this);
        two = new JButton(buttonPicker());
        two.setBackground(Color.pink);
        two.setForeground(Color.blue);
        two.addActionListener(this);
        three = new JButton(buttonPicker());
        three.setBackground(Color.pink);
        three.setForeground(Color.blue);
        three.addActionListener(this);
        four = new JButton(buttonPicker());
        four.setBackground(Color.pink);
        four.setForeground(Color.blue);
        four.addActionListener(this);

        JPanel blankOne = new JPanel();
        blankOne.setBackground(Color.pink);
        JPanel blankTwo = new JPanel();
        blankTwo.setBackground(Color.pink);
        JPanel blankThree = new JPanel();
        blankThree.setBackground(Color.pink);
        one.setPreferredSize(new Dimension(((width / 5)), 30));
        blankOne.setPreferredSize(new Dimension(20, 50));
        blankTwo.setPreferredSize(new Dimension(20, 50));
        blankThree.setPreferredSize(new Dimension(20, 50));
        two.setPreferredSize(new Dimension(((width / 5)), 30));
        three.setPreferredSize(new Dimension(((width / 5)), 30));
        four.setPreferredSize(new Dimension(((width / 5)), 30));
        buttons.setLayout(new FlowLayout());

        buttons.add(one);
        buttons.add(blankOne);
        buttons.add(two);
        buttons.add(blankTwo);
        buttons.add(three);
        buttons.add(blankThree);
        buttons.add(four);
        myPane.add(buttons, BorderLayout.SOUTH);
        buttons.setVisible(true);
        getContentPane().validate();
    }

    private void newNameCall() { }

    /**
     * @author David O'Sullivan T00139303
     *
     * Contains the code that displays the names stored in the system
     */
    private void displayCall() {

        Color jtaBackGround = new Color(255, 182, 193);
        Color jtaForeground = new Color(8, 131, 178);
        JTextArea names = new JTextArea();
        names.setBackground(jtaBackGround);
        names.setForeground(jtaForeground);
        names.setSize(975, 200);
        Font myFont = new Font(Font.DIALOG, Font.PLAIN, 12);
        names.setFont(myFont);
        names.append("Female Names\n\n");
        for(int i = 0; i < Name.femaleNames.length; i++) {
            if(i == 22 || i == 46)
                names.append("\n");
            if(i == (Name.femaleNames.length - 1))
                names.append(String.format("%-5s", Name.femaleNames[i] + "."));
            else
                names.append(String.format("%-5s", Name.femaleNames[i] + ", "));
        }

        names.append("\n\nMale Names\n\n");

        for(int i = 0; i < Name.maleNames.length; i++) {
            if(i == 25)
                names.append("\n");
            if(i == (Name.maleNames.length - 1))
                names.append(Name.maleNames[i] + ".");
            else
                names.append(Name.maleNames[i] + ", ");
        }

        names.append("\n\nSurname\n\n");

        for(int i = 0; i < Name.surnames.length; i++) {
            if(i == 20 || i == 39)
                names.append("\n");
            if(i == (Name.surnames.length - 1))
                names.append(Name.surnames[i] + ".");
            else
                names.append(Name.surnames[i] + ", ");
        }
        names.setLineWrap(true);
        JOptionPane.showMessageDialog(null, names);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Contains the code that exits the Game
     */
    private void exitCall() {
        System.out.print("EXIT");
        System.exit(0);
    }

    /**
     * @author David O'Sullivan T00139303
     *
     * Contains the code that attempts to save the game
     *
     * @throws Exception
     */
    private void saveGame() throws Exception {

        try {
            if(j > 0) {
                File saveFile = new File("sgm.data");
                FileOutputStream fileOut = new FileOutputStream(saveFile);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

                objectOut.writeObject(playerPersonality);
                objectOut.close();
            } else
                JOptionPane.showMessageDialog(null, "You have yet to have a date which to save!");
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Apologies, There was an error saving the game");
        }
    }

    /**
     * @author David O'Sullivan
     *
     * Contains the code that attempts to load the game
     *
     * @throws Exception
     */
    public void loadGame() throws Exception {

        String personality;

        try {
            if(j > 0) {
                File loadFile = new File("sgm.data");
                FileInputStream fileIn = new FileInputStream(loadFile);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);

                Personality loadedPesron = (Personality) objectIn.readObject();
                personality = loadedPesron.toString();
                JOptionPane.showMessageDialog(null, personality);

                objectIn.close();
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Apologies, could not load data at this time");
        }
    }

    /**
     * @author David O'Sullivan - T00139303
     *
     * Contains the code that creates the player and displays the welcome text for thwe new Game
     */
    private void createPlayer() {

        playerQuestionsFrame = new JFrame("Welcome!");
        playerQuestionsFrame.setSize(600, 500);
        playerQuestionsFrame.setLocation(100, 100);
        playerQuestionsFrame.setResizable(false);
        playerQuestionsFrame.setBackground(Color.pink);

        JTextArea welcomeText = new JTextArea("        Hello and welcome to Dating Simulator 2017!\n" +
                "\n Before we begin, we would like to ask you a few questions " +
                "\n as to better help you with your date selection.\n" +
                "\n These are just situational questions that we have derived" +
                "\n From a tried and tested Psychological study often used in " +
                "\n in the dating world. Don't worry, your answers are " +
                "\n strictly confidential, but do try to answer as honestly as possible. " +
                "\n\n Remember, there is no such thing as a wrong answer!" +
                "\n\n\n                  Good Luck!");
        welcomeText.setSize(580, 400);
        welcomeText.setBackground(Color.pink);
        welcomeText.setForeground(Color.blue);
        welcomeText.setFont(new Font("Ariel", Font.PLAIN, 16));
        playerQuestionsFrame.add(welcomeText);
        welcomeText.setLineWrap(true);
        welcomeText.setLayout(new FlowLayout());
        playerQuestionsFrame.setLayout(new FlowLayout());

        welcomeContinue = new JButton("Continue");
        welcomeContinue.setBackground(Color.pink);
        welcomeContinue.setForeground(Color.blue);
        playerQuestionsFrame.add(welcomeContinue);
        welcomeContinue.addActionListener(this);
        playerQuestionsFrame.setVisible(true);
    }

    /**
     * @author David O'Sullivan - t00139303
     *
     * Contains the code that Displays the questions that decide the type of player is playiing
     */

    private void playerQuestions() {

        questionTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionTime.setSize(500, 200);
        questionTime.setLocation(200, 200);
        questionTime.setLayout(new BorderLayout());
        questionTime.setBackground(Color.pink);
        questionHolder = new JTextArea();


        notLikely = new JButton("Not Likely");
        notLikely.addActionListener(this);
        somewhatLikely = new JButton("Somewhat Likely");
        somewhatLikely.addActionListener(this);
        likely = new JButton("Likely");
        likely.addActionListener(this);
        notLikely.setSize(100, 30);
        somewhatLikely.setSize(100, 30);
        likely.setSize(100, 30);
        likely.setBackground(Color.pink);
        notLikely.setBackground(Color.pink);
        somewhatLikely.setBackground(Color.pink);
        likely.setForeground(Color.blue);
        somewhatLikely.setForeground(Color.blue);
        notLikely.setForeground(Color.blue);


        questionHolder.append(questionText());
        questionHolder.setLineWrap(true);
        questionHolder.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        questionHolder.setBackground(Color.pink);
        questionHolder.setForeground(Color.blue);
        questionHolder.setEditable(false);
        questionButtons = new JPanel();
        questionButtons.setLayout(new FlowLayout());
        questionButtons.add(notLikely);
        questionButtons.add(somewhatLikely);
        questionButtons.add(likely);
        questionButtons.setBackground(Color.pink);
        questionTime.add(questionHolder, BorderLayout.CENTER);
        questionTime.add(questionButtons, BorderLayout.SOUTH);


        questionTime.setVisible(true);


    }

    /**
     * @author David O'Sullivan
     *
     * Contains the code returns the text depending on what question is being asked
     *
     * @return text of type String
     */

    private static String questionText() {
        String text;

        if(i == 1) //Empathy Text
            text = "You walk across the road with a friend, going for a drink,  when you" +
                    " see an old lady behind you trying to cross also.   The lights are turning red again so you will" +
                    " have to wait   with her for another three minutes if you go back. How      " +
                    "likely are you to help her?";

        else if(i == 2) //Honesty text
            text = "You are walking down the street when you find a wallet brimming with 50 euro notes. " +
                    "There is no one around and you know you could get away with putting it in your pocket. " +
                    "How likely are you to turn it in to the police station, or try to find the owner on Facebook?";

        else if(i == 3) //Courage text
            text = "You are on a night out. Everyone is laughing and joking and generally having a good time." +
                    "As you are leaving, you spot a man you've never seen before being attacked as he walks down " +
                    "the road. How likely are you to intervene?";

        else if(i == 4) //Humour text
            text = "You are out for a walk with your friend on a cold, crisp winters morning when your friend slips on" +
                    "the ice, uninjured. How likely are you to fall beside your friend with laughter?";

        else if(i == 5) //Creativity text
            text = "You walk past a man in the street handing out fliers that advertise the introduction of an up and " +
                    "coming artists work in a gallery that is an hours drive from your house. You have heard of them " +
                    "somewhat through social media and are aware that it may well be some interesting art. How likely " +
                    "are you to go?";
        else if(i == 6) //Self Awareness text
            text = "You are at a party and an old school mate is there. You didn't particularly get on with him" +
                    "and found him to be quite annoying. He brings up an embarrassing story about you in front of a " +
                    "crowd in order to make himself look charismatic How likely are you to laugh along with him in order" +
                    "to not cause a scene";
        else if(i == 7) //Integrity text
            text = "The same person seems to have forgotten that you were in the classroom the same day he did not make " +
                    "it to the toilet on time. When he has his story told, how likely are you to remind him in front of " +
                    "the same crowd?";
        else if(i == 8) //Curiosity text
            text = "An ex-partner of yours that you parted ways with amicably sends you a message asking to meet for a drink " +
                    "saying that they have split from their current partner. How likely are you to take them up on their offer?";
        else if(i == 9) //Intelligence text
            text = "You have been asked to go for dinner on a friday evening, but you have been reading a historical book of " +
                    "an area that you have great interest in. It has been a long week, but you are interested in the book. " +
                    "How likely are you to abandon the book in favor of a night's wining and dining?";
        else
            text = "";


        return text;
    }

    /**
     * @author David O'Sullivan - T00139303
     *
     * Contains the code that ask the user what gender they would like to date in order to select a random name
     */

    public void genderSelect() {
        String genderString = JOptionPane.showInputDialog("Please enter what gender you would like to date? 'M'ale or 'F'emale");
        boolean valid = false;
        gender = genderString.toUpperCase().charAt(0);
        while(!valid) {
            if(gender == 'M' || gender == 'F') {
                Game.computerName.setGender(gender);
                name = Name.getName(Game.computerName);
                valid = true;
            } else {
                genderString = JOptionPane.showInputDialog("Please enter what gender you would like to date? 'M'ale or 'F'emale");
                gender = genderString.toUpperCase().charAt(0);
            }
        }
    }

    /**
     * @author David O'Sullivan - T00139303
     *
     * Contains the code that sets the text to the four buttons that determine the topic of conversation
     *
     * @return buttonText[randomNumber] of type String
     */
    private static String buttonPicker() {

        String buttonText[] = new String[50];

        for(int buttonPicker = 0; buttonPicker < buttonText.length; buttonPicker++) {
            if(buttonPicker < 10)
                buttonText[buttonPicker] = Game.earthInterest[buttonPicker];
            else if(buttonPicker >= 10 && buttonPicker < 20)
                buttonText[buttonPicker] = Game.waterInterest[(buttonPicker - 10)];
            else if(buttonPicker >= 20 && buttonPicker < 30)
                buttonText[buttonPicker] = Game.fireInterest[(buttonPicker - 20)];
            else if(buttonPicker >= 30 && buttonPicker < 40)
                buttonText[buttonPicker] = Game.windInterest[(buttonPicker - 30)];
            else
                buttonText[buttonPicker] = Game.averageInterest[(buttonPicker - 40)];
        }

        return buttonText[(int) (Math.random() * 50)];
    }
}