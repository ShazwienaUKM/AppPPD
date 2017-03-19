package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 12/19/2016.
 */
public class DanaData {

    String question,answer;

    public DanaData(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
