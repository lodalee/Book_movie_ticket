package com.book.movie.model;

import com.book.movie.db.entity.enumType.FilmRating;
import lombok.Getter;

@Getter
public class MoviesResponse {
    private Long movieId;
    private String movieTitle;
    private String director;
    private FilmRating filmRating;

    public MoviesResponse(Long movieId, String movieTitle, String director, String filmRating) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.director = director;
        this.filmRating = FilmRating.valueOf(filmRating);
    }
}
