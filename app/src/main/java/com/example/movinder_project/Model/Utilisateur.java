package com.example.movinder_project.Model;

public class Utilisateur {

    private int idUser;
    private String nom_utilisateur;
    private String e_mail;
    private String num_utilisateur;
    private String mdp_utilisateur;
    private String sexe;
    private String orientation;

    public Utilisateur(int idUser, String nom_utilisateur, String e_mail, String num_utilisateur, String mdp_utilisateur, String sexe, String orientation) {

        this.idUser = idUser;
        this.nom_utilisateur = nom_utilisateur;
        this.e_mail = e_mail;
        this.num_utilisateur = num_utilisateur;
        this.mdp_utilisateur = mdp_utilisateur;
        this.sexe = sexe;
        this.orientation = orientation;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom_utilisateur;
    }

    public String getE_mail() {
        return e_mail ;
    }

    public String getNum(){
        return num_utilisateur;
    }

    public String getMdp() {
        return mdp_utilisateur;
    }

    public String getSexe() {
        return sexe;
    }

    public String getOrientation(){
        return orientation;
    }
}
