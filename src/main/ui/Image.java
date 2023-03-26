package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

// Represents the class containing the image pop-up
public class Image extends JFrame {
    private JFrame jframe;
    private ImageIcon image;

    // EFFECTS: constructs an image
    public Image() {
        jframe = new JFrame("Yay!");
    }

    // EFFECTS: adds the image onto the JFrame to be displayed
    public void addImage() {
        jframe = new JFrame("Yay!");
        jframe.setSize(700, 700);
        jframe.setLocation(200, 0);
        jframe.setLayout(new FlowLayout());
        jframe.setVisible(true);
        image = new ImageIcon("/Users/tracygan/Desktop/CPSC 210/Personal Project/src/main/images/image.png");

        jframe.setContentPane(new JLabel(image));
        jframe.setResizable(false);
    }
}
