/***********************************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROGRAM TITLE: State Capitals Quiz (Quiz.java)
 * CLASS OBJECTIVE: To handle the calculating portion of the quiz
 **********************************************************************************************************************/

import java.text.DecimalFormat;
import java.util.Random;

public class Quiz
{
    private static String letterGrade = "";                   //variable for storing the quiz taker's letter grade
    private static double numericalGrade = 0;                 //variable for storing the quiz taker's numerical/percent grade
    private int totalQuestions = 0;                           //variable for storing the number of questions that are asked
    private int numRight = 0;                                 //variable for storing the number of correct answers
    private int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,    //variable for storing the number of indices
            11, 12, 13, 14, 15, 16, 17, 18, 19};

    private String[] questions = {                            //array for storing the questions for the quiz
            "What is the capital of New Mexico?",
            "What is the capital of Arizona?",
            "What is the capital of Colorado?",
            "What is the capital of California?",
            "What is the capital of Washington?",
            "What is the capital of Oregon?",
            "What is the capital of Utah?",
            "What is the capital of Idaho?",
            "What is the capital of Wyoming?",
            "What is the capital of Oklahoma?",
            "What is the capital of Kansas?",
            "What is the capital of Texas?",
            "What is the capital of Florida?",
            "What is the capital of New York?",
            "What is the capital of Ohio?",
            "What is the capital of Maine?",
            "What is the capital of Connecticut?",
            "What is the capital of North Carolina?",
            "What is the capital of South Carolina?",
            "What is the capital of Virginia?"
    };

    private String[] answers = {                               //array for storing the quiz answers
            "Santa Fe",
            "Phoenix",
            "Denver",
            "Sacramento",
            "Olympia",
            "Salem",
            "Salt Lake City",
            "Boise",
            "Cheyenne",
            "Oklahoma City",
            "Topeka",
            "Austin",
            "Tallahassee",
            "Albany",
            "Columbus",
            "Augusta",
            "Hartford",
            "Raleigh",
            "Columbia",
            "Richmond"
    };

    //******************************************************************************************************************
    //shuffle the indicies
    public Quiz() {
        shuffle();
    }

    //******************************************************************************************************************
    //method for retrieving the numerical grade for the quiz results
    public static double getNumericalGrade() {
        return numericalGrade;
    }

    //******************************************************************************************************************
    //method for retrieving the letter grade for the quiz results
    public String getLetterGrade() {
        return letterGrade;
    }

    //******************************************************************************************************************
    //method for shuffling the indicies of the questions array
    private void shuffle() {
        for (int i = num.length - 1; i > 0; i--) {
            int j;
            j = (int) (Math.random() * (i + 1));
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
    }

    public void setNumRight(int numRight){
        this.numRight = numRight;
    }

    //******************************************************************************************************************
    //method for retrieving a question to ask the quiz taker
    public String getQuestion() {
        return questions[num[totalQuestions]];
    }

    //******************************************************************************************************************
    //method for retrieving the answer to the question asked
    public  String getAnswer() {
        return answers[num[totalQuestions]];
    }

    //******************************************************************************************************************
    //method for calculating the numerical grade
    public void calculateNumericalGrade () {
        //calculate the numerical grade
        numericalGrade = ((double) numRight / (double) totalQuestions) * 100;
        //numericalGrade = ((double) numRight / (double) totalQuestions) * 100;
    }

    //******************************************************************************************************************
    //method for calculating the letter grade
    public void calculateLetterGrade() {
        //calculate letter grade
        //if the numerical grade is greater than or equal to 91, set 'letterGrade' to "A"*
        if(numericalGrade >= 91) {
            letterGrade = "A";
        }

        //if the numerical grade is greater than or equal to 81 and less than or equal to 90, set 'letterGrade' to "B"
        if(numericalGrade >= 81 && numericalGrade <= 90) {
            letterGrade = "B";
        }

        //if the numerical grade is greater than or equal to 71 and less than or equal to 80, set 'letterGrade' to "C"
        if(numericalGrade >= 71 && numericalGrade <= 80) {
            letterGrade = "C";
        }

        //if the numerical grade is greater than or equal to 61 and less than or equal to 70, set 'letterGrade' to "D"
        if(numericalGrade >= 61 && numericalGrade <= 70) {
            letterGrade = "D";
        }

        //if the numerical grade is less than 60, set 'letterGrade to "F"
        if(numericalGrade < 61) {
            letterGrade = "F";
        }
    }

    //******************************************************************************************************************
    //Set the total questions asked
    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;

        //if total questions answered equals 20, shuffle the indicies
        if(totalQuestions == 20)
        {
            shuffle();
        }
    }
}