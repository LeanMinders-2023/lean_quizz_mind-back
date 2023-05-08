package com.leanquizzmind.lean_quizz_mind.domain.valueObjects;

public class Text {

    private String text;

    private Text(String text) {
        this.text = text;
    }

    public static Text createText(String text) {

        if (text.isBlank()) {
            throw new IllegalArgumentException("The text cannot be empty");
        }

        return new Text(text);

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
