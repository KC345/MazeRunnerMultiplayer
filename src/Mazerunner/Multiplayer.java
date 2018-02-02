package Mazerunner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Multiplayer implements ActionListener{

    JFrame multiframe = new JFrame("Maze Runner Multiplayer");
    JPanel buttonPannel = new JPanel();
    JButton client = new JButton("Client");
    JButton server = new JButton("Server");
    JButton back;




    public Multiplayer(){

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/Mazerunner/Maze_Background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        client.setVisible(true);
        client.addActionListener(this);
        server.setVisible(true);
        server.addActionListener(this);

        buttonPannel.add(client);
        buttonPannel.add(server);
        back = new JButton("Zurück");
        buttonPannel.add(back);
        back.addActionListener(this);
        buttonPannel.setLayout(new GridLayout(3,1));
        buttonPannel.setBounds(150, 250,400,150);
        buttonPannel.setVisible(true);
        buttonPannel.setBackground(new Color(0f,0f,0f,0));




        multiframe.setContentPane(new JLabel(new ImageIcon(myPicture)));
        multiframe.add(buttonPannel);
        multiframe.setLayout(null);
        multiframe.setSize(705,705);
        multiframe.setResizable(false);
        multiframe.pack();
        multiframe.setLocationRelativeTo(null);
        multiframe.setVisible(true);
        multiframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == back){
                new Menue();
                multiframe.dispose();
            }

            if (e.getSource() == client){
                new ChooseServer();
                multiframe.dispose();
            }
        }
    public static void main(String [] args){
        new Multiplayer();
    }

}
