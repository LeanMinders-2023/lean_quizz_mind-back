package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.Warning;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;

import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLAnswerRepositoryAdapter;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
 *   save(Answer answer)         ->      save into the database
 *   save(Answer answerExist)    ->      don`t save into the database
 *   if answer text is empty     ->      don`t save into the database
 */

class AnswerServiceTest {
    private final AnswerRepository MOCK_ANSWER_REPOSITORY = mock(PostgreSQLAnswerRepositoryAdapter.class);
    private final AnswerService ANSWER_SERVICE = new AnswerService(MOCK_ANSWER_REPOSITORY);
    private final String ANSWER_TEXT = "example answer text";

    @Test
    void should_save_a_new_answer() {
        Answer answer = new Answer(ANSWER_TEXT, false);

        Either<Warning, Answer> possibleAnswer = ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY).save(answer);
        assertNull(possibleAnswer);
    }
    @Test
    void should_not_save_answer_if_exists() {
        Answer answer = new Answer(ANSWER_TEXT, false);

        when(MOCK_ANSWER_REPOSITORY.answersExist(answer)).thenReturn(true);
        Either<Warning, Answer> possibleAnswer = ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY, never()).save(answer);
        assertEquals(possibleAnswer.getLeft(), Warning.DATA_ALREADY_EXISTS);
    }

    @Test
    void should_not_save_answer_if_statement_is_empty() {
        Answer answer = new Answer("", false);

        Either<Warning, Answer> possibleAnswer = ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY, never()).save(answer);
        assertEquals(possibleAnswer.getLeft(), Warning.STATEMENT_CANNOT_BE_EMPTY);
    }

}