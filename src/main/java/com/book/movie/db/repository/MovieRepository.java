package com.book.movie.db.repository;

import com.book.movie.db.entity.Movie;
import com.book.movie.db.entity.enumType.FilmRating;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository{

    private static final Map<Long, Movie> store = new HashMap<>();
    private static long sequence = 0L;

    public Movie save(Movie movie) {
        movie.setId(++sequence);
        store.put(movie.getId(), movie);
        return movie;
    }

    public Movie findById(Long id) {
        return store.get(id);
    }

    public List<Movie> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long movieId, Movie updateParam) {
        Movie findMovie = findById(movieId);
        findMovie.setMovieTitle(updateParam.getMovieTitle());
        findMovie.setDirector(updateParam.getDirector());
        findMovie.setFilmRating(FilmRating.valueOf(updateParam.getFilmRating().name()));
    }

    public void clearStore() {
        store.clear();
    }
}
