package com.itimindree.movie.movieimagesapi.controller;

import com.itimindree.movie.movieimagesapi.model.MovieImage;
import com.itimindree.movie.movieimagesapi.service.MovieImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movie-images")
public class MovieImageController {

    @Autowired
    private MovieImageService movieImageService;

    @Operation(summary = "List all movie images grouped by release year")
    @GetMapping("/all/grouped-by-year")
    public Map<Integer,List<MovieImage>> getAllMovieImagesByReleaseYear() {
        return movieImageService.listAllMovieImagesGroupedByReleaseYear();
    }

    @Operation(summary = "List all movie images by year")
    @GetMapping("/year/{year}")
    public List<MovieImage> getMovieImagesByYear(@PathVariable int year) {
        return movieImageService.listMovieImagesByReleaseYear(year);
    }

    @Operation(summary = "Vote movie image")
    @PostMapping("/vote/{id}")
    public MovieImage voteMovieImage(@PathVariable Long id, @RequestParam boolean upVote) {
        return movieImageService.voteMovieImage(id, upVote);
    }

    @Operation(summary = "Get details of a movie image")
    @GetMapping("/{id}")
    public MovieImage getMovieImageDetails(@PathVariable Long id) {
        return movieImageService.getMovieImageDetails(id);
    }
}
