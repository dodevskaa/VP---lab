package mk.finki.ukim.mk.lab_2_b.service;

import mk.finki.ukim.mk.lab_2_b.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> listArtists();
    Artist findById(Long id);

}
