package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Category;
import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quiz;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {

    List<Category> getAll();

    void save(Category category);

    List<Quiz> getAllQuizzesById(UUID categoryId);

    List<Quiz> getAllQuizzesByCategoryName(String categoryName);

    List<Quiz> getAllQuizzesByDifficulty(Difficulty difficulty);

}
