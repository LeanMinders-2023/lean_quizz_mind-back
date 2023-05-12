package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository {

    void save(Question question);

    PossibleAnswer getAll(UUID questionId);

    boolean questionExists(Question question);

}
