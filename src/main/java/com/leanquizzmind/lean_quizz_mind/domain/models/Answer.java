package com.leanquizzmind.lean_quizz_mind.domain.models;
import java.util.UUID;

public class Answer {
    private UUID answerId;
    private String answer;
    private boolean correct;
    public Answer() {}
    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }
    public Answer(UUID answerId, String answer, boolean correct) {
        this.answerId = answerId;
        this.answer = answer;
        this.correct = correct;
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
    public boolean getCorrect() {
        return correct;
    }
    public void insertId() {
        this.answerId = UUID.randomUUID();
    }

    public boolean isEmpty() {
        return this.answer.isEmpty();
    }

}
