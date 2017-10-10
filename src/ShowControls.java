import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShowControls implements ActionListener {

    JFrame controlframe;
    JPanel gridpanel;
    JPanel picturepanel;
    JPanel txtpanel;
    JLabel anleitung;
    JButton back;

    public ShowControls(){

        controlframe = new JFrame("Maze Runner Multiplayer");
        gridpanel = new JPanel();
        picturepanel = new JPanel();
        txtpanel = new JPanel();

        gridpanel.setLayout(new GridLayout(2,1));
        controlframe.add(gridpanel);

        BufferedImage controlPicture = null;
        try {
            controlPicture = ImageIO.read(new File("src/arrowkeys.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        picturepanel.add(new JLabel(new ImageIcon(controlPicture)));
        gridpanel.add(picturepanel);

        anleitung = new JLabel("<html><h1>Steuerung</h1> <br> 1) Die Figur wird mit der Pfeiltaste oben, nach oben bewegt. <br> 2) Die Figur wird mit der Pfeiltaste unten, nach unten bewegt. <br> 3) Die Figur wird mit der Pfeiltaste links, nach unten links. <br> 4) Die Figur wird mit der Pfeiltaste rechts, nach rechts bewegt.</html>");
        back = new JButton("Zurück");
        txtpanel.setLayout(new GridLayout(2,1));
        txtpanel.add(anleitung);
        txtpanel.add(back);
        back.addActionListener(this);
        gridpanel.add(txtpanel);

        controlframe.setSize(725,1000);
        controlframe.setVisible(true);
        controlframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new Menue();
            controlframe.dispose();
        }
    }
}
