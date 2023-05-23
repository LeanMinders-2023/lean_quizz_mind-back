package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.errors.AnswerErrors;
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

    // Optional
    public Either<AnswerErrors, Answer> save(Answer answer) {

        Either<AnswerErrors, Answer> validateAnswer = getWarningAnswerEither(answer);
        if (validateAnswer != null) {
            return validateAnswer;
        }

        answer.insertId();
        ANSWER_REPOSITORY.save(answer);
        return null;
    }

    // Optional
    private Either<AnswerErrors, Answer> getWarningAnswerEither(Answer answer) {

        // método para comprobaciones en objeto de dominio
        // tell dont ask
        boolean answerStatementIsEmpty = answer.getAnswer().isEmpty();
        if (answerStatementIsEmpty){
            return Either.left(AnswerErrors.STATEMENT_CANNOT_BE_EMPTY);
        }

        if (answer.getAnswerId() != null) {
            return Either.left(AnswerErrors.DATA_ALREADY_EXISTS);
        }
        return null;
    }

}
