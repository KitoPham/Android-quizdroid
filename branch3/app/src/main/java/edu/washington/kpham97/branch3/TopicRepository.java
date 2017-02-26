package edu.washington.kpham97.branch3;

/**
 * Created by Kito Pham on 2/17/2017.
 */

public class TopicRepository {

    TopicObject[] topics;
    int topiccount;

    public TopicRepository(){
        topiccount = 4;
        topics = new TopicObject[topiccount];
        //Math Topic Initialization
        topics[0] = new TopicObject(
                "Math",
                "Math is really cool",
                "Tested on Algebro, Calculbro, Geomebro, and Trigobro, all minus the bro and this is just long descript hello"
        );

        topics[0].addQuestion(
                "What is 2 + 2",
                "1",
                "2",
                "3",
                "4",
                4
        );
        topics[0].addQuestion(
                "What is 6 x 6",
                "14",
                "22",
                "36",
                "48",
                3
        );
        topics[0].addQuestion(
                "What is 9 + 2",
                "11",
                "12",
                "13",
                "14",
                1
        );
        topics[0].addQuestion(
                "What is 9 / 3",
                "1",
                "3",
                "9",
                "4",
                2
        );

        //Physics Init
        topics[1] = new TopicObject(
                "Physics",
                "physics is better than math",
                "Tested on falling flying swimming breathing, blah blah more filler text yay lots of filler text so much filler text"
        );

        topics[1].addQuestion(
                "What falls fastest, bowling ball, feather, airplane, or garage",
                "feather",
                "bowling ball",
                "airplane",
                "garage",
                3
        );
        topics[1].addQuestion(
                "water is wet true of false",
                "true",
                "false",
                "false",
                "false",
                1
        );
        topics[1].addQuestion(
                "e is equal to what c square",
                "a",
                "i",
                "m",
                "t",
                3
        );

        //Marvel Init
        topics[2] = new TopicObject(
                "Marvel",
                "supers heroes flying everywhere fighting do you know them",
                "superman batman wait those are dc captain amellica wolverine spoderman, blah blah more filler text yay lots of filler text so much filler text"
        );

        topics[2].addQuestion(
                "Captain America uses what for a weapon",
                "Tony Stark",
                "A gun",
                "A big gun",
                "A boomerang",
                4
        );
        topics[2].addQuestion(
                "The hulk is what color",
                "pink",
                "blue",
                "red",
                "green",
                4
        );

        //Physics Init
        topics[3] = new TopicObject(
                "Life",
                "someone please help me",
                "what is life but an empty void beyond anyones comprehension of I need to do my laundry, blah blah more filler text yay lots of filler text so much filler text"
        );
        topics[3].addQuestion(
                "Sleep is a temporary state of what",
                "sleep",
                "life",
                "death",
                "pillow",
                4
        );
        topics[3].addQuestion(
                "Same?",
                "Same",
                "nah",
                "what",
                "is this a question",
                1
        );


    }
}
