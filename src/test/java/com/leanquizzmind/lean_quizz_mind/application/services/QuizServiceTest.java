package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.*;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgresSQLQuizRepositoryAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.mockito.Mockito.*;

class QuizServiceTest {

    /*
    *   Either<QuizWarning, Quiz> save(Quiz quiz)                       ->      insert quiz into database
    *   Either<QuizWarning, Quiz> save(Quiz existingQuiz)               ->      don`t add into database and send warning
    *   Either<QuizWarning, Quiz> getQuizBy(UUID quizId)                ->      Quiz object with data
    *   Either<QuizWarning, Quiz> getQuizBy(UUID quizIdThatExists)      ->      null response with CANNOT_GET_QUIZ_WITH_THAT_ID warning
    *   List<Question> getAllQuestion()                                 ->      [question1, question2...]
    *   List<Quiz> getAllByContainingTitle(String title)                ->      [quiz1, quiz2...]
    */

    private final QuizRepository mockQuizRepository = mock(PostgresSQLQuizRepositoryAdapter.class);
    private final QuizService quizService = new QuizService(mockQuizRepository);

    private List<Answer> answers;
    private List<Question> questions;
    private Ranking ranking;

    @BeforeEach
    void setUp() {
        Answer firstAnswer = new Answer("My new answer", true);
        Answer secondAnswer = new Answer("My new answer", false);
        answers = List.of(firstAnswer, secondAnswer);
        questions = List.of(
                new Question("example", answers),
                new Question("example", answers),
                new Question("example", answers)
                );
        ranking = new Ranking("fernando", (float) 5.65, new Time(0,2,35));
    }

    @Test
    void should_save_quiz_into_database() {
        Quiz quiz = new Quiz("title example", "explication example", Difficulty.EASY, questions, ranking);

        quizService.save(quiz);

        verify(mockQuizRepository).save(quiz);
    }

}