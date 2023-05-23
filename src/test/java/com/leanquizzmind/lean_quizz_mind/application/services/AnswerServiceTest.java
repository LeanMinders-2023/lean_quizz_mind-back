package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.errors.AnswerErrors;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;

import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgresSQLAnswerRepositoryAdapter;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
 *   save(Answer answer)         ->      save into the database
 *   save(Answer answerExist)    ->      don`t save into the database and send DATA_ALREADY_EXISTS warning
 *   if answer text is empty     ->      don`t save into the database and send STATEMENT_CANNOT_BE_EMPTY warning
 */

class AnswerServiceTest {
    private final AnswerRepository MOCK_ANSWER_REPOSITORY = mock(PostgresSQLAnswerRepositoryAdapter.class);
    private final AnswerService ANSWER_SERVICE = new AnswerService(MOCK_ANSWER_REPOSITORY);
    private final String ANSWER_TEXT = "example answer text";

    @Test
    void should_save_a_new_answer() {
        Answer answer = new Answer(ANSWER_TEXT, false);

        Optional<AnswerErrors> possibleAnswer = ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY).save(answer);
        assertFalse(possibleAnswer.isPresent());
    }
    @Test
    void should_not_save_answer_if_exists() {
        Answer answer = new Answer(ANSWER_TEXT, false);
        answer.insertId();

        Optional<AnswerErrors> possibleAnswer = ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY, never()).save(answer);
        assertTrue(possibleAnswer.isPresent());
        assertEquals(possibleAnswer.get(), AnswerErrors.DATA_ALREADY_EXISTS);
    }

    @Test
    void should_not_save_answer_if_statement_is_empty() {
        Answer answer = new Answer("", false);

        Optional<AnswerErrors> possibleAnswer = ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY, never()).save(answer);
        assertTrue(possibleAnswer.isPresent());
        assertEquals(possibleAnswer.get(), AnswerErrors.STATEMENT_CANNOT_BE_EMPTY);
    }

}