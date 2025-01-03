# Java Quiz Application
This is a simple Java Quiz application that allows users to test their knowledge on Java-related questions. 
The quiz consists of multiple-choice questions with a time limit per question. 
The user can also use a lifeline to reduce the number of choices available in certain questions.
## Features
* <b>Timer:</b> Each question has a 15-second timer.
* <b>Lifeline:</b> 50-50 lifeline, which removes two incorrect answers.
* <b>Multiple Questions:</b> 10 multiple-choice questions are available.
* <b>Score Calculation:</b> After completing the quiz, the user's score is displayed.
* <b>GUI-based:</b> The application has a graphical user interface (GUI) built using Java Swing.
## Structure of the Application
### Login.java
* This is the initial login screen where the user enters their name to start the quiz.<br>
* After entering the name, the user can proceed to the next screen.
### Rules.java
* Displays the rules for the quiz.
* The user can read the rules and then start the quiz or go back to the login screen.
### Quiz.java
* Contains the main quiz logic.
* Displays one question at a time with four options.
* The user selects an option and clicks "Next" to proceed to the next question.
* The user has a fixed amount of time to answer each question.
* Includes a 50-50 lifeline to reduce the number of available options.
### Score.java
* After the quiz is completed, the user's score is displayed.
* The user is given the option to play again, which will restart the quiz or return to the login screen.
## How to Run
1. Clone or download the repository.<br>
2. Ensure you have Java Development Kit (JDK) installed.<br>
3. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).<br>
4. Run the Login.java file to start the application.<br>
## Steps
* <b>Login Screen:</b> The user enters their name to start.<br>

![image](https://github.com/user-attachments/assets/4cfd98f1-e65e-4b72-aaa7-eebdca95cc63)

* <b>Rules Screen:</b> Shows the rules of the quiz.<br>

![image](https://github.com/user-attachments/assets/0b39e744-c273-40a5-8a69-0af4a73ec5dd)

* <b>Quiz Screen:</b> The user answers 10 multiple-choice questions with a timer.<br>

![image](https://github.com/user-attachments/assets/69def44f-59b9-46ff-a18b-eb41a2544a09)

* You may also use the <b>50-50 lifeline</b> here<br>

![image](https://github.com/user-attachments/assets/42aed235-1dbd-4ebd-9813-745c5e4adfc5)

* <b>Score Screen:</b> Displays the score after the quiz ends.<br>

![image](https://github.com/user-attachments/assets/c15d1c11-4be2-4b44-9129-350d3ee8dde1)

## Code Structure and Explanation
### Login.java
* <b>Components:</b> JTextField, JLabel, JButton.
* <b>Functionality:</b> Captures the user's name and navigates to the next screen (Rules.java)
### Rules.java
* Components: JLabel, JButton.
* Functionality: Displays quiz rules and provides options to proceed to the quiz or go back to login.
### Quiz.java
* Components: JLabel, JRadioButton, JButton, Timer.
* Functionality: Manages the quiz questions, options, timers, lifelines, and score tracking.
### Score.java
* Components: JLabel, JButton.
* Functionality: Displays the user's score and gives the option to play again or return to login.
## Dependencies
* Java Development Kit (JDK) 8 or higher.
* Swing for GUI components.
## Credits
The application is developed using Java and Swing for the GUI.<br>
Images are sourced from the icons folder in the project directory.
