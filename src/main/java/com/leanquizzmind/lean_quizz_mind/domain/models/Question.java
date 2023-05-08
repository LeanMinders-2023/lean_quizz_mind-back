package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.UUID;

public class Question {

    private UUID questionId = UUID.randomUUID();
    private Text question;
    private UUID answerId;
    private UUID quizzId;

    public Question() {}

    public Question(UUID questionId, Text question, UUID answerId, UUID quizzId) {
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

    public Text getQuestion() {
        return question;
    }

    public void setQuestion(Text question) {
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
