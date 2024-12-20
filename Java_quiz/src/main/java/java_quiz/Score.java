package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Imported for event handling

public class Score extends JFrame implements ActionListener{

    Score(String name, int score) {
        setBounds(400, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imgobj = new ImageIcon(ClassLoader.getSystemResource("icons/score.png")); // The img folder named 'icons' needs to be inside a 'resources' folder inside the 'main' folder
        Image imgobj2 = imgobj.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT); // This line is to scale the image (a new object of the Image class has to be made for this purpose)
        ImageIcon imgobj3 = new ImageIcon (imgobj2);
        JLabel image = new JLabel(imgobj3); // This class is a part of swing, it allows its object to be displayed as a label in the GUI
        image.setBounds(0, 200, 300, 250); // Literally sets bounds (dist from left, dist from top, length, width)
        add(image);

        JLabel heading = new JLabel("Thank you, " + name + ", for playing!");
        heading.setBounds(45, 50, 700, 30);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        add(heading);

        JLabel dispScore = new JLabel("You scored: " + score);
        dispScore.setBounds(45, 150, 700, 30);
        dispScore.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        add(dispScore);

        JButton playAgain = new JButton("Play Again");
        playAgain.setBounds(500, 400, 200, 30);
        playAgain.setBackground(new Color(30, 144, 254)); //sets bgcolor
        playAgain.setForeground(Color.WHITE);
        playAgain.setFont(new Font("Dialog", Font.PLAIN, 20));
        playAgain.addActionListener(this);
        add(playAgain);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        Score score = new Score("User", 0);
    }
}
