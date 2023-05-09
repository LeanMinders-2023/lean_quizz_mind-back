package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository {

    public void save(Answer answer);

    public boolean answerExist(UUID answerId);

}
