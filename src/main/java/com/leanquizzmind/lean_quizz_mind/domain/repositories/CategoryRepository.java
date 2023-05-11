package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Category;
import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quizz;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {

    List<Category> getAll();

    void save(Category category);

    List<Quizz> getAllQuizzesById(UUID categoryId);

    List<Quizz> getAllQuizzesByCategoryName(Text categoryName);

    List<Quizz> getAllQuizzesByDifficulty(Difficulty difficulty);

}
