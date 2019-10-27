package com.example.demo;

import javax.persistence.*;

@Entity
public class Song {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String songname;
    private double duration;
    private String artist;
    private String genre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private Album album;

    public Song() {
    }

    public Song(String songname, double duration, String artist, String genre, Album album) {
        this.songname = songname;
        this.duration = duration;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
