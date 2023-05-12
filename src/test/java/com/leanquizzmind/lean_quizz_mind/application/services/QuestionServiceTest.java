package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLQuestionRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class QuestionServiceTest {
    /*
     *   void save(Question question)               ->      save into database
     *   void save(Question existingQuestion)       ->      don`t save into database
     */

    private final QuestionRepository MY_FAKE_QUESTION_REPOSITORY = mock(PostgreSQLQuestionRepositoryAdapter.class);
    private final QuestionService QUESTION_SERVICE = new QuestionService(MY_FAKE_QUESTION_REPOSITORY);
    private final Text QUESTION_TEXT = Text.createText("My new question");
    private PossibleAnswer possibleAnswers;
    @BeforeEach
    void setUp() {
        Text answerText = Text.createText("My new answer");
        Answer firstAnswer = new Answer(answerText, true);
        Answer secondAnswer = new Answer(answerText, false);
        possibleAnswers = PossibleAnswer.createPossibleAnswer(List.of(firstAnswer, secondAnswer));
    }
    @Test
    void should_save_a_new_question() {
        Question question = new Question(QUESTION_TEXT, possibleAnswers);

        QUESTION_SERVICE.save(question);

        verify(MY_FAKE_QUESTION_REPOSITORY).save(question);
    }
    @Test
    void should_not_save_an_existent_question() {
        Question question = new Question(QUESTION_TEXT, possibleAnswers);

        when(MY_FAKE_QUESTION_REPOSITORY.questionExists(question)).thenReturn(true);
        QUESTION_SERVICE.save(question);

        verify(MY_FAKE_QUESTION_REPOSITORY, never()).save(question);
    }
}