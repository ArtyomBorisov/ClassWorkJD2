package by.it.academy.Mk_JD2_88_22.model;

import java.io.Serializable;

public class Poll implements Serializable {
    private int artist;
    private int[] genres;
    private String about;

    public Poll(int artist, int[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public int getArtist() {
        return artist;
    }

    public int[] getGenres() {
        return genres;
    }

    public String getAbout() {
        return about;
    }




}
