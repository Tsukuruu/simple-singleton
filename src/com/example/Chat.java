package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Singleton
public class Chat {

    private static Chat instance;

    private File chatFile;
    private ArrayList<String> participants;
    private int messagesCount;

    private Chat() {
        this.chatFile = new File("chat.txt");

        try {
            if (this.chatFile.createNewFile()) {
                System.out.println("Chat file successfully created.");
            } else {
                System.out.println("Chat file already exists.");
            }
        } catch (IOException exception) {
            System.out.println("Error while creating chat file...");
            exception.printStackTrace();
        }

        this.participants = new ArrayList<>();
        this.messagesCount = 0;
    };

    public static Chat getInstance () {
        if (Chat.instance == null) {
            Chat.instance = new Chat();
        }

        return Chat.instance;
    };

    private boolean isInChatRoom(ChatParticipant participant) {
        return this.participants.contains(participant.getNickname());
    }

    public void addParticipant(ChatParticipant participant) {
        String nickname = participant.getNickname();

        if (!isInChatRoom(participant)) {
            this.participants.add(nickname);
        }
    }

    public void sendMessage(String message, ChatParticipant participant) {
        if (isInChatRoom(participant)) {
            this.messagesCount++;

            try {
                FileWriter writer = new FileWriter(this.chatFile, true);
                writer.write("[" + participant.getNickname() + "]: " + message + "\n");
                writer.close();
            } catch (IOException exception) {
                System.out.println("Error while writing to chat file...");
                exception.printStackTrace();
            }
        }
    }
    public void leave(ChatParticipant leaver) {
        if (isInChatRoom(leaver)) {
            int leaverIndex = this.participants.indexOf(leaver.getNickname());
            this.participants.remove(leaverIndex);

            try {
                FileWriter writer = new FileWriter(this.chatFile, true);
                writer.write("[" + leaver.getNickname() + "] leave the chat.\n");
                writer.close();
            } catch (IOException exception) {
                System.out.println("Error while writing to chat file...");
                exception.printStackTrace();
            }
        }
    }

    public int getMessagesCount() {
        return messagesCount;
    }
}
