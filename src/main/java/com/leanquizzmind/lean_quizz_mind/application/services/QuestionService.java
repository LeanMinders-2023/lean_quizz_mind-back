package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.PossibleAnswer;

import java.util.UUID;

public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void save(Question question) {
        question.insertId();
        boolean questionNotExist = !this.questionRepository.questionExists(question);
        if (questionNotExist) {
            this.questionRepository.save(question);
        }
    }

    public PossibleAnswer getAllPossibleAnswers(UUID questionId) {

        return questionRepository.getAll(questionId);
    }

}
