package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.infraestructure.entities.AnswerEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PostgreSQLAnswerRepositoryAdapter {

    private final JpaAnswerRepository jpaAnswerRepository;


    public PostgreSQLAnswerRepositoryAdapter(JpaAnswerRepository jpaAnswerRepository) {
        this.jpaAnswerRepository = jpaAnswerRepository;
    }

    public void save(Answer answer) {

        throw new Error("Not implemented yet");
        // jpaAnswerRepository.save(AnswerEntity.fromDomain(answer));
    }

    public List<Answer> getAllBy(UUID quizzId) {

        throw new Error("Not implemented yet");
        // return jpaAnswerRepository.findAllById(quizzId).stream().map(AnswerEntity::toDomain).toList();
    }

}
