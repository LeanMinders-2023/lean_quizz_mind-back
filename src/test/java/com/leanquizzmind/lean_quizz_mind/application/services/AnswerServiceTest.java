package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;

import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLAnswerRepositoryAdapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/*
 *   save(Answer answer)         ->      save into the database
 *   save(Answer answerExist)    ->      don`t save into the database
 *   if answer text exists       ->      don`t save into the database
 */
class AnswerServiceTest {
    private final AnswerRepository MOCK_ANSWER_REPOSITORY = mock(PostgreSQLAnswerRepositoryAdapter.class);
    private final AnswerService ANSWER_SERVICE = new AnswerService(MOCK_ANSWER_REPOSITORY);
    private String ANSWER_TEXT = "example answer text";
    @Test
    void should_not_save_a_new_answer_with_empty_text() {
        Answer answer = new Answer("", false);

        assertThrows(IllegalArgumentException.class, () -> ANSWER_SERVICE.save(answer));
    }
    @Test
    void should_save_a_new_answer() {
        Answer answer = new Answer(ANSWER_TEXT, false);

        ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY).save(answer);
    }
    @Test
    void should_not_save_answer_if_exists() {
        Answer answer = new Answer(ANSWER_TEXT, false);

        when(MOCK_ANSWER_REPOSITORY.answersExist(answer)).thenReturn(true);
        ANSWER_SERVICE.save(answer);

        verify(MOCK_ANSWER_REPOSITORY, never()).save(answer);
    }
}