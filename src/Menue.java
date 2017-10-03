import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menue {

    JFrame frame = new JFrame("Maze Runner Multiplayer");
    JLabel picLabel;


    public Menue(){

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/Maze_Background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        picLabel = new JLabel(new ImageIcon(myPicture));
        frame.add(picLabel);
        frame.setSize(705,705);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String [] args){
        new Menue();
    }
}
