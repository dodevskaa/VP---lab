//package mk.finki.ukim.mk.lab_2_b.web;
//
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import mk.finki.ukim.mk.lab_2_b.model.Song;
//import mk.finki.ukim.mk.lab_2_b.service.ArtistService;
//import mk.finki.ukim.mk.lab_2_b.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "ListSongsByArtistServlet", urlPatterns = "/songsArtist/")
//@AllArgsConstructor
//public class ListSongsByArtistServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final ArtistService artistService;
//    private final SongService songService;
//
////    public ListSongsByArtistServlet(SpringTemplateEngine springTemplateEngine, ArtistService artistService, SongService songService) {
////        this.springTemplateEngine = springTemplateEngine;
////        this.artistService = artistService;
////        this.songService = songService;
////    }
//
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    IWebExchange webExchange = JakartaServletWebApplication
//    .buildApplication(req.getServletContext())
//    .buildExchange(req, resp);
//
//    WebContext webContext = new WebContext(webExchange);
//    String artistId = req.getParameter("artistId");
//    webContext.setVariable("artistId", artistId);
//    List<Song> s = songService.listSongsByArtist(Long.valueOf(artistId));
//    webContext.setVariable("songs", songService.listSongsByArtist(Long.valueOf(artistId)));
//    springTemplateEngine.process(
//    "listSongArtist.html",
//    webContext,
//    resp.getWriter()
//    );
//    }
//}
//
