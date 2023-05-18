package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quiz;
import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;

import java.util.List;
import java.util.UUID;

public interface QuizRepository {

    void save(Quiz quiz);

    List<Question> getAllQuestions(UUID quiz);

    Ranking getRankingBy(UUID quizId);

}
