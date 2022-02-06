package com.example.movinder_project.Model;

import java.util.List;

public class Film {

    private int id_film;
    private String titre_film;
    private String synopsis;
    private String directeur;
    private String affiche;
    private int note;

    public Film(int id_film, String titre_film, String synopsis, String directeur, String affiche, int note) {
        this.id_film = id_film;
        this.titre_film = titre_film;
        this.synopsis = synopsis;
        this.directeur = directeur;
        this.affiche = affiche;
        this.note = note;
    }

    public int getId_film() {
        return id_film;
    }

    public String getTitre_film() {
        return titre_film;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirecteur() {
        return directeur;
    }

    public String getAffiche() {
        return affiche;
    }

    public int getNote() {
        return note;
    }
}
