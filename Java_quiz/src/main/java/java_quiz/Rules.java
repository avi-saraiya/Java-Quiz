package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener{

    String name;
    JButton start, back;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Displays name on the rules frame
        JLabel heading = new JLabel("Welcome, " + name + ", to the Java Quiz"); // Literally the label
        heading.setBounds(50, 20, 700, 40); // Defining the label's coordinates
        heading.setFont(new Font("Times New Roman", Font.BOLD, 28)); // setFont() requires a new object Font which is initialized with a font type, modifiers, and a font size
        heading.setForeground(Color.BLUE);
        add(heading);

        String RULES = new String();
        RULES = "1. This quiz is 15 minutes long.\n2. I'll make up some more rules as I go along"; 
        JLabel rules = new JLabel(); // Literally the label
        rules.setBounds(50, 50, 700, 350); // Defining the label's coordinates
        rules.setFont(new Font("Times New Roman", Font.PLAIN, 16)); // setFont() requires a new object Font which is initialized with a font type, modifiers, and a font size
        rules.setText("<html>"+ 
                "1. This quiz is 2 and a half minutes long." + "<br><br>" +
                "2. You will have 15 seconds to answer each question." + "<br><br>" +
                "3. Once the time for each question is up, the next question will appear." + "<br><br>" +
                "4. Answer carefully. There is no going back to the previous question." + "<br><br>" +
                    "<html>");
        add(rules);

        // Another button
        back = new JButton("Back");
        back.setBounds(50, 500, 200, 50);
        back.setBackground(new Color(30, 144, 254)); //sets bgcolor
        back.setForeground(Color.WHITE); //sets text color  
        back.setFont(new Font ("Times New Roman", Font.PLAIN, 26));
        back.addActionListener(this); 
        add(back);

        // The following makes a button
        start = new JButton("Start"); // No need to define this as JButton rules = new JButton() as the former was already done globally
        start.setBounds(520, 500, 200, 50);
        start.setBackground(new Color(30, 144, 254)); //sets bgcolor
        start.setForeground(Color.WHITE); //sets text color 
        start.setFont(new Font ("Times New Roman", Font.PLAIN, 26));
        start.addActionListener(this); 
        add(start);

        setSize(800, 650);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        }
        else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        Rules rule = new Rules("User");
    }
}