package com.leanquizzmind.lean_quizz_mind.domain.models;
import java.util.UUID;

public class Answer {

    private UUID answerId;
    private String answer;
    private boolean correctAnswer;
    public Answer(String answer, boolean correctAnswer) {
        this.answer = answer;
        this.correctAnswer = correctAnswer;
    }
    public Answer(UUID answerId, String answer, boolean correctAnswer) {
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

    public String getAnswer() {
        return answer;
    }
    public boolean getCorrectAnswer() {
        return correctAnswer;
    }
    public void insertId() {
        this.answerId = UUID.randomUUID();
    }
}
