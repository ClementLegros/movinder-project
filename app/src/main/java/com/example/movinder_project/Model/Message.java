package com.example.movinder_project.Model;

import android.widget.DatePicker;


public class Message {

    private int id;
    private DatePicker dateEnvoie;
    private String contenu;

    public Message(int id, DatePicker dateEnvoie, String contenu) {
        this.id = id;
        this.dateEnvoie = dateEnvoie;
        this.contenu = contenu;
    }
}
