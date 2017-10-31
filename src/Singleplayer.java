import javax.swing.*;

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
        singleframe.setLocationRelativeTo(null);
        singleframe.setVisible(true);
        singleframe.setSize(500,550);
        singleframe.setResizable(false);
        singleframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
