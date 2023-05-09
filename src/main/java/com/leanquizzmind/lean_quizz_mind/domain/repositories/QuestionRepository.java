package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository {

    public void save(Question question);

    public List<Answer> getAll(UUID questionId);

    public boolean questionExist(UUID questionId);

}
