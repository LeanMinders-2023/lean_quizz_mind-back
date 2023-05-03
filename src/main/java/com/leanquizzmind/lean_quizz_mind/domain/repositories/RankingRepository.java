package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;

import java.util.List;
import java.util.UUID;

public interface RankingRepository {

    public List<Ranking> getAllBy(UUID quizzId);

// UUID quizzId to get position

    public int getPositionBy(String nickname);

    public void save(Ranking ranking);

}
