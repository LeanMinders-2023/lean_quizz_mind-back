package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;


import java.util.List;
import java.util.UUID;

public class QuestionService {
    private final QuestionRepository QUESTION_REPOSITORY;

    public QuestionService(QuestionRepository questionRepository) {
        this.QUESTION_REPOSITORY = questionRepository;
    }

    public void save(Question question) {
        this.validateQuestions(question);
        question.insertId();
        boolean questionNotExist = !this.QUESTION_REPOSITORY.questionExists(question);
        if (questionNotExist) {
            this.QUESTION_REPOSITORY.save(question);
        }
    }

    public List<Answer> getAllPossibleAnswers(UUID questionId) {
        return QUESTION_REPOSITORY.getAll(questionId);
    }

    private void validateQuestions(Question question) {
        UUID questionId = question.getQuestionId();
        List<Answer> answers = question.getAnswers();
        if (questionId == null) {
            throw new IllegalArgumentException("Question already has ID");
        }
        int numberOfCorrectAnswer = Math.toIntExact(answers.stream().filter(Answer::getCorrectAnswer).count());
        if (numberOfCorrectAnswer != 1) {
            throw new IllegalArgumentException("Only one element can be the correct answer");
        }
        if (answers.isEmpty()) {
            throw new NullPointerException("The Answer List cannot be empty");
        }
    }
}