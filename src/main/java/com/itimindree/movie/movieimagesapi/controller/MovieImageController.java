package com.itimindree.movie.movieimagesapi.controller;

import com.itimindree.movie.movieimagesapi.model.MovieImage;
import com.itimindree.movie.movieimagesapi.service.MovieImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movie-images")
public class MovieImageController {

    @Autowired
    private MovieImageService movieImageService;

    @GetMapping("/all/grouped-by-year")
    public Map<Integer,List<MovieImage>> getAllMovieImagesByReleaseYear() {
        return movieImageService.listAllMovieImagesGroupedByReleaseYear();
    }

    @GetMapping("/year/{year}")
    public List<MovieImage> getMovieImagesByYear(@PathVariable int year) {
        return movieImageService.listMovieImagesByReleaseYear(year);
    }

    @PostMapping("/vote/{id}")
    public MovieImage voteMovieImage(@PathVariable Long id, @RequestParam boolean upVote) {
        return movieImageService.voteMovieImage(id, upVote);
    }

    @GetMapping("/{id}")
    public MovieImage getMovieImageDetails(@PathVariable Long id) {
        return movieImageService.getMovieImageDetails(id);
    }
}
