package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

}