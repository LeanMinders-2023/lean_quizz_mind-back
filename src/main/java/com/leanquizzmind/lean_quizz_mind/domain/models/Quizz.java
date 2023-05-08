package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.List;
import java.util.UUID;

public class Quizz {

    private UUID quizzId;
    private Text explication;
    private Difficulty difficulty;
    private List<Question> questions;
    private Ranking ranking;

    public Quizz() {}

    public Quizz(UUID quizzId, Text explication, Difficulty difficulty, List<Question> questions, Ranking ranking) {
        this.quizzId = quizzId;
        this.explication = explication;
        this.difficulty = difficulty;
        this.questions = questions;
        this.ranking = ranking;
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
        this.quizzId = UUID.randomUUID();
    }
}
