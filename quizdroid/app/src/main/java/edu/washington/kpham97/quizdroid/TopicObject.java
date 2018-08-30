package edu.washington.kpham97.quizdroid;

/**
 * Created by Kito Pham on 2/17/2017.
 */

public class TopicObject {
    String title;
    String shortDescript;
    QuestionObject[] questions;
    int totalQuestions;

    public TopicObject(String topic, String shortDescript){
        title = topic;
        this.shortDescript = shortDescript;
        questions = new QuestionObject[10];
        totalQuestions = 0;
    }

    public void addQuestion(QuestionObject question){
        questions[totalQuestions] = question;
        totalQuestions++;
    }

    public void addQuestion(String question, String answer1, String answer2, String answer3, String answer4, int correct){
        String[] answers = new String[]{
                answer1, answer2, answer3, answer4
        };
        questions[totalQuestions] = new QuestionObject(question, answers, correct);
        totalQuestions++;
        if (totalQuestions == questions.length){
            QuestionObject[] temp = new QuestionObject[questions.length*2];
            for (int i = 0; i < questions.length; i++){
                temp[i] = questions[i];
            }
            questions = temp;
        }
    }
}
