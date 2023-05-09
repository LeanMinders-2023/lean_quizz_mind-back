package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {

        this.answerRepository = answerRepository;
    }

    public List<Answer> getAllBy(UUID quizzId) {

        throw new Error("Not implemented yet");
    }

    public void save(Answer answer) {

        answer.insertId();
        answerRepository.save(answer);
    }

    public boolean answerExist(UUID answerId) {

        throw new Error("Not implemented yet");
    }

}
