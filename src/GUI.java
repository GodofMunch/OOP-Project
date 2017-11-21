import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame{

    JMenu fileMenu, namesMenu;

    public static void main(String args[]) {
        GUI myGUI = new GUI();
        myGUI.setVisible(true);
    }

    public GUI() {
    this.setTitle("Dating Simulator 2017");
    int width = 800, height = 650;
    Container myPane = getContentPane();
    myPane.setLayout(new BorderLayout());
    this.add(new JLabel(new ImageIcon("C:\\Users\\t00139303\\Desktop\\OOP-Project\\Images\\Couple.jpg")), BorderLayout.CENTER);
    setBounds(300,200, width, height);


    createFileMenu();
    createNamesMenu();
    JButton startGame = new JButton("New Game");
/*
Create a JPanel

add the button to the jpanel

this uses a flow layout

add button to panel

and panel to frame.south
 */
    JPanel introPanel = new JPanel();
    introPanel.add(new JButton("New Game"));
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

        item = new JMenuItem("Exit");
        fileMenu.add(item);
    }

    private void createNamesMenu() {

        namesMenu = new JMenu("Names");

        JMenuItem item;

        item = new JMenuItem("New");
        namesMenu.add(item);

        item = new JMenuItem("Display");
        namesMenu.add(item);
    }

    public int playerQuestion(String s) {
        int i=0;
        return i;
    }
}


