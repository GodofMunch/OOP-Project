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
    private JLabel meHolder = new JLabel(me);
    private JLabel coupleHolder = new JLabel(couple);
    private static JTextArea questionHolder;
    private static JFrame playerQuestionsFrame;
    private static JPanel questionButtons;
    private static JFrame questionTime;
    private static JButton welcomeContinue;
    private static JButton notLikely;
    private static JButton somewhatLikely;
    private static JButton likely;
    private final int width = 800;

    public static void main(String args[]) {
        GUI2 myGUI = new GUI2();
        myGUI.setVisible(true);
    }

    //C:\Users\HP\Documents\GitHub\OOP-Project\
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
            //newGameCall();
            playerQuestions();
        }
    }

    private void newGameCall() {

       /* System.out.print("New Game");
        myPane.remove(coupleHolder);
        myPane.add(meHolder, BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton one = new JButton();
        one.setBackground(Color.pink);
        try {
            Image tv = ImageIO.read(getClass().getResource("Resources/Images/tv.png"));
            one.setIcon(new ImageIcon(tv));
        } catch(Exception ex) {
            System.out.println(ex);
        }

        createPlayer();

        JButton two = new JButton("Two");
        JButton three = new JButton("Three");
        JButton four = new JButton("Four");

        JPanel blankOne = new JPanel();
        JPanel blankTwo = new JPanel();
        JPanel blankThree = new JPanel();
        one.setPreferredSize(new Dimension(((width / 7)), 50));
        blankOne.setPreferredSize(new Dimension(((width / 8) - 5), 50));
        blankTwo.setPreferredSize(new Dimension(((width / 8) - 5), 50));
        blankThree.setPreferredSize(new Dimension(((width / 8) - 5), 50));
        two.setPreferredSize(new Dimension(((width / 7)), 30));
        three.setPreferredSize(new Dimension(((width / 7)), 30));
        four.setPreferredSize(new Dimension(((width / 7)), 30));
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
        getContentPane().validate();*/
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
        Personality playerPersonality = new Personality();

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
        ButtonHandler continueHandler = new ButtonHandler();
        welcomeContinue.addActionListener(continueHandler);
        playerQuestionsFrame.setVisible(true);
    }

    private class ButtonHandler implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == welcomeContinue)
            {
                playerQuestions();
                playerQuestionsFrame.setVisible(false);
            }
        }
    }

    private void playerQuestions() {

        questionTime = new JFrame(("Questions"));
        questionTime.setSize(800, 200);
        questionTime.setLocation(200, 200);
        questionTime.setLayout(new BorderLayout());
        questionTime.setBackground(Color.pink);

        notLikely = new JButton("Not Likely");
        somewhatLikely = new JButton("Somewhat Likely");
        likely = new JButton("Likely");

        for(int i =1;i<=9;i++) {
            if(i == 1) {
                questionHolder = new JTextArea("  You walk across the road with a friend , going for a drink, when you" +
                        " see    an old lady behind you tryng to cross also. The lights are turning red again  so you will" +
                        " have to wait wih her for another three minutes if you go back. How likely are you to help her");

                questionHolder.setLineWrap(true);
                questionHolder.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
            }


        }


        questionButtons = new JPanel();
        questionButtons.setLayout(new FlowLayout());
        questionButtons.add(notLikely);
        questionButtons.add(somewhatLikely);
        questionButtons.add(likely);
        notLikely.setSize(100,30);
        somewhatLikely.setSize(100,30);
        likely.setSize(100,30);
        likely.setBackground(Color.pink);
        notLikely.setBackground(Color.pink);
        somewhatLikely.setBackground(Color.pink);
        likely.setForeground(Color.blue);
        somewhatLikely.setForeground(Color.blue);
        notLikely.setForeground(Color.blue);
        questionTime.add(questionHolder, BorderLayout.CENTER);
        questionTime.add(questionButtons, BorderLayout.SOUTH);
        questionTime.setVisible(true);


    }
}