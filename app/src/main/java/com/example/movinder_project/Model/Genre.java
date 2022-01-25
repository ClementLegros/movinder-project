package com.example.movinder_project.Model;

public class Genre {
    private int idGenre;
    private String genre;

    public Genre(int idGenre, String genre) {
        this.idGenre = idGenre;
        this.genre = genre;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
