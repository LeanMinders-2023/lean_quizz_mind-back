package com.leanquizzmind.lean_quizz_mind.domain.models;

import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.UUID;

public class Category {

    private UUID categoryId = UUID.randomUUID();
    private Text category;

    public Category() {}

    public Category(UUID categoryId, Text category) {
        this.categoryId = categoryId;
        this.category = category;
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
}
