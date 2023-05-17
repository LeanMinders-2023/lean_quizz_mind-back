package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.RankingRepository;


public class PostgreSQLRankingRepositoryAdapter implements RankingRepository {

    private final JpaAnswerRepository jpaAnswerRepository;

    public PostgreSQLRankingRepositoryAdapter(JpaAnswerRepository jpaAnswerRepository) {
        this.jpaAnswerRepository = jpaAnswerRepository;
    }

    @Override
    public void save(Ranking ranking) {
        throw new Error("Not implemented yet");
    }

    @Override
    public int getPositionBy(String nickname) {
        throw new Error("Not implemented yet");
    }
}
