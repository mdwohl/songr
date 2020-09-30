package com.mdwohl.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class AlbumController {

    @GetMapping("/albums")
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
