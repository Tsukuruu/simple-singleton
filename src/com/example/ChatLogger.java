package com.example;

// Singleton consumer
public class ChatLogger {
    private Chat chat;

    public ChatLogger() {
        this.chat = Chat.getInstance();
    }

    public void logChatEnd() {
        System.out.println("This exciting dialog contains " + chat.getMessagesCount() + " messages.");
    }

    public Chat getChat() {
        return chat;
    }
}
