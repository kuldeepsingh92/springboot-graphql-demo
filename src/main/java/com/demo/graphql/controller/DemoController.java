package com.demo.graphql.controller;

import com.demo.graphql.models.Movie;
import com.demo.graphql.records.MovieRecord;
import com.demo.graphql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class DemoController {

    @Autowired
    private MovieService movieService;

    @QueryMapping
    public List<Movie> getAllMoviesHandler() {
        return movieService.getAllMovies();
    }

    @MutationMapping
    public Movie addMovieHandler(@Argument(name = "movieInput") MovieRecord movieRecord) {
        return movieService.addMovie(movieRecord);
    }

    @MutationMapping
    public Movie updateMovieHandler(@Argument int id, @Argument(name = "movieInput") MovieRecord movieRecord) {
        return movieService.updateMovie(id, movieRecord);
    }

    @MutationMapping
    public String deleteMovieHandler(@Argument int id) {
        return movieService.deleteMovie(id);
    }
}
