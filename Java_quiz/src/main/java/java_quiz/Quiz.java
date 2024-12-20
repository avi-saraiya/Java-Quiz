package java_quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{

    // Global declarations
    String questions[][] = new String[10][5]; // 1st column contains the question, remaining column containt the options
    String answers[][] = new String[10][2]; // No real reason for 2 arrays. Change if seen fit
    String userAnswers[][] =  new String[10][1]; // Keeps track of all user answers
    JLabel qno, question; // Declared globally to be used in the start function as well
    JRadioButton opt1, opt2, opt3, opt4; // same as above
    ButtonGroup groupoptions; // DEfined here to be used in the start and paint methods 
    JButton next, lifeline, submit; // Globally defined to be used in the ActionPerformed method

    public static int timer = 15; // to be used in the 
    public static int ans_given = 0; // Flag to check whether answer chosen or not
    public static int count = 0;
    public static int score = 0;

    String name;

    Quiz(String name) {
        this.name = name;
        setBounds(0, 0, 1550, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon imgobj = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg")); // The img folder named 'icons' needs to be inside a 'resources' folder inside the 'main' folder
        JLabel image = new JLabel(imgobj); // This class is a part of swing, it allows its object to be displayed as a label in the GUI
        image.setBounds(0, 0, 1530, 400); // Literally sets bounds (dist from left, dist from top, length, width)
        add(image);

        qno = new JLabel();
        qno.setBounds(80, 450, 30, 30);
        qno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(qno);

        question = new JLabel("Question?");
        question.setBounds(110, 450, 700, 30);
        question.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(question);

        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";

        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";

        opt1 = new JRadioButton("Option 1:");
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton("Option 2:");
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton("Option 3:");
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton("Option 4:");
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 520, 200, 40);
        next.setBackground(new Color(30, 144, 254)); //sets bgcolor
        next.setForeground(Color.WHITE); //sets text color 
        next.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        next.addActionListener(this); 
        add(next);

        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 600, 200, 40);
        lifeline.setBackground(new Color(30, 144, 254)); //sets bgcolor
        lifeline.setForeground(Color.WHITE); //sets text color  
        lifeline.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lifeline.addActionListener(this); 
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(1100, 680, 200, 40);
        submit.setBackground(new Color(30, 144, 254)); //sets bgcolor
        submit.setForeground(Color.WHITE); //sets text color
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 20));  
        submit.setEnabled(false);
        submit.addActionListener(this); 
        add(submit);

        //Function to track and display question number
        start(count);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            ans_given = 1; // THIS IS AN ASSUMPTION that the user has already answered before proceeding to the next question
            if (groupoptions.getSelection() == null) {
                userAnswers[count][0] = ""; // If not answered, sets user answer to an empty string
            }
            else {
                userAnswers[count][0] =  groupoptions.getSelection().getActionCommand(); // Sets user answer to the selected option
            }

            // At the 9th question, next should be enabled for the last time, and submit should be disabled for the last time
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        }
        else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 | count == 8){
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            }
            else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        }
        else if (ae.getSource() == submit){
            ans_given = 1; // ASSUMING THAT THE USER HAS ANSWERED UPON CLICKING THE SUBMIT BUTTON
            if (groupoptions.getSelection() == null) {
                userAnswers[count][0] = ""; // If not answered, sets user answer to an empty string
            }
            else {
                userAnswers[count][0] =  groupoptions.getSelection().getActionCommand(); // Sets user answer to the selected option
            }
            
            for (int i = 0; i < userAnswers.length; i++) {
                if(userAnswers[i][0].equals(answers[i][1])) score += 10;
            }
            setVisible(false);
            new Score(name, score);
        }
    }

    // The following method is for the timer
    // Is called once upon object instantiation
    @Override
    public void paint (Graphics g) {
        super.paint(g); // Overrding the paint method of the Graphics class

        String time = "Time left: " + timer + " seconds"; // this is set to 15
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman", Font.BOLD, 30));

        if (timer > 0) {
            g.drawString(time, 1105, 500); // Prints out (str, dist from left, dist from right) on the frame
        }
        else {
            g.drawString("Time's up!", 1105, 500);
        }

        timer--; // This now goes to 14 and so on

        try{
            Thread.sleep(1000); // To wait for 1 second per timer decrement
            repaint(); // Method provided by the Graphics class to recall the paint method
        }
        catch (Exception e){
            e.printStackTrace();
        }

        if (ans_given == 1) { // MADE THE ENABLE ALL OPTIONS CHANGE HERE
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given = 0;
            timer = 15;  
        }
        else if (timer < 0) {
            timer = 15; // Reset timer
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                    userAnswers[count][0] = ""; // If not answered, sets user answer to an empty string
                }
                else {
                    userAnswers[count][0] =  groupoptions.getSelection().getActionCommand(); // Sets user answer to the selected option
                }
                
                for (int i = 0; i < userAnswers.length; i++) {
                    if(userAnswers[i][0].equals(answers[i][1])) score += 10;
                }
                setVisible(false);
                new Score(name, score);
            }
            else {
                if (groupoptions.getSelection() == null) {
                    userAnswers[count][0] = ""; // If not answered, sets user answer to an empty string
                }
                else {
                    userAnswers[count][0] =  groupoptions.getSelection().getActionCommand(); // Sets user answer to the selected option
                }
                count++; // Increments from 0 onward
                start(count); // To move to the next question
            }
        }
    }

    public void start (int count){
        qno.setText("" + (count + 1) + ".");
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]); // Sets option 1 to the first option defined in the questions array
        opt1.setActionCommand(questions[count][1]); // Associates the act of selecting the 1st option (radio button) with selecting the actual 1st option (questions array)

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection(); // sets all the radio buttons back to the deselected stage

    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz("User");
    }
}