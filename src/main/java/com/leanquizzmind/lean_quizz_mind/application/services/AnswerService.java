package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.errors.AnswerErrors;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class AnswerService {
    private final AnswerRepository ANSWER_REPOSITORY;
    public AnswerService(AnswerRepository answerRepository) {
        this.ANSWER_REPOSITORY = answerRepository;
    }
    public Optional<AnswerErrors> save(Answer answer) {
        Optional<AnswerErrors> validateAnswer = getWarningAnswerEither(answer);
        if (validateAnswer.isPresent()) {
            return validateAnswer;
        }
        answer.insertId();
        ANSWER_REPOSITORY.save(answer);
        return Optional.empty();
    }
    private Optional<AnswerErrors> getWarningAnswerEither(Answer answer) {
        boolean answerStatementIsEmpty = answer.isEmpty();
        if (answerStatementIsEmpty){
            return Optional.of(AnswerErrors.STATEMENT_CANNOT_BE_EMPTY);
        }
        if (answer.getAnswerId() != null) {
            return Optional.of(AnswerErrors.DATA_ALREADY_EXISTS);
        }
        return Optional.empty();
    }
}
