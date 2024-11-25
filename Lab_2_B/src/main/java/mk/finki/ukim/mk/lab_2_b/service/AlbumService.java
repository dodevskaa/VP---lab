package mk.finki.ukim.mk.lab_2_b.service;

import mk.finki.ukim.mk.lab_2_b.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {

    public List<Album> findAll();

    Optional<Album> findById(Long albumId);
}
