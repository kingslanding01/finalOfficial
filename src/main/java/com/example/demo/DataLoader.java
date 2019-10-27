package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Id;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    SongRepository songRepository;

    @Override
    public void run(String... strings) throws Exception{
        Album album;
        Album album1;
        Album album2;
        Album album3;
        Album album4;
        Song song;
        Song song1;
        Song song2;
        Song song3;
        Song song4;
        Song song5;
        Song song6;
        Song song7;
        Song song8;
        Song song9;
        Song song10;
        Song song11;
        Song song12;
        Song song13;
        Song song14;
        Song song15;
        Song song16;
        Song song17;
        Song song18;
        Song song19;
        Song song20;
        Song song21;
        Song song22;
        Song song23;
        Song song24;


        album = new Album("Rock", "queen", "1984", 10);
        albumRepository.save(album);

        album1 = new Album("rap", "Stankonia", "2000", 10);
        albumRepository.save(album1);

        album2 = new Album("rock", "Tragic Kingdom", "1992", 10);
        albumRepository.save(album2);

        album3 = new Album("classic rock", "Dark Side of The Moon", "1971", 10);
        albumRepository.save(album3);

        album4 = new Album("gospel", "Starlight", "2017", 10);
        albumRepository.save(album4);

        song = new Song("We Are The Champions", 3, "queen", "rock", album);
        songRepository.save(song);

        song1 = new Song("Bohemian Rhapsody", 5, "queen", "rock", album);
        songRepository.save(song1);

        song2 = new Song("under pressure", 4, "queen", "rock", album);
        songRepository.save(song2);

        song3 = new Song("fat bottomed girls", 3, "queen", "rock", album);
        songRepository.save(song3);

        song4 = new Song("we will rock you", 4, "queen", "rock", album);
        songRepository.save(song4);

        song5 = new Song("Gasoline Dreams", 3, "Outkast", "hip hop", album1);
        songRepository.save(song5);

        song6 = new Song("Ms. Jackson", 4, "Outkast", "hip hop", album1);
        songRepository.save(song6);

        song7 = new Song("Good Hair", 4, "Outkast", "hip hop", album1);
        songRepository.save(song7);

        song8 = new Song("Humble Mumble", 5, "Outkast", "hip hop", album1);
        songRepository.save(song8);

        song9 = new Song("Kim & Cookie", 4, "Outkast", "hip hop", album1);
        songRepository.save(song9);

        song10 = new Song("Just a Girl", 4, "No Doubt", "rock", album2);
        songRepository.save(song10);

        song11= new Song("Hey You!", 4, "No Doubt", "rock", album2);
        songRepository.save(song11);

        song12 = new Song("Sixteen", 4, "No Doubt", "rock", album2);
        songRepository.save(song12);

        song13 = new Song("Don't Speak", 4, "No Doubt", "rock", album2);
        songRepository.save(song13);

        song14 = new Song("The Climb", 4, "No Doubt", "rock", album2);
        songRepository.save(song14);

        song15= new Song("Time", 5, "Pink Floyd", "Classic Rock", album3);
        songRepository.save(song15);

        song16= new Song("The Great Gig In The Sky", 5, "Pink Floyd", "Classic Rock", album3);
        songRepository.save(song16);

        song17 = new Song("Money", 5, "Pink Floyd", "Classic Rock", album3);
        songRepository.save(song17);

        song18 = new Song("Us And Them", 5, "Pink Floyd", "Classic Rock", album3);
        songRepository.save(song18);

        song19 = new Song("Dark Side Of The Moon", 5, "Pink Floyd", "Classic Rock", album3);
        songRepository.save(song19);

        song20 = new Song("Starlight", 4, "Bethel", "Contemporary Gospel", album4);
        songRepository.save(song20);

        song21 = new Song("Extravagant", 4, "Bethel", "Contemporary Gospel", album4);
        songRepository.save(song21);

        song22 = new Song("The War Is Over", 4, "Bethel", "Contemporary Gospel", album4);
        songRepository.save(song22);

        song23 = new Song("Old For New", 4, "Bethel", "Contemporary Gospel", album4);
        songRepository.save(song23);

        song24 = new Song("You Came (Lazarus)", 4, "Bethel", "Contemporary Gospel", album4);
        songRepository.save(song24);




    }
}