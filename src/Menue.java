import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menue implements ActionListener{

    JFrame frame = new JFrame("Maze Runner Multiplayer");
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

        solo.setVisible(true);
        multi.setVisible(true);
        cont.setVisible(true);

        buttonPannel.add(solo);
        buttonPannel.add(multi);
        buttonPannel.add(cont);
        buttonPannel.setLayout(new GridLayout(3,1));
        buttonPannel.setBounds(150, 250,400,150);
        buttonPannel.setVisible(true);
        buttonPannel.setBackground(new Color(0f,0f,0f,0));

        solo.addActionListener(this);
        multi.addActionListener(this);
        cont.addActionListener(this);

        frame.setContentPane(new JLabel(new ImageIcon(myPicture)));
        frame.add(buttonPannel);
        frame.setLayout(null);
        frame.setSize(705,705);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



    }


    public static void main(String [] args){
        new Menue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== solo){
            new Singleplayer();
            frame.dispose();
        }

        if (e.getSource()==multi){

        }

        if (e.getSource()==cont){
            new ShowControls();
            frame.dispose();
        }
    }
}
