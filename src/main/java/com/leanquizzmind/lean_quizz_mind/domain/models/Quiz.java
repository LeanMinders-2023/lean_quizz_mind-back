package com.leanquizzmind.lean_quizz_mind.domain.models;


import java.util.List;
import java.util.UUID;

public class Quiz {
    private UUID quizId;
    private String explication;
    private Difficulty difficulty;
    private List<Question> questions;
    private Ranking ranking;
    public Quiz() {}
    public Quiz(UUID quizId, String explication, Difficulty difficulty, List<Question> questions, Ranking ranking) {
        this.quizId = quizId;
        this.explication = explication;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
    }
    public Quiz(String explication, Difficulty difficulty, List<Question> questions, Ranking ranking) {
        this.explication = explication;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
    }
    public UUID getQuizId() {
        return quizId;
    }

    public void setQuizId(UUID quizzId) {
        this.quizId = quizzId;
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
