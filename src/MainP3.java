/***********************************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROGRAM TITLE: State Capitals Quiz (MainP3.java)
 * CLASS OBJECTIVE: To drive the Quiz and QuizFrame classes
 **********************************************************************************************************************/

import javax.swing.*;


//**********************************************************************************************************************
//Start main

public class MainP3{
    private QuizFrame qFrame;
    public static void main(String[] args){
        MainP3 app = new MainP3();}

    public MainP3(){
        qFrame = new QuizFrame();
        //qFrame.setTitle(“US State Capitals Quiz”);
        qFrame.setSize(400,700);
        qFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        qFrame.setLocationRelativeTo(null);
        qFrame.setVisible(true);
    }
}