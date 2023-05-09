package com.leanquizzmind.lean_quizz_mind.infraestructure.api;

import com.leanquizzmind.lean_quizz_mind.application.services.AnswerService;
import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("lean_quizz_mind/api")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/answers/{questionId}")
    public ResponseEntity<List<Answer>> getAllBy(@PathVariable UUID questionId) {

        throw new Error("Not implemented yet");

    }

    @PostMapping("/answers")
    public ResponseEntity<String> save(@RequestBody Answer answer) {

        throw new Error("Not implemented yet");
    }

}
