package com.example.movinder_project.Model;

public class Utilisateur {

    private int idUser;
    private String nom;
    private String utilisateur;
    private String num_utilisateur;
    private String sexe;
    private String orientation;
    private String religion;

    public Utilisateur(int idUser, String nom, String utilisateur, String num_utilisateur, String sexe, String orientation, String religion) {
        this.idUser = idUser;
        this.nom = nom;
        this.utilisateur = utilisateur;
        this.num_utilisateur = num_utilisateur;
        this.sexe = sexe;
        this.orientation = orientation;
        this.religion = religion;
    }
}
