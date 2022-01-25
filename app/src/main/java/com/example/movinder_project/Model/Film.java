package com.example.movinder_project.Model;

public class Film {
    private int idFilm;
    private String titre;
    private String synopsis;
    private String directeur;
    private String affiche;
    private String note;

    public Film(int idFilm, String titre, String synopsis, String directeur, String affiche, String note) {
        this.idFilm = idFilm;
        this.titre = titre;
        this.synopsis = synopsis;
        this.directeur = directeur;
        this.affiche = affiche;
        this.note = note;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirecteur() {
        return directeur;
    }

    public void setDirecteur(String directeur) {
        this.directeur = directeur;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
