package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

public class Text {

    private String text;

    private Text(String text) {
        this.text = text;
    }

    public static Text createText(String text) {

        throw new Error("Not implemented yet");

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
