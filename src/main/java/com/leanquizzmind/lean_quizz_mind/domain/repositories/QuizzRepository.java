package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Difficulty;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quizz;
import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;

import java.util.List;
import java.util.UUID;

public interface QuizzRepository {

    public void save(Quizz quizz);

    public List<Question> getAllQuestions(UUID quizz);

    public Ranking getRankingBy(UUID quizzId);

}
