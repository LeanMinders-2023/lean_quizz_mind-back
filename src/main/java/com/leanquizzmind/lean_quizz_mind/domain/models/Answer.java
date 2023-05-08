package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.UUID;

public class Answer {

    private UUID answerId;
    private Text answer;
    private boolean correctAnswer;

    // Clase records java
    private Answer(UUID answerId, Text answer, boolean correctAnswer) {
        this.answerId = answerId;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public void setAnswerId(UUID answerId) {
        this.answerId = answerId;
    }

    public Text getAnswer() {
        return answer;
    }

    public void setAnswer(Text answer) {
        this.answer = answer;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void insertId() {
        this.answerId = UUID.randomUUID();
    }
}
