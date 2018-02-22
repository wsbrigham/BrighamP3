/***********************************************************************************************************************
 *              NAME: William Brigham
 *             EMAIL: wbrigham@cnm.edu
 *    PROGRAM TITLE: State Capitals Quiz (MainP2.java)
 * CLASS OBJECTIVE: To drive the Quiz and QuizUI classes
 **********************************************************************************************************************/



import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

//**********************************************************************************************************************
//

public class MainP3{
    private QuizFrame qFrame;
    public static void main(String[] args){
        MainP3 app = new MainP3();}

    public MainP3(){
        qFrame = new QuizFrame();
        //qFrame.setTitle(“US State Capitals Quiz”);
        qFrame.setSize(400,1000);
        qFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        qFrame.setLocationRelativeTo(null);
        qFrame.setVisible(true);
    }
}