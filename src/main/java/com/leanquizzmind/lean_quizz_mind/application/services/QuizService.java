package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.QuizWarnings;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quiz;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;
import io.vavr.control.Either;

public class QuizService {
    private final QuizRepository quizRepository;
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Either<QuizWarnings, Quiz> save(Quiz quiz) {

        quizRepository.save(quiz);
        return Either.right(quiz);
    }

}