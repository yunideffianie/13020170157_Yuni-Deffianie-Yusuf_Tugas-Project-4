package com.example.tugasproject4;

public class FilmDetails {
    private String nama;
    private int fotoCast;

    public FilmDetails(String nama, int fotoCast) {
        this.nama = nama;
        this.fotoCast = fotoCast;
    }

    public String getNama() {
        return nama;
    }

    public int getFotoCast() {
        return fotoCast;
    }
}
