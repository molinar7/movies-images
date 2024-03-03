package com.itimindree.movie.movieimagesapi.service;

import com.itimindree.movie.movieimagesapi.model.MovieImage;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


@Service
public class MovieImageServiceImpl implements MovieImageService {


    private final Map<Long, MovieImage> movieImages = new ConcurrentHashMap<>();
    private long nextId = 1;

    @PostConstruct
    public void init() {

        addMovieImage("https://example.com/thedeparted.jpg", 2024);
        addMovieImage("https://example.com/pulpfiction.jpg", 2024);
        addMovieImage("https://example.com/killbill.jpg", 2024);
        addMovieImage("https://example.com/inglouriousbasterds.jpg", 2009);
        addMovieImage("https://example.com/django.jpg", 2012);
        addMovieImage("https://example.com/reservoirdogs.jpg", 1992);
        addMovieImage("https://example.com/thehatefuleight.jpg", 2015);
        addMovieImage("https://example.com/onceuponatime.jpg", 2019);
        addMovieImage("https://example.com/jackiebrown.jpg", 1997);
        addMovieImage("https://example.com/thelordoftherings1.jpg", 2022);
        addMovieImage("https://example.com/thelordoftherings2.jpg", 2018);
        addMovieImage("https://example.com/thelordoftherings3.jpg", 2017);
        addMovieImage("https://example.com/thematrix.jpg", 1999);
        addMovieImage("https://example.com/gladiator.jpg", 2000);



    }

    private void addMovieImage(String imageUrl, int releaseYear) {
        MovieImage movieImage = new MovieImage();
        movieImage.setId(nextId++);
        movieImage.setUrl(imageUrl);
        movieImage.setReleaseYear(releaseYear);
        movieImage.setFavoritesCount(0);
        movieImages.put(movieImage.getId(), movieImage);
    }

    @Override
    public Map<Integer, List<MovieImage>> listAllMovieImagesGroupedByReleaseYear() {
        return movieImages.values().stream()
                .collect(Collectors.groupingBy(MovieImage::getReleaseYear));
    }
    @Override
    public List<MovieImage> listMovieImagesByReleaseYear(int year) {
        return movieImages.values().stream()
                .filter(movieImage -> movieImage.getReleaseYear() == year)
                .sorted(Comparator.comparingInt(MovieImage::getFavoritesCount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public MovieImage voteMovieImage(Long movieImageId, boolean upVote) {
        MovieImage movieImage = movieImages.get(movieImageId);
        if (movieImage != null) {
            if (upVote) {
                movieImage.setFavoritesCount(movieImage.getFavoritesCount() + 1);
            } else {
                movieImage.setFavoritesCount(Math.max(0, movieImage.getFavoritesCount() - 1));
            }
        }
        return movieImage;

    }

    @Override
    public MovieImage getMovieImageDetails(Long movieImageId) {
        return movieImages.get(movieImageId);
    }
}