import javax.swing.*;

public class Singleplayer {

    JFrame singleframe;

    public Singleplayer(){

        singleframe = new JFrame("Maze Runner Multiplayer");

        singleframe.pack();
        singleframe.setLocationRelativeTo(null);
        singleframe.setVisible(true);
        singleframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
