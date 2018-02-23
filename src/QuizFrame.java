/***********************************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROGRAM TITLE: State Capitals Quiz (QuizFrame.java)
 * CLASS OBJECTIVE: This class presents the UI to the quiz taker.
 **********************************************************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class QuizFrame extends JFrame
{
    private Quiz quiz = new Quiz();
    private JTextArea header;
    private JTextField nameBox;                                          //asks player for their name
    private JTextField questionPrompt;                                   //captures the player's answer
    private JLabel greeting;                                             //player greeting message
    private JLabel question;                                             //displays a quiz question
    private JButton startButton;                                         //button to start the quiz
    private JLabel namePrompt;                                           //captures the player's name
    private JLabel playAgain;                                            //asks the user if they want to play again
    private boolean continueGame;                                        //track if user want to continue quiz
    private JButton yesButton;                                           //button if user want to continue quiz
    private JButton noButton;                                            //button if user wants to stop quiz
    private JButton doneButton;                                          //done button when answer is to be submitted
    private int questionsAnswered = 0;                                   //counts the number of answered questions
    private int numRight = 0;                                            //counts the number of correct answers
    private JLabel quizSummary;                                          //displays quiz summary
    private JLabel quizDetail;                                           //displays detailed quiz results
    private DecimalFormat formatter = new DecimalFormat("#.00");  //decimal formatter


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

        //display course header
        header = new JTextArea("Name:  William Brigham\n0Program Title:  US State Capitals Quiz\nProgram Objective:  To give a quiz of US State "
                + "Capitals and report\n pass/fail status and a grade.");
        add(header);


        //display label asking user for their name
        namePrompt = new JLabel("What's Your Name?");

        //display a text box for the user to input their name
        nameBox = new JTextField(15);

        //add action listener for the nameBox
        nameBox.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                namePrompt.setVisible(false);
                nameBox.setVisible(false);
                greeting.setVisible(true);
                startButton.setVisible(true);
                String message; // the personalized greeting
                message = "<html>Welcome to the US State Capitals Quiz, " + nameBox.getText() + "!<br><br>Click the Start"
                        + " button to begin the quiz.</html>";
                //nameBox.setText("");
                greeting.setText(message);
            }
        }));

        //**************************************************************************************************************
        // a greeting to the user using their name

        greeting = new JLabel();
        greeting.setVisible(false);

        //**************************************************************************************************************
        //start button for displaying the first quiz question/beginning the quiz

        startButton = new JButton("Start");
        startButton.setBackground(Color.BLUE);
        startButton.setForeground(Color.WHITE);
        startButton.setVisible(false);
        startButton.addActionListener(new StartGameListener());


        //**************************************************************************************************************
        //field to display the quiz questions

        question = new JLabel(quiz.getQuestion());
        question.setVisible(false);

        //**************************************************************************************************************
        //field to capture the users's answer

        questionPrompt = new JTextField(15);
        questionPrompt.setVisible(false);

        //**************************************************************************************************************
        //done button the submits the users's answer to the Quiz.class

        doneButton = new JButton("Done");
        doneButton.setBackground(Color.BLUE);
        doneButton.setForeground(Color.WHITE);
        doneButton.setVisible(false);
        doneButton.addActionListener(new DoneButtonListener());

        //**************************************************************************************************************
        //field that asks the user if they would like to answer another question

        playAgain = new JLabel("Would You Like to Answer Another Question?");
        playAgain.setVisible(false);

        //**************************************************************************************************************
        //button for the user to click if they want to answer another question

        yesButton = new JButton("Yes");
        yesButton.setBackground(Color.BLUE);
        yesButton.setForeground(Color.WHITE);
        yesButton.setVisible(false);
        yesButton.addActionListener(new YesButtonListener());

        //**************************************************************************************************************
        //button for the user to click if they don't want to answer more questions

        noButton = new JButton("No");
        noButton.setBackground(Color.BLUE);
        noButton.setForeground(Color.WHITE);
        noButton.setVisible(false);
        noButton.addActionListener(new NoButtonListener());

        //**************************************************************************************************************
        //displays a summary of the quiz results(name, letter grade, and numeric grade)

        quizSummary = new JLabel();
        quizSummary.setVisible(false);

        //**************************************************************************************************************
        //display detail quiz results(questions answered, correct answers, incorrect errors

        quizDetail = new JLabel();
        quizDetail.setVisible(false);

        //**************************************************************************************************************
        //add objects to the frame

        add(namePrompt);
        add(nameBox);
        add(greeting);
        add(startButton);
        add(question);
        add(doneButton);
        add(questionPrompt);
        add(doneButton);
        add(playAgain);
        add(yesButton);
        add(noButton);
        add(quizSummary);
        add(quizDetail);
    }

    //******************************************************************************************************************
    //startButton listener

    public class StartGameListener implements ActionListener
    {
        @Override

        public void actionPerformed(ActionEvent e)
        {

            greeting.setVisible(false);
            question.setVisible(true);
            questionPrompt.setVisible(true);
            questionPrompt.requestFocus();
            doneButton.setVisible(true);
            startButton.setVisible(false);
            header.setVisible(false);
        }
    }

    //******************************************************************************************************************
    //done button listener

    public class DoneButtonListener implements ActionListener
    {
        @Override

        public void actionPerformed(ActionEvent e)
        {


            //if answer is correct, display a JOption pane showing question & answer
            if(questionPrompt.getText().equalsIgnoreCase(quiz.getAnswer())) {

                JOptionPane.showMessageDialog(null, "Correct!\n\nQUESTION:   "
                        + quiz.getQuestion() + "\nANSWER:      " + quiz.getAnswer(),"US State Capitals Quiz",
                        JOptionPane.INFORMATION_MESSAGE);

                //increment the number of questions answered
                questionsAnswered++;

               // increment the number of questions correct
                numRight ++;
                quiz.setNumRight(numRight);
            }

            //if user get the wrong answer, display a JOption pane showing the question and correct answer
            if(!questionPrompt.getText().equalsIgnoreCase(quiz.getAnswer())) {

                JOptionPane.showMessageDialog(null, "Incorrect.\n\nQUESTION:  "
                                + quiz.getQuestion() + "\nANSWER:     " + quiz.getAnswer(),
                        "US State Capitals Quiz", JOptionPane.ERROR_MESSAGE);

                //increment total questions answered
                questionsAnswered++;
                quiz.setTotalQuestions(questionsAnswered);
            }

            //display the play again yes/no buttons
            playAgain.setVisible(true);
            yesButton.setVisible(true);
            yesButton.requestFocus();
            noButton.setVisible(true);
        }
    }

    //******************************************************************************************************************
    //Play again yes button listener

    public class YesButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            yesButton.isEnabled();
            nameBox.setVisible(false);
            namePrompt.setVisible(false);
            greeting.setVisible(false);
            startButton.setVisible(false);
            continueGame = true;

            //set questionsAnswered in quiz class
            quiz.setTotalQuestions(questionsAnswered);

            // get new question
            question.setText(quiz.getQuestion());
            yesButton.setVisible(false);
            noButton.setVisible(false);
            playAgain.setVisible(false);
            questionPrompt.setText("");

        }
    }

    //******************************************************************************************************************
    //Play again no button listener

    public class NoButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //set questionsAnswered in quiz class
            quiz.setTotalQuestions(questionsAnswered);

            //calculate numeric grade
            quiz.calculateNumericalGrade();

            //determine letter grade
            quiz.calculateLetterGrade();
            question.setVisible(false);
            questionPrompt.setVisible(false);
            playAgain.setVisible(false);
            yesButton.setVisible(false);
            noButton.setVisible(false);
            doneButton.setVisible(false);


            //display quiz results
            JTextArea results = new JTextArea("Name:  " + nameBox.getText() + "            Grade:  " + quiz.getLetterGrade()
                    + "        % Grade:  " + formatter.format(Quiz.getNumericalGrade()) + "%\nTotal Questions:  "
                    + quiz.getTotalQuestions() + "        Correct:  " + quiz.getNumRight() + "        Incorrect:  " + (quiz.getTotalQuestions() - quiz.getNumRight()) );
            add(results);

        }
    }

    //******************************************************************************************************************
    //instantiate new QuizFrame

    public static void main(String[] args)
    {
        new QuizFrame();
    } // end main
} //