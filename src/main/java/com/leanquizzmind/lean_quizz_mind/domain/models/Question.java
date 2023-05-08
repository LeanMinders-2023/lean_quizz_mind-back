package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {

    private UUID questionId;
    private Text question;
    private List<Answer> possibleAnswers = new ArrayList<>();

    public Question() {}

    public Question(UUID questionId, Text question, List<Answer> possibleAnswers) {
        this.questionId = questionId;
        this.question = question;
        this.possibleAnswers = possibleAnswers;
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

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public void insertId() {
        this.questionId = UUID.randomUUID();
    }
}
