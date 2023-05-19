package com.leanquizzmind.lean_quizz_mind.infraestructure.repositories;

import com.leanquizzmind.lean_quizz_mind.infraestructure.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaQuizRepository extends JpaRepository<QuizEntity, UUID> {
}
