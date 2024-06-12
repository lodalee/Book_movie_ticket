package com.book.movie.db.entity;

import com.book.movie.db.entity.enumType.FilmRating;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    private String movieId;

    private String movieTitle;
    private FilmRating filmRating;
}
