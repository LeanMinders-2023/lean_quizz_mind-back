package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PossibleAnswerTest {

    /*
     *   List<Answer> [answer1, answer2...]                 ->      new PossibleAnswer
     *   List<Answer> []                                    ->      return error response
     *   List<Answer> [answer1(true), answer2(true)...]     ->      return error response
     *   List<Answer> [answer1(false), answer2(false)...]     ->      return error response
    */

    Text firstText = Text.createText("example 1");
    Text secondText = Text.createText("example 2");
    Text thirdText = Text.createText("example 3");

    @Test
    void should_create_a_new_possible_answer() {
        Answer firstAnswer = new Answer(firstText, false);
        Answer secondAnswer = new Answer(secondText, true);
        List<Answer> answerList = List.of(firstAnswer, secondAnswer);

        PossibleAnswer possibleAnswers = PossibleAnswer.createPossibleAnswer(answerList);

        assertEquals(possibleAnswers.getPossibleAnswers(), answerList);
    }

    @Test
    void should_pass_empty_list_error_response() {
        List<Answer> answerList = List.of();

        assertThrows(NullPointerException.class, () -> PossibleAnswer.createPossibleAnswer(answerList));
    }

    @Test
    void should_pass_an_error_response_that_there_cant_be_two_correct_asnwers() {
        Answer firstAnswer = new Answer(firstText, true);
        Answer secondAnswer = new Answer(secondText, true);
        Answer thirdAnswer = new Answer(thirdText, false);
        List<Answer> answerList = List.of(firstAnswer, secondAnswer, thirdAnswer);

        assertThrows(IllegalArgumentException.class, () -> PossibleAnswer.createPossibleAnswer(answerList));
    }

}
