import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;

public class GUI extends JFrame{

    JMenu fileMenu, namesMenu;
    Container myPane;
    JButton startGame;
    JMenuItem newName, display, exit, save, open;

    public static void main(String args[]) {
        GUI myGUI = new GUI();
        myGUI.setVisible(true);
    }

    public GUI() {
    this.setTitle("Dating Simulator 2017");
    int width = 800, height = 650;
    myPane = getContentPane();
    myPane.setLayout(new BorderLayout());
    this.add(new JLabel(new ImageIcon("C:\\Users\\t00139303\\Documents\\GitHub\\OOP-Project\\Images\\Couple.jpg")), BorderLayout.CENTER);
    this.add(new JLabel(new ImageIcon("C:\\Users\\HP\\Documents\\GitHub\\OOP-Project\\Images\\Couple.jpg")), BorderLayout.CENTER);
    setBounds(300,200, width, height);
    setLocation (50,50);


    createFileMenu();
    createNamesMenu();
    startGame = new JButton("New Game");
    JPanel introPanel = new JPanel();
    introPanel.add(startGame);
    ButtonEventHandler newGame = new ButtonEventHandler();
    startGame.addActionListener(newGame);

    myPane.add(introPanel, BorderLayout.SOUTH);
    JMenuBar myMenuBar = new JMenuBar();
    setJMenuBar(myMenuBar);
    myMenuBar.add(fileMenu);
    myMenuBar.add(namesMenu);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createFileMenu() {
        fileMenu = new JMenu("File");

        MenuItemHandler fileHandler = new MenuItemHandler();

        save = new JMenuItem("Save");
        fileMenu.add(save);
        save.addActionListener(fileHandler);

        open = new JMenuItem("Open");
        fileMenu.add(open);
        open.addActionListener(fileHandler);


        exit = new JMenuItem("Exit");
        fileMenu.add(exit);
        exit.addActionListener(fileHandler);
    }

    private void createNamesMenu() {

        MenuItemHandler namesHandler = new MenuItemHandler();

        namesMenu = new JMenu("Names");

        newName = new JMenuItem("New");
        newName.addActionListener(namesHandler);
        namesMenu.add(newName);
        display = new JMenuItem("Display");
        display.addActionListener(namesHandler);
        namesMenu.add(display);
    }

    private class ButtonEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==startGame) {
                JOptionPane.showMessageDialog(null, "You have begun a new game");
            }

        }
    }

    private class MenuItemHandler implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == newName) {
                newNameCall();
            }

            if(e.getSource() == display){
                displayCall();
            }

            if(e.getSource()==exit) {
                exitCall();
            }
        }
    }

    private void newNameCall() {

    }

    private void displayCall() {

        JTextArea names = new JTextArea();
        names.setSize(975,200);
        Font myFont = new Font(Font.MONOSPACED, Font.PLAIN, 12);
        names.setFont(myFont);
        names.append("Female Names\n\n");
        for(int i = 0; i < Name.femaleNames.length; i++ ) {
            if(i==36)
                names.append("\n");
            if(i==(Name.femaleNames.length-1))
                names.append(String.format("%-5s", Name.femaleNames[i] + "."));
            else
                names.append(String.format("%-5s", Name.femaleNames[i] + ", "));
        }

        names.append("\n\nMale Names\n\n");

        for (int i=0; i<Name.maleNames.length;i++) {
            if(i==20)
                names.append("\n");
            if(i==(Name.maleNames.length-1))
                names.append(Name.maleNames[i] + ".");
            else
                names.append(Name.maleNames[i] + ", ");
        }

        names.append("\n\nSurname\n\n");

        for(int i =0; i<Name.surnames.length;i++) {
            if(i==16 || i==31)
                names.append("\n");
            if(i==(Name.surnames.length-1))
                names.append(Name.surnames[i] + ".");
            else
                names.append(Name.surnames[i] + ", ");
        }
        JScrollPane scroller = new JScrollPane(names,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        names.setLineWrap(true);
        JOptionPane.showMessageDialog (null, names);
    }

    private void exitCall(){
        System.out.print("EXIT");
        System.exit(0);
    }
}


