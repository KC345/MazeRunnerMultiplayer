import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menue {

    JFrame frame = new JFrame("Maze Runner Multiplayer");
    JLabel picLabel;
    JButton solo = new JButton("Einzelspieler");
    JButton multi = new JButton("Multiplayer");
    JButton cont = new JButton("Steuerung anzeigen");


    public Menue(){

        frame.setLayout(new GridLayout(1,1));

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/Maze_Background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        picLabel = new JLabel(new ImageIcon(myPicture));
        picLabel.setLayout(new FlowLayout());

        solo.setBounds(200,150,50,50);

        picLabel.add(solo);
        picLabel.add(multi);
        picLabel.add(cont);

        frame.add(picLabel);

        frame.setSize(705,705);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String [] args){
        new Menue();
    }
}
