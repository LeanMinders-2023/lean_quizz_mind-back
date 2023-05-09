package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Category;
import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quizz;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {

    public List<Category> getAll();

    public void save(Category category);

    public List<Quizz> getAllQuizzesById(UUID categoryId);

    public List<Quizz> getAllQuizzesByCategoryName(Text categoryName);

    public List<Quizz> getAllQuizzesByDifficulty(Difficulty difficulty);

}
