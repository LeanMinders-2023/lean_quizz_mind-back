package com.leanquizzmind.lean_quizz_mind.infraestructure.entities;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "answers")
public class AnswerEntity {
    @Id
    @Column(name = "answerId", nullable = false)
    private UUID answerId;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "correctAnswer", nullable = false)
    private boolean correctAnswer;

    public AnswerEntity() {}

    public AnswerEntity(UUID answerId, String answer, boolean correctAnswer) {
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

    public java.lang.String getAnswer() {
        return answer;
    }

    public void setAnswer(java.lang.String answer) {
        this.answer = answer;
    }

    public boolean getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public static AnswerEntity fromDomain(Answer answer) {
        return new AnswerEntity(
                answer.getAnswerId(),
                answer.getAnswer(),
                answer.getCorrectAnswer()
        );

    }

    public Answer toDomain() {
        return new Answer(
                this.getAnswerId(),
                this.getAnswer(),
                this.getCorrectAnswer()
        );

    }

}
