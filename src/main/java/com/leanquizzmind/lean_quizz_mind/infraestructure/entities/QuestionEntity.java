package com.leanquizzmind.lean_quizz_mind.infraestructure.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @Column(name = "questionId", nullable = false)
    private UUID questionId;

    @Column(name = "question", nullable = false)
    private String question;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<AnswerEntity> possibleAnswerEntitiesList = new ArrayList<>();

    public QuestionEntity() {}

    public QuestionEntity(UUID questionId, String question, List<AnswerEntity> possibleAnswerEntitiesList) {
        this.questionId = questionId;
        this.question = question;
        this.possibleAnswerEntitiesList = possibleAnswerEntitiesList;
    }

    public QuestionEntity(String question, List<AnswerEntity> possibleAnswerEntitiesList) {
        this.question = question;
        this.possibleAnswerEntitiesList = possibleAnswerEntitiesList;
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

    public List<AnswerEntity> getPossibleAnswerEntitiesList() {
        return possibleAnswerEntitiesList;
    }

    public void setPossibleAnswerEntitiesList(List<AnswerEntity> possibleAnswerEntitiesList) {
        this.possibleAnswerEntitiesList = possibleAnswerEntitiesList;
    }
}
