package com.book.movie.db.repository;

import com.book.movie.db.entity.Movie;
import com.book.movie.model.MovieRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MovieRepositoryTest {

    MovieRepository movieRepository = new MovieRepository();

    @AfterEach
    void afterEach() {
        movieRepository.clearStore();
    }

    @Test
    void save() {
        //given
        Movie movie = new Movie("제목1", "감독A", "ALL");

        //when
        Movie savedMovie = movieRepository.save(movie);

        //then
        Movie findMovie = movieRepository.findById(movie.getId());
        assertThat(findMovie).isEqualTo(savedMovie);
    }

    @Test
    void findAll(){
        //given
        Movie movie1 = new Movie("제목1", "감독A", "ALL");
        Movie movie2 = new Movie("제목2", "감독B", "OVER15");
        Movie movie3 = new Movie("제목3", "감독C", "OVER18");

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        //when
        List<Movie> result = movieRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(3);
        assertThat(result).contains(movie1, movie2, movie3);
    }

//    @Test
//    void updateMovie() {
//        //given
//        Movie movie = new Movie("제목1", "감독A", "ALL");
//
//        Movie savedMovie = movieRepository.save(movie);
//        Long movieId = savedMovie.getId();
//
//        //when
//        Movie updateParam = new MovieRequest("제목2", "감독B", "OVER15");
//        movieRepository.update(movieId, updateParam);
//
//        Movie findMovie = movieRepository.findById(movieId);
//
//        //then
//        assertThat(findMovie.getMovieTitle()).isEqualTo(updateParam.getMovieTitle());
//        assertThat(findMovie.getDirector()).isEqualTo(updateParam.getDirector());
//        assertThat(findMovie.getFilmRating()).isEqualTo(updateParam.getFilmRating());
//    }
}