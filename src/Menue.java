import javax.swing.*;

public class Menue {

    JFrame frame = new JFrame("Maze Runner Multiplayer");

    public Menue(){


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String [] args){
        new Menue();
    }
}
