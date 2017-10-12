import javax.swing.*;

public class Multiplayer {

    JFrame multiframe;

    public Multiplayer(){

        multiframe = new JFrame("Maze Runner Multiplayer");

        multiframe.pack();
        multiframe.setLocationRelativeTo(null);
        multiframe.setVisible(true);
        multiframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
