package com.itimindree.movie.movieimagesapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.itimindree.movie.movieimagesapi.model.MovieImage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class MovieImageServiceImplTest {

    private MovieImageServiceImpl movieImageServiceImpl;

    @BeforeEach
    void setUp() {
        movieImageServiceImpl = new MovieImageServiceImpl();
        movieImageServiceImpl.addMovieImage("https://example.com/thedeparted.jpg", 2024);
        movieImageServiceImpl.addMovieImage("https://example.com/pulpfiction.jpg", 2024);
        movieImageServiceImpl.addMovieImage("https://example.com/killbill.jpg", 2024);
        movieImageServiceImpl.addMovieImage("https://example.com/inglouriousbasterds.jpg", 2009);
        movieImageServiceImpl.addMovieImage("https://example.com/django.jpg", 2012);
        movieImageServiceImpl.addMovieImage("https://example.com/reservoirdogs.jpg", 1992);
        movieImageServiceImpl.addMovieImage("https://example.com/thehatefuleight.jpg", 2015);
        movieImageServiceImpl.addMovieImage("https://example.com/onceuponatime.jpg", 2019);
        movieImageServiceImpl.addMovieImage("https://example.com/jackiebrown.jpg", 1997);
        movieImageServiceImpl.addMovieImage("https://example.com/thelordoftherings1.jpg", 2022);
        movieImageServiceImpl.addMovieImage("https://example.com/thelordoftherings2.jpg", 2018);
        movieImageServiceImpl.addMovieImage("https://example.com/thelordoftherings3.jpg", 2017);
        movieImageServiceImpl.addMovieImage("https://example.com/thematrix.jpg", 1999);
        movieImageServiceImpl.addMovieImage("https://example.com/gladiator.jpg", 2000);
    }

    @Test
    void testListAllMovieImagesGroupedByReleaseYear() {
        Map<Integer, List<MovieImage>> groupedImages = movieImageServiceImpl.listAllMovieImagesGroupedByReleaseYear();

        assertEquals(12, groupedImages.size());
        assertEquals(3, groupedImages.get(2024).size());
        assertEquals(1, groupedImages.get(2012).size());
    }

    @Test
    void testlistMovieImagesByReleaseYear2024() {
        List<MovieImage> groupedImages = movieImageServiceImpl.listMovieImagesByReleaseYear(2024);
        assertEquals(3, groupedImages.size());
    }

    @Test
    void testlistMovieImagesByReleaseYear2012() {
        List<MovieImage> groupedImages = movieImageServiceImpl.listMovieImagesByReleaseYear(2012);
        assertEquals(1, groupedImages.size());
    }

    @Test
    void testGetMovieImageDetails() {
        MovieImage movieDetails = movieImageServiceImpl.getMovieImageDetails(2L);
        assertEquals(2024, movieDetails.getReleaseYear());
    }

    @Test
    void testUpVoteMovieImage() {
        MovieImage upVotedImage = movieImageServiceImpl.voteMovieImage(1L, true);
        assertEquals(1, upVotedImage.getFavoritesCount());
    }

    @Test
    void testDownVoteMovieImage() {
        movieImageServiceImpl.voteMovieImage(1L, true);
        MovieImage downVotedImage = movieImageServiceImpl.voteMovieImage(1L, false);
        assertEquals(0, downVotedImage.getFavoritesCount());
    }


}
