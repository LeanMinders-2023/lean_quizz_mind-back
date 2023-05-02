package com.leanquizzmind.lean_quizz_mind.domain.models;

import java.util.UUID;

public class Answer {

    private UUID answerId;
    private String answer;
    private boolean correctAnswer;
    private UUID questionId;

    private Answer(UUID answerId, String answer, boolean correctAnswer, UUID questionId) {
        this.answerId = answerId;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.questionId = questionId;
    }

    public Answer(String answer, boolean correctAnswer, UUID questionId) {
        this.answerId = UUID.randomUUID();
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.questionId = questionId;
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

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }
}
