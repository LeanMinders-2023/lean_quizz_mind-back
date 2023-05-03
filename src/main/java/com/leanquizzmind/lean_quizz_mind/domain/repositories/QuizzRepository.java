package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quizz;

import java.util.List;

public interface QuizzRepository {

    public List<Quizz> getAll();

    public List<Quizz> getAllByCategoryName(String categoryName);

    public List<Quizz> getAllByDifficulty(Difficulty difficulty);

    public void save(Quizz quizz);

}
