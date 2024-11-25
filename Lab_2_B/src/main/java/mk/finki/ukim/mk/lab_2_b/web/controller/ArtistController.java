package mk.finki.ukim.mk.lab_2_b.web.controller;


import mk.finki.ukim.mk.lab_2_b.service.AlbumService;
import mk.finki.ukim.mk.lab_2_b.service.ArtistService;
import mk.finki.ukim.mk.lab_2_b.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtistController {

    private final AlbumService albumService;
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(AlbumService albumService, ArtistService artistService, SongService songService) {
        this.albumService = albumService;
        this.artistService = artistService;
        this.songService = songService;
    }


    @GetMapping("/artist/artist-list")
    public String showArtists(Model model) {
        model.addAttribute("artistList", artistService.listArtists());

        return "listArtists";
    }

    @PostMapping("/artist/artist-list")
    public String addArtistsToSong(@RequestParam(required = false) String songRadio, Model model) {
        String trackId = (songRadio != null) ? songRadio : "-";

        model.addAttribute("trackId", trackId);
        model.addAttribute("artistList", artistService.listArtists());

        return "listArtists";
    }

}
