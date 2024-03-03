package com.itimindree.movie.movieimagesapi.service;

import com.itimindree.movie.movieimagesapi.model.MovieImage;

import java.util.List;
import java.util.Map;

public interface MovieImageService {
    Map<Integer,List<MovieImage>> listAllMovieImagesGroupedByReleaseYear();
    List<MovieImage> listMovieImagesByReleaseYear(int year);
    MovieImage voteMovieImage(Long movieImageId, boolean upVote);
    MovieImage getMovieImageDetails(Long movieImageId);
}
