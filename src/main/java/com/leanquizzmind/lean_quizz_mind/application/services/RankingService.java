package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.RankingRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

public class RankingService {

    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public void save(Ranking ranking) {
        ranking.insertId();
        rankingRepository.save(ranking);
    }
    public int getPositionBy(Text nickname) {
        return rankingRepository.getPositionBy(nickname);
    }

}
