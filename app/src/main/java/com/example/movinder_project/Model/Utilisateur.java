package com.example.movinder_project.Model;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class Utilisateur {

    private int id_utilisateur;
    private String nom_utilisateur;
    private String e_mail;
    private String num_utilisateur;
    private String mdp_utilisateur;
    private String sexe;
    private String orientation;

    public Utilisateur(int id_utilisateur, String nom_utilisateur, String e_mail, String num_utilisateur, String mdp_utilisateur, String sexe, String orientation) {
        this.id_utilisateur = id_utilisateur;
        this.nom_utilisateur = nom_utilisateur;
        this.e_mail = e_mail;
        this.num_utilisateur = num_utilisateur;
        this.mdp_utilisateur = mdp_utilisateur;
        this.sexe = sexe;
        this.orientation = orientation;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getNum_utilisateur() {
        return num_utilisateur;
    }

    public String getMdp_utilisateur() {
        return mdp_utilisateur;
    }

    public String getSexe() {
        return sexe;
    }

    public String getOrientation() {
        return orientation;
    }
}
