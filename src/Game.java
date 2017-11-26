import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    private JFrame window;
    Container gamePane;

    public static void main(String args[]) {
        Game newGame = new Game();

    }

    public Game() {
        window = new JFrame("Dating Simulator 2017");
        window.setVisible(true);
        window.setSize(800,200);
        window.setLocation(100,100);
        window.setLayout(new BorderLayout());
        window.add(new GUI().fileMenu);
        window.add(new GUI().namesMenu);

        gamePane = new Container();
        gamePane.setVisible(true);
        gamePane.setSize(400,50);
        gamePane.setBackground(new Color(100,200,200));

        window.add(gamePane, BorderLayout.SOUTH);

    }
}
