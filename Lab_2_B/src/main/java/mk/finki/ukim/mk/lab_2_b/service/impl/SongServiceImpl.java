package mk.finki.ukim.mk.lab_2_b.service.impl;

import mk.finki.ukim.mk.lab_2_b.model.Album;
import mk.finki.ukim.mk.lab_2_b.model.Artist;
import mk.finki.ukim.mk.lab_2_b.model.Song;
import mk.finki.ukim.mk.lab_2_b.repository.ArtistRepository;
import mk.finki.ukim.mk.lab_2_b.repository.SongRepository;
import mk.finki.ukim.mk.lab_2_b.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(song, artist);
    }

    @Override
    public Song findByTrackId(Long trackId) {
        return songRepository.findByTrackId(trackId);
    }


//    //dopolnitelnoto
//    @Override
//    public List<Song> listSongsByArtist(Long artistId) {
//        Artist artist = artistRepository.findById(artistId).orElse(null);
//        List<Song> songs = songRepository.findAll();
//
//        return songs.stream().filter(s -> s.getPerformers().contains(artist)).collect(Collectors.toList());
//
//    }


    @Override
    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album) {
        return songRepository.save(title, genre, releaseYear, album);
    }

    @Override
    public void deleteById(Long id) {
        this.songRepository.deleteById(id);
    }
}
