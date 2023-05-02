package com.leanquizzmind.lean_quizz_mind.domain.models;

import java.util.UUID;

public class Category {

    private UUID categoryId = UUID.randomUUID();
    private String category;

    public Category() {}

    public Category(UUID categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
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
}
