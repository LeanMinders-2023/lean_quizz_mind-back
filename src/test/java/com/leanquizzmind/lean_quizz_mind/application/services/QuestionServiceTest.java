package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLQuestionRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

class QuestionServiceTest {
    /*
     *   void save(Question question)               ->      save into database
     *   void save(Question existingQuestion)       ->      don`t save into database
     *   PossibleAnswer getAll(UUID questionId)     ->      return a PossibleAnswer list object  with the possible answers
     */

    private final QuestionRepository MOCK_QUESTION_REPOSITORY = mock(PostgreSQLQuestionRepositoryAdapter.class);
    private final QuestionService QUESTION_SERVICE = new QuestionService(MOCK_QUESTION_REPOSITORY);
    private final Text QUESTION_TEXT = Text.createText("My new question");
    private final Text ANSWER_TEXT = Text.createText("My new answer");
    private PossibleAnswer possibleAnswers;
    @BeforeEach
    void setUp() {
        Answer firstAnswer = new Answer(ANSWER_TEXT, true);
        Answer secondAnswer = new Answer(ANSWER_TEXT, false);
        possibleAnswers = PossibleAnswer.createPossibleAnswer(List.of(firstAnswer, secondAnswer));
    }
    @Test
    void should_save_a_new_question() {
        Question question = new Question(QUESTION_TEXT, possibleAnswers);

        QUESTION_SERVICE.save(question);

        verify(MOCK_QUESTION_REPOSITORY).save(question);
    }
    @Test
    void should_not_save_an_existent_question() {
        Question question = new Question(QUESTION_TEXT, possibleAnswers);

        when(MOCK_QUESTION_REPOSITORY.questionExists(question)).thenReturn(true);
        QUESTION_SERVICE.save(question);

        verify(MOCK_QUESTION_REPOSITORY, never()).save(question);
    }

    @Test
    void should_get_a_list_with_possible_answer_data() {
        UUID questionId = UUID.randomUUID();

        when(MOCK_QUESTION_REPOSITORY.getAll(questionId)).thenReturn(possibleAnswers);
        PossibleAnswer serviceResponse = QUESTION_SERVICE.getAllPossibleAnswers(questionId);

        assertEquals(serviceResponse, possibleAnswers);
    }
}