package com.demo.graphql.service.impl;

import com.demo.graphql.exception.NoRecordException;
import com.demo.graphql.models.Movie;
import com.demo.graphql.records.MovieRecord;
import com.demo.graphql.repsitories.MovieRepository;
import com.demo.graphql.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    @Override
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    @Override
    public Movie addMovie(MovieRecord record) {
        return repository
                .save(toMovie(record));
    }

    private static Movie toMovie(MovieRecord record) {
        return Movie.builder()
                .title(record.title())
                .director(record.director())
                .releaseYear(record.releaseYear())
                .movieCast(record.movieCast())
                .build();
    }

    @Override
    public Movie updateMovie(int id, MovieRecord record) {

        Movie movie = repository.findById(id)
                .orElseThrow(() -> new NoRecordException("Requested record not found."));

        movie.setTitle(record.title());
        movie.setDirector(record.director());
        movie.setReleaseYear(record.releaseYear());
        movie.setMovieCast(record.movieCast());

        return repository.save(movie);
    }

    @Override
    public String deleteMovie(int id) {

        Movie movie = repository.findById(id)
                .orElseThrow(() -> new NoRecordException("Requested record not found."));

        repository.deleteById(id);

        return "Record deleted successfully";
    }
}
