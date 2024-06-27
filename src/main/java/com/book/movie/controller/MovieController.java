package com.book.movie.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {

//    private final MovieRepository movieRepository;
//
//    //영화 목록 조회
//    @GetMapping
//    public String movies(Model model) {
//        List<Movie> movies = movieRepository.findAll();
//
//        List<MovieResponseDto> responseDtos = (List<MovieResponseDto>) movies.stream()
//                .map(m-> new MovieResponseDto(m.getId(), m.getMovieTitle(), m.getFilmRating()))
//                .collect(Collectors.toList());
//        model.addAttribute("responseDtos", responseDtos);
//        return "api/movies";
//    }
//
//    //테스트용 데이터 추가
//    @PostConstruct
//    public void init() {
//        movieRepository.save(new Movie("영화1","감독A", FilmRating.valueOf("ALL")));
//        movieRepository.save(new Movie("영화2","감독B", FilmRating.valueOf("OVER15")));
//    }


}
