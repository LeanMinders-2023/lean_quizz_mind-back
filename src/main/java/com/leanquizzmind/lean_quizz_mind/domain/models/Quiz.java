package com.leanquizzmind.lean_quizz_mind.domain.models;


import java.util.List;
import java.util.UUID;

public class Quiz {
    private UUID quizId;
    private String title;
    private String description;
    private Difficulty difficulty;
    private List<Question> questions;
    private Ranking ranking;
    public Quiz() {}

    public Quiz(UUID quizId, String title, String description, Difficulty difficulty, List<Question> questions, Ranking ranking) {
        this.quizId = quizId;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
    }

    public Quiz(String title, String description, Difficulty difficulty, List<Question> questions, Ranking ranking) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public void insertId() {
        this.quizId = UUID.randomUUID();
    }
}
