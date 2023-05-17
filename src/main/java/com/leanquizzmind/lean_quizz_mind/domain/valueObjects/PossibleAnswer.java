package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;

import java.util.List;

public class PossibleAnswer {

    private final List<Answer> possibleAnswers;

    private PossibleAnswer(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public static PossibleAnswer createPossibleAnswer(List<Answer> possibleAnswers) {
        boolean answersAreEmpty = possibleAnswers.isEmpty();
        if (answersAreEmpty) {
            throw new NullPointerException("The possibleAnswer List cannot be empty");
        }
        PossibleAnswer.checkOnlyOneCorrectAnswer(possibleAnswers);
        return new PossibleAnswer(possibleAnswers);
    }

    private static void checkOnlyOneCorrectAnswer(List<Answer> possibleAnswers) {
        int correctAnswer = Math.toIntExact(possibleAnswers.stream().filter(Answer::getCorrectAnswer).count());
        if (correctAnswer != 1) {
            throw new IllegalArgumentException("Only one element can be the correct answer");
        }
    }

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }
}
