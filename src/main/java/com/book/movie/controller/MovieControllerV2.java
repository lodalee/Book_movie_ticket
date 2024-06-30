package com.book.movie.controller;

import com.book.movie.db.entity.Movie;
import com.book.movie.db.entity.enumType.FilmRating;
import com.book.movie.db.repository.MovieRepository;
import com.book.movie.model.MovieRequest;
import com.book.movie.model.MoviesResponse;
import com.book.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieControllerV2 {

    private final MovieService movieService;
    private final MovieRepository movieRepository;

    @GetMapping()
    public String moviesV2(Model model) {
        List<MoviesResponse> moviesResponses = movieService.getAllMovies();
        model.addAttribute("movies", moviesResponses);

        return "api/movies";
    }

    @GetMapping("/{movieId}")
    public String movie(@PathVariable Long movieId, Model model) {
        MoviesResponse moviesResponse = movieService.getMovieById(movieId);

        if (moviesResponse == null) {
            model.addAttribute("error", "Movie not found");
        }

        model.addAttribute("movie", moviesResponse);
        return "api/movie";
    }

    @GetMapping("/add")
    public String addForm() {
        return "api/addForm";
    }

    @PostMapping("/add")
    public String addMovie(MovieRequest movieRequest, RedirectAttributes redirectAttributes) {
        Movie savedMovie = movieService.addMovie(movieRequest);
        redirectAttributes.addAttribute("movieId", savedMovie.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/api/movies/{movieId}";
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
