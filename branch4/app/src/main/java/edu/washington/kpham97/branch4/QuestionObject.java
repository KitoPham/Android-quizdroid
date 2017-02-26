package edu.washington.kpham97.branch4;

/**
 * Created by Kito Pham on 2/17/2017.
 */

public class QuestionObject {
    String question;
    String[] answers;
    int correct;
    public QuestionObject(String question, String[] answers, int correct ){
        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }
}
