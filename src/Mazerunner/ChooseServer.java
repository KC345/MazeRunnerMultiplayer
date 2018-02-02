package Mazerunner;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChooseServer implements ActionListener {

    JFrame cs = new JFrame("Maze Runner Multiplayer");
    JPanel contentpanel = new JPanel();
    JLabel iplabel = new JLabel("Server IP eingeben:");
    JTextField ip = new JTextField();
    JButton connect = new JButton("Verbinden");
    JButton back = new JButton("Zurück");


    public ChooseServer(){

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/Mazerunner/Maze_Background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        iplabel.setVisible(true);
        ip.setVisible(true);
        connect.setVisible(true);
        back.setVisible(true);

        connect.addActionListener(this);
        back.addActionListener(this);

        contentpanel.setLayout(new GridLayout(3,1));
        contentpanel.add(iplabel);
        contentpanel.add(ip);
        contentpanel.add(connect);
        contentpanel.add(back);
        contentpanel.setBounds(150, 250,400,150);
        contentpanel.setVisible(true);

        cs.setContentPane(new JLabel(new ImageIcon(myPicture)));
        cs.add(contentpanel);
        cs.setLayout(null);
        cs.setSize(705,705);
        cs.setResizable(false);
        cs.pack();
        cs.setLocationRelativeTo(null);
        cs.setVisible(true);
        cs.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String [] args){
        new ChooseServer();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back){
            new Multiplayer();
            cs.dispose();
        }

        if (e.getSource() == connect){

        }
    }
}
