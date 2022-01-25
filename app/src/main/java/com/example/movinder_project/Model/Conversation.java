package com.example.movinder_project.Model;

import android.widget.DatePicker;

import java.util.List;

public class Conversation {

    private int id;
    private DatePicker date_debut_conversation;
    private List<Message> listMessage;

    public Conversation(int id, DatePicker date_debut_conversation, List<Message> listMessage) {
        this.id = id;
        this.date_debut_conversation = date_debut_conversation;
        this.listMessage = listMessage;
    }
}
