package mk.finki.ukim.mk.lab_2_b.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Data
//@NoArgsConstructor

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    private String title;
    private String genre;
    private Integer releaseYear;


    //private Long id;

    @ManyToOne
    private Album album;

    @ManyToMany
    private List<Artist> performers; //lista od Artists


    public Song() {

    }


    public Song(String title, String genre, Integer releaseYear, Album album) {     //List<Artist> performers)
        this.trackId = (long) (Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;

        //sozdavanje na nova istanca na ArrayList koja e prazna vo momentot na sozdavanje i se koristi zaedno so addPerformer
        performers = new ArrayList<>();
        //this.performers = performers; //so ova se dodeluva postoecka referenca(lista) od konstruktorot
    }




    public void addPerformer(Artist performer) { //dodava nov Artist vo performer
        performers.add(performer);
    }

    public Long getTrackId() {
        return trackId;
    }

//    public void setTrackId(String trackId) {
//        this.trackId = trackId;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Artist> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Artist> performers) {
        this.performers = performers;
    }


    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
