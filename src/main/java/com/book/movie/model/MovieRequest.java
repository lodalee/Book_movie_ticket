package com.book.movie.model;

import com.book.movie.db.entity.enumType.FilmRating;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRequest {
    private String movieTitle;
    private String director;
    private FilmRating filmRating;

    public MovieRequest(String movieTitle, String director, String filmRating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.filmRating = FilmRating.valueOf(filmRating);
    }
}
