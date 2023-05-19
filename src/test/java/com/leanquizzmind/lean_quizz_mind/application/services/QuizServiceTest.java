package com.leanquizzmind.lean_quizz_mind.application.services;

import static org.junit.jupiter.api.Assertions.*;

class QuizServiceTest {

    /*
    *   Either<QuizWarning, Quiz> save(Quiz quiz)                       ->      insert quiz into database
    *   Either<QuizWarning, Quiz> save(Quiz existingQuiz)               ->      don`t add into database and send warning
    *   Either<QuizWarning, Quiz> getQuizBy(UUID quizId)                ->      Quiz object with data
    *   Either<QuizWarning, Quiz> getQuizBy(UUID quizIdThatExists)      ->      null response with CANNOT_GET_QUIZ_WITH_THAT_ID warning
    *   List<Question> getAllQuestion()                                 ->      [question1, question2...]
    */

}