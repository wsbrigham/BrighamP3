/***********************************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROGRAM TITLE: State Capitals Quiz (MainP2.java)
 * CLASS OBJECTIVE: To drive the Quiz and QuizUI classes
 **********************************************************************************************************************/


import javax.swing.*;
import javax.swing.border.Border;
import javax.xml.stream.events.StartDocument;
import java.awt.*;
import java.awt.event.*;

public class QuizFrame extends JFrame
{
    private Quiz quiz = new Quiz();
    //private static final int WIDTH = 700;
   // private static final int HEIGHT = 700;
    private JTextField nameBox;
    private JTextField questionPrompt;
    private JLabel greeting;
    private JTextField answerAnotherQuestion;
    private JLabel question;
    private JButton startButton;
    private JLabel namePrompt;
    private JLabel playAgain;
    private boolean continueGame;
    private JButton yesButton;
    private JButton noButton;
    private JButton doneButton;


    //*******************************************
    //QuizFrame Constructor

    public QuizFrame(){


        setTitle("US State Capitals Quiz");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(15, 1, 2, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);

    }

    //*******************************************
    // Create components and add them to the window.

    private void initComponents()
    {
        namePrompt = new JLabel("What's Your Name?");
        nameBox = new JTextField(15);
        nameBox.addActionListener(new NameListener());

        greeting = new JLabel();
        greeting.setVisible(false);

        startButton = new JButton("Start");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setVisible(false);
        startButton.addActionListener(new StartGameListener());


        question = new JLabel("What's the Capital of " + quiz.getQuestion());
        question.setVisible(false);

        questionPrompt = new JTextField(15);
        questionPrompt.setVisible(false);

        doneButton = new JButton("Done");
        doneButton.setBackground(Color.BLUE);
        doneButton.setForeground(Color.WHITE);
        doneButton.setVisible(false);
        doneButton.addActionListener(new DoneButtonListener());

        playAgain = new JLabel("Would You Like to Answer Another Question?");
        playAgain.setVisible(false);

        answerAnotherQuestion = new JTextField(15);
        answerAnotherQuestion.setVisible(false);

        yesButton = new JButton("Yes");
        yesButton.setBackground(Color.BLUE);
        yesButton.setForeground(Color.WHITE);
        yesButton.setVisible(false);
        yesButton.addActionListener(new YesButtonListener());

        noButton = new JButton("No");
        noButton.setBackground(Color.BLUE);
        noButton.setForeground(Color.WHITE);
        noButton.setVisible(false);
        noButton.addActionListener(new NoButtonListener());

        add(namePrompt);
        add(nameBox);
        add(greeting);
        add(startButton);
        add(question);
        add(doneButton);
        add(questionPrompt);
        add(doneButton);
        add(playAgain);
        add(answerAnotherQuestion);
        add(yesButton);
        add(noButton);

    }

    //****************************************************
    // player's name listener

    public class NameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            namePrompt.setVisible(false);
            nameBox.setVisible(false);
            greeting.setVisible(true);
            startButton.setVisible(true);
            String message; // the personalized greeting
            message = "<html>Welcome to the US State Capitals Quiz, " + nameBox.getText() + "!<br><br>Click the Start"
            + "button to begin the quiz.</html>";
            //nameBox.setText("");
            greeting.setText(message);
        }
    }

    //****************************************************
    //start listener
    public class StartGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            greeting.setVisible(false);
            question.setVisible(true);
            questionPrompt.setVisible(true);
            questionPrompt.requestFocus();
            doneButton.setVisible(true);
            startButton.setVisible(false);
        }
    }



    //****************************************************
    //done button listener
    public class DoneButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(questionPrompt.getText().equalsIgnoreCase(quiz.getAnswer())) {

                JOptionPane.showMessageDialog(null, "Correct!\n\nThe capital of " + quiz.getQuestion() + " is "
                        + quiz.getAnswer() + "\n\nClick OK to continue.\n\n",
                        "US State Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);

            }

            if(!questionPrompt.getText().equalsIgnoreCase(quiz.getAnswer())) {

                JOptionPane.showMessageDialog(null, "Incorrect.\n\nThe capital of " + quiz.getQuestion() + " is " + quiz.getAnswer()
                        + "\n\nClick OK to continue.\n\n",
                        "US State Capitals Quiz", JOptionPane.ERROR_MESSAGE);

            }

            playAgain.setVisible(true);
            yesButton.setVisible(true);
            yesButton.requestFocus();
            noButton.setVisible(true);
        }
    }


    //****************************************************
    //Play again yes button listener
    public class YesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            yesButton.isEnabled();
            JOptionPane.showMessageDialog(null, "The Yes button was clicked\n\n",
                    "US State Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);
            nameBox.setVisible(false);
            namePrompt.setVisible(false);
            greeting.setVisible(false);
            startButton.setVisible(false);
            continueGame = true;

        }
    }

    //****************************************************
    //Play again no button listener
    public class NoButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            noButton.isEnabled();
            JOptionPane.showMessageDialog(null, "The No button was clicked\n\n",
                    "US State Capitals Quiz", JOptionPane.INFORMATION_MESSAGE);
            continueGame = false;
        }
    }


    public static void main(String[] args)
    {
        new QuizFrame();
    } // end main
} //