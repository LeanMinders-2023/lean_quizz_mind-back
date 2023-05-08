package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.UUID;

public class Quizz {

    private UUID quizzId = UUID.randomUUID();
    private Text explication;
    private Difficulty difficulty;
    private UUID questionId;
    private UUID categoryId;
    private UUID rankingId;

    public Quizz() {}

    public Quizz(UUID quizzId, Text explication, Difficulty difficulty,
                 UUID questionId, UUID categoryId, UUID rankingId) {
        this.quizzId = quizzId;
        this.explication = explication;
        this.difficulty = difficulty;
        this.questionId = questionId;
        this.categoryId = categoryId;
        this.rankingId = rankingId;
    }

    public UUID getQuizzId() {
        return quizzId;
    }

    public void setQuizzId(UUID quizzId) {
        this.quizzId = quizzId;
    }

    public Text getExplication() {
        return explication;
    }

    public void setExplication(Text explication) {
        this.explication = explication;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public UUID getRankingId() {
        return rankingId;
    }

    public void setRankingId(UUID rankingId) {
        this.rankingId = rankingId;
    }
}
