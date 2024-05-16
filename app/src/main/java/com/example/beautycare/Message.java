package com.example.beautycare;

public class Message {
    private String message;
    private boolean isUserMessage;

    public Message(String message, boolean isUserMessage) {
        this.message = message;
        this.isUserMessage = isUserMessage;
    }

    public String getMessage() {
        return message;
    }

    public boolean isUserMessage() {
        return isUserMessage;
    }
}

