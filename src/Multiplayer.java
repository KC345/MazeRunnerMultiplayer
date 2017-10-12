import javax.swing.*;

public class Multiplayer {

    JFrame multiframe;

    public Multiplayer(){

        multiframe = new JFrame("Maze Runner Multiplayer");

        multiframe.pack();
        multiframe.setLocationRelativeTo(null);
        multiframe.setVisible(true);
        multiframe.setSize(705,705);
        multiframe.setResizable(false);
        multiframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
