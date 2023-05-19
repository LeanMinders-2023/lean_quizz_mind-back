package com.leanquizzmind.lean_quizz_mind.domain.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {

    private UUID categoryId;
    private String category;
    private List<Quiz> quizList = new ArrayList<>();

    public Category() {}

    public Category(UUID categoryId, String category, List<Quiz> quizList) {
        this.categoryId = categoryId;
        this.category = category;
        this.quizList = quizList;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public void insertId() {
        this.categoryId = UUID.randomUUID();
    }
}
