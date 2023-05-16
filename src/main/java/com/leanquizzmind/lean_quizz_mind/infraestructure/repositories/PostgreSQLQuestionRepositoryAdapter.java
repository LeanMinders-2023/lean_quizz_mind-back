package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;

import java.util.UUID;

public class PostgreSQLQuestionRepositoryAdapter implements QuestionRepository {

    private final JpaRankingRepository JPA_RANKING_REPOSITORY;

    public PostgreSQLQuestionRepositoryAdapter(JpaRankingRepository jpa_ranking_repository) {
        JPA_RANKING_REPOSITORY = jpa_ranking_repository;
    }

    @Override
    public void save(Question question) {
        throw new Error("Not implemented yet");
    }

    @Override
    public PossibleAnswer getAll(UUID questionId) {
        throw new Error("Not implemented yet");
    }

    @Override
    public boolean questionExists(Question questionId) {
        throw new Error("Not implemented yet");
    }
}
