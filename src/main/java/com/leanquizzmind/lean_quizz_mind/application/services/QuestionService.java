package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.errors.QuestionErrors;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import io.vavr.control.Either;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class QuestionService {
    private final QuestionRepository QUESTION_REPOSITORY;

    public QuestionService(QuestionRepository questionRepository) {
        this.QUESTION_REPOSITORY = questionRepository;
    }

    public List<Answer> getAllPossibleAnswers(UUID questionId) {
        return QUESTION_REPOSITORY.getAll(questionId);
    }

    public Optional<QuestionErrors> save(Question question) {

        Optional<QuestionErrors> validateQuestion = getWarningQuestionEither(question);
        if (validateQuestion.isPresent()) {
            return validateQuestion;
        }

        question.insertId();
        this.QUESTION_REPOSITORY.save(question);
        return Optional.empty();
    }

    private  Optional<QuestionErrors> getWarningQuestionEither(Question question) {

        UUID questionId = question.getQuestionId();
        List<Answer> answers = question.getAnswers();
        boolean questionExists = questionId != null;
        if (questionExists) {
            return Optional.of(QuestionErrors.DATA_ALREADY_EXISTS);
        }

        boolean possibleAnswerListIsEmpty = answers.isEmpty();
        if (possibleAnswerListIsEmpty) {
            return Optional.of(QuestionErrors.ANSWER_LIST_CANNOT_BE_EMPTY);
        }

        int numberOfCorrectAnswer = Math.toIntExact(answers.stream().filter(Answer::getCorrectAnswer).count());
        boolean areNotOnlyOneCorrectAnswer = numberOfCorrectAnswer != 1;
        if (areNotOnlyOneCorrectAnswer) {
            return Optional.of(QuestionErrors.ONLY_ONE_CORRECT_ANSWER_REQUIRED);
        }
        return Optional.empty();
    }
}