package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Component;
@Component
public class PostgresSQLAnswerRepositoryAdapter implements AnswerRepository {

    private final JpaAnswerRepository JPA_ANSWER_REPOSITORY;

    public PostgresSQLAnswerRepositoryAdapter(JpaAnswerRepository jpaAnswerRepository) {
        this.JPA_ANSWER_REPOSITORY = jpaAnswerRepository;
    }

    public void save(Answer answer) {

        throw new Error("Not implemented yet");
    }

    public boolean answersExist(Answer answer) {

        throw new Error("Not implemented yet");
    }

}
