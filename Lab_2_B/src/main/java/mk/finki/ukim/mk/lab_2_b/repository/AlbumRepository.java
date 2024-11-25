package mk.finki.ukim.mk.lab_2_b.repository;

import mk.finki.ukim.mk.lab_2_b.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab_2_b.model.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {

    public List<Album> findAll(){
        return DataHolder.albumList;
    }

    public Optional<Album> findAlbumById(Long albumId) {
        return DataHolder.albumList.stream().filter(a -> a.getId().equals(albumId)).findFirst();
    }


}
