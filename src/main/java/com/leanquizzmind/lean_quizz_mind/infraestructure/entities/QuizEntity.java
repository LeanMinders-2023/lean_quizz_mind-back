package com.leanquizzmind.lean_quizz_mind.infraestructure.entities;

import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "quizzes")
public class QuizEntity {

    @Id
    @Column(name = "quizId", nullable = false)
    private UUID quizId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "explication", nullable = false)
    private String explication;

    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<QuestionEntity> questions = new ArrayList<>();

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "rankingId",
    referencedColumnName = "rankingId")
    private RankingEntity ranking;

    public QuizEntity(UUID quizId, String title, String explication,
                      Difficulty difficulty, List<QuestionEntity> questions, RankingEntity ranking) {
        this.quizId = quizId;
        this.title = title;
        this.explication = explication;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
    }

    public QuizEntity(String title, String explication, Difficulty difficulty,
                      List<QuestionEntity> questions, RankingEntity ranking) {
        this.title = title;
        this.explication = explication;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
    }

    public QuizEntity() {
    }

    public UUID getQuizId() {
        return quizId;
    }

    public void setQuizId(UUID quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplication() {
        return explication;
    }

    public void setExplication(String explication) {
        this.explication = explication;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public RankingEntity getRanking() {
        return ranking;
    }

    public void setRanking(RankingEntity ranking) {
        this.ranking = ranking;
    }
}
