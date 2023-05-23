package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.errors.QuestionErrors;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgresSQLQuestionRepositoryAdapter;
import io.vavr.control.Either;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

/*
 *   void save(Question question)                             ->      save into database
 *   void save(Question existingQuestion)                     ->      don`t save into database and send DATA_ALREADY_EXISTS warning
 *   List<Answer> getAll(UUID questionId)                     ->      [possibleAnswer1, possibleAnswer2...]
 *   void save(Question question) with empty List<Answer>     ->      don`t save into database and send ANSWER_LIST_CANNOT_BE_EMPTY warning
 */
class QuestionServiceTest {
    private final QuestionRepository MOCK_QUESTION_REPOSITORY = mock(PostgresSQLQuestionRepositoryAdapter.class);
    private final QuestionService QUESTION_SERVICE = new QuestionService(MOCK_QUESTION_REPOSITORY);
    private final String QUESTION_TEXT = "My new question";
    private List<Answer> possibleAnswers;
    @BeforeEach
    void setUp() {
        Answer firstAnswer = new Answer("My new answer", true);
        Answer secondAnswer = new Answer("My new answer", false);
        possibleAnswers = List.of(firstAnswer, secondAnswer);
    }
    @Test
    void should_save_a_new_question() {
        Question question = new Question(QUESTION_TEXT, possibleAnswers);

        Optional<QuestionErrors> possibleQuestion = QUESTION_SERVICE.save(question);

        verify(MOCK_QUESTION_REPOSITORY).save(question);
        assertFalse(possibleQuestion.isPresent());
    }

    @Test
    void should_not_save_an_existent_question() {
        Question question = new Question(QUESTION_TEXT, possibleAnswers);
        question.insertId();

        Optional<QuestionErrors> possibleQuestion = QUESTION_SERVICE.save(question);

        verify(MOCK_QUESTION_REPOSITORY, never()).save(question);
        assertTrue(possibleQuestion.isPresent());
        assertEquals(possibleQuestion.get(), QuestionErrors.DATA_ALREADY_EXISTS);
    }

    @Test
    void should_get_a_list_with_possible_answer_data() {
        UUID questionId = UUID.randomUUID();

        when(MOCK_QUESTION_REPOSITORY.getAll(questionId)).thenReturn(possibleAnswers);
        List<Answer> serviceResponse = QUESTION_SERVICE.getAllPossibleAnswers(questionId);

        assertEquals(serviceResponse, possibleAnswers);
    }

    @Test
    void should_not_save_question_if_have_a_empty_answer_list() {
        Question question = new Question(QUESTION_TEXT, List.of());

        Optional<QuestionErrors> possibleQuestion = QUESTION_SERVICE.save(question);

        verify(MOCK_QUESTION_REPOSITORY, never()).save(question);
        assertTrue(possibleQuestion.isPresent());
        assertEquals(possibleQuestion.get(), QuestionErrors.ANSWER_LIST_CANNOT_BE_EMPTY);
    }

}