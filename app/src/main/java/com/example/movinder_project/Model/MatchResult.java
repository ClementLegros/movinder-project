package com.example.movinder_project.Model;

public class MatchResult {
    private String nom_utilisateur;
    private String genre;

    public MatchResult(String nom_utilisateur, String genre) {
        this.nom_utilisateur = nom_utilisateur;
        this.genre = genre;
    }

    public String getNom_utilisateur(){
        return nom_utilisateur;
    }
    public String getGenre(){
        return genre;
    }
}
