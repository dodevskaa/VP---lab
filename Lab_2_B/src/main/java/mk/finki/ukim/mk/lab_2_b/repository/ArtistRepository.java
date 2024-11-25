package mk.finki.ukim.mk.lab_2_b.repository;

import mk.finki.ukim.mk.lab_2_b.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab_2_b.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    public List<Artist> findAll() {
        return DataHolder.artistList;
    }

    public Optional<Artist> findById(Long id) {
        return DataHolder.artistList.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }

}
