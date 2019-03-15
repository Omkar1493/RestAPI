package com.galvanize.gmdbmonolith.Repositories;

import com.galvanize.gmdbmonolith.Models.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    ArrayList<Movie> findMovieModelsByTitleContains(String criteria);
    Movie findMovieModelByImdbid(String imdbId);
}