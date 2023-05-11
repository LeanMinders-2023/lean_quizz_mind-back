package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLQuestionRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.*;

class QuestionServiceTest {
    /*
     *   void save(Question question)
     */

    private final QuestionRepository MY_FAKE_QUESTION_REPOSITORY = mock(PostgreSQLQuestionRepositoryAdapter.class);
    private final QuestionService QUESTION_SERVICE = new QuestionService(MY_FAKE_QUESTION_REPOSITORY);
    List<Answer> possibleAnswers;
    @BeforeEach
    void setUp() {
        Text answerText = Text.createText("My new answer");
        Answer firstAnswer = new Answer(answerText, true);
        Answer secondAnswer = new Answer(answerText, false);
        possibleAnswers = List.of(firstAnswer, secondAnswer);
    }
    @Test
    void should_save_a_new_question() {
        Text questionText = Text.createText("My new question");
        Question question = new Question(questionText, possibleAnswers);

        QUESTION_SERVICE.save(question);

        verify(MY_FAKE_QUESTION_REPOSITORY).save(question);
    }
    @Test
    void should_not_save_an_existent_question() {
        Text questionText = Text.createText("My new question");
        Question question = new Question(questionText, possibleAnswers);

        when(MY_FAKE_QUESTION_REPOSITORY.questionExist(question)).thenReturn(true);
        QUESTION_SERVICE.save(question);

        verify(MY_FAKE_QUESTION_REPOSITORY, never()).save(question);
    }
}