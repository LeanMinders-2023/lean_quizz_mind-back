package com.leanquizzmind.lean_quizz_mind.application.services;

import com.leanquizzmind.lean_quizz_mind.domain.models.Answer;
import com.leanquizzmind.lean_quizz_mind.domain.repositories.AnswerRepository;
import com.leanquizzmind.lean_quizz_mind.domain.valueObjects.Text;
import com.leanquizzmind.lean_quizz_mind.infraestructure.repositories.PostgreSQLAnswerRepositoryAdapter;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class AnswerServiceTest {

    /*
     *   save(Answer answer)         ->      save into the database
     *   save(Answer answerExist)    ->      dont save into the database
    */

    private final AnswerRepository MY_FAKE_ANSWER_REPOSITORY = mock(PostgreSQLAnswerRepositoryAdapter.class);
    private final AnswerService ANSWER_SERVICE = new AnswerService(MY_FAKE_ANSWER_REPOSITORY);

    @Test
    void should_save_a_new_answer() {
        Text answerText = Text.createText("example answer text");
        Answer answer = new Answer(answerText, false);

        ANSWER_SERVICE.save(answer);

        verify(MY_FAKE_ANSWER_REPOSITORY).save(answer);
    }

    @Test
    void should_not_save_answer_if_exist() {
        Text answerText = Text.createText("example answer text");
        Answer answer = new Answer(answerText, false);

        when(MY_FAKE_ANSWER_REPOSITORY.answerExist(answer)).thenReturn(true);
        ANSWER_SERVICE.save(answer);

        verify(MY_FAKE_ANSWER_REPOSITORY, never()).save(answer);
    }

}