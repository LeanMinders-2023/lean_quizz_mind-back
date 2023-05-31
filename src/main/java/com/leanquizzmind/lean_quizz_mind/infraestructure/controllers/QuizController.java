package com.leanquizzmind.lean_quizz_mind.infraestructure.controllers;

import com.leanquizzmind.lean_quizz_mind.infraestructure.dto.QuizDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {
    @PostMapping("/quiz")
    public ResponseEntity<QuizDTO> createQuiz(@RequestBody QuizDTO quizDto) {
        return new ResponseEntity<>(quizDto, HttpStatus.OK);
    }
}

