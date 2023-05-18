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
        Either<Warning, Answer> validateAnswer = getWarningAnswerEither(answer);
        if (validateAnswer != null) {
            return validateAnswer;
        }

        answer.insertId();
        ANSWER_REPOSITORY.save(answer);
        return null;
    }

    private Either<Warning, Answer> getWarningAnswerEither(Answer answer) {
        boolean answerStatementIsEmpty = answer.getAnswer().isEmpty();
        if (answerStatementIsEmpty){
            return Either.left(Warning.STATEMENT_CANNOT_BE_EMPTY);
        }

        if (answer.getAnswerId() != null) {
            return Either.left(Warning.DATA_ALREADY_EXISTS);
        }
        return null;
    }

}
