package com.leanquizzmind.lean_quizz_mind.infraestructure.entities;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "question")
public class QuestionEntity {

    @Column(name = "questionId", nullable = false)
    private UUID questionId;

    @Column(name = "question", nullable = false)
    private Text question;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<AnswerEntity> possibleAnswerEntitiesList = new ArrayList<>();

    public QuestionEntity() {}

    public QuestionEntity(UUID questionId, Text question, List<AnswerEntity> possibleAnswerEntitiesList) {
        this.questionId = questionId;
        this.question = question;
        this.possibleAnswerEntitiesList = possibleAnswerEntitiesList;
    }

    public QuestionEntity(Text question, List<AnswerEntity> possibleAnswerEntitiesList) {
        this.question = question;
        this.possibleAnswerEntitiesList = possibleAnswerEntitiesList;
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

    public List<AnswerEntity> getPossibleAnswerEntitiesList() {
        return possibleAnswerEntitiesList;
    }

    public void setPossibleAnswerEntitiesList(List<AnswerEntity> possibleAnswerEntitiesList) {
        this.possibleAnswerEntitiesList = possibleAnswerEntitiesList;
    }
}
