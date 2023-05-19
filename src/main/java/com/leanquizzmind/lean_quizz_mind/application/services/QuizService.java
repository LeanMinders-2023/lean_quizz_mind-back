package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.QuizWarnings;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quiz;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;
import io.vavr.control.Either;

import java.util.List;
import java.util.UUID;

public class QuizService {
    private final QuizRepository quizRepository;
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Either<QuizWarnings, Quiz> save(Quiz quiz) {

        boolean quizExistsInDatabase = quiz.getQuizId() != null;

        if (quizExistsInDatabase) {
            return Either.left(QuizWarnings.QUIZ_ALREADY_EXISTS);
        }

        quiz.insertId();
        quizRepository.save(quiz);
        return Either.right(quiz);
    }

    public Either<QuizWarnings, Quiz> getQuizById(UUID quizId) {

        Quiz quiz = quizRepository.getQuizBy(quizId);
        if (quiz == null) {
            return Either.left(QuizWarnings.CANNOT_GET_QUIZ_THAT_NOT_EXISTS);
        }
        return Either.right(quiz);
    }

    public List<Quiz> getAllQuizzesByContainingTitle(String title) {
        return quizRepository.getAllByContainingTitle(title);
    }

}