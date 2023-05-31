package com.leanquizzmind.lean_quizz_mind.infraestructure.dto;

import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;

import java.util.List;

public class QuizDTO {
    private String title;
    private String description;
    private Difficulty difficulty;
    private List<Question> questions;
    public QuizDTO(String title, String description, Difficulty difficulty, List<Question> questions) {
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.questions = questions;
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
}
