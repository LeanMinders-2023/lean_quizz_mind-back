package com.leanquizzmind.lean_quizz_mind.domain.models;

import java.util.UUID;

public class Question {

    private UUID questionId = UUID.randomUUID();
    private String question;
    private UUID answerId;
    private UUID quizzId;

    public Question() {}

    public Question(UUID questionId, String question, UUID answerId, UUID quizzId) {
        this.questionId = questionId;
        this.question = question;
        this.answerId = answerId;
        this.quizzId = quizzId;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public UUID getAnswerId() {
        return answerId;
    }

    public void setAnswerId(UUID answerId) {
        this.answerId = answerId;
    }

    public UUID getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(UUID quizzId) {
        this.quizzId = quizzId;
    }
}
