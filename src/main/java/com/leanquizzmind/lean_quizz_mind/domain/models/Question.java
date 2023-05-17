package com.leanquizzmind.lean_quizz_mind.domain.models;

import java.util.List;
import java.util.UUID;

public class Question {
    private UUID questionId;
    private String question;
    private List<Answer> answers;

    public Question() {}
    public Question(String question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }
    public Question(UUID questionId, String question, List<Answer> answers) {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void insertId() {
        this.questionId = UUID.randomUUID();
    }
}
