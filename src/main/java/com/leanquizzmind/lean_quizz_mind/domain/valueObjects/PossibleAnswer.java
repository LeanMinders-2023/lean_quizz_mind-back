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

        boolean answersNotExists = possibleAnswers.isEmpty();

        if (answersNotExists) { throw new NullPointerException("The possibleAnswer List cannot be empty"); }

        boolean isMoreThanOneCorrectAnswer = isOnlyOneCorrectAnswer(possibleAnswers);

        if (isMoreThanOneCorrectAnswer) {
            throw new IllegalArgumentException("Only one element can be the correct answer");
        }

        boolean allAnswerAreWrong = allAnswerAreFalse(possibleAnswers);

        if (allAnswerAreWrong) {
            throw new IllegalArgumentException("The answers cant all be wrong");
        }

        return new PossibleAnswer(possibleAnswers);
    }

    private static boolean isOnlyOneCorrectAnswer(List<Answer> possibleAnswers) {

        int haveCorrectFormat = Math.toIntExact(possibleAnswers.stream().filter(Answer::getCorrectAnswer).count());
        return haveCorrectFormat > 1;
    }

    private static boolean allAnswerAreFalse(List<Answer> possibleAnswers) {

        int haveCorrectFormat = Math.toIntExact(possibleAnswers.stream().filter(answer -> !answer.getCorrectAnswer()).count());
        return haveCorrectFormat == possibleAnswers.size();
    }

    public List<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<Answer> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }
}
