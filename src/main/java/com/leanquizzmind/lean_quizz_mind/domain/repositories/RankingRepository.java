package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;

import java.util.List;

public interface RankingRepository {

    List<Ranking> getAllBy(long quizzId);

    int getPositionBy(String nickname);

    void save(Ranking ranking);

}
