package Mazerunner;

import javax.swing.*;
import java.awt.*;

class MazePanel extends JPanel {
    private Maze maze;

    public MazePanel(Maze theMaze)
    {
        maze = theMaze;
    }


    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);

        setBackground(Color.white);

        maze.draw(page);

        Graphics2D g2d = (Graphics2D) page;

        g2d.drawOval(5, 5, 10, 10);

        g2d.setColor(Color.red);
    }
}