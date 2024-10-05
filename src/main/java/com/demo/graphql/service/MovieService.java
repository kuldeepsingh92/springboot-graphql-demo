package com.demo.graphql.service;

import com.demo.graphql.models.Movie;
import com.demo.graphql.records.MovieRecord;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovies();

    Movie addMovie(MovieRecord record);

    Movie updateMovie(int id, MovieRecord movieRecord);

    String deleteMovie(int id);
}
