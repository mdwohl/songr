package com.mdwohl.songr;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    String title;
    String artist;
    String imageUrl;
    int songCount;
    int length;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    public List<Song> songs = new ArrayList<Song>();


    public Album(String title, String artist, String imageUrl, int songCount, int length){
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.songCount = songCount;
        this.length = length;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public int getSongCount(){
        return songCount;
    }

    public void setSongCount(int songCount){
        this.songCount = songCount;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }
}
