package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.models.Quiz;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuizRepository;

import java.util.List;
import java.util.UUID;

public class PostgresSQLQuizRepositoryAdapter implements QuizRepository {

    private final JpaQuizRepository jpaQuizRepository;

    public PostgresSQLQuizRepositoryAdapter(JpaQuizRepository jpaQuizRepository) {
        this.jpaQuizRepository = jpaQuizRepository;
    }

    @Override
    public void save(Quiz quiz) {
        throw new Error("Not implemented yet");
    }

    @Override
    public List<Question> getAllQuestions(UUID quiz) {
        throw new Error("Not implemented yet");
    }

    @Override
    public Quiz getQuizBy(UUID quizId) {
        throw new Error("Not implemented yet");
    }

    @Override
    public List<Quiz> getAllByContainingTitle(String title) {
        throw new Error("Not implemented yet");
    }
}
