package com.example.android.americanquiz;

/**
 * Created by Navendu Agarwal on 30-Jun-16.
 */
public class Question {

    public String questionText;
    public String answerText_one;
    public String answerText_two;
    public String answerText_three;
    public String answerText_four;
    public int score;

    // Constructor for free text question
    public Question(String question, String answer, int score) {
        questionText = question;
        answerText_one = answer;
        answerText_two = null;
        answerText_three = null;
        answerText_four = null;
        this.score = score;
    }
}
