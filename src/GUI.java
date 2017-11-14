import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    JMenu fileMenu, namesMenu;

    public static void main(String args[])
    {
        GUI myGUI = new GUI();
        myGUI.setVisible(true);
    }

    public GUI() {
    this.setTitle("Dating Simulator 2017");
    int width = 800, height = 650;

    setBounds(300,200, width, height);
    Container myPane = getContentPane();
    Color lightPink = new Color(240,210,240);
    myPane.setBackground(lightPink);

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
}
