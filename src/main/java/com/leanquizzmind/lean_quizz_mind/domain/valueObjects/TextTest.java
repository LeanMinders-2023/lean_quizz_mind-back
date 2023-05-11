package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextTest {

    /*
    *   ""          ->      error response
    *   ""example   ->      new Text
    */

    @Test
    void should_return_error_response_if_string_is_empty() {
        assertThrows(IllegalArgumentException.class, () -> Text.createText(""));
    }

    @Test
    void should_return_new_text_if_text_is_not_empty() {
        Text text = Text.createText("example");
        String expectedResponse = "example";

        assertEquals(text.getText(), expectedResponse);
    }

}