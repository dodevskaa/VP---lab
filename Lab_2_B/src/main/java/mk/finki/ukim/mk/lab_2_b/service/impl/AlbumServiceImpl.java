package mk.finki.ukim.mk.lab_2_b.service.impl;

import mk.finki.ukim.mk.lab_2_b.model.Album;
import mk.finki.ukim.mk.lab_2_b.repository.AlbumRepository;
import mk.finki.ukim.mk.lab_2_b.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return  albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long albumId) {
        return albumRepository.findAlbumById(albumId);
    }
}
