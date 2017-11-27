import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI2 extends JFrame implements ActionListener {

    public JMenu fileMenu;
    public JMenu namesMenu;
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
            newGameCall();
        }
    }

    private void newGameCall() {

        System.out.print("New Game");
        myPane.remove(coupleHolder);
        myPane.add(meHolder, BorderLayout.CENTER);

        JPanel buttons = new JPanel();

        JButton one = new JButton();
        one.setBackground(Color.pink);
        try{
        Image tv = ImageIO.read(getClass().getResource("Resources/Images/tv.png"));
        one.setIcon(new ImageIcon(tv));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        /*try {
            Image
        }*/


        JButton two = new JButton("Two");
        JButton three = new JButton("Three");
        JButton four = new JButton("Four");


        JPanel blankOne = new JPanel();
        JPanel blankTwo = new JPanel();
        JPanel blankThree = new JPanel();
        one.setPreferredSize(new Dimension(((width/7)),50));
        blankOne.setPreferredSize( new Dimension(((width/8)-5),50));
        blankTwo.setPreferredSize( new Dimension(((width/8)-5),50));
        blankThree.setPreferredSize( new Dimension(((width/8)-5),50));
        two.setPreferredSize(new Dimension(((width/7)),30));
        three.setPreferredSize(new Dimension(((width/7)),30));
        four.setPreferredSize(new Dimension(((width/7)),30));
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


}