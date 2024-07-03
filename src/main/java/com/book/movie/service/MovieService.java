package com.book.movie.service;

import com.book.movie.db.entity.Movie;
import com.book.movie.db.repository.MovieRepository;
import com.book.movie.model.MovieRequest;
import com.book.movie.model.MoviesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<MoviesResponse> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();

        return movies.stream()
                .map(movie -> new MoviesResponse(
                        movie.getId(),
                        movie.getMovieTitle(),
                        movie.getDirector(),
                        movie.getFilmRating().name()
                ))
                .collect(Collectors.toList());
    }

    public MoviesResponse getMovieById(Long movieId) {
        return Optional.ofNullable(movieRepository.findById(movieId))
                .map(movie -> new MoviesResponse(
                        movie.getId(),
                        movie.getMovieTitle(),
                        movie.getDirector(),
                        movie.getFilmRating().name()
                )).orElse(null);
    }

    public Movie addMovie(MovieRequest movieRequest) {
        Movie movie = new Movie();
        movie.setMovieTitle(movieRequest.getMovieTitle());
        movie.setDirector(movieRequest.getDirector());
        movie.setFilmRating(movieRequest.getFilmRating());
        return movieRepository.save(movie);
    }
}