package com.galvanize.gmdbmonolith.Controllers;


import com.galvanize.gmdbmonolith.Models.Movie;
import com.galvanize.gmdbmonolith.Services.GmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {


    private final GmdbService service;

    @Autowired
    public MovieController(GmdbService service)
    {
        this.service = service;

    }

    @GetMapping(path="/byId")
    public Movie getMovieName(@RequestParam String imdbid){
        System.out.println("input name is : " + imdbid);
        Movie movie = service.getMovie(imdbid);
        if(null != movie){
            System.out.println(movie.getDirector());
        }
        return movie;
    }

    @GetMapping(path="/getAllMovies")
    public List<Movie> getAllMovies(){
        return service.doSearch("");
    }


    @DeleteMapping(path="/deleteById/{movieId}")
    public void deleteMovieById(@PathVariable("movieId") Long movieId){
        service.deleteMoive(movieId);
    }



}
