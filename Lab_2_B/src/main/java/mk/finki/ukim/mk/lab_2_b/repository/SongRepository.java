package mk.finki.ukim.mk.lab_2_b.repository;

import mk.finki.ukim.mk.lab_2_b.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab_2_b.model.Album;
import mk.finki.ukim.mk.lab_2_b.model.Artist;
import mk.finki.ukim.mk.lab_2_b.model.Song;
import org.springframework.stereotype.Repository;
import org.thymeleaf.standard.expression.GreaterThanExpression;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class SongRepository {

    public List<Song> findAll() {
        return DataHolder.songList;
    }

    public Song findByTrackId(Long trackId) {
        return DataHolder.songList.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Song song, Artist artist) {
        for (Song s : DataHolder.songList) {
            if (s.getTrackId().equals(song.getTrackId())) {
                s.addPerformer(artist);
                return artist;
            }
        }
        return null;
    }


    //dopolnitelno
//    public List<Artist> findAllByArtistId(){
//        return DataHolder.artistList;
//    }

    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album){
        Song song = new Song(title, genre, releaseYear, album);
        DataHolder.songList.removeIf(s -> Objects.equals(s.getTitle(), title));
        DataHolder.songList.add(song);
        return Optional.of(song);
    }

    public void deleteById(Long id) {
        DataHolder.songList.removeIf(s -> s.getTrackId().equals(id));
    }


}
