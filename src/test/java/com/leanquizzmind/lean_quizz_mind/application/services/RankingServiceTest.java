package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Ranking;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.RankingRepository;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLRankingRepositoryAdapter;
import org.junit.jupiter.api.Test;

import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RankingServiceTest {

    /*
    *       void save(Ranking ranking)      ->      save into the database
    *       void getPositionBy()            ->      get position in ranking
    */

    private final RankingRepository MOCK_RANKING_REPOSITORY = mock(PostgreSQLRankingRepositoryAdapter.class);
    private final RankingService RANKING_SERVICE = new RankingService(MOCK_RANKING_REPOSITORY);

    private final String NICKNAME = "example nickname";

    @Test
    void should_save_a_new_ranking() {
        Time time = new Time(0,3,45);
        Ranking ranking = new Ranking(NICKNAME, (float) 9.7, time);

        RANKING_SERVICE.save(ranking);

        verify(MOCK_RANKING_REPOSITORY).save(ranking);
    }

    @Test
    void should_get_an_user_position_by_nickname() {
        Time time = new Time(0,3,45);
        Ranking ranking = new Ranking(NICKNAME, (float) 9.7, time);

        when(MOCK_RANKING_REPOSITORY.getPositionBy(NICKNAME)).thenReturn(4);
        int position = RANKING_SERVICE.getPositionBy(NICKNAME);

        assertEquals(position, 4);
    }

}