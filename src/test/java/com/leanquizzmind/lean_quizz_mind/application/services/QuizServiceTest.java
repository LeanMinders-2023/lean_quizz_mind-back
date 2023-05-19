package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.QuizWarnings;
import com.leanquizzmind.lean_quizz_mind.domain.models.*;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgresSQLQuizRepositoryAdapter;
import io.vavr.control.Either;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/*
 *   Either<QuizWarning, Quiz> save(Quiz quiz)                       ->      insert quiz into database
 *   Either<QuizWarning, Quiz> save(Quiz existingQuiz)               ->      don`t add into database and send warning
 *   Either<QuizWarning, Quiz> getQuizBy(UUID quizId)                ->      Quiz object with data
 *   Either<QuizWarning, Quiz> getQuizBy(UUID quizIdThatExists)      ->      null response with CANNOT_GET_QUIZ_THAT_NOT_EXISTS warning
 *   List<Quiz> getAllByContainingTitle(String title)                ->      [quiz1, quiz2...]
 */

class QuizServiceTest {

    private final QuizRepository mockQuizRepository = mock(PostgresSQLQuizRepositoryAdapter.class);
    private final QuizService quizService = new QuizService(mockQuizRepository);
    private final Answer firstAnswer = new Answer("My new answer", true);
    private final Answer secondAnswer = new Answer("My new answer", false);
    private final List<Answer> answers = List.of(firstAnswer, secondAnswer);
    private final List<Question> questions = List.of(
            new Question("example", answers),
                new Question("example", answers),
                new Question("example", answers)
                );
    private final Ranking ranking = new Ranking("fernando", (float) 5.65, new Time(0,2,35));

    @Nested
    class saveQuizTest {

        private Quiz quiz;

        @BeforeEach
        void setUp() {
            quiz = new Quiz("title example", "explication example", Difficulty.EASY, questions, ranking);
        }

        @Test
        void should_save_quiz_into_database() {
            Either<QuizWarnings, Quiz> possibleQuiz = quizService.save(quiz);

            verify(mockQuizRepository).save(quiz);
            assertEquals(possibleQuiz.get(), quiz);
        }

        @Test
        void should_save_existing_quiz_into_database() {
            quiz.insertId();

            Either<QuizWarnings, Quiz> possibleQuiz = quizService.save(quiz);

            verify(mockQuizRepository, never()).save(quiz);
            assertEquals(possibleQuiz.getLeft(), QuizWarnings.QUIZ_ALREADY_EXISTS);
        }

    }

    @Nested
    class getQuizByIdTest {

        private Quiz quiz;

        @BeforeEach
        void setUp() {
            quiz = new Quiz("title example", "explication example", Difficulty.EASY, questions, ranking);
            quiz.insertId();
        }

        @Test
        void should_get_a_quiz_by_id() {
            when(mockQuizRepository.getQuizBy(quiz.getQuizId())).thenReturn(quiz);
            Either<QuizWarnings, Quiz> possibleQuiz = quizService.getQuizById(quiz.getQuizId());

            assertEquals(possibleQuiz.get(), quiz);
        }

        @Test
        void should_get_a_quiz_by_id_that_not_exists_in_database() {
            when(mockQuizRepository.getQuizBy(quiz.getQuizId())).thenReturn(null);
            Either<QuizWarnings, Quiz> possibleQuiz = quizService.getQuizById(quiz.getQuizId());

            assertEquals(possibleQuiz.getLeft(), QuizWarnings.CANNOT_GET_QUIZ_THAT_NOT_EXISTS);
        }

    }

    @Nested
    class getAllByContainingTitleTest {

        private final String firstTitle = "testing in python";
        private final String secondTitle = "testing in java";
        private final Quiz firstQuiz = new Quiz(firstTitle, "explication example", Difficulty.EASY, questions, ranking);
        private final Quiz secondQuiz = new Quiz(secondTitle, "explication example", Difficulty.MEDIUM, questions, ranking);
        private final List<Quiz> quizzes = List.of(firstQuiz, secondQuiz);

        @Test
        void should_get_a_quiz_list_by_containing_tile() {
            when(mockQuizRepository.getAllByContainingTitle("tes")).thenReturn(quizzes);
            List<Quiz> quizList = quizService.getAllQuizzesByContainingTitle("tes");

            assertEquals(quizList, quizzes);
        }

    }

}