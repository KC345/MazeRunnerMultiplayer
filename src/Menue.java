import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;

public class Menue {

    JFrame frame = new JFrame("Maze Runner Multiplayer");
    JLabel picLabel;
    JPanel buttonPannel = new JPanel();
    JButton solo = new JButton("Einzelspieler");
    JButton multi = new JButton("Multiplayer");
    JButton cont = new JButton("Steuerung anzeigen");

    public Menue(){



        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/Maze_Background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // picLabel = new JLabel(new ImageIcon(myPicture));
        // picLabel.setLayout(new FlowLayout());
       // picLabel.setBounds(700, 700,400,100);


        solo.setVisible(true);
        multi.setVisible(true);
        cont.setVisible(true);
        //buttonPannel.add(picLabel);

        buttonPannel.add(solo);
        buttonPannel.add(multi);
        buttonPannel.add(cont);
        buttonPannel.setLayout(new GridLayout(3,1));
        buttonPannel.setBounds(150, 250,400,150);
        buttonPannel.setVisible(true);
        buttonPannel.setBackground(new Color(0f,0f,0f,0));



        //frame.add(picLabel);
        frame.setContentPane(new JLabel(new ImageIcon(myPicture)));
        frame.add(buttonPannel);
        frame.setLayout(null);
        frame.setSize(705,705);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }


    public static void main(String [] args){
        new Menue();
    }
}
