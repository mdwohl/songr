package com.mdwohl.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

        @Autowired //connects to DB
        AlbumRepository albumRepository;

        @Autowired
        SongRepository songRepository;

        @PostMapping("/song")
        public RedirectView addSong(String action, long albumId){
            Album exampleAlbum = albumRepository.getOne(albumId);
            Song songs = new Song("SongEx",exampleAlbum, 4, 5);
            songRepository.save(songs);
            return new RedirectView("/album");
        }
}
