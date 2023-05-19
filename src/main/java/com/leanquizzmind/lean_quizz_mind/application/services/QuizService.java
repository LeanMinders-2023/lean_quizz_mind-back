package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.QuizWarnings;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quiz;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;
import io.vavr.control.Either;

public class QuizService {
    private final QuizRepository QUIZ_REPOSITORY;
    public QuizService(QuizRepository quizRepository) {
        this.QUIZ_REPOSITORY = quizRepository;
    }

    public Either<QuizWarnings, Quiz> save(Quiz quiz) {
        throw new Error("Not implemented yet");
    }

}