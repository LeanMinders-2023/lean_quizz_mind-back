package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;

import java.util.List;
import java.util.UUID;

public interface RankingRepository {

    public void save(Ranking ranking);

    public int getPositionBy(Text nickname);

    public boolean nickNameExist(Text nickname);

}
