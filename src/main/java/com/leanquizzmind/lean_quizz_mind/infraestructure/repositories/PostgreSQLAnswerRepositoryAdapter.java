package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Component;
@Component
public class PostgreSQLAnswerRepositoryAdapter implements AnswerRepository {

    private final JpaAnswerRepository jpaAnswerRepository;

    public PostgreSQLAnswerRepositoryAdapter(JpaAnswerRepository jpaAnswerRepository) {
        this.jpaAnswerRepository = jpaAnswerRepository;
    }

    public void save(Answer answer) {

        throw new Error("Not implemented yet");
    }

    public boolean answerExist(Answer answer) {

        throw new Error("Not implemented yet");
    }

}
