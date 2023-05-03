package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository {

    public List<Question> getAllBy(UUID quizzId);

    public void save(Question question);

}
