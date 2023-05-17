package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;

public class QuizService {
    private final QuizRepository QUIZ_REPOSITORY;
    public QuizService(QuizRepository quizRepository) {
        this.QUIZ_REPOSITORY = quizRepository;
    }
}