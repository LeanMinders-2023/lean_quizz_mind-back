package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;

import java.util.UUID;

public class QuestionService {
    private final QuestionRepository QUESTION_REPOSITORY;

    public QuestionService(QuestionRepository questionRepository) {
        this.QUESTION_REPOSITORY = questionRepository;
    }

    public void save(Question question) {
        question.insertId();
        boolean questionNotExist = !this.QUESTION_REPOSITORY.questionExists(question);
        if (questionNotExist) {
            this.QUESTION_REPOSITORY.save(question);
        }
    }

    public PossibleAnswer getAllPossibleAnswers(UUID questionId) {

        return QUESTION_REPOSITORY.getAll(questionId);
    }

}
