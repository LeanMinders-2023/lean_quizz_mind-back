package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {

    private UUID questionId;
    private Text question;
    private PossibleAnswer possibleAnswers;

    public Question() {}
    public Question(Text question, PossibleAnswer possibleAnswers) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
    }
    public Question(UUID questionId, Text question, PossibleAnswer possibleAnswers) {
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

    public PossibleAnswer getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(PossibleAnswer possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public void insertId() {
        this.questionId = UUID.randomUUID();
    }
}
