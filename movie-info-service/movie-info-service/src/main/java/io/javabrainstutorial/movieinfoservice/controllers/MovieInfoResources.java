package io.javabrainstutorial.movieinfoservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrainstutorial.movieinfoservice.models.Movie;

@RestController
@RequestMapping("/movies")
public class MovieInfoResources {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId,"xyzw");
	}
	
}
