package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;

import java.util.ArrayList;
import java.util.List;

public class PossibleAnswer {

    private List<Answer> possibleAnswers = new ArrayList<>();

    private PossibleAnswer(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public static PossibleAnswer createPossibleAnswer(List<Answer> possibleAnswers) {

        if (possibleAnswers.isEmpty()) { throw new NullPointerException("The possibleAnswer List cannot be empty"); }

        return new PossibleAnswer(possibleAnswers);
    }

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
}
