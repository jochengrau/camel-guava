package com.jochen.test.events;

/**
 * Created by jochen on 01Aug15.
 */
public class TextEvent {

    String message;
    public TextEvent(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "TextEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
