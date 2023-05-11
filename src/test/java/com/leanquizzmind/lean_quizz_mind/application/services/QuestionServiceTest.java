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
     *   List<Answer> get_answers_from_a_question(Question question)
     *
     */

    private final QuestionRepository MY_FAKE_QUESTION_REPOSITORY = mock(PostgreSQLQuestionRepositoryAdapter.class);
    private final QuestionService QUESTION_SERVICE = new QuestionService(MY_FAKE_QUESTION_REPOSITORY);
    List<Answer> possibleAnswers;
    @BeforeEach
    void setUp() {
        Text answerText = Text.createText("My new answer");
        Answer firstAnswer = new Answer(answerText, true);
        Answer secondAnswer = new Answer(answerText, false);
        List<Answer> possibleAnswers = List.of(firstAnswer, secondAnswer);
    }
    @Test
    void should_save_a_new_question() {
        Text questionText = Text.createText("My new question");
        Question question = new Question(questionText, possibleAnswers);

        QUESTION_SERVICE.save(question);

        verify(MY_FAKE_QUESTION_REPOSITORY).save(question);
    }


}