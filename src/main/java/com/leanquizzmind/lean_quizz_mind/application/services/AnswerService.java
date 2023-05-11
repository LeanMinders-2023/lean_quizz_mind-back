package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Component;

@Component
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {

        this.answerRepository = answerRepository;
    }

    public void save(Answer answer) {
        answer.insertId();
        boolean answerNotExist = !answerRepository.answersExist(answer);

        if (answerNotExist) {
            answerRepository.save(answer);
        }
    }

}
