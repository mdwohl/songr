package com.mdwohl.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    @Autowired //connects to DB
    public AlbumRepository albumRepository;

    @Autowired
    public SongRepository songRepository;

    @PostMapping("/delete/{id}")
    public RedirectView removeAlbum(@PathVariable long id){
        albumRepository.deleteById(id);
        return new RedirectView("/albums");
    }

    @PostMapping("")
    public RedirectView addAlbum(
            @RequestParam String title,
            @RequestParam String artist,
            @RequestParam String imageUrl,
            @RequestParam int songCount,
            @RequestParam int length
            ){
        Album newAlbum = new Album(
                title,
                artist,
                imageUrl,
                songCount,
                length
        );

        albumRepository.save(newAlbum);

        return new RedirectView("/albums");


    }

    @GetMapping("/createalbums")
    public String createAlbums (Model m) {
        Album album1 = new Album(
                "Unity",
                "Larry Young",
                "/images/unity.jpg",
                6,
                40
        );
      Album album2 = new Album(
                "Bon Voyage Co.",
                "Haruomi Hosono",
                "/images/bonvoyage.jpg",
                10,
                32
        );
        Album album3 = new Album(
                "The Low End Theory",
                "A Tribe Called Quest",
                "/images/lowend.jpg",
                14,
                48
        );
        this.albumRepository.save(album1);
        this.albumRepository.save(album2);
        this.albumRepository.save(album3);
        List<Album> albumList = albumRepository.findAll();
        m.addAttribute("albumList", albumList);
        return "album";
    }

    @GetMapping("")
    public String getAllAlbums (Model m) {
        List<Album> albumList = albumRepository.findAll();
        m.addAttribute("albumList", albumList);
        return "album";
    }
    @GetMapping("/{id}")
    public String getOneAlbum (Model m, @PathVariable long id) {
        Optional<Album> foundAlbums = albumRepository.findById(id);
        if (foundAlbums.isPresent()) {
            m.addAttribute("albumList", foundAlbums.get());
            return "album";
        }
        throw new AlbumNotFoundException();
    }
}
