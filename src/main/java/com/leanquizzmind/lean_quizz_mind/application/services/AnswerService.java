package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Component;

@Component
public class AnswerService {
    private final AnswerRepository ANSWER_REPOSITORY;
    public AnswerService(AnswerRepository answerRepository) {
        this.ANSWER_REPOSITORY = answerRepository;
    }
    public void save(Answer answer) {
        this.validate(answer);
        answer.insertId();
        boolean answerNotExist = !ANSWER_REPOSITORY.answersExist(answer);

        if (answerNotExist) {
            ANSWER_REPOSITORY.save(answer);
        }
    }
    private void validate(Answer answer) {
        if (answer.getAnswer().isEmpty()) {
            throw new IllegalArgumentException("Answer name cannot be empty.");
        }
    }
}
