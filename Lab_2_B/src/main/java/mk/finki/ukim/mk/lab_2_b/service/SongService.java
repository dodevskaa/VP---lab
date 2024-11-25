package mk.finki.ukim.mk.lab_2_b.service;

import mk.finki.ukim.mk.lab_2_b.model.Album;
import mk.finki.ukim.mk.lab_2_b.model.Artist;
import mk.finki.ukim.mk.lab_2_b.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {

    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(Long trackId);

   // List<Song> listSongsByArtist(Long artistId); //dopolnitelnoto

    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album);

    void deleteById(Long id);

}
