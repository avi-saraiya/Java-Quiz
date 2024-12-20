package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; // Imported for event handling

public class Login extends JFrame implements ActionListener{

    JButton begin, exit; // Declared globally to be used in the actionPerformed class as well
    JTextField tfname; // Same as above

    Login(){
        getContentPane().setBackground(Color.WHITE); // Sets the exitground color of the frame to white (this is an awt function)
        setLayout(null); // Indicates to swing that we want to use a custom layout, not a predefined one

        /* In the line below, ImageIcon is a class from swing which represents an img as an icon in the GUI 
           ClassLoader locates libraries and loads the relevant data found there (the img file in this instance)
           getSystemResourse is a method to fetch data from the path specified as the argument*/
        ImageIcon imgobj = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpeg")); // The img folder named 'icons' needs to be inside a 'resources' folder inside the 'main' folder
        JLabel image = new JLabel(imgobj); // This class is a part of swing, it allows its object to be displayed as a label in the GUI
        image.setBounds(0 ,0, 600, 500); // Literally sets bounds (dist from left, dist from top, length, width)
        add(image); // This function adds the Jlabel object to the frame

        JLabel heading = new JLabel("Java Quiz"); // Literally the label
        heading.setBounds(790, 60, 300, 45); // Defining the label's coordinates
        heading.setFont(new Font("Times New Roman", Font.BOLD, 40)); // setFont() requires a new object Font which is initialized with a font type, modifiers, and a font size
        heading.setForeground(Color.BLUE);
        //Alternatively, if you want RGB values to be specified, make an object of the class Color
        // eg : heading.setForeground(new Color(r, g, b));
        add(heading); // The add() function is the way to add anything to the frame

        JLabel name = new JLabel("Enter your name"); // Literally the label
        name.setBounds(810, 150, 300, 20); // Defining the label's coordinates
        name.setFont(new Font("Times New Roman", Font.BOLD, 20)); // setFont() requires a new object Font which is initialized with a font type, modifiers, and a font size
        name.setForeground(Color.BLUE);
        add(name);

        // The following creates a textbox
        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font ("Times New Roman", Font.BOLD, 20));
        add(tfname);

        // The following makes a button
        begin = new JButton("Begin"); // No need to define this as JButton begin = new JButton() as the former was already done globally
        begin.setBounds(920, 370, 200, 50);
        begin.setBackground(new Color(30, 144, 254)); //sets bgcolor
        begin.setForeground(Color.WHITE); //sets text color 
        begin.setFont(new Font ("Times New Roman", Font.PLAIN, 26));
        begin.addActionListener(this); 
        add(begin);

        // Another button
        exit = new JButton("Exit");
        exit.setBounds(650, 370, 200, 50);
        exit.setBackground(new Color(30, 144, 254)); //sets bgcolor
        exit.setForeground(Color.WHITE); //sets text color 
        exit.setFont(new Font ("Times New Roman", Font.PLAIN, 26)); 
        exit.addActionListener(this); 
        add(exit);

        setSize(1200, 500); // Sets the size of the frame to (length, width) 
        setLocation(200, 150); // Sets the location of the frame to the point (x, y)
        setVisible(true); // Makes the frame visible   
    }

    // This is an abstract method defined in the ActionListener Interface
    public void actionPerformed(ActionEvent ae) { // Parameter is an object ae of the class ActionEvent
        if (ae.getSource() == begin) { // Behavior defined in another file
            String name = tfname.getText(); // Stores text as object attribute
            setVisible(false); // Closes current frame
            new Rules(name); // Opens begin frame
        }
        else if (ae.getSource() == exit) {
            setVisible(false); // Closes the frame
        }
    }

    public static void main(String[] args) {
        Login login = new Login();
    }
}
