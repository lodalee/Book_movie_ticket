package com.book.movie.controller;

import com.book.movie.db.entity.Movie;
import com.book.movie.db.repository.MovieRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping()
    public String moviesV1(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "api/movies";
    }

    //테스트용 데이터 추가
    @PostConstruct
    public void init() {
        movieRepository.save(new Movie("영화A", "감독A", "OVER15"));
        movieRepository.save(new Movie("영화B", "감독B", "ALL"));
    }

    @GetMapping("/{movieId}")
    public String movie(@PathVariable Long movieId, Model model) {
        Movie movie = movieRepository.findById(movieId);
        model.addAttribute("movie", movie);
        return "api/movie";
    }

    @GetMapping("/add")
    public String addForm() {
        return "api/addForm";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Movie movie) {
        movieRepository.save(movie);
        return "api/movie";
    }

    @GetMapping("/{movieId}/edit")
    public String editForm(@PathVariable Long movieId, Model model) {
        Movie movie = movieRepository.findById(movieId);
        model.addAttribute("movie", movie);
        return "api/editForm";
    }

    @PostMapping("/{movieId}/edit")
    public String edit(@PathVariable Long movieId, @ModelAttribute Movie movie) {
        movieRepository.update(movieId, movie);
        return "redirect:/api/movies/{movieId}";
    }
}
