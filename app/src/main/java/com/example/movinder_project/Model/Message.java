package com.example.movinder_project.Model;

import android.widget.DatePicker;


public class Message {

    private int id_message;
    private int id_conversation;
    private String date_envoie_msg;
    private String message;
    private int id_utilisateur;

    public Message(int id_message, int id_conversation, String date_envoie_msg, String message, int id_utilisateur) {
        this.id_message = id_message;
        this.id_conversation = id_conversation;
        this.date_envoie_msg = date_envoie_msg;
        this.message = message;
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_message() {
        return id_message;
    }

    public int getId_conversation() {
        return id_conversation;
    }

    public String getDate_envoie_msg() {
        return date_envoie_msg;
    }

    public String getMessage() {
        return message;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }
}
