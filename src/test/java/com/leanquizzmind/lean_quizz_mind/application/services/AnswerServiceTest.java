package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLAnswerRepositoryAdapter;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnswerServiceTest {

    /*
    *   save(Answer answer)         ->      save into the database
    *   save(Answer answerExist)    ->      dont save into the database
    *
    */

    private final AnswerRepository MY_FAKE_ANSWER_REPOSITORY = mock(PostgreSQLAnswerRepositoryAdapter.class);
    private final AnswerService ANSWER_SERVICE = new AnswerService(MY_FAKE_ANSWER_REPOSITORY);

    @Test
    void should_save_a_new_answer() {
        Text answerText = Text.createText("answer example");
        Answer answer = new Answer(answerText, false);
        ArgumentCaptor<Answer> answerArgument = ArgumentCaptor.forClass(Answer.class);

        ANSWER_SERVICE.save(answer);
        when(MY_FAKE_ANSWER_REPOSITORY.answerExist(answer.getAnswerId())).thenReturn(false);

        verify(MY_FAKE_ANSWER_REPOSITORY).save(answerArgument.capture());
        assertEquals(answer, answerArgument.getValue());
    }

    @Test
    void should_not_save_answer_if_exist() {
        Text answerText = Text.createText("answer example");
        Answer answer = new Answer(answerText, false);

        answer.insertId();
        ANSWER_SERVICE.save(answer);
        when(MY_FAKE_ANSWER_REPOSITORY.answerExist(answer.getAnswerId())).thenReturn(true);

        verify(MY_FAKE_ANSWER_REPOSITORY, never()).save(answer);
    }

}