package com.mdwohl.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class SongController {

    @Autowired //connects to DB
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @PostMapping("/song")
    public RedirectView addSong(String action, Long AlbumId) {
        Album exampleAlbum = albumRepository.getOne(AlbumId);
        Song songs = new Song("SongEx", exampleAlbum, 4, 5);
        songRepository.save(songs);
        return new RedirectView("/album");
    }

    @GetMapping("/song")
    public String getAllSongs(Model m) {
        List<Song> allSongs = songRepository.findAll();
        m.addAttribute("allSongs", allSongs);
        return "song";
    }

    @GetMapping("/generatesongs")
    public RedirectView generateSongs(Model m){
        System.out.println("hello");
        Optional<Album> unity = albumRepository.findById(1L);
        if (unity.isPresent()) {
            Song song1 = new Song("testSong1", unity.get(), 5,2);
            songRepository.save(song1);
            return new RedirectView("/song");
        } throw new SongNotFoundException();
    }
}
