package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents the class containing the image pop-up
public class Image extends JFrame {
    private JFrame jframe;
    private ImageIcon image;

    // EFFECTS: constructs an image
    public Image() {
        jframe = new JFrame("Yay!");
    }

    // MODIFIES: jframe
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
        setTimer();
    }

    // MODIFIES: timer
    // EFFECTS: sets the time the jframe appears for
    public void setTimer() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
