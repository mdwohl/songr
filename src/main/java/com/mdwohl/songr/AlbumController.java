package com.mdwohl.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class AlbumController {
    @Autowired //connects to DB
    public AlbumRepository albumRepository;

    @Autowired
    public SongRepository songRepository;

    @PostMapping("/album/delete/{id}")
    public RedirectView removeAlbum(@PathVariable long id){
        albumRepository.deleteById(id);
        return new RedirectView("/album");
    }

    @PostMapping("/album")
    public RedirectView addAlbum(
            String title,
            String artist,
            String imageUrl,
            int songCount,
            int length
            ){
        Album newAlbum = new Album(
                title,
                artist,
                imageUrl,
                songCount,
                length
        );

        albumRepository.save(newAlbum);

        return new RedirectView("/album");


    }

    @GetMapping("/album")
    public String displayAlbums (Model m) {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album(
                "Unity",
                "Larry Young",
                "/images/unity.jpg",
                6,
                40
        ));
        albums.add(new Album(
                "Bon Voyage Co.",
                "Haruomi Hosono",
                "/images/bonvoyage.jpg",
                10,
                32
        ));
        albums.add(new Album(
                "The Low End Theory",
                "A Tribe Called Quest",
                "/images/lowend.jpg",
                14,
                48
        ));

        m.addAttribute("albumList", albums);
        return "album";
    }
}
