package com.example.movinder_project.Model;

import android.widget.DatePicker;

import java.util.Date;
import java.util.List;

public class Conversation {

    private int id_conversation;
    private String date_deb_conversation;
    private int rendez_vous;
    private int id_utilisateur;

    public Conversation(int id_conversation, String date_deb_conversation, int rendez_vous, int id_utilisateur) {
        this.id_conversation = id_conversation;
        this.date_deb_conversation = date_deb_conversation;
        this.rendez_vous = rendez_vous;
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_conversation() {
        return id_conversation;
    }

    public String getDate_deb_conversation() {
        return date_deb_conversation;
    }

    public int getRendez_vous() {
        return rendez_vous;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }
}
