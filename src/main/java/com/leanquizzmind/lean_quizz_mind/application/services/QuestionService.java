package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.application.warnings.QuestionWarnings;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.models.Question;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.QuestionRepository;
import io.vavr.control.Either;


import java.util.List;
import java.util.UUID;

public class QuestionService {
    private final QuestionRepository QUESTION_REPOSITORY;

    public QuestionService(QuestionRepository questionRepository) {
        this.QUESTION_REPOSITORY = questionRepository;
    }

    public List<Answer> getAllPossibleAnswers(UUID questionId) {
        return QUESTION_REPOSITORY.getAll(questionId);
    }

    public Either<QuestionWarnings, Question> save(Question question) {

        Either<QuestionWarnings, Question> validateQuestion = getWarningQuestionEither(question);
        if (validateQuestion != null) {
            return validateQuestion;
        }

        question.insertId();
        this.QUESTION_REPOSITORY.save(question);
        return null;
    }

    private  Either<QuestionWarnings, Question> getWarningQuestionEither(Question question) {

        UUID questionId = question.getQuestionId();
        List<Answer> answers = question.getAnswers();
        if (questionId != null) {
            return Either.left(QuestionWarnings.DATA_ALREADY_EXISTS);
        }
        int numberOfCorrectAnswer = Math.toIntExact(answers.stream().filter(Answer::getCorrectAnswer).count());
        if (numberOfCorrectAnswer != 1) {
            return Either.left(QuestionWarnings.ONLY_ONE_CORRECT_ANSWER_REQUIRED);
        }

        return null;
    }
}