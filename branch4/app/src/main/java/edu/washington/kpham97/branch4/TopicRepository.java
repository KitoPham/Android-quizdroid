package edu.washington.kpham97.branch4;

import android.util.JsonReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Kito Pham on 2/17/2017.
 */

public class TopicRepository {

    TopicObject[] topics;
    int topiccount = 0;

    public TopicRepository() throws IOException {
        topics = new TopicObject[10];

        File file = new File("data/questions.json");
        InputStream in = new FileInputStream(file);
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));

        reader.beginArray();
        while (reader.hasNext()){
            readTitle(reader);
        }
        reader.endArray();
    }

    public void readTitle(JsonReader reader) throws IOException {
        String title = "";
        String desc = "";


        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("title")){
                title = reader.nextString();
                String check = reader.nextName();
                desc = reader.nextString();
                topics[topiccount] = new TopicObject(title, desc);
                topiccount++;

            } else if (name.equals("questions")){
                readQuestions(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
    }

    public void readQuestions(JsonReader reader) throws IOException{
        reader.beginArray();
        while(reader.hasNext()) {
            topics[topiccount-1].addQuestion(readQuestion(reader));
        }
        reader.endArray();
    }

    public QuestionObject readQuestion(JsonReader reader) throws IOException {
        String title = "";
        int answer = 0;
        String[] answers = new String[4];
        QuestionObject question;

        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("text")){
                title = reader.nextString();
            } else if (name.equals("answer")){
                answer = reader.nextInt();
            } else if (name.equals("answers")){
                answers = readAnswers(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();

        question = new QuestionObject(title, answers, answer);
        return question;
    }

    public String[] readAnswers(JsonReader reader) throws IOException {
        String[] answers = new String[4];

        reader.beginArray();
        while(reader.hasNext()){
            answers[0] = reader.nextString();
            answers[1] = reader.nextString();
            answers[2] = reader.nextString();
            answers[3] = reader.nextString();
        }
        reader.endArray();
        return answers;
    }
}
