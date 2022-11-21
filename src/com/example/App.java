package com.example;

public class App {
    public static void main(String[] args) {
        ChatLogger chatLogger = new ChatLogger();

        ChatParticipant alex = new ChatParticipant("AlexCoolBoy");
        ChatParticipant julia = new ChatParticipant("Julia_NekoTyan^_^");

        alex.say("HI!");
        julia.say("Are u an animeboy?");
        alex.leave();

        chatLogger.logChatEnd();
    }
}
