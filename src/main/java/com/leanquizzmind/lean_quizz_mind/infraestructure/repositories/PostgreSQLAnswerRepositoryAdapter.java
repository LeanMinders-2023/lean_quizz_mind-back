package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import com.leanquizzmind.lean_quizz_mind.infraestructure.entities.AnswerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PostgreSQLAnswerRepositoryAdapter implements AnswerRepository {

    private final JpaAnswerRepository jpaAnswerRepository;

    public PostgreSQLAnswerRepositoryAdapter(JpaAnswerRepository jpaAnswerRepository) {
        this.jpaAnswerRepository = jpaAnswerRepository;
    }

    public void save(Answer answer) {

        throw new Error("Not implemented yet");
    }

    public List<Answer> getAllBy(UUID quizzId) {

        throw new Error("Not implemented yet");
    }

}
