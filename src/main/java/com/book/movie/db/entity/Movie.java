package com.book.movie.db.entity;

import com.book.movie.db.entity.enumType.FilmRating;
import lombok.Data;

@Data
public class Movie {
//    @Id @GeneratedValue
//    @Column(name = "movie_id")
    private Long id;

    private String movieTitle;
    private String director;
    private FilmRating filmRating;

    public Movie() {
    }

    public Movie(String movieTitle, String director, String filmRating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.filmRating = FilmRating.valueOf(filmRating);
    }

    public Movie(String movieTitle, String director) {
        this.movieTitle = movieTitle;
        this.director = director;
    }

//==비즈니스 로직==//
}
