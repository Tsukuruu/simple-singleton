package com.example;

// Consumer of singleton
public class ChatParticipant {

    private String nickname;
    private Chat chat;

    public ChatParticipant(String nickname) {
        this.nickname = nickname;
        this.chat = Chat.getInstance();
        this.chat.addParticipant(this);
    }

    public void say(String message) {
        this.chat.sendMessage(message, this);
    }

    public void leave() {
        this.chat.leave(this);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Chat getChat() {
        return chat;
    }
}
