package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;

public interface RankingRepository {

    void save(Ranking ranking);

    // getRankingByQuizIdLimit10(UUID quizId)

    int getPositionBy(String nickname);

}
