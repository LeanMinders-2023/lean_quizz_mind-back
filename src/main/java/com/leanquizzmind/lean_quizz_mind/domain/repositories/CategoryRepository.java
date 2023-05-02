package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Category;

import java.util.List;

public interface CategoryRepository {

    public List<Category> getAll();

}
