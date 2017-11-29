import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToolBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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
    private static JFrame questionTime = new JFrame(("Questions"));
    private static JButton welcomeContinue;
    private static JButton notLikely;
    private static JButton somewhatLikely;
    private static JButton likely;
    public static JProgressBar score;
    private final int width = 800;
    private static int i = 1;
    public static Personality playerPersonality = new Personality();
    private static char gender;
    public static Person player = new Person(gender);
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;

    public static void main(String args[]) {
        GUI2 myGUI = new GUI2();
        myGUI.setVisible(true);
    }

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
            i = 0;
        }

        if(e.getSource() == welcomeContinue) {
            //System.out.print("ASKING QUESTIONS");
            playerQuestionsFrame.setVisible(false);
            playerQuestions();
        }
        if(i > 1)
            playerQuestions();
        if(i == 1 && e.getSource() == notLikely) {
            playerPersonality.setEmpathy(randomLow());
        }
        if(i == 1 && e.getSource() == somewhatLikely) {
            playerPersonality.setEmpathy(randomMid());
        }
        if(i == 1 && e.getSource() == likely) {
            playerPersonality.setEmpathy(randomHigh());
        }

        //Empathy


        if(i == 2 && e.getSource() == notLikely) {
            playerPersonality.setHonesty(randomLow());
        }
        if(i == 2 && e.getSource() == somewhatLikely) {
            playerPersonality.setHonesty(randomMid());
        }
        if(i == 2 && e.getSource() == likely) {
            playerPersonality.setHonesty(randomHigh());
        }

        //Honesty


        if(i == 3 && e.getSource() == notLikely) {
            playerPersonality.setCourage(randomLow());
        }
        if(i == 3 && e.getSource() == somewhatLikely) {
            playerPersonality.setCourage(randomMid());
        }
        if(i == 3 && e.getSource() == likely) {
            playerPersonality.setCourage(randomHigh());
        }

        //Courage


        if(i == 4 && e.getSource() == notLikely) {
            playerPersonality.setHumour(randomLow());
        }
        if(i == 4 && e.getSource() == somewhatLikely) {
            playerPersonality.setHumour(randomMid());
        }
        if(i == 4 && e.getSource() == likely) {
            playerPersonality.setHumour(randomHigh());
        }

        //Humour


        if(i == 5 && e.getSource() == notLikely) {
            playerPersonality.setCreativity(randomLow());
        }
        if(i == 5 && e.getSource() == somewhatLikely) {
            playerPersonality.setCreativity(randomMid());
        }
        if(i == 5 && e.getSource() == likely) {
            playerPersonality.setCreativity(randomHigh());
        }
        //Creativity


        if(i == 6 && e.getSource() == notLikely) {
            playerPersonality.setSelfAwareness(randomLow());
        }
        if(i == 6 && e.getSource() == somewhatLikely) {
            playerPersonality.setSelfAwareness(randomMid());
        }
        if(i == 6 && e.getSource() == likely) {
            playerPersonality.setSelfAwareness(randomHigh());
        }
        //Self Awareness


        if(i == 7 && e.getSource() == notLikely) {
            playerPersonality.setIntegrity(randomHigh());
        }
        if(i == 7 && e.getSource() == somewhatLikely) {
            playerPersonality.setIntegrity(randomMid());
        }
        if(i == 7 && e.getSource() == likely) {
            playerPersonality.setIntegrity(randomLow());
        }
        //Integrity low is high


        if(i == 8 && e.getSource() == notLikely) {
            playerPersonality.setCuriosity(randomLow());
        }
        if(i == 8 && e.getSource() == somewhatLikely) {
            playerPersonality.setCuriosity(randomMid());
        }
        if(i == 8 && e.getSource() == likely) {
            playerPersonality.setCuriosity(randomHigh());
        }
        //Curiosity


        if(i == 9 && e.getSource() == notLikely) {
            playerPersonality.setIntelligence(randomHigh());
        }
        if(i == 9 && e.getSource() == somewhatLikely) {
            playerPersonality.setIntelligence(randomMid());
        }
        if(i == 9 && e.getSource() == likely) {
            playerPersonality.setIntelligence(randomLow());
        }//Intelligence low is high
        //questionTime.setVisible(false);

        if(i == 10) {
            questionTime.setVisible(false);
            gender = genderSelect();
            //Game.computerName.setGender(gender);
            i++;
        }

        if(i == 11) {
            Game.startGame();
            newGameCall();
        }
        i++;

        String type = Personality.getPersonalityType(Game.computerPersonality);
        boolean goodGuess = false;

        if(e.getSource() == one) {
            if(type.equals("Earth")) {
                for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
                    if(one.getText().equals(Game.earthInterest[earthCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveEarth();
                } else {
                    Game.negativeEarth();
                }
            }

            if(type.equals("Wind")) {
                for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
                    if(one.getText().equals(Game.windInterest[windCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWind();
                } else {
                    Game.negativeWind();
                }
            }

            if(type.equals("Fire")) {
                for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
                    if(one.getText().equals(Game.fireInterest[fireCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveFire();
                } else {
                    Game.negativeFire();
                }
            }

            if(type.equals("Water")) {
                for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
                    if(one.getText().equals(Game.waterInterest[waterCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWater();
                } else {
                    Game.negativeWater();
                }
            }

        }
        if(e.getSource() == one) {
            if(type.equals("Earth")) {
                for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
                    if(one.getText().equals(Game.earthInterest[earthCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveEarth();
                } else {
                    Game.negativeEarth();
                }
            }

            if(type.equals("Wind")) {
                for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
                    if(one.getText().equals(Game.windInterest[windCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWind();
                } else {
                    Game.negativeWind();
                }
            }

            if(type.equals("Fire")) {
                for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
                    if(one.getText().equals(Game.fireInterest[fireCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveFire();
                } else {
                    Game.negativeFire();
                }
            }

            if(type.equals("Water")) {
                for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
                    if(one.getText().equals(Game.waterInterest[waterCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWater();
                } else {
                    Game.negativeWater();
                }
            }

        }

        if(e.getSource() == two) {
            if(type.equals("Earth")) {
                for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
                    if(two.getText().equals(Game.earthInterest[earthCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveEarth();
                } else {
                    Game.negativeEarth();
                }
            }

            if(type.equals("Wind")) {
                for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
                    if(two.getText().equals(Game.windInterest[windCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWind();
                } else {
                    Game.negativeWind();
                }
            }

            if(type.equals("Fire")) {
                for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
                    if(two.getText().equals(Game.fireInterest[fireCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveFire();
                } else {
                    Game.negativeFire();
                }
            }

            if(type.equals("Water")) {
                for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
                    if(two.getText().equals(Game.waterInterest[waterCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWater();
                } else {
                    Game.negativeWater();
                }
            }

        }
        if(e.getSource() == three) {
            if(type.equals("Earth")) {
                for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
                    if(three.getText().equals(Game.earthInterest[earthCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveEarth();
                } else {
                    Game.negativeEarth();
                }
            }

            if(type.equals("Wind")) {
                for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
                    if(three.getText().equals(Game.windInterest[windCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWind();
                } else {
                    Game.negativeWind();
                }
            }

            if(type.equals("Fire")) {
                for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
                    if(three.getText().equals(Game.fireInterest[fireCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveFire();
                } else {
                    Game.negativeFire();
                }
            }

            if(type.equals("Water")) {
                for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
                    if(three.getText().equals(Game.waterInterest[waterCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWater();
                } else {
                    Game.negativeWater();
                }
            }

        }
        if(e.getSource() == one) {
            if(type.equals("Earth")) {
                for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
                    if(one.getText().equals(Game.earthInterest[earthCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveEarth();
                } else {
                    Game.negativeEarth();
                }
            }

            if(type.equals("Wind")) {
                for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
                    if(one.getText().equals(Game.windInterest[windCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWind();
                } else {
                    Game.negativeWind();
                }
            }

            if(type.equals("Fire")) {
                for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
                    if(one.getText().equals(Game.fireInterest[fireCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveFire();
                } else {
                    Game.negativeFire();
                }
            }

            if(type.equals("Water")) {
                for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
                    if(one.getText().equals(Game.waterInterest[waterCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWater();
                } else {
                    Game.negativeWater();
                }
            }

        }
        if(e.getSource() == four) {
            if(type.equals("Earth")) {
                for(int earthCheck = 0; earthCheck < Game.earthInterest.length; earthCheck++) {
                    if(four.getText().equals(Game.earthInterest[earthCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveEarth();
                } else {
                    Game.negativeEarth();
                }
            }

            if(type.equals("Wind")) {
                for(int windCheck = 0; windCheck < Game.windInterest.length; windCheck++) {
                    if(four.getText().equals(Game.windInterest[windCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWind();
                } else {
                    Game.negativeWind();
                }
            }

            if(type.equals("Fire")) {
                for(int fireCheck = 0; fireCheck < Game.fireInterest.length; fireCheck++) {
                    if(four.getText().equals(Game.fireInterest[fireCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveFire();
                } else {
                    Game.negativeFire();
                }
            }

            if(type.equals("Water")) {
                for(int waterCheck = 0; waterCheck < Game.waterInterest.length; waterCheck++) {
                    if(four.getText().equals(Game.waterInterest[waterCheck])) {
                        goodGuess = true;
                    }
                }

                if(goodGuess) {
                    Game.positiveWater();
                } else {
                    Game.negativeWater();
                }
            }

        }


    }

    private int randomMid() {
        return (int) (Math.random() * 4 + 4);
    }

    private int randomLow() {
        return (int) (Math.random() * 3 + 1);
    }

    private int randomHigh() {
        return (int) (Math.random() * 3 + 7);
    }

    private void newGameCall() {

        //System.out.print("New Game");
        myPane.remove(coupleHolder);
        if(gender == 'M')
            myPane.add(manHolder, BorderLayout.CENTER);
        else
            myPane.add(womanHolder, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.pink);

        /*try {
            Image tv = ImageIO.read(getClass().getResource("Resources/Images/tv.png"));
            one.setIcon(new ImageIcon(tv));
        } catch(Exception ex) {
            System.out.println(ex);
        }*/


        //https://stackoverflow.com/questions/15199091/progress-bar-java
        JPanel scoreHolder = new JPanel();
        scoreHolder.setLayout(new FlowLayout());
        String type = Personality.getPersonalityType(Game.computerPersonality);
        String name = Name.getName(Game.computerName);
        Game.computerName.setGender(genderSelect());
        JLabel typeDisplay = new JLabel(type);
        JLabel nameDisplay = new JLabel(name);
        scoreHolder.add(typeDisplay);
        scoreHolder.setBackground(Color.pink);
        score = new JProgressBar(0, 100);
        score.setValue(50);
        score.setBackground(Color.pink);
        score.setForeground(Color.blue);
        JToolBar scoreToolbar = new JToolBar();
        scoreToolbar.add(scoreHolder);
        //scoreHolder.add(nameDisplay);
        scoreToolbar.setPreferredSize(new Dimension(width, 40));
        scoreHolder.add(score);

        myPane.add(scoreToolbar, BorderLayout.NORTH);

        one = new JButton(buttonPicker());
        one.setBackground(Color.pink);
        one.setForeground(Color.blue);
        two = new JButton(buttonPicker());
        two.setBackground(Color.pink);
        two.setForeground(Color.blue);
        three = new JButton(buttonPicker());
        three.setBackground(Color.pink);
        three.setForeground(Color.blue);
        four = new JButton(buttonPicker());
        four.setBackground(Color.pink);
        four.setForeground(Color.blue);

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

    private void newNameCall() {

    }

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

    private void exitCall() {
        System.out.print("EXIT");
        System.exit(0);
    }

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
        welcomeText.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
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

    private void playerQuestions() {

        questionTime.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionTime.setSize(500, 200);
        questionTime.setLocation(200, 200);
        questionTime.setLayout(new BorderLayout());
        questionTime.setBackground(Color.pink);
        questionHolder = new JTextArea();
        notLikely = new JButton("Not Likely");
        somewhatLikely = new JButton("Somewhat Likely");
        likely = new JButton("Likely");
        questionHolder.append(questionText());
        questionHolder.setLineWrap(true);
        questionHolder.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        questionHolder.setBackground(Color.pink);
        questionHolder.setForeground(Color.blue);
        questionHolder.setEditable(false);
        questionHolder.validate();
        questionButtons = new JPanel();
        questionButtons.setLayout(new FlowLayout());
        questionButtons.add(notLikely);
        questionButtons.add(somewhatLikely);
        questionButtons.add(likely);
        questionButtons.setBackground(Color.pink);
        notLikely.setSize(100, 30);
        somewhatLikely.setSize(100, 30);
        likely.setSize(100, 30);
        likely.setBackground(Color.pink);
        notLikely.setBackground(Color.pink);
        somewhatLikely.setBackground(Color.pink);
        likely.setForeground(Color.blue);
        somewhatLikely.setForeground(Color.blue);
        notLikely.setForeground(Color.blue);
        questionTime.add(questionHolder, BorderLayout.CENTER);
        questionTime.add(questionButtons, BorderLayout.SOUTH);
        notLikely.addActionListener(this);
        somewhatLikely.addActionListener(this);
        likely.addActionListener(this);

        questionTime.setVisible(true);


    }

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

    public static char genderSelect() {
        char gender;
        String genderString = JOptionPane.showInputDialog("Please enter what gender you would like to date? 'M'ale or 'F'emale");
        boolean valid = false;
        gender = genderString.toUpperCase().charAt(0);

        while(!valid) {
            if(gender == 'M' || gender == 'F') {
                valid = true;
            } else {
                genderString = JOptionPane.showInputDialog("Please enter what gender you would like to date? 'M'ale or 'F'emale");
                gender = genderString.toUpperCase().charAt(0);
            }
        }
        return gender;
    }

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

        return buttonText[(int) (Math.random() * 50) + 1];
    }
}