package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {

    private UUID categoryId;
    private Text category;
    private List<Quizz> quizzList = new ArrayList<>();

    public Category() {}

    public Category(UUID categoryId, Text category, List<Quizz> quizzList) {
        this.categoryId = categoryId;
        this.category = category;
        this.quizzList = quizzList;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public Text getCategory() {
        return category;
    }

    public void setCategory(Text category) {
        this.category = category;
    }

    public List<Quizz> getQuizzList() {
        return quizzList;
    }

    public void setQuizzList(List<Quizz> quizzList) {
        this.quizzList = quizzList;
    }

    public void insertId() {
        this.categoryId = UUID.randomUUID();
    }
}
