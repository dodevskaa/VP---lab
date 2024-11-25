package mk.finki.ukim.mk.lab_2_b.web.controller;

import mk.finki.ukim.mk.lab_2_b.model.Album;
import mk.finki.ukim.mk.lab_2_b.model.Artist;
import mk.finki.ukim.mk.lab_2_b.model.Song;
import mk.finki.ukim.mk.lab_2_b.model.exceptions.InvalidAlbumIdException;
import mk.finki.ukim.mk.lab_2_b.service.AlbumService;
import mk.finki.ukim.mk.lab_2_b.service.ArtistService;
import mk.finki.ukim.mk.lab_2_b.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class SongController {

    private final AlbumService albumService;
    private final ArtistService artistService;
    private final SongService songService;

    public SongController(AlbumService albumService, ArtistService artistService, SongService songService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error,
                               Model model){

        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Song> songs = this.songService.listSongs();

        for (Song song : songs) {
            // Ако песната има албум, вклучете го во моделот
            if (song.getAlbum() != null) {
                model.addAttribute("albumName", song.getAlbum().getName());
            }
        }


        model.addAttribute("songList", this.songService.listSongs()); //songList


        return "listSongs";
    }

    @GetMapping("/songs/add-form")
    public String getAddSongPage(Model model){

        List<Artist> artists = this.artistService.listArtists();
        List<Album> albums = this.albumService.findAll();

        model.addAttribute("artistList", artists);
        model.addAttribute("albumList", albums);

        return "add-song";
    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam(required = false) String title,
                           @RequestParam(required = false) Long trackId,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) Integer releaseYear,
                           @RequestParam(required = false) Long albumId){

        Album album = albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId));

        if(trackId == null){
            this.songService.save(title, genre, releaseYear, album);

            return "redirect:/songs";
        }

        Song song = this.songService.findByTrackId(trackId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId)));

        return "redirect:/songs";
    }

    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long songId,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String genre,
                           @RequestParam(required = false) Integer releaseYear,
                           @RequestParam(required = false) Long albumId){

        Song song = this.songService.findByTrackId(songId);

        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId)));

        return "redirect:/songs";
    }

    @GetMapping("/songs/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model){

        Song song = this.songService.findByTrackId(id);
        List<Artist> artists = this.artistService.listArtists();
        List<Album> albums = this.albumService.findAll();

        model.addAttribute("songList", song);
        model.addAttribute("artistList", artists);
        model.addAttribute("albumList", albums);

        return "add-song";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        this.songService.deleteById(id);

        return "redirect:/songs";
    }

    @GetMapping("/songs/song-details/{id}")
    public String getSongDetails(@PathVariable Long id, Model model) {
        // Пронаоѓање на песната по ID
        Song song = this.songService.findByTrackId(id);

        // Проверка дали песната постои
        if (song == null) {

            return "redirect:/songs?error=SongNotFound";
        }

        // Додавање на песната во моделот
        model.addAttribute("songList", song);

        return "songDetails";
    }

}
