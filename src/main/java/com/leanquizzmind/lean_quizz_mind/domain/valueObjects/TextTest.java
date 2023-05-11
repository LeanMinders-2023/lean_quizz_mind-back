package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextTest {

    /*
    *   ""          ->      error response
    *   ""example   ->      new Text
    */

    @Test
    void should_pass_an_error_response_if_string_is_empty() {
        assertThrows(IllegalArgumentException.class, () -> Text.createText(""));
    }

    @Test
    void should_create_new_text_if_text_is_not_empty() {
        Text text = Text.createText("example");
        String expectedResponse = "example";

        assertEquals(text.getText(), expectedResponse);
    }

}