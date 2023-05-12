package com.leanquizzmind.lean_quizz_mind.domain.repositories;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository {

    void save(Answer answer);

    boolean answersExist(Answer answer);

}
