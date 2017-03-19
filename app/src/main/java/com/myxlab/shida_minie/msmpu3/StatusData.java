package com.myxlab.shida_minie.msmpu3;

/**
 * Created by User on 12/20/2016.
 */
public class StatusData {

    String question,answer;

    public StatusData(String question, String answer) {
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
