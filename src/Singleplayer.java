import javax.swing.*;
import java.awt.*;

public class Singleplayer {

    JFrame singleframe;
    MazePanel playfield;


    public Singleplayer(){

        singleframe = new JFrame("Maze Runner Multiplayer");

        int size = 20 ;
        Maze maze = new Maze(size);
        playfield = new MazePanel(maze);

        singleframe.add(playfield);
        singleframe.pack();
        singleframe.setVisible(true);
        singleframe.setSize(500,550);
        singleframe.setResizable(false);
        singleframe.setLocationRelativeTo(null);
        singleframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void paintComponent(Graphics g) {
        playfield.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(5, 5, 1000, 1000);
        g2d.setColor(Color.red);
        playfield.repaint();
        }
}

