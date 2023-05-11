package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;

import java.util.List;
import java.util.UUID;

public class PostgreSQLQuestionRepositoryAdapter implements QuestionRepository {

    @Override
    public void save(Question question) {
        throw new Error("Not implemented yet");
    }

    @Override
    public List<Answer> getAll(UUID questionId) {
        throw new Error("Not implemented yet");
    }

    @Override
    public boolean questionExist(Question questionId) {
        throw new Error("Not implemented yet");
    }
}
