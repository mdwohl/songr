package com.mdwohl.songr;

import javax.persistence.*;

@Entity

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String songTitle;
    @ManyToOne
    Album album;
    int songLength;
    int trackNumber;

    public Song(String songTitle, Album album, int songLength, int trackNumber){
        this.songTitle = songTitle;
        this.album = album;
        this.songLength = songLength;
        this.trackNumber = trackNumber;
    }

}
