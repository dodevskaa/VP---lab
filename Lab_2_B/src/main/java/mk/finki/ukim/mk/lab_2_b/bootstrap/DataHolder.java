package mk.finki.ukim.mk.lab_2_b.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab_2_b.model.Album;
import mk.finki.ukim.mk.lab_2_b.model.Artist;
import mk.finki.ukim.mk.lab_2_b.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();
    public static List<Album> albumList = new ArrayList<>();



    @PostConstruct
    public void init() {
        artistList.add(new Artist(11L, "Milica", "Pavlovic", "Srpska pevacica"));
        artistList.add(new Artist(22L, "Tose", "Proeski", "Makedonski Pop Peac"));
        artistList.add(new Artist(44L, "Martin", "Garix", "Favorite DJ"));
        artistList.add(new Artist(612L, "Tina", "Turner", "Queen of Rock 'n' Roll"));
        artistList.add(new Artist(327L, "Lambe", "Alabakovski", "Makedonski peac"));

        albumList = new ArrayList<>();
        albumList.add(new Album("album 1", "rock", "2015"));
        albumList.add(new Album("album 2", "pop", "2005"));
        albumList.add(new Album("album 3", "turbofolk", "1964"));
        albumList.add(new Album("album 4", "metal", "1998"));
        albumList.add(new Album("album 5", "techno", "2021"));

        songList.add(new Song("MetalSong", "Metal", 1998, albumList.get(3)));
        songList.add(new Song("TurbofolkSong", "Turbofolk", 1964, albumList.get(2)));
        songList.add(new Song("PopSong", "Pop", 2005, albumList.get(1)));
        songList.add(new Song("TechnoSong", "Techno", 2021, albumList.get(4)));
        songList.add(new Song("RockSong", "Rock", 2015, albumList.get(0)));
    }


}
