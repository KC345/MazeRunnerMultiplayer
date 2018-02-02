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

        setBackground(Color.white); // set preferredSize for JScrollPane

        maze.draw(page);
    }
}