import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame{

    JMenu fileMenu, namesMenu;
    Container myPane;
    JButton startGame;
    JMenuItem newGame, display, exit;

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
    setBounds(300,200, width, height);


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

        JMenuItem item;

        item = new JMenuItem("Save");
        fileMenu.add(item);

        item = new JMenuItem("Open");
        fileMenu.add(item);

        exit = new JMenuItem("Exit");
        fileMenu.add(exit);
    }

    private void createNamesMenu() {

        namesMenu = new JMenu("Names");

        newGame = new JMenuItem("New");
        namesMenu.add(newGame);

        display = new JMenuItem("Display");
        namesMenu.add(display);
    }

    private class ButtonEventHandler implements ActionListener{

        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==startGame) {
                myPane.setVisible(false);
                JOptionPane.showMessageDialog(null, "You have begun a new game");
            }

            if(e.getSource()==fileMenu){

            }
            if(e.getSource() == display){
             JTextArea names = new JTextArea();

             names.append("Female Names\n\n");

             for(int i = 0; i < Name.femaleNames.length; i++ ) {
                 names.append(Name.femaleNames[i] + "\n");
             }

             names.append("\n\nMale Names\n\n");

             for (int i=0; i<Name.maleNames.length;i++) {
                 names.append(Name.maleNames[i]);
             }

             names.append("\n\nSurname\n\n");

             for(int i =0; i<Name.surnames.length;i++) {
                 names.append(Name.surnames[i]);
             }
             JOptionPane.showMessageDialog(null, names);
            }

            if(e.getSource()==exit) {
                System.out.print("EXIT");
                System.exit(0);
            }
        }
    }
}


