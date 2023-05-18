package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.Warning;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class AnswerService {
    private final AnswerRepository ANSWER_REPOSITORY;

    public AnswerService(AnswerRepository answerRepository) {
        this.ANSWER_REPOSITORY = answerRepository;
    }

    public Either<Warning, Answer> save(Answer answer) {

        if (answerIsNotCorrect(answer)){
            return Either.left(Warning.STATEMENT_CANNOT_BE_EMPTY);
        }

        answer.insertId();
        boolean answerNotExist = !ANSWER_REPOSITORY.answersExist(answer);

        if (answerNotExist) {
            ANSWER_REPOSITORY.save(answer);
            return null;
        }

        return Either.left(Warning.DATA_ALREADY_EXISTS);
    }
    private boolean answerIsNotCorrect(Answer answer) {

        return answer.getAnswer().isEmpty();
    }
}
