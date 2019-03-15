package com.galvanize.gmdbmonolith.Repositories;

import com.galvanize.gmdbmonolith.Models.Movie;
import com.galvanize.gmdbmonolith.Models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
}